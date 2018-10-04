
import entity.Address;
import entity.CityInfo;
import entity.Person;
import facade.FacadeCity;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author The Overlord
 */
public class Populate
{
    public static void main(String[] args)
    {
        
        Persistence.generateSchema("Ca2PU", null);
        
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ca2PU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Address a1 = new Address("Some Road 1", "Villa");
        em.persist(a1);
        
        Person p1 = new Person("baggedal@godmail.dk", "Nicolai","Bagge");
        em.persist(p1);
        a1.addPersons(p1);
        p1.setAddress(a1);
        
        
        em.getTransaction().commit();
        em.close();
        FacadeCity fc = new FacadeCity(Persistence.createEntityManagerFactory("Ca2PU"));
        System.out.println(fc.getPersonsByZip("0555"));
        
//        System.out.println(fc.getCityInfoId(1l).getCity());
    }
}
