package com.iweb.util.comparator;


import com.iweb.entity.Product;

import java.util.Comparator;

/**
 * @author JI
 * @date 2023/3/6 8:51
 */
public class ProductSaleComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getSaleCount()>o2.getSaleCount()){
            return 1;
        }else if (o1.getSaleCount()==(o2.getSaleCount())){
            return 0;
        }else {
            return -1;
        }
    }
}
