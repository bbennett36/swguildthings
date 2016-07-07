/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luckysevenweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "ConverterController", urlPatterns = {"/ConverterController"})
public class ConverterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
        rd.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("hideMenu", false);
        request.setAttribute("tempMenu", false);
        request.setAttribute("currMenu", false);
        request.setAttribute("massMenu", false);

        String choice = request.getParameter("mass");
        String choice2 = request.getParameter("temp");
        String choice3 = request.getParameter("currency");

        if (choice != null) {
            request.setAttribute("hideMenu", true);
            request.setAttribute("massMenu", true);

            RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
            rd.forward(request, response);

        } else if (choice2 != null) {
            request.setAttribute("hideMenu", true);
            request.setAttribute("tempMenu", true);

            RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
            rd.forward(request, response);

        } else if (choice3 != null) {
            request.setAttribute("hideMenu", true);
            request.setAttribute("currMenu", true);

            RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
            rd.forward(request, response);

        }

        String action = request.getParameter("action");

        if (action.equals("FtoC")) {

            double f = 0;
            try {
                String degree = request.getParameter("f");
                f = Double.parseDouble(degree);
                request.setAttribute("degree", degree);
            } catch (NumberFormatException ex) {
                String error = ("Incorrect format!");
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
                rd.forward(request, response);
            }

            double total = Math.round((f - 32) * 5 / 9);

            DecimalFormat df = new DecimalFormat("");
            String c = ("°" + df.format(f) + "F = " + "°" + df.format(total) + "C");
            request.setAttribute("c", c);

            RequestDispatcher rd = request.getRequestDispatcher("convresponse.jsp");
            rd.forward(request, response);

        }

        if (action.equals("CtoF")) {

            double c = 0;
            try {
                String degree = request.getParameter("c");
                c = Double.parseDouble(degree);
            } catch (NumberFormatException ex) {
                String error = ("Incorrect format!");
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
                rd.forward(request, response);
            }

            double total = Math.round(c * 1.8 + 32);
            DecimalFormat df = new DecimalFormat("");
            String f = ("°" + df.format(c) + "C = " + "°" + df.format(total) + "F");
            request.setAttribute("f", f);

            RequestDispatcher rd = request.getRequestDispatcher("convresponse.jsp");
            rd.forward(request, response);

        }

        if (action.equals("UStoEU")) {

            double usd = 0;
            try {
                String amount = request.getParameter("usd");
                usd = Double.parseDouble(amount);
            } catch (NumberFormatException ex) {
                String error = ("Incorrect format!");
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
                rd.forward(request, response);
            }

            double total = usd * 0.898154;
            DecimalFormat df = new DecimalFormat(".00");
            String euro = ("$" + df.format(usd) + " = €" + df.format(total));

            request.setAttribute("euro", euro);

            RequestDispatcher rd = request.getRequestDispatcher("convresponse.jsp");
            rd.forward(request, response);

        }

        if (action.equals("EUtoUS")) {

            double euro = 0;

            try {
                String amount = request.getParameter("euro");
                euro = Double.parseDouble(amount);
            } catch (NumberFormatException ex) {
                String error = ("Incorrect format!");
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
                rd.forward(request, response);
            }

            double dollar = euro * 1.11160021521;
            DecimalFormat df = new DecimalFormat(".00");
            String dollars = ("€" + df.format(euro) + " = $" + df.format(dollar));
            request.setAttribute("dollars", dollars);

            RequestDispatcher rd = request.getRequestDispatcher("convresponse.jsp");
            rd.forward(request, response);

        }

        if (action.equals("LBtoKG")) {

            double lb = 0;

            try {
                String amount = request.getParameter("lb");
                lb = Double.parseDouble(amount);
            } catch (NumberFormatException ex) {
                String error = ("Incorrect format!");
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
                rd.forward(request, response);
            }

            double total = Math.round(lb / 2.2046);
            DecimalFormat df = new DecimalFormat("");
            String kg = (df.format(lb) + "lbs = " + df.format(total) + "kgs");
            request.setAttribute("kg", kg);

            RequestDispatcher rd = request.getRequestDispatcher("convresponse.jsp");
            rd.forward(request, response);

        }

        if (action.equals("KGtoLB")) {

            double kg = 0;

            try {
                String amount = request.getParameter("kg");
                kg = Double.parseDouble(amount);
            } catch (NumberFormatException ex) {
                String error = ("Incorrect format!");
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("converter.jsp");
                rd.forward(request, response);
            }

            double total = Math.round(kg * 2.2046);
            DecimalFormat df = new DecimalFormat("");
            String lb = (df.format(kg) + "kgs = " + df.format(total) + "lbs");
            request.setAttribute("lb", lb);

            RequestDispatcher rd = request.getRequestDispatcher("convresponse.jsp");
            rd.forward(request, response);

        }
    }
}
