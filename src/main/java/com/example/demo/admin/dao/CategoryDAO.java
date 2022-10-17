package com.example.demo.admin.dao;

import com.example.demo.admin.connection.DBConnection;
import com.example.demo.admin.dao.interfaces.ICategoryDAO;
import com.example.demo.admin.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBConnection implements ICategoryDAO {

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Category(categoryName,images,status) VALUES (?,?,?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCatename());
            ps.setString(2, category.getImages());
            ps.setString(3, category.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Category category) {
        String sql = "UPDATE category SET categoryName = ?, status=? ,images=?  WHERE categoryId = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCatename());
            ps.setString(2, category.getStatus());
            ps.setString(3, category.getImages());
            ps.setInt(4, category.getCateid());
            ps.executeUpdate();
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM category WHERE categoryId = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM category WHERE categoryId = ? ";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCateid(rs.getInt("categoryId"));
                category.setCatename(rs.getString("categoryName"));
                category.setStatus(rs.getString("status"));
                category.setImages(rs.getString("images"));
                return category;
            }} catch (Exception e) {
            e.printStackTrace();}
        return null;
    }

    @Override
    public Category get(String name) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM Category";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCateid(rs.getInt("categoryId"));
                category.setCatename(rs.getString("categoryName"));
                category.setStatus(rs.getString("status"));
                category.setImages(rs.getString("images"));
                categories.add(category);
            }} catch (Exception e) {
            e.printStackTrace();}
        return categories;
    }

    @Override
    public List<Category> search(String keyword) {
        return null;
    }
}
