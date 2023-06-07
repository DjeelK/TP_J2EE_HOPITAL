package services;

import entities.Patient;
import interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {

    public PatientService(){
        super();
    }
    @Override
    public boolean create(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Patient findById(int id) {
        Patient patient = null;
        session = sessionFactory.openSession();
        patient = (Patient) session.get(Patient.class,id);
        session.close();
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = null;
        session = sessionFactory.openSession();
        Query<Patient> patientQuery = session.createQuery("from Patient");
        patientList = patientQuery.list();
        session.close();
        return patientList;
    }

    @Override
    public Patient findByNom(String nom_patient) {
            Patient patient = null;
            session = sessionFactory.openSession();
            Query<Patient> query = session.createQuery("from Patient where nom_patient = :nom_patient");
            query.setParameter("nom_patient",nom_patient);
            patient = query.uniqueResult();
            session.close();
            return patient;
        }
    }

