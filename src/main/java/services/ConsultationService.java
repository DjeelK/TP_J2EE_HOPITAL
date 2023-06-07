package services;

import entities.Consultation;
import entities.Patient;
import interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultationService extends BaseService implements Repository<Consultation> {
    @Override
    public boolean create(Consultation o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Consultation findById(int id) {
        Consultation consultation = null;
        session = sessionFactory.openSession();
        consultation = (Consultation) session.get(Consultation.class,id);
        session.close();
        return consultation;
    }

    @Override
    public List<Consultation> findAll() {
        List<Consultation> consultationList = null;
        session = sessionFactory.openSession();
        Query<Consultation> consultationQuery = session.createQuery("from Consultation");
        consultationList = consultationQuery.list();
        session.close();
        return consultationList;
    }

    @Override
    public Consultation findByNom(String nom_patient) {
        return null;
    }
}
