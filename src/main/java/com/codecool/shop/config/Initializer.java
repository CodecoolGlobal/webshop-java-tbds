package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
        Supplier nokia = new Supplier("Nokia", "Phones");
        supplierDataStore.add(nokia );
        Supplier chuwi = new Supplier("Chuwi","laptops");
        supplierDataStore.add(chuwi);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        ProductCategory phone = new ProductCategory("Phone", "Hardware", "Phone phone phone description");
        ProductCategory laptop = new ProductCategory("Laptop","Hardware", "Very useful good");

        productCategoryDataStore.add(tablet);
        productCategoryDataStore.add(phone);
        productCategoryDataStore.add(laptop);

        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        productDataStore.add(new Product("Nokia 3310", 75, "USD","Classic Nokia phone with new style", phone, nokia));
        productDataStore.add(new Product("Chuwi hero notebook", 500, "USD","The real gamer laptop, if you use an other laptop you are not a real gamer", laptop, chuwi));
        productDataStore.add(new Product("Lenovo blue phone", 125,"USD", "The bluest phone what ever made on this planet", phone, lenovo));
        productDataStore.add(new Product("Lenovo K5 Note", 200, "USD", "This phone has been called NOTE because this is the notest note what you ever used!", phone, lenovo));
        productDataStore.add(new Product("Lenovo ThinkPad Extreme", 1500, "USD","The best laptop if you have to work with IDEA-s", laptop, lenovo));
        productDataStore.add(new Product("Lenovo notbook original", 800, "USD", "A cheap laptop from lenovo, don't pay for this sht!", laptop, lenovo));
        productDataStore.add(new Product("Lenovo laptop", 500, "USD", "Cheap, ugly, stupid, slowl. If you want to make your dinner until the computer is turning on this is the laptop what you want", laptop, lenovo));
    }
}
