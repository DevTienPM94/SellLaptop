/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import java.util.List;

/**
 *
 * @author tien0
 */
public interface CategoryDAO {
    public List<Category> getAll();
    public Category getById(int CategoryId);
    public void insert (Category c);
    public void update (Category c);
    public void delete (int CategoryId);
    public List<Category> search(String name);
}
