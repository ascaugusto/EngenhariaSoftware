/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author augusto.coelho
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        
/* Login ============================================================================================= */            
   try {    
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
                       
            /*Trata login e senha em branco ===============================*/
            if ((login == "")&&(senha== "")){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>AcaiServlet</title>");
                out.println("</head>");
                out.println("<body style=\"background:#8d00a1\"> ");      
                out.println("<h3>Digite o Login do Admin.</h3>");
                out.println("<h3>Digite a Senha do Admin.</h3>");
                out.println("</body>");
                out.println("</html>");
            } else if ((login == "")&&(senha!= "")){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>AcaiServlet</title>");
                out.println("</head>");
                out.println("<body style=\"background:#8d00a1\"> ");      
                out.println("<h3>Digite Login do Admin.</h3>");
                out.println("</body>");
                out.println("</html>");
            } else if ((login != "")&&(senha == "")){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>AcaiServlet</title>");
                out.println("</head>");
                out.println("<body style=\"background:#8d00a1\"> ");      
                out.println("<h3>Digite Senha do Admin</h3>");
                out.println("</body>");
                out.println("</html>");
            } else if ((login != "")&&(senha != "")){
                       if(login.equals("admin") && senha.equals("admin")){ // Login e senha preenchidos 
                            RequestDispatcher dispatcher = request.getRequestDispatcher("acai.html");
                            dispatcher.forward(request, response);
                       } else { 
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>AcaiServlet</title>");
                            out.println("</head>");
                            out.println("<body style=\"background:#8d00a1\"> ");      
                            out.println("<h3>Login ou Senha do Admin incorreta</h3>");
                            out.println("</body>");
                            out.println("</html>");
                       }
            } 
        } finally {
            out.close();
        }
    }
    
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
        processRequest(request, response);
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
        processRequest(request, response);
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