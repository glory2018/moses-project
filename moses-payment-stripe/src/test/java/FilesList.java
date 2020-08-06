/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: PACKAGE_NAME.FilesList
 * @version V1.0
 */

import java.io.File;
import java.util.Scanner;

/**
 * @author Moses
 * @date 2020/8/5
 */
public class FilesList {
    public static void main(String[] args) {
        String path = null;
        System.out.println("请输入你要查询的目录：");
        Scanner input = new Scanner(System.in);
        path = input.nextLine();
        File dir = new File(path);
        String[] child = dir.list();
        if (child == null) {
            System.out.println("当前目录为空");
        } else {
            for (int i = 0; i < child.length; i++) {
                String str = child[i];
                System.out.println(str);
            }
        }
    }
}
