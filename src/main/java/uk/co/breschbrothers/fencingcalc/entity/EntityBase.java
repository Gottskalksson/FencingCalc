package uk.co.breschbrothers.fencingcalc.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;

@MappedSuperclass
public abstract class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String type;

    @Min(0)
    private double pricePerM3;

    @Min(0)
    private double pricePerPiece;

    @NotNull
    private int length;

    @NotNull
    private int width;

    @NotNull
    private int thickness;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerM3() {
        return pricePerM3;
    }

    public void setPricePerM3(double price) {
        this.pricePerM3 = price;
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece() {
        DecimalFormat df = new DecimalFormat("0.00");
        String price = df.format((double) (this.length * this.thickness * this.width * this.pricePerM3) * 0.000000001);
        this.pricePerPiece = Double.parseDouble(price);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

}
