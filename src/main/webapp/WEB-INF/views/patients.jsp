<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
</head>
<body>
  <h1> Liste des patients</h1>
  <c:forEach items="${patients}" var="patient">
    <div>
      Nom : ${patient.getNom_patient()}
      Prenom : ${patient.getPrenom_patient()}
      <a href = "patients?id=${patient.getId_patient()}">Dossier médical</a>
    </div>
  </c:forEach>
</br>
  </br>
  <form action ="patients" method="get">
    <div><label>Rechercher par nom</label><input type="text" name="searchByName"/></div>
    <div><button type="submit" >Valider</button></div>
  </form>

</body>
</html>
