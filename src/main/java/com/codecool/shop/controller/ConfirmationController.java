package com.codecool.shop.controller;

import com.codecool.shop.Global;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
    private void sendEmail() throws MessagingException {


        final String username = "sirosborncox";
        final String password = "Codecool oop";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sirosborncox@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("dbalazs1219@gmail.com")
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Email sent successfully");

    }

    private void saveToJSON() {
        Gson gson = new Gson();

        //Read from JSON
        Gson gsonIn = new GsonBuilder().setPrettyPrinting().create();
        JsonElement json = null;

        try (Reader reader = new FileReader("staff.json")) {

            // Convert JSON to JsonElement, and later to String
            json = gsonIn.fromJson(reader, JsonElement.class);

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
    private void doTheThing() throws IOException, MessagingException { // todo: rename function name
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
