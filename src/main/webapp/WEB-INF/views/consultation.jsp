<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/06/2023
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consultation ${consulation.getId_consultation}</title>
</head>
<body>
<div>
    Titre consultation : ${consultation.getNom_consultation()}
    Prescription : ${consultation.getPrescription()}
    Fiche de soin : ${consultation.getFicheDeSoin()}
</div>
</body>
</html>
