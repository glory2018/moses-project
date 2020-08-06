/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.web.service.impl;

import com.moses.web.repository.StatisticsRepository;
import com.moses.web.service.StatisticsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author Moses
 * @date 2020/6/20
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public List laboratoryNum() {
        return statisticsRepository.laboratoryNum();
    }

    @Override
    public List yearNum() {
        return statisticsRepository.yearNum();
    }

    /**
     * 替换为英文逗号
     *
     * @param data 中文逗号，顿号
     * @return
     */
    private String unifiedSymbol(String data) {
        return data.replaceAll("[\\s\\t\\n\\r,、，]", ",").replaceAll(",,", ",");
    }

    @Override
    public Map continued(MultipartFile file, String group, String data) {
        String[] dataArr = null;
        if (file.isEmpty()) {
            data = unifiedSymbol(data);
            dataArr = data.split(",");
        } else {
            dataArr = readFileData(file);
        }
        String[] groupArr = group.replaceAll("[\\s\\t\\n\\r\\(\\（\\)\\）；]", "").split(";");
        String[] statusArr = new String[dataArr.length];
        String group1 = null;
        String group2 = null;
        String group3 = null;
        String tempGroup;
        String temp;
//        1、8、3、2、10、9、5、1、3、2、7、5、4、9、4、5、6、2、9、7
//        N、Y、N、N、Y、Y、N、N、N、N、N、N、Y、N、Y、Y、Y、Y、Y、Y
        for (int i = 0; i < dataArr.length; i++) {
            temp = dataArr[i];
            if (getMatch(group1, temp)) {
                statusArr[i] = "Y";
                tempGroup = group1;
                group1 = group2;
                group2 = group3;
                group3 = tempGroup;
            } else if (getMatch(group2, temp)) {
                statusArr[i] = "Y";
                tempGroup = group2;
                group2 = group3;
                group3 = tempGroup;
            } else if (getMatch(group3, temp)) {
                statusArr[i] = "Y";
            } else {
                statusArr[i] = "N";
                group1 = group2;
                group2 = group3;
                group3 = getMatchGroup(groupArr, temp);
            }
        }
        String statusMap = getStatus(statusArr);
        Map map = new HashMap();
        map.put("status", StringUtils.join(statusArr, "、"));
        map.put("content", statusMap);
        return map;
    }

    private String[] readFileData(MultipartFile file) {
        List<String> list = new ArrayList<>();
        try {
            //获得上传的excel文件
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            //获取第一个sheet
            XSSFSheet sheet = workbook.getSheetAt(0);
            //获取物理行数
            int rowNums = sheet.getPhysicalNumberOfRows();
            //遍历行数
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                XSSFCell cell = sheet.getRow(i).getCell(0);
                if (cell != null) {
                    int value = new Double(cell.getNumericCellValue()).intValue();
                    list.add(String.valueOf(value));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.toArray(new String[list.size()]);
    }

    @Override
    public String pair(String data) {
        List<String> list = duplicateRemoval(unifiedSymbol(data));
        String preNum = list.get(0);
        String temp;
        int pairNum = 0;
        int interval = 0;
        Map<String, Integer> map = new HashMap();
        for (int i = 1; i < list.size(); i++) {
            temp = list.get(i);
            if (preNum.equals(temp)) {
                pairNum++;
                if (interval > 0) {
                    cumulative(map, String.valueOf(interval - 1));
                }
                interval = 0;
            } else {
                interval++;
            }
            preNum = temp;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("有对子" + pairNum + "对;\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuffer.append("间隔" + entry.getKey() + "=" + entry.getValue() + "次\n");
        }
        return stringBuffer.toString();
    }

    private List duplicateRemoval(String data) {
        String[] dataArr = unifiedSymbol(data).split(",");
        List dataList = new ArrayList();
        dataList.add(dataArr[0]);
        dataList.add(dataArr[1]);
        Set<Integer> set = new HashSet();
        for (int i = 2; i < dataArr.length; i++) {
            dataList.add(dataArr[i]);
            if (dataArr[i - 2].equals(dataArr[i - 1]) && dataArr[i - 1].equals(dataArr[i])) {
                set.add(i - 2);
                set.add(i - 1);
                set.add(i);
            }
        }
        Set<Integer> sortSet = new TreeSet<Integer>((o1, o2) -> o2.compareTo(o1));
        sortSet.addAll(set);
        for (Integer i : sortSet) {
            dataList.remove(dataList.get(i));
        }
        return dataList;
    }

    private String getStatus(String[] statusArr) {
        String tempStatus;
        int yNum = 1;
        int nNum = 1;
        int maxY = 1;
        int maxN = 1;
        String preStatus = "";
        String key;
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < statusArr.length; i++) {
            tempStatus = statusArr[i];
            if (tempStatus.equals(preStatus)) {
                if ("Y".equals(tempStatus)) {
                    yNum++;
                    nNum = 1;
                } else {
                    yNum = 1;
                    nNum++;
                }
            } else {
                if ("Y".equals(preStatus)) {
                    key = yNum + "Y";
                    if (yNum > maxY) {
                        maxY = yNum;
                    }
                } else {
                    key = nNum + "N";
                    if (nNum > maxN) {
                        maxN = nNum;
                    }
                }
                //第一次不累计
                if (i > 0) {
                    cumulative(map, key);
                }
                yNum = 1;
                nNum = 1;
                preStatus = tempStatus;
            }
        }
        //最后一次统计
        if ("Y".equals(preStatus)) {
            key = yNum + "Y";
            if (yNum > maxY) {
                maxY = yNum;
            }
        } else {
            key = nNum + "N";
            if (nNum > maxN) {
                maxN = nNum;
            }
        }
        cumulative(map, key);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey() + "=" + entry.getValue() + "次\n");
        }
        stringBuffer.append("最多的Y是" + maxY + "Y;");
        stringBuffer.append("最多的N是" + maxN + "N;");
        return stringBuffer.toString();
    }

    private void cumulative(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private boolean getMatch(String group, String temp) {
        if (group == null) {
            return false;
        } else {
            String[] groupArr = group.split(",");
            return groupArr[0].equals(temp) || groupArr[1].equals(temp);
        }
    }

    private String getMatchGroup(String[] groupArr, String s) {
        for (int j = 0; j < groupArr.length; j++) {
            if (groupArr[j].contains(s)) {
                return groupArr[j];
            }
        }
        return "";
    }
}


