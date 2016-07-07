/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luckysevenweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "InterestCalcController", urlPatterns = {"/InterestCalcController"})
public class InterestCalcController extends HttpServlet {

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

        RequestDispatcher rd = request.getRequestDispatcher("interestcalc.jsp");
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

        double aRate = 0;
        int years = 0;
        double principle = 0;
        String stringAnnual = "";
        int yearCount = 1;
        double newPrinciple = 0;
        double interestCalc;

        try {
            String stringRate = request.getParameter("annualRate");
            aRate = Double.parseDouble(stringRate);
            stringAnnual = request.getParameter("principal");
            principle = Double.parseDouble(stringAnnual);
            String stringYear = request.getParameter("years");
            years = Integer.parseInt(stringYear);

        } catch (NumberFormatException ex) {
            String error = ("Incorrect format!");
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("interestcalc.jsp");
            rd.forward(request, response);
        }
        double qRate = aRate / 4;

        List<Object> printStuff = new ArrayList();

        while (yearCount <= years) {

            double beginPrinciple = principle;
            interestCalc = 0;

            for (int i = 1; i <= 4; i++) {
                newPrinciple = principle * (1 + (qRate / 100));
                interestCalc += principle * (qRate / 100);
                principle = newPrinciple;
            }
            DecimalFormat df = new DecimalFormat(".00");

            Object currentYear = ("Year: " + yearCount);
            Object beginPrinc = ("Principal at the beginning of the year $" + df.format(beginPrinciple));
            Object calc = ("Total amount of interest earned for this year: $" + df.format(interestCalc));
            Object newPrinc = ("The principle at the end of the year is $" + df.format(newPrinciple));

            printStuff.add(currentYear);
            printStuff.add(beginPrinc);
            printStuff.add(calc);
            printStuff.add(newPrinc);

            yearCount++;
//            System.out.println(" ");
        }
        request.setAttribute("printStuff", printStuff);
        request.setAttribute("printStuff", printStuff);
        request.setAttribute("printStuff", printStuff);
        request.setAttribute("printStuff", printStuff);

        RequestDispatcher rd = request.getRequestDispatcher("icresponse.jsp");
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
