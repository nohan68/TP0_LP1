import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet("/cookies")
public class Cookie extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("\n" +
                "<html>\n" +
                "<body>\n" +
                "<h2>Cookies</h2>\n" +
                "\n" +
                "<form method=\"post\" action='cookies'>\n" +
                "    <input type='hidden' name='action' value='ajouter'>"+
                "    <label for=\"cookie\">Cookie </label>\n" +
                "    <input id=\"cookie\" name=\"cookie\">\n" +
                "    <label for=\"contenue\">Contenu </label>\n" +
                "    <input id=\"contenue\" name=\"contenue\">\n" +
                "    <input type=\"submit\" value=\"Ajouter\">\n" +
                "</form>\n" );
        printWriter.println("<h2>Mes cookies</h2>" +
                            "<table>");

        for(javax.servlet.http.Cookie cookie : request.getCookies() ){
            printWriter.println("<tr><td>"+cookie.getName()+"</td><td>"+cookie.getValue()+"</td><td><form action='/cookies' method='post'><input type='hidden' name='action' value='supprimer'><input type='hidden' name='cookie' value='"+cookie.getName()+"'><input type='submit' value='Supprimer'></form></td></tr>");
        }
        printWriter.println("</table>" +
                "</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        if(request.getParameter("action").equals("ajouter")){
            javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(
                    request.getParameter("cookie"),
                    request.getParameter("contenue")
            );
            response.addCookie(cookie);
        }
        if(request.getParameter("action").equals("supprimer")){
            javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(request.getParameter("cookie"), "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        /*
        for(Map.Entry<String,String[]> element : request.getParameterMap().entrySet()){
            cookie = new javax.servlet.http.Cookie(element.getKey(),element.getValue()[0]);
            response.addCookie(cookie);
        }
        */
        if(request.getParameter("origin") != null){
            response.sendRedirect("/"+request.getParameter("origin"));
            return;
        }
        response.sendRedirect("/cookies");
    }

}