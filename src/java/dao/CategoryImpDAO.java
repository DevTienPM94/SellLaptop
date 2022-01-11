/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Category;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tien0
 */
public class CategoryImpDAO implements CategoryDAO{
    private Connection con;

    public CategoryImpDAO() {
        con = DBContext.getConnection();
    }
    @Override
    public List<Category> getAll() {
        List<Category> data = new ArrayList<Category>();
        try {
            CallableStatement cs = con.prepareCall("{Call Category_GetAll}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Category c = new Category(
                        rs.getInt("CategoryId"),
                        rs.getString("CategoryName"), 
                        rs.getBoolean("IsActive"));
                data.add(c);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public Category getById(int CategoryId) {
        Category c = null;
        try {
            CallableStatement cs = con.prepareCall("{Call Category_GetById(?)}");
            cs.setInt(1, CategoryId);            
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                c = new Category(
                        rs.getInt("CategoryId"),
                        rs.getString("CategoryName"), 
                        rs.getBoolean("IsActive"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void insert(Category c) {
        try {
            CallableStatement cs = con.prepareCall("{Call Category_Insert(?,?)}");
            cs.setString(1, c.getCategoryName());
            cs.setBoolean(2, c.isIsActive());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Category c) {
        try {
            CallableStatement cs = con.prepareCall("{Call Category_Update(?,?,?)}");
            cs.setInt(1, c.getCategoryId());
            cs.setString(2, c.getCategoryName());
            cs.setBoolean(3, c.isIsActive());
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int CategoryId) {
        CallableStatement cs;
        try {
            cs = con.prepareCall("{Call Category_Delete(?)}");
            cs.setInt(1, CategoryId);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Category> search(String name) {
        List<Category> data = new ArrayList<Category>();
        try {
            CallableStatement cs = con.prepareCall("{Call Category_Search(?)}");
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {                
                Category c = new Category(
                        rs.getInt("CategoryId"),
                        rs.getString("CategoryName"), 
                        rs.getBoolean("IsActive"));
                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
       
}
