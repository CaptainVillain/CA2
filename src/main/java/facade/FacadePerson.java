/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
//import entity.PersonDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author The Overlord
 */
public class FacadePerson
{

    EntityManagerFactory emf;
    
    EntityManager em;

    public FacadePerson(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    
    public Person getPersonPhone(String phone) 
    {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT p FROM Person p WHERE p.phones.number = :phone");
            q.setParameter("phone", phone);
            em.getTransaction().commit();
            Person person = (Person) q.getSingleResult();
            return person;
        } finally {
            em.close();
        }
    }
    
    public List<Person> getPersonsByHobby(long id) 
    {
        em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Query q;
            q = em.createQuery("SELECT p FROM Person p, Hobby h WHERE h.id = :id");
            q.setParameter("id", id);
            em.getTransaction().commit();
            List<Long> hobbyList = q.getResultList();
            List<Person> persList = null;
            for(int i = 0;i<hobbyList.size()-1;i++)
            {
                
                q = em.createNativeQuery("SELECT * FROM person WHERE id = :id");
                q.setParameter("id", hobbyList.get(i));
                em.getTransaction().commit();
                persList.add((Person) q.getSingleResult());
            }
            return persList;
        } finally {
            em.close();
        }
    }
    
    public int getPersonCountByHobby(long id) 
    {
        em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Query q;
            q = em.createNativeQuery("SELECT * FROM person_hobby WHERE hobbies_id = :id");
            q.setParameter("id", id);
            em.getTransaction().commit();
            List<Long> hobbyList = q.getResultList();
            return hobbyList.size();
        } finally {
            em.close();
        }
    }
    //VOID IS TEMP
    public void getPersonsCity(String city)
    {
        try {
            //NOT DONE
            em.getTransaction().begin();
            Query q;
            q = em.createNativeQuery("SELECT * FROM person_hobby WHERE hobbies_id = :id");
            q.setParameter("city", city);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
    }
    
    

//    public PersonDTO getPerson(Long id)
//    {
//        EntityManager em = emf.createEntityManager();
//
//        PersonDTO p = null;
//
//        try
//        {
//            em.getTransaction().begin();
//   //         p = em.find(Person.class, id);
//            em.getTransaction().commit();
//            return p;
//        }
//        finally
//        {
//            em.close();
//        }
//    }
//
//    public List<PersonDTO> getPersons()
//    {
//        EntityManager em = emf.createEntityManager();
//
//        List<PersonDTO> persons = null;
//
//        try
//        {
//            em.getTransaction().begin();
//            TypedQuery<PersonDTO> query = em.createQuery("Select new entity.PersonDTO(p.email, p.firstname, p.lastname) from Person p", PersonDTO.class);
//            persons = query.getResultList();
//            em.getTransaction().commit();
//            return persons;
//        }
//        finally
//        {
//            em.close();
//        }
//    }
//
//    public List<PersonDTO> getContactInfo()
//    {
//        EntityManager em = emf.createEntityManager();
//
//        List<PersonDTO> ci = null;
//
//        try
//        {
//            em.getTransaction().begin();
//            ci = em.createQuery("Select p from Person p").getResultList();
//            em.getTransaction().commit();
//            return ci;
//        }
//        finally
//        {
//            em.close();
//        }
//    }

}
