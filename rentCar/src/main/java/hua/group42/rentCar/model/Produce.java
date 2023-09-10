package hua.group42.rentCar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Produce")
public class Produce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // pk
    private int id;
    @Column(name = "producerName")
    private String producerName;
    @Column(name = "email")
    private String email;

    @Column(name = "carModel")
    private String carModel;

    @Column(name = "carYear")
    private String carYear;

    @Column(name = "brand")
    private String brand;

   public Produce(@JsonProperty("id") int id, @JsonProperty("producerName") String producerName, @JsonProperty("email") String email, @JsonProperty("carModel") String carModel, @JsonProperty("carYear") String carYear, @JsonProperty("brand") String Brand){
       this.id=id;
       this.producerName=producerName;
       this.email=email;
       this.carModel=carModel;
       this.carYear=carYear;
       this.brand=brand;
   }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "id=" + id +
                ", producerName='" + producerName + '\'' +
                ", email='" + email + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carYear='" + carYear + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Produce() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }
}
