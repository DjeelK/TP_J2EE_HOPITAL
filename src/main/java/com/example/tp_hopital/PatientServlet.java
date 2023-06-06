package com.example.tp_hopital;

import entities.Patient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PatientService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="patients", value ="/patients")
public class PatientServlet extends HttpServlet {
    private PatientService service;
    public void init(){
        service = new PatientService();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getParameter("nom_patient") != null){
            String nom_patient = request.getParameter("nom_patient");
            String prenom_patient = request.getParameter("prenom_patient");
            String mail_patient = request.getParameter("mail_patient");
            String tel_patient = request.getParameter("tel_patient");
            Patient patient = new Patient(nom_patient,prenom_patient,mail_patient,tel_patient);
            if(service.create(patient)) {
                out.println("<h1> Patient ajouté");
            }
        } else {
            out.println("<h1> Erreur lors de l'ajout du patient</h1>");
        }
        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            Patient patient = service.findById(id);
            out.println("<h1>Patient </h1>");
            out.println("<div>"+patient+ "</div>");
        }
        else {
            out.println("<h1>Liste des patients</h1>");
            for(Patient p : service.findAll()) {
                out.println("<div>"+p+ "</div>");
            }
        }
        out.println("</body></html>");
    }
}


