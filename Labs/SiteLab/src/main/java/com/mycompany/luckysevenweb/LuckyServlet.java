package com.mycompany.luckysevenweb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;
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
@WebServlet(urlPatterns = {"/LuckyServlet"})
public class LuckyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LuckyServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LuckyServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = request.getRequestDispatcher("luckyseven.jsp");
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

        String ibet = "";
        double bet = 0;

        try {
            ibet = request.getParameter("bet");
            bet = Double.parseDouble(ibet);
        } catch (NumberFormatException ex) {
            String error = ("Incorrect format!");
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("luckyseven.jsp");
            rd.forward(request, response);
        }

        int rolls = 0;
        double maxMoney = 0;
        int maxRolls = 0;

        while (bet > 0) {
            if (bet > maxMoney) {
                maxMoney = bet;
                maxRolls = rolls;
            }
            int total = rollDice();
            if (total == 7) {
                bet += 4;
            } else {
                bet -= 1;
            }

            rolls++;
        }

        String messageToUser = ("You are broke after " + rolls + " rolls");
        DecimalFormat df2 = new DecimalFormat(".00");
        String messageToUser2 = ("You should of quit after " + maxRolls + " rolls when you had $" + df2.format(maxMoney));

        request.setAttribute("message", messageToUser);
        request.setAttribute("message2", messageToUser2);

        RequestDispatcher rd = request.getRequestDispatcher("lsresponse.jsp");
        rd.forward(request, response);

    }

    public int rollDice() {
        Random generator = new Random();
        int dice1 = generator.nextInt(6) + 1;
        int dice2 = generator.nextInt(6) + 1;
        int total = dice1 + dice2;
        return total;
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
