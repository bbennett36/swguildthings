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
@WebServlet(name = "TipCalcController", urlPatterns = {"/TipCalcController"})
public class TipCalcController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs /
     *
     * //
     *
     * /**
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

        RequestDispatcher rd = request.getRequestDispatcher("tipcalc.jsp");
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

        double amount = 0;
        double tipPercent = 0;
        try {

            String sAmount = request.getParameter("getAmount");
            amount = Double.parseDouble(sAmount);

            String sPercent = request.getParameter("getPercent");

            tipPercent = Double.parseDouble(sPercent);

        } catch (NumberFormatException ex) {
            String error = ("Incorrect format!");
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("tipcalc.jsp");
            rd.forward(request, response);
        }

        tipPercent = tipPercent / 100;
        double tip = amount * tipPercent;
        double total = tip + amount;

        DecimalFormat df = new DecimalFormat(".00");
        DecimalFormat df2 = new DecimalFormat("");

        String stringAmount = ("Amount: $" + df.format(amount));
        String stringPercent = ("Tip: " + df2.format(tipPercent) + "%");
        String stringTip = ("Tip Amount: $" + df.format(tip));
        String stringTotal = ("Total: $" + df.format(total));

        request.setAttribute("stringAmount", stringAmount);
        request.setAttribute("stringPercent", stringPercent);
        request.setAttribute("stringTip", stringTip);
        request.setAttribute("stringTotal", stringTotal);

        RequestDispatcher rd = request.getRequestDispatcher("tcresponse.jsp");
        rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
