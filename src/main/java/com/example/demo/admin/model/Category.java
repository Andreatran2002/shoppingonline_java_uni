package com.example.demo.admin.model;

public class Category {
    private int cateid;
    private String catename;
    private String status;
    private String images ;

    public Category(int cateid, String catename, String icon, String images) {
        this.cateid = cateid;
        this.catename = catename;
        this.status = icon;
        this.images = images;
    }

    public Category() {

    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String icon) {
        this.status = icon;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cateid=" + cateid +
                ", catename='" + catename + '\'' +
                ", status='" + status + '\'' +
                ", images='" + images + '\'' +
                '}';
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}