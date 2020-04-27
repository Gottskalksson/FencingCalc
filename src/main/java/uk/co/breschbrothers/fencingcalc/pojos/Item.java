package uk.co.breschbrothers.fencingcalc.pojos;

import java.text.DecimalFormat;

public class Item {

    private String description;
    private String type;
    private int quantity;
    private double priceForEach;
    private double totalPrice;

    public Item() {
    }

    public Item(String description, String type, int quantity, double priceForEach, double totalPrice) {
        this.description = description;
        this.type = type;
        this.quantity = quantity;
        this.priceForEach = priceForEach;
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceForEach() {
        return priceForEach;
    }

    public void setPriceForEach(double priceForEach) {
        this.priceForEach = priceForEach;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        String price = df.format((double) this.quantity * this.priceForEach);
        this.totalPrice = Double.parseDouble(price);
    }
}
