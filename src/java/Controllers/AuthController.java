/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Entities.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author umbke
 */
@WebServlet(name = "AuthController", urlPatterns = { "/AuthController" })
public class AuthController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArrayList<Persona> personas = new ArrayList<>();

    protected void processRequest(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {}

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
        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();

        // Obtengo los datos de la peticion
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String edad = request.getParameter("edad");

        // Compruebo que los campos del formulario tienen datos para añadir a la tabla
        if (!nombre.equals("") && !apellido.equals("") && !edad.equals("")) {
            // Creo el objeto persona y lo añado al arrayList
            Persona persona = new Persona(nombre, apellido, edad);
            personas.add(persona);
        }
        out.println("<table style= cellspacing='1' bgcolor='#0099cc' >");
        out.println("<tr>");
        out.println(
            "<td style= rowspan='7' align='center' bgcolor='#f8f8f8'> NOMBRE </td>"
        );
        out.println(
            "<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>APELLIDO</td>"
        );
        out.println("<td style= rowspan='7' align='center' bgcolor='#f8f8f8'> EDAD</td>");
        out.println("</tr>");
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            out.println("<tr>");
            out.println(
                "<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>" +
                persona.getNombre() +
                "</td>"
            );
            out.println(
                "<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>" +
                persona.getApellido() +
                "</td>"
            );
            out.println(
                "<td style= rowspan='7' align='center' bgcolor='#f8f8f8'>" +
                persona.getEdad() +
                "</td>"
            );
            out.println("</tr>");
        }
        out.println("</table>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>
}
