/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luckysevenweb;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FactorizerController", urlPatterns = {"/FactorizerController"})
public class FactorizerController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = request.getRequestDispatcher("factorizer.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int counter = 1;
        int factorCount = 0;
        int factorSum = 0;
        String ibet = "";
        int number = 0;

        try {
        ibet = request.getParameter("number");
        number = Integer.parseInt(ibet);
        } catch (NumberFormatException ex)  {
            String error = ("Incorrect format!");
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("factorizer.jsp");
            rd.forward(request, response);
        }

        String printNum = ("" + number);
        request.setAttribute("printNum", printNum);
        List<Integer> numbers = new ArrayList();

        while (counter < number) {
            String factors = ("Factors of " + number);
            request.setAttribute("factors", factors);

            if (number % counter == 0) {
                numbers.add(counter);

                factorCount++;
                factorSum += counter;
            }

            String totalFactor = (number + " has " + (factorCount + 1) + " total factors");
            request.setAttribute("totalFactor", totalFactor);
            counter++;
        }
        request.setAttribute("numbers", numbers);

        String perfectNum = "";
        if (factorSum == number) {
            perfectNum = (number + " is a perfect number");
        } else {
            perfectNum = (number + " is not a perfect number");
        }
        request.setAttribute("perfectNum", perfectNum);

        String factorC = "";
        if (factorCount == 1) {
            factorC = (number + " is a prime number");
        } else {
            factorC = (number + " is not a prime number");
        }
        request.setAttribute("factorC", factorC);

        RequestDispatcher rd = request.getRequestDispatcher("factresponse.jsp");
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
