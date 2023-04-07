package com.iweb.util.comparator;


import com.iweb.entity.Product;

import java.util.Comparator;

/**
 * @author JI
 * @date 2023/3/5 21:43
 */
public class ProductPriceComparatorEsc implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPromotePrice()>o2.getPromotePrice()){
            return 1;
        }else if (o1.getPromotePrice()==o2.getPromotePrice()){
            return 0;
        }else {
            return -1;
        }
    }
    }



