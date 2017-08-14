package com.chinabluedon.designmodedemo.simple_factory;

/**
 * @author ht
 * @time 2017/8/14  8:59
 * @desc ${TODD}
 */
public class ContreteFactory {

    public static <T extends Product> T createProduct (Class<T> cla) {
        Product product = null;
        try {
            product = (Product) Class.forName(cla.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
