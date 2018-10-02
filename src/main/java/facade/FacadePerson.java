/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
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
    public Person getPerson(Long id)
    {
        EntityManager em = emf.createEntityManager();
        
        Person p = null;
        
        try
        {
           em.getTransaction().begin();
           p = em.find(Person.class , );
           em.getTransaction().commit();
           return p;
        }
        finally
        {
            em.close();
        }
    }
}
