<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/06/2023
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Consultations</title>
</head>
<body>
<h1>Liste des consultations</h1>
<c:forEach items="${consultations}" var="consultation">
  <div>
    Titre consultation : ${consultation.getNom_consultation()}
    Prescription : ${consultation.getPrescription()}
    Fiche de soin : ${consultation.getFicheDeSoin()}
  </div>
</c:forEach>
<h1>Création consultation</h1>
<form method="post">
  <div><label>Titre de la consultation :</label><input type="text" name="nom_consultation"/></div>
  <div><label>Médicament :</label><input type="text" name="medicament_prescription"/></div>
  <div><label>Fiche de soin</label><textarea></textarea></div>
  <div><button type="submit" >Valider</button></div>
</form>
</body>
</html>