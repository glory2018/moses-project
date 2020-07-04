package com.moses.stripe.common;

/**
 * @author Moses
 */
public class Constant {
    /**
     * com.stripe.Stripe API keys
     */
    public static String STRIPE_PUBLISHABLE_KEY = "pk_test_006OAh34ulUJDmQB2aX79pOV00BlzpMT7s";
    public static String STRIPE_SECRET_KEY = "sk_test_CJHd0u6xamJgOdg0DY5v0PDN00a2WNazUH";
    //  Required to run webhook
    public static String STRIPE_WEBHOOK_SECRET = "whsec_uKr7IpVxChSMW2HCZYXKTu1eFVrOVgin";
    // Checkout settings
    public static String DOMAIN = "http://localhost:4242";
    public static int BASE_PRICE = 1099;
    public static String CURRENCY = "usd";
    // Some payment methods support only a subset of currencies.
    // PAYMENT_METHODS="card, ideal"  Requires CURRENCY=eur
    // PAYMENT_METHODS="card, fpx"  Requires CURRENCY=myr
    public static String PAYMENT_METHODS = "card";
    public static String BASIC_PLAN_ID = "plan_H8yFrGg9Q77y8k";
    public static String PRO_PLAN_ID = "plan_H8yFrGg9Q77y8k";
    public static String SUBSCRIPTION_PLAN_ID = "plan_H8yFrGg9Q77y8k";
    /**
     * redis存储token设置的过期时间，30分钟
     */
    public static final Integer TOKEN_EXPIRE_TIME = 60 * 30;
    /**
     * 设置可以重置token过期时间的时间界限
     */
    public static final Integer TOKEN_RESET_TIME = 1000 * 100;
}
