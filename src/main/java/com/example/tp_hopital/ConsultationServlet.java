package com.example.tp_hopital;

import entities.FicheDeSoin;
import entities.Prescription;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ConsultationService;
import util.Definition;

import java.io.IOException;

@WebServlet(name="patientDetail", value="/patientDetail")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService serviceConsultation;

    public void init() {
        serviceConsultation = new ConsultationService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("nom_consultation") != null) {
            String nom_consultation = request.getParameter("nom_consultation");
            entities.Consultation consultation = new entities.Consultation();
            consultation.setNom_consultation(nom_consultation);
            if (serviceConsultation.create(consultation)) {
                response.sendRedirect("consultations");
            }
        } else {
        }
    }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt((request.getParameter("id")));
                entities.Consultation consultation = serviceConsultation.findById(id);
                request.setAttribute("consultation", consultation);
                request.getRequestDispatcher(Definition.VIEW_PATH + "consultation.jsp").forward(request, response);
            } else {
                request.setAttribute("consultations", serviceConsultation.findAll());
                request.getRequestDispatcher(Definition.VIEW_PATH + "consultations.jsp").forward(request, response);
            }
        }

    }
