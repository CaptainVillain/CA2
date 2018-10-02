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
import javax.persistence.TypedQuery;

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
            p = em.find(Person.class, id);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }

    public List<PersonDTO> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        List<PersonDTO> persons = null;

        try
        {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("Select new entity.PersonDTO(p.email, p.firstname, p.lastname) from Person p", PersonDTO.class);
            persons = query.getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }

    public List<PersonDTO> getContactInfo()
    {
        EntityManager em = emf.createEntityManager();

        List<PersonDTO> ci = null;

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
