package com.kanok.btlibrarygui.model;

public class TorrentRow {

    private String name;

    private double downloaded;

    private int quantity;

    public TorrentRow() {
        this.name = "";
        this.downloaded = 0;
        this.quantity = 0;
    }

    public TorrentRow(String name, double downloaded, int quantity) {
        this.name = name;
        this.downloaded = downloaded;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(double downloaded) {
        this.downloaded = downloaded;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
