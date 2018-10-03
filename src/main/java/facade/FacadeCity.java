/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.CityInfoDTO;
import entity.CityInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
}
