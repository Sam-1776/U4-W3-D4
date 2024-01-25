package samuelesimeone.eventi;

import samuelesimeone.newentities.GenereMusica;
import samuelesimeone.newentities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Evento x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Evento salvato con successo!");
    }

    public Evento getById (long id){
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            return found;
        }else {
            System.out.println("Evento non trovato");
            return null;
        }
    }

    public void delete (long id){
        Evento found = em.find(Evento.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();
        }else {
            System.out.println("Evento non trovato");
        }
    }

    public List<Boolean> getConcertiInStreaming(){
        TypedQuery<Boolean> getAllConcerti = em.createQuery("SELECT c.in_streaming FROM Concerto c", Boolean.class);
        return  getAllConcerti.getResultList();
    }

    public List<GenereMusica> getConcertiPerGenere(){
        TypedQuery<GenereMusica> getAllGeneri = em.createQuery("SELECT c.genere FROM Concerto c", GenereMusica.class);
        return getAllGeneri.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> getPartiteByVittoriaCasa = em.createNamedQuery("getVinteCasa", PartitaDiCalcio.class);
        return getPartiteByVittoriaCasa.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
        TypedQuery<PartitaDiCalcio> getPartiteByVittoriaTrasferta = em.createNamedQuery("getVinteTrasferta", PartitaDiCalcio.class);
        return getPartiteByVittoriaTrasferta.getResultList();
    }
}
