/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ClaseDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

    
    String r1[]=null; //para atributos de usuario
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String pagina= request.getParameter("nombrePag");
        
        if(pagina.equals("index")){
            
            String id= request.getParameter("user");
            
            String user=request.getParameter("nomusuario");
            String pwd=request.getParameter("contrasena");
            
            if(CheckUser(pwd,user)){
             r1=ClaseDAO.ConsultarRegistroUnitario(r1[0],"usuario");
             
             if(r1[0]!=null){
             request.getServletContext().getRequestDispatcher("/Vistaestudiante.jsp").forward(request, response);
             }else{
             request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                request.setAttribute("error", "error");
             }
            
            }
        
        }
        
        
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
    
     public boolean CheckUser(String pwd, String user) {

        boolean pas = false;

        if (pwd.isEmpty()) {

            return pas;
        } else {

            r1 = ClaseDAO.ConsultarRegistroUnitario(user, "nomusuario");

            if (r1 != null) {
                pwd = getHash(pwd, "MD5");
                if (pwd.equalsIgnoreCase(r1[2])) {
                    pas = true;
                }

            }

        }
        return pas;
    }
     
     public String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    

}
