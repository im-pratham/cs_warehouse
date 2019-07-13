package com.company.Warehouse;

public class Gadget extends Product {
    private int packs;

    public Gadget(String title, double price, int packs) {
        super(title, price);
        this.packs = packs;
    }

    public int getPacks() {
        return packs;
    }

    public void setPacks(int packs) {
        this.packs = packs;
    }

    public double getPrice() {
        return super.getPrice() * packs;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Gadget g = (Gadget) obj;
        // comparing the state of argument with
        // the state of 'this' Object.
        return (g.getTitle().equals(getTitle()) && g.getPrice() == getPrice() && g.packs == getPacks());
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    public String toPrint() {
//        return "[" + getTitle() +  getPrice() + getPacks() + "]\n";
        return "G: " + String.format("[ %s  %f  %d  ]\n", getTitle(), getPrice(), getPacks());
    }
}
