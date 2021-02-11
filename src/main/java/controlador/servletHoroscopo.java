package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Utilidades;

public class servletHoroscopo extends HttpServlet {

    private ArrayList<String> meses;
    private ArrayList<String> dias;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        meses = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            meses.add(String.valueOf(i));
        }

        dias = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            dias.add(String.valueOf(i));
        }
    }

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Horoscopo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Horoscopo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String nombre = "";
        String diaSeleccionado = "1";
        String mesSeleccionado = "1";
        String error = "";

        if (request.getParameter("nombre") != null) {
            nombre = request.getParameter("nombre");
        }
        
        if (request.getParameter("dia") != null) {
            diaSeleccionado = request.getParameter("dia");
        }
        if (request.getParameter("mes") != null) {
            mesSeleccionado = request.getParameter("mes");
        }
        boolean diaCorrecto = Utilidades.comporbarDiaMes(Integer.parseInt(diaSeleccionado), Integer.parseInt(mesSeleccionado));
        if(!diaCorrecto) {
            error = "No existe el día " + diaSeleccionado + " para el mes " + mesSeleccionado;
            diaSeleccionado = "1";
            mesSeleccionado = "1";
        }
        
        request.setAttribute("nombre", nombre);
        request.setAttribute("dia", diaSeleccionado);
        request.setAttribute("mes", mesSeleccionado);

        String signo = "";

        request.setAttribute("dias", dias);
        request.setAttribute("meses", meses);
        signo = Utilidades.obtenerSigno(Integer.parseInt(diaSeleccionado), Integer.parseInt(mesSeleccionado));
        request.setAttribute("signo", signo);
        request.setAttribute("err_str", error);
        request.setAttribute("err_bool", diaCorrecto);
        request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
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
