/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tien0
 */
public class Category {
    private int CategoryId;
    private String CategoryName;
    private boolean IsActive;

    public Category() {
    }

    public Category(int CategoryId, String CategoryName, boolean IsActive) {
        this.CategoryId = CategoryId;
        this.CategoryName = CategoryName;
        this.IsActive = IsActive;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }
    
}
