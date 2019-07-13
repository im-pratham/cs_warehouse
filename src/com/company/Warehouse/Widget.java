package com.company.Warehouse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Widget extends Product {
   private LocalDate expiryDate;

    public Widget(String title, double price, LocalDate expiryDate) {
        super(title, price);
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(expiryDate)) {
            setPrice(0);
        }
        return super.getPrice();
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Widget g = (Widget) obj;
        // comparing the state of argument with
        // the state of 'this' Object.
        return (g.getTitle().equals(getTitle()) && g.getPrice() == getPrice() && g.getExpiryDate().equals(getExpiryDate()));
    }

    public String toPrint() {
//        return "[" + getTitle() + getPrice() + getExpiryDate() + "]";
        return String.format("[\t%s\t%f\t%s\t]\n", getTitle(), getPrice(), getExpiryDate());
    }
    @Override
    public int hashCode() {
        return this.hashCode();
    }
}
