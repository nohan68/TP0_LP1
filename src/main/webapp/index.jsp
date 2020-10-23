<html>
<body>
<h2>TP0: LP1 LPCDAD:2</h2>
<h3>JAUGEY Nohan<br>SCHMIDT Simon</h3>
<ol>
    <li> <a href="dispatch?target=method">Methode </a></li>
    <li> On s'en fou</li>
    <li> <a href="dispatch?target=login">Login </a></li>
    <li> <a href="dispatch?target=dispatch">Dispatch</a></li>
    <li> <a href="dispatch?target=accueil">Accueil</a> </li>
    <li> <a href="dispatch?target=cookies">Cookies</a> </li>

    <p style="color:darkred"><%= request.getParameter("message")==null ? "" : request.getParameter("message") %></p>
</ol>
</body>
</html>

