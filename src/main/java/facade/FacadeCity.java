/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.CityInfoDTO;
import entity.CityInfo;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author The Overlord
 */
public class FacadeCity
{
    EntityManagerFactory emf;
    
    public FacadeCity(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public List<CityInfoDTO> getZipCodes()
    {
        EntityManager em = emf.createEntityManager();
        List<CityInfoDTO> zipcodes = null;
        try
        {
           em.getTransaction().begin();
           zipcodes = em.createQuery("Select c.zipCode from CityInfo c",CityInfoDTO.class).getResultList();
           em.getTransaction().commit();
           return zipcodes;
        }finally
        {
            em.close();
        }
    }
    public List<Person> getPersonsByZip(String zipcode)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
           em.getTransaction().begin();
           
           Query pbz = em.createQuery("Select p from Person p join p.address a where a.cityInfo.zipCode=:zipcode");
           pbz.setParameter("zipcode", zipcode);
           List<Person> persons = pbz.getResultList();
           em.getTransaction().commit();
           return persons;
        }finally
        {
            em.close();
        }
        
    }
     public CityInfo getCityInfoId(Long id)
    {
        EntityManager em = emf.createEntityManager();
        
        CityInfo c = null;
        try
        {
            em.getTransaction().begin();
            c = em.find(CityInfo.class, id);
            em.getTransaction().commit();
            return c;
        }
        finally
        {
            em.close();
        }

    }
}
