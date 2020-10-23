import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/method")
public class Method extends HttpServlet {
    public void doDelete(HttpServletRequest request, HttpServletResponse response){
        afficherPage(request,response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response){
        afficherPage(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        afficherPage(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        afficherPage(request,response);
    }

    public void afficherPage(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        PrintWriter out = null;


        try {
            out = response.getWriter();

            out.println("<html>");
            out.println("<h1> METHOD: "+request.getMethod()+" </h1>");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            out.close();
        }


    }




    public void destroy() {
        // do nothing.
    }
}
