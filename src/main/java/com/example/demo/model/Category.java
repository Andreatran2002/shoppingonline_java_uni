package com.example.demo.model;

public class Category {
    private int cateid;
    private String catename;
    private int status;
    private String icon ;

    @Override
    public String toString() {
        return "Category{" +
                "cateid=" + cateid +
                ", catename='" + catename + '\'' +
                ", status=" + status +
                ", icon='" + icon + '\'' +
                '}';
    }

    public Category(int cateid, String catename, String icon, int status ) {
        this.cateid = cateid;
        this.catename = catename;
        this.status = status;
        this.icon = icon;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}