import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/panier")
public class Panier extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/panier.jsp");
        rd.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contenuBrut = "";
        // On cherche le cookie panier
        for(javax.servlet.http.Cookie cookie : request.getCookies() ){
            if(cookie.getName().equals("panier")){
                contenuBrut = cookie.getValue();
                break;
            }
        }
        //int taille = contenuBrut.split(",").length;
        //int[][] panier = new int[taille][2];

        // Création du panier
        ArrayList<int[]> panier = new ArrayList<>();
        //panier.add(new int[]{2,2});

        // Conversion du cookie en panier
        String[] couplesItemQuantite = contenuBrut.split("&");
        if(contenuBrut.length() > 0) {
            for (String coupleItemQuantite : couplesItemQuantite) {
                int itemId = Integer.parseInt(coupleItemQuantite.split(":")[0]);
                int quantite = Integer.parseInt(coupleItemQuantite.split(":")[1]);
                panier.add(new int[]{itemId, quantite});
            }
        }
        if(request.getParameter("action").equals("ajouter")){
            boolean existe = false;
            for(int[] coupleItemQuantite : panier){
                if(coupleItemQuantite[0] == Integer.parseInt(request.getParameter("id"))){
                    existe=true;
                    coupleItemQuantite[1]++;
                }
            }
            if(!existe){
                panier.add(new int[]{Integer.parseInt(request.getParameter("id")),1});
            }
        }

        if(request.getParameter("action").equals("retirer")){
            boolean existe = false;
            for(int[] coupleItemQuantite : panier){
                if(coupleItemQuantite[0] == Integer.parseInt(request.getParameter("id"))){
                    existe=true;
                    if(coupleItemQuantite[1] > 0) {
                        coupleItemQuantite[1]--;
                    }
                }
            }
        }

        contenuBrut = "";
        for(int[] coupleItemQuantite : panier){
            if(coupleItemQuantite[1] < 1)
                continue;
            contenuBrut=contenuBrut+""+coupleItemQuantite[0]+":"+coupleItemQuantite[1]+"&";
        }
        // On retire la dernière virgule
        if(contenuBrut.length() > 1)
            contenuBrut = contenuBrut.substring(0, contenuBrut.length() - 1);
        System.out.println(contenuBrut);
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("panier",contenuBrut);

        response.addCookie(cookie);

        response.sendRedirect("/panier");
        return;

    }
}
