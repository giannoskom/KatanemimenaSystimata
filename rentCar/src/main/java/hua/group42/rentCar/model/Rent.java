package hua.group42.rentCar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // pk
    private int id;
    @Column(name = "renterName")
    private String renterName;
    @Column(name = "renterLastName")
    private String renterLastName;
    @Column(name="gettingTime")
    private Date gettingDate;

    @Column(name="email")
    private String email;

    @Column(name = "backTime")
    private Date backDate;

    public Rent(@JsonProperty("id") int id, @JsonProperty("renterName") String renterName, @JsonProperty("renterLastName") String renterLastName,@JsonProperty("email") String email, @JsonProperty("gettingDate") Date gettingDate, @JsonProperty("backDate") Date backDate) {
        this.id = id;
        this.renterName=renterName;
        this.renterLastName=renterLastName;
        this.email=email;
        this.gettingDate = gettingDate;
        this.backDate = backDate;
    }

    public Rent() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRenterName() { return renterName; }

    public void setRenterName(String renterName) {this.renterName = renterName;}

    public String getRenterLastName(){ return renterLastName;}

    public void setRenterLastName(String renterLastName){ this.renterLastName=renterLastName;}

    public Date getGettingDate() {
        return gettingDate;
    }

    public void setGettingDate (Date gettingDate) {
        this.gettingDate = gettingDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate (Date backDate) {
        this.backDate = backDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", renterName='" + renterName + '\'' +
                ", renterLastName='" + renterLastName + '\'' +
                ", gettingDate=" + gettingDate +
                ", email='" + email + '\'' +
                ", backDate=" + backDate +
                '}';
    }
}
