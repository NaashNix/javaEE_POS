package dto;

import java.sql.Date;

public class ItemDTO {
    private String itemId;
    private String itemName;
    private double unitPrice;
    private int inStock;
    private String batchNumber;
    private Date mfd;
    private Date exd;

    public ItemDTO() {
    }

    public ItemDTO(String itemId, String itemName, double unitPrice, int inStock, String batchNumber, Date mfd, Date exd) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.inStock = inStock;
        this.batchNumber = batchNumber;
        this.mfd = mfd;
        this.exd = exd;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getMfd() {
        return mfd;
    }

    public void setMfd(Date mfd) {
        this.mfd = mfd;
    }

    public Date getExd() {
        return exd;
    }

    public void setExd(Date exd) {
        this.exd = exd;
    }
}
