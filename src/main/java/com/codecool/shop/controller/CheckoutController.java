package com.codecool.shop.controller;

import com.codecool.shop.Global;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.User;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    private Global global = Global.getInstance();
    private User user = global.getUserById();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        saveData(req, resp);
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("checkout/checkout.html", context, resp.getWriter());

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

//    @Override
    private void saveData (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setName(req.getParameter("name"));
        user.setEmailAddress(req.getParameter("email"));
        user.setPhoneNumber(req.getParameter("phone_number"));

        String billingCountry = req.getParameter("billing_country");
        String billingCity = req.getParameter("billing_city");
        String billingZipcode = req.getParameter("billing_zipcode");
        String billingAddress = req.getParameter("billing_address");
        user.setBillingAddress(billingCountry + " " + billingCity + " " + billingZipcode + " " + billingAddress); // todo: rename billing address

        String shippingCountry = req.getParameter("shipping_country");
        String shippingCity = req.getParameter("shipping_city");
        String shippingZipcode = req.getParameter("shipping_zipcode");
        String shippingAddress = req.getParameter("shipping_address");
        user.setShippingAddress(shippingCountry + " " + shippingCity + " " + shippingZipcode + " " + shippingAddress); // todo: rename shipping address
        try {
            if (req.getParameter("submitted").equals("submitted")) {
                System.out.println("siker");
                resp.sendRedirect(req.getContextPath() + "/pay");
            }
        } catch (Exception ignored) {
            System.out.println("hiba");
        }
    }
}
