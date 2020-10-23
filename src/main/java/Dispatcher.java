import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/dispatch")
public class Dispatcher extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=null;

        switch (request.getParameter("target")){
            case "method":
                rd = request.getRequestDispatcher("/method");
                break;
            case "login":
                rd = request.getRequestDispatcher("/login");
                break;
            case "dispatch":
                rd = request.getRequestDispatcher("/dispatcher.jsp");
                ArrayList al = new ArrayList(){{
                    add("Bonjour");
                    add("à");
                    add("tous");
                }};
                request.setAttribute("list", al);
                break;
            case "accueil":
                rd = request.getRequestDispatcher("/");
                break;
            case "cookies":
                rd = request.getRequestDispatcher("/cookies");
                //response.sendRedirect("/cookies");
                //return;

        }

        rd.forward(request,response);

    }
}
