package servlet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import acai.dominio.AbstractAcai;
import acai.dominio.Acai;
import acai.dominio.Sorvete;
import acai.dominio.adicionais.CoberturaChocolate;
import acai.dominio.adicionais.CoberturaMorango;
import acai.dominio.adicionais.Frutas;
import acai.dominio.adicionais.Granola;
import acai.dominio.adicionais.LeiteEmPo;
import acai.dominio.adicionais.Mel;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Augusto Coelho
 */
public class AcaiServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
           
/*ACAI =============================================================================================== */            
    try{   
            AbstractAcai acai = null;
            
            String tipo_pedido = request.getParameter("tipo_pedido");
            
            if (tipo_pedido.equalsIgnoreCase("acai")) {
                acai = new Acai();
            } else if (tipo_pedido.equalsIgnoreCase("Sorvete")) {
                acai = new Sorvete();
            }
            
            if (request.getParameterMap() != null) {
                if (request.getParameterMap().containsKey("Frutas")) {
                    acai = new Frutas(acai);
                }
                if (request.getParameterMap().containsKey("Granola")) {
                    acai = new Granola(acai);
                }
                if (request.getParameterMap().containsKey("Mel")) {
                    acai = new Mel(acai);                    
                }
                if (request.getParameterMap().containsKey("CoberturaChocolate")) {
                    acai = new CoberturaChocolate(acai);
                }
                if (request.getParameterMap().containsKey("CoberturaMorango")) {
                    acai = new CoberturaMorango(acai);
                }
                if (request.getParameterMap().containsKey("LeiteEmPo")) {
                    acai = new LeiteEmPo(acai);
                }
            }
            out.println("<body style=\"background:#8d00a1\"> ");
            out.println("Você pediu um " + acai.getDescription() + ".");
            out.println("Valor a pagar: R$" + acai.cost() + ".");
            out.println("<a href="+"\""+"pagamento.html"+"\""+">");
            out.println("<input type="+"\""+"button"+"\""+ "value="+"\""+"Realizar Pagamento"+"\""+"/>");
            out.println("</a>");
            out.println("</body>");
            out.println("</html>");
/*=======================================================================================================*/
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
