package samuelesimeone;

import samuelesimeone.dao.AnimalDAO;
import samuelesimeone.entities.Cat;
import samuelesimeone.entities.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("teoria_d4");

    public static void main(String[] args) {
        System.out.println("Teoria D4");

        EntityManager em = emf.createEntityManager();
        AnimalDAO ab = new AnimalDAO(em);

        Cat tor = new Cat("jhon", 12, 12.0);
        Dog pluto = new Dog("pluto", 100, 45.0);

//        ab.save(tor);
//        ab.save(pluto);

//        ab.findAll().forEach(System.out::println);
//        ab.findAllDog().forEach(System.out::println);
//        ab.findAllCat().forEach(System.out::println);

//        ab.findAllCatName().forEach(System.out::println);

//        System.out.println(ab.getById(5));
//        System.out.println(ab.getById(6));

//        ab.FindDogByNameAndUpdate("rosso", "pluto");
        ab.findAllDog().forEach(System.out::println);


        em.close();
        emf.close();
    }
}
