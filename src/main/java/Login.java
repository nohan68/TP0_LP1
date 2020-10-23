import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = null;
        out = response.getWriter();
        out.println("<html>");
        if(request.getParameter("pseudo").equals("admin") && request.getParameter("mdp").equals("password")) {
            response.sendRedirect("/panier");
            return;
            //out.println("<h1>Bienvenue "+request.getParameter("pseudo")+"</h1>");
        }
        else {
            response.sendRedirect("/index.jsp?message=Identifiants%20incorrect%20");
            return;
            //out.println("<h1>Identifiants incorrects <br><a href='login'> Retour </a> </h1>");
            //out.println("<script>alert('Identifiants incorrects');</script>");
        }

        //out.println(request.getParameter("mdp"));
        //out.println("</html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = null;
        out = response.getWriter();

        out.println("<html>");
        out.println("<h1> Connexion </h1>");
        out.println("<form action='/login' method=\"post\" class=\"form-example\">\n" +
                "  <div>\n" +
                "    <label for=\"pseudo\">Pseudo </label>\n" +
                "    <input type=\"text\" name=\"pseudo\" id=\"pseudo\" required>\n" +
                "  </div>\n" +
                "  <div>\n" +
                "    <label for=\"mdp\">Mot de passe </label>\n" +
                "    <input type=\"password\" name=\"mdp\" id=\"mdp\" required>\n" +
                "  </div>\n" +
                "  <div>\n" +
                "    <input type=\"submit\" value=\"Se connecter\">\n" +
                "  </div>\n" +
                "</form>");
        out.println("<span> Tips: pseudo: admin  et motdepasse: password");
        out.println("</html>");
    }
}
