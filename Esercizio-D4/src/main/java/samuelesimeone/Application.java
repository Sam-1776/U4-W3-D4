package samuelesimeone;

import samuelesimeone.eventi.EventoDAO;
import samuelesimeone.newentities.Concerto;
import samuelesimeone.newentities.GenereMusica;
import samuelesimeone.newentities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizio_d4");
    public static void main(String[] args) {

        System.out.println("Esercizio D4");

        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        PartitaDiCalcio p1 = new PartitaDiCalcio("Milan-inter", LocalDate.now(), "derby", 80000, "Milan", "Inter", "Milan", 2, 1);
//        ed.save(p1);
        Concerto c1 = new Concerto("Rock-festival", LocalDate.now().plusMonths(3), "Festival musicale", 1000000, GenereMusica.rock, false);
//        ed.save(c1);
        ed.getConcertiInStreaming().forEach(System.out::println);
        ed.getConcertiPerGenere().forEach(System.out::println);
        ed.getPartiteVinteInCasa().forEach(System.out::println);

        PartitaDiCalcio p2 = new PartitaDiCalcio("Inter-Milan", LocalDate.now().plusWeeks(2), "derby", 80000, "Inter", "Milan", "Milan", 0, 1);
//        ed.save(p2);
        ed.getPartiteVinteInTrasferta().forEach(System.out::println);


        em.close();
        emf.close();

    }
}
