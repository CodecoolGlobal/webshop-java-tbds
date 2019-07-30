package com.codecool.shop.controller;

import com.codecool.shop.Global;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.JDBC.UserDaoJdbc;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/pay"})
public class PayController extends HttpServlet {
    private BigDecimal price = Global.getInstance().getActualOrder().getTotalPrice();
    private User user = Global.getInstance().getUserById();
    private void saveData(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        if(req.getParameter("paymethod").equals("paypal")){
            user.setPaypalUsername(req.getParameter("username"));
            user.setPaypalPassword(req.getParameter("password"));
            resp.sendRedirect(req.getContextPath() + "/confirmation");
        } else if (req.getParameter("paymethod").equals("creditcard")) {
            user.setCardNumber(req.getParameter("cardNumber"));
            user.setCardHolder(req.getParameter("cardHolder"));
            user.setExpirityDate(req.getParameter("expirityDate"));
            user.setCardCode(req.getParameter("code"));
            resp.sendRedirect(req.getContextPath() + "/confirmation");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try{
            saveData(req, resp);

            //
            UserDao userDao = new UserDaoJdbc();
            userDao.updateUser(user);
            //


        }catch (Exception ignored){}

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("totalPrice", price);
        engine.process("payment/pay.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp) ;

    }




}
