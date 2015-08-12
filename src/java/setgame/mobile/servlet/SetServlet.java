/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setgame.mobile.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import setgame.SetGame;

/**
 *
 * @author jyothsna
 */
@WebServlet(name = "SetServlet", urlPatterns = {"/SetServlet"})
public class SetServlet extends HttpServlet {
    
    private SetGame setGame = SetGame.getInstance();
    String result = "";

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
        response.setContentType("application/json");
        //String gid = (String)request.getParameter("gameid");
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if ( br != null) {
            json = br.readLine();
        }
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = mapper.readValue(json, HashMap.class);
        String pid = map.get("playerid");
        String gid = map.get("gameId");
        String card1 = map.get("card1");
        String card2 = map.get("card2");
        String card3 = map.get("card3");
        
        System.out.println("In Set Servlet: " + card1 + " " + card2 + " " + card3);
        System.out.println("In Set Servlet: pid: " + pid + " gid: " + gid);
        if ( setGame.isSet(pid, card1, card2, card3) ) {
            result = "True";
        } else {
            result = "False";
        }

        mapper.writeValue(response.getOutputStream(), result);
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
