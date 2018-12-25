/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author VIIGstar
 */
public class ProductDataAccess {
    private PreparedStatement searchStt;
    
    private PreparedStatement getSearchStt() throws ClassNotFoundException, SQLException{
        if(searchStt == null){
            Connection con = new DBConnection().getConnection();
            searchStt = 
                    con.prepareStatement(
                            "SELECT * from productStore where pro_name like ?");
            
        }
        return searchStt;
    }
    
    public List<Product> getProductsByName(String name){
        try{
            PreparedStatement stt = getSearchStt();
            stt.setString(1, "%" + name + "%");
            ResultSet rs = stt.executeQuery();
            List<Product> products = new LinkedList<Product>();
            while(rs.next()){
                products.add(new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getString("pro_desc")));
            }
            return products;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
