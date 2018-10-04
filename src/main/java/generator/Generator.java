/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Kristian
 */
public class Generator
{

    public void populate(int amount)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ca2PU");
        EntityManager em = emf.createEntityManager();

        ArrayList<String> first = Generator.genFirstName();
        ArrayList<String> last = Generator.genLastName();
        ArrayList<String> emailList = Generator.genEmail();

        List<Hobby> hobbies = Generator.genHobbies();

        ArrayList<String> streets = Generator.genStreetNames();
        ArrayList<String> addressInfo = Generator.genAdditionalInfo();

        List<CityInfo> cityList = Generator.getCityInfo();

        for (int i = 0; i < amount; i++)
        {
            em.getTransaction().begin();

            String firstName = first.get((int) (Math.random() * first.size()));
            String lastName = last.get((int) (Math.random() * last.size()));
            String email = emailList.get((int) (Math.random() * emailList.size()));
            String street = streets.get((int) (Math.random() * streets.size()));
            String info = addressInfo.get((int) (Math.random() * addressInfo.size()));
            CityInfo cityInfo = cityList.get((int) (Math.random() * cityList.size()));
            Address address = new Address(street, info, cityInfo);
            Person person = new Person(email, firstName, lastName, address);

            for (int j = 0; j <= (int) (Math.random() * 5); j++)
            {
                person.addPhone(new Phone(Generator.genPhone(), "Who this?"));
            }

            person.addHobby(hobbies.get((int) (Math.random() * hobbies.size())));


            em.persist(person);
            em.getTransaction().commit();
        }
    }

    private static ArrayList<String> genFirstName()
    {
        ArrayList<String> first = new ArrayList<String>();
        first.add("Benny");
        first.add("Johnny");
        first.add("Suleiman");
        first.add("Abdul");
        first.add("Sveinur");
        return first;
    }

    private static ArrayList<String> genLastName()
    {
        ArrayList<String> last = new ArrayList<String>();
        last.add("Hansen");
        last.add("Jensen");
        last.add("Fransen");
        return last;
    }

    private static String genPhone()
    {
        StringBuilder psb = new StringBuilder();
        psb.append((int) (Math.random() * 9));
        psb.append((int) (Math.random() * 9));
        psb.append((int) (Math.random() * 9));
        psb.append((int) (Math.random() * 9));
        psb.append((int) (Math.random() * 9));
        psb.append((int) (Math.random() * 9));
        psb.append((int) (Math.random() * 9));
        psb.append((int) (Math.random() * 9));
        return psb.toString();
    }

    private static List<Hobby> genHobbies()
    {
        List<Hobby> hobbies = new ArrayList();
        hobbies.add(new Hobby("Skydning", "På bane/i klub"));
        hobbies.add(new Hobby("Alkoholiker", "Dagligt indtag af store mængder alkohol"));
        hobbies.add(new Hobby("Golf", "Slå til lille bold på kæmpe græsplæne"));
        hobbies.add(new Hobby("Jagt", "Alle slags"));
        hobbies.add(new Hobby("Svømning", "..."));
        return hobbies;
    }

    private static ArrayList<String> genStreetNames()
    {
        ArrayList<String> streets = new ArrayList();
        streets.add("Etgade");
        streets.add("Togade");
        streets.add("Tregade");
        streets.add("Firegade");
        streets.add("Femgade");
        streets.add("Seksgade");
        streets.add("Syvgade");
        streets.add("Ottegade");
        streets.add("Nigade");
        return streets;
    }

    private static ArrayList<String> genAdditionalInfo()
    {
        ArrayList<String> info = new ArrayList();
        info.add("1");
        info.add("2");
        info.add("3");
        info.add("4");
        info.add("5");
        info.add("6");
        info.add("7");
        info.add("8");
        info.add("9");
        return info;
    }

    public static List<CityInfo> getCityInfo()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ca2PU");
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT p FROM CityInfo p");
            em.getTransaction().commit();
            List<CityInfo> infoList = q.getResultList();
            return infoList;
        }
        finally
        {
            em.close();
        }
    }
    
    public static ArrayList<String> genEmail()
    {
        ArrayList<String> email = new ArrayList<String>();
        email.add("et@mail.dk");
        email.add("to@mail.dk");
        email.add("tre@mail.dk");
        email.add("fire@mail.dk");
        email.add("fem@mail.dk");
        return email;
    }

}
