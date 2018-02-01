package com.srikar.springmvc.validator;

import com.srikar.springmvc.form.ProductForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vedantas on 2/1/2018.
 */
public class ProductValidator {

    public List<String> validateProduct(ProductForm productForm){
        List<String> errorList = new ArrayList<>();
        if(productForm.getName().isEmpty())
            errorList.add("Product 'Name' cannot be empty!");
        try{
            Float.parseFloat(productForm.getPrice());
        }
        catch(NumberFormatException ex){
            errorList.add("Product 'Price' should be a decimal number!");
        }
        return errorList;
    }
}
