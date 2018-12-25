/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import da.ProductDataAccess;
import java.util.List;
import entities.Product;

/**
 *
 * @author VIIGstar
 */
public class ProductFinderBean {
    private String keyword;
    
    public void setKeyword(String key){
    this.keyword = key; 
    }
    
    public List<Product> getProducts(){
        return new ProductDataAccess().getProductsByName(keyword);
    }
}
