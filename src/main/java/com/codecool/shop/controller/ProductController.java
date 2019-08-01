package com.codecool.shop.controller;

import com.codecool.shop.Global;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.applet.Applet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        String supplierName = req.getParameter("supplier");
        String categoryName = req.getParameter("category");

        ProductCategory productCategory = null;

        if (categoryName != null) {
            productCategory = productCategoryDataStore.findByName(categoryName);
        }

        Supplier supplier = null;

        if (supplierName != null) {
            supplier = SupplierDaoMem.getInstance().findByName(supplierName);
        }

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", productDataStore.getBy(productCategory, supplier));
        context.setVariable("dropDownCategories", productCategoryDataStore.getAll());
        context.setVariable("dropDownSupplier", SupplierDaoMem.getInstance().getAll());
        // // Alternative setting of the template context
        // Map<String, Object> params = new HashMap<>();
        // params.put("category", productCategoryDataStore.find(1));
        // params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        // context.setVariables(params);


        if(req.getParameter("id") != null){
            int id = Integer.parseInt(req.getParameter("id"));
            //Global.getInstance().getActualOrder().getCart().addProductToList(Global.getInstance().getActualOrder().getCart().addProductToList(ProductDaoMem.getInstance().find(1).getProductCategory().getProducts().get(id-1));

            Product product = productDataStore.find(id);
            Global.getInstance().getActualOrder().getCart().addProductToList(product);
            System.out.println(Global.getInstance().getActualOrder().getCart().getProductQuanity(product));
            //Global.getInstance().getActualOrder().getCart().addProductToList(ProductDaoMem.getInstance().find(1).getProductCategory().getProducts().get(id-1));
            //System.out.println(Global.getInstance().getActualOrder().getCart().getProductQuanity(Global.getInstance().getActualOrder().getCart().getProductList().get(0)));
        }
        engine.process("product/index.html", context, resp.getWriter());
    }

}
