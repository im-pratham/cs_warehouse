package com.company.Warehouse;

import com.company.Warehouse.Exceptions.InvalidLimitException;
import com.company.Warehouse.Exceptions.ProductNotFoundException;
import com.company.Warehouse.Exceptions.WareHouseFullException;

import java.util.ArrayList;

public class Warehouse {
    private int limit;
    private ArrayList<Product> products;

    public Warehouse(int limit) {
        if (limit < 0) {
            throw new InvalidLimitException("Invalid Warehouse Limit");
        }
        products = new ArrayList<>();
        this.limit = limit;
    }

    public boolean add(Product p) {
        if (products.size()  >= limit) {
            throw new WareHouseFullException("Warehouse Full ....!");
        }
        return products.add(p);
    }

    public double getTotalValue() {
        double ans = 0;
        for (Product p: products) {
            ans += p.getPrice();
        }
        return ans;
    }

    public double getTotalSpace() {
        return limit - products.size();
    }

    public boolean remove(Product p) {
        if (products.contains(p)) {
            return products.remove(p);
        }
        throw new ProductNotFoundException("Product Not Found");
    }


    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        String str = String.format(" ------------ WAREHOUSE %d --------------- \n", products.size());
        for (Product p : products) {
            str += p.toPrint();
        }
        return str + " --------------------------------------- \n";
    }
}
