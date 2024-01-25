package samuelesimeone.dao;

import samuelesimeone.entities.Animal;
import samuelesimeone.entities.Cat;
import samuelesimeone.entities.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnimalDAO {
    private final EntityManager em;

    public AnimalDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Animal x){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(x);
        transaction.commit();
        System.out.println("Animale salvato con successo!");
    }

    public Animal getById (long id){
        Animal found = em.find(Animal.class, id);
        if (found != null) {
            return found;
        }else {
            System.out.println("Animale non trovato");
            return null;
        }
    }

    public List<Animal> findAll(){
        TypedQuery<Animal> getAll = em.createQuery("SELECT a FROM Animal a", Animal.class);
        return getAll.getResultList();
    }

    public List<Dog> findAllDog(){
        TypedQuery<Dog> getAllD = em.createQuery("SELECT d FROM Dog d", Dog.class);
        return getAllD.getResultList();
    }
    public List<Cat> findAllCat(){
        TypedQuery<Cat> getAllC = em.createQuery("SELECT c FROM Cat c", Cat.class);
        return getAllC.getResultList();
    }

    public List<String> findAllCatName(){
        TypedQuery<String> getAllCN = em.createQuery("SELECT c.name FROM Cat c", String.class);
        return getAllCN.getResultList();
    }

    public void FindDogByNameAndUpdate(String x, String y){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query updateName = em.createQuery("UPDATE Dog d SET d.name = :x WHERE d.name = :y");
        updateName.setParameter("x", x);
        updateName.setParameter("y", y);

       int nMod = updateName.executeUpdate();

        transaction.commit();

        if (nMod > 0) {
            System.out.println("Cane modificato");
        }else {
            System.out.println("Nessun cane trovato con nome: " + y);
        }
    }

    public void delete (long id){
        Animal found = em.find(Animal.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();
        }else {
            System.out.println("Animale non trovato");
        }
    }
}
