package com.codecool.shop.controller;

import com.codecool.shop.Global;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



@WebServlet(urlPatterns = {"/confirmation"})
public class ConfirmationController extends HttpServlet {
    private void sendEmail()
    {

    }

    private void saveToJSON() {
        Gson gson = new Gson();

        //Read from JSON
        Gson gsonIn = new GsonBuilder().setPrettyPrinting().create();
        JsonElement json = null;

        try (Reader reader = new FileReader("staff.json")) {

            // Convert JSON to JsonElement, and later to String
            json = gsonIn.fromJson(reader, JsonElement.class);
            String jsonInString = gsonIn.toJson(json);

            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write to JSON
        try (FileWriter writer = new FileWriter("staff.json")) {
            assert json != null;
            json.getAsJsonObject().get("orders").getAsJsonArray()
                    .add(gson.toJsonTree(Global.getInstance().getActualOrder()));
            gson.toJson(json, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saved order successfully to JSON....");
    }
    private void doTheThing() throws IOException { // todo: rename function name
        // create JSON file
        saveToJSON();
        // send email
        sendEmail();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            if(req.getParameter("confirmed").equals("true")){
                doTheThing();
                resp.sendRedirect(req.getRequestURL()+ "/vegevanLOLx0");
            }
        }catch (Exception ignored){ }
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("user", Global.getInstance().getUserById());
        engine.process("payment/confirmation.html", context, resp.getWriter());
    }


}
