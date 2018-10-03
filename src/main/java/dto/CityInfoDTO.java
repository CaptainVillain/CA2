/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import java.util.Objects;
/**
 *
 * @author Tiba
 */
public class CityInfoDTO {

    private String zipCode;
    private String city;

    public CityInfoDTO() {
    }

    public CityInfoDTO(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CityInfoDTO{" + "zipCode=" + zipCode + ", city=" + city + '}';
    }
    
    

}
