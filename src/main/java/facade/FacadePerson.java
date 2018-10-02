/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import entity.PersonDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author The Overlord
 */
public class FacadePerson
{

    EntityManagerFactory emf;

    public FacadePerson(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public PersonDTO getPerson(Long id)
    {
        EntityManager em = emf.createEntityManager();

        PersonDTO p = null;

        try
        {
            em.getTransaction().begin();
            p = em.find(Person.class, p.get());
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }

    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        List<Person> persons = null;

        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }

    public List<Person> getContactInfo()
    {
        EntityManager em = emf.createEntityManager();

        List<Person> ci = null;

        try
        {
            em.getTransaction().begin();
            ci = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return ci;
        }
        finally
        {
            em.close();
        }
    }

}
