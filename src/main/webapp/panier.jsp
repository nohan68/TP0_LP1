<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Articles" %><%--
  Created by IntelliJ IDEA.
  User: nohanjaugey
  Date: 14/10/2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panier</title>
</head>
<body>

<div style="display: flex">
<div>
    <h2>Magasin</h2>

    <ol>
        <form action="/panier" method="post">
            <input type="hidden" name="id" value="1">
            <input type="hidden" name="action" value="ajouter">
            <li> <input type="submit" value="Ajouter">Potiron</li>
        </form>
        <form action="/panier" method="post">
            <input type="hidden" name="id" value="2">
            <input type="hidden" name="action" value="ajouter">
            <li><input type="submit" value="Ajouter"> Bannane</li>
        </form>
        <form action="/panier" method="post">
            <input type="hidden" name="id" value="3">
            <input type="hidden" name="action" value="ajouter">
            <li><input type="submit" value="Ajouter">Poire </li>
        </form>
        <form action="/panier" method="post">
            <input type="hidden" name="id" value="4">
            <input type="hidden" name="action" value="ajouter">
            <li><input type="submit" value="Ajouter">Pomme</li>
        </form>
        <form action="/panier" method="post">
            <input type="hidden" name="id" value="5">
            <input type="hidden" name="action" value="ajouter">
            <li><input type="submit" value="Ajouter">Noix </li>
        </form>
        <form action="/panier" method="post">
            <input type="hidden" name="id" value="6">
            <input type="hidden" name="action" value="ajouter">
            <li><input type="submit" value="Ajouter">Patate </li>
        </form>
    </ol>
</div>
<div style="margin-right: 0px;">
    <h2>Panier</h2>
    <table>
        <thead>
            <tr>
                <th> Item x Quantite </th>
                <th> image </th>
                <th> Prix à l'unité </th>
                <th> Prix total </th>
            </tr>
        </thead>
        <tbody>
    <%
        for(javax.servlet.http.Cookie cookie : request.getCookies() ){
            if(cookie.getName().equals("panier")){
                String contenuBrut = cookie.getValue();

                // Création du panier
                ArrayList<int[]> panier = new ArrayList<>();
                String[] couplesItemQuantite = contenuBrut.split("&");

                if(contenuBrut.length() > 0) {
                    for (String coupleItemQuantite : couplesItemQuantite) {
                        int itemId = Integer.parseInt(coupleItemQuantite.split(":")[0]);
                        int quantite = Integer.parseInt(coupleItemQuantite.split(":")[1]);
                        %>
                        <tr>
                            <td><%= Articles.get(itemId).libelle + " x " + quantite + "<br>" %></td>
                            <td><img height="100" width="100" src="<%= Articles.get(itemId).imageURL%>"> </td>
                            <td><%= Articles.get(itemId).prix  %></td>
                            <td><%= (Articles.get(itemId).prix*quantite) %></td>
                            <td>
                                <form method="post">
                                    <input type="hidden" name="action" value="retirer">
                                    <input type="hidden" name="id" value="<%= itemId%>">
                                    <input type="submit" value="retirer">
                                </form>
                            </td>
                        </tr>
                        <%
                    }
                }
            }
        }
    %>
        </tbody>
    </table>

    <form action="/cookies" method="post">
        <input type="hidden" name="action" value="supprimer">
        <input type="hidden" name="cookie" value="panier">
        <input type="hidden" name="origin" value="panier">
        <input type="submit" value="Vider le panier">
    </form>

</div>
</div>
</body>
</html>
