/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import context.DBContext;
import dao.CategoryImpDAO;
import entity.Category;
import java.util.List;

/**
 *
 * @author tien0
 */
public class NewClass {
public static void main(String[] args) {
    
           CategoryImpDAO c = new CategoryImpDAO();
           //int num = c.getAll().size();
          //Category cat = c.getById(2);
          Category cat = new Category();
          List<Category> data = c.getAll();
          for (Category category : data) {
              System.out.println(category.getCategoryId());
              System.out.println(category.getCategoryName());
    }
          //c.update(cat);
          //c.insert(cat);
          //c.delete(4);
           //System.out.println(cat.getCategoryId());
           //System.out.println(cat.getCategoryName());
           //System.out.println(cat.isIsActive());
    }
}
