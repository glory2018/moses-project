package com.moses.stripe.service;

import com.moses.stripe.param.ProductParams;
import com.stripe.exception.StripeException;

/**
 * @author Moses
 * @date 2020/4/27
 */
public interface ProductsService {
    String createProduct(ProductParams obj) throws StripeException;
}
