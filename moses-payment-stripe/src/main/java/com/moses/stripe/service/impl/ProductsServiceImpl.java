package com.moses.stripe.service.impl;

import com.moses.framework.util.ObjectUtil;
import com.moses.stripe.param.ProductParams;
import com.moses.stripe.service.ProductsService;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Moses
 */
@Service
public class ProductsServiceImpl extends BaseService implements ProductsService {
    @Override
    public String createProduct(ProductParams obj) throws StripeException {
        init();
        Map<String, Object> params = ObjectUtil.beanToMap(obj);
        Product product = Product.create(params);
        return product.getId();
    }
}


