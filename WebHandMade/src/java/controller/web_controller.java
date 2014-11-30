/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Shops;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ShopsFacade;

/**
 *
 * @author Mary
 */
@WebServlet(name = "web_controller", loadOnStartup=1, urlPatterns = {"/shop", "/registration"})
public class web_controller extends HttpServlet {
    
    @EJB
    ShopsFacade shopsFacade;

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("shops", shopsFacade.findAll());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userPath=request.getServletPath();
        if ("/shop".equals(userPath)){
            String id=null;
            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String param = params.nextElement();
                id = "id".equals(param) ? request.getParameter(param) : id;
            }
            try {
                Shops shop = shopsFacade.find(Integer.parseInt(id));
                request.setAttribute("shop", shop);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("/registration".equals(userPath)) {
            //TODO: обработка запроса регистрации
        }

        request.getRequestDispatcher("/WEB-INF/views" + userPath + ".jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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