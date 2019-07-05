package com.codecool.shop.controller;

import com.codecool.shop.Cart;
import com.codecool.shop.Global;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        Cart cart  = Global.getInstance().getActualOrder().getCart();
        ArrayList<Integer> quanity = Global.getInstance().getActualOrder().getCart().getQuanityList();
        context.setVariable("cart",cart);
        context.setVariable("quanity",quanity);
        //float totalPrice = 0;
        for (int i=0;i<Global.getInstance().getActualOrder().getCart().getProductList().size();i++){
            //totalPrice = totalPrice + (Global.getInstance().getActualOrder().getCart().getProductList().get(i).getDefaultPrice() * quanity.get(i));
        }
        context.setVariable("total",4);
        //Global.getInstance().getActualOrder().setTotalPrice(BigDecimal.valueOf(totalPrice));

        engine.process("product/cart.html", context, response.getWriter());

    }
}
