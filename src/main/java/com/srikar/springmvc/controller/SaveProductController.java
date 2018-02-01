package com.srikar.springmvc.controller;

import com.srikar.springmvc.domain.Product;
import com.srikar.springmvc.form.ProductForm;
import com.srikar.springmvc.validator.ProductValidator;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by vedantas on 2/1/2018.
 */
public class SaveProductController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ProductForm productForm = new ProductForm();
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        ProductValidator productValidator = new ProductValidator();
        List<String> errorList = productValidator.validateProduct(productForm);

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try{
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        }
        catch(NumberFormatException ex){
            // Nothing to do here.
        }
        ModelAndView modelAndView = new ModelAndView();
        if(!errorList.isEmpty()){
            modelAndView.setViewName("ProductForm");
            modelAndView.addObject("errors", errorList);
        }
        else{
            modelAndView.setViewName("ProductDetails");
            modelAndView.addObject("product", product);
        }
        return modelAndView;
    }
}
