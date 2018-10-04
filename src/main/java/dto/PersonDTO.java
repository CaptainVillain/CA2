/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Objects;

/**
 *
 * @author The Overlord
 */
public class PersonDTO
{
    private String email;
    private String firstname;
    private String lastname;

    public PersonDTO()
    {
    }

    public PersonDTO(String email, String firstname, String lastname)
    {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.firstname);
        hash = 23 * hash + Objects.hashCode(this.lastname);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final PersonDTO other = (PersonDTO) obj;
        if (!Objects.equals(this.email, other.email))
        {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname))
        {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "PersonDTO{" + "email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }
    
    
    
}
