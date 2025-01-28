package ru.ikm.flight.schedule.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table(name = "airports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Data
//@Builder
//@Entity
public class Airports {

    @Id
    @Column(name = "airport_code")
    private String airportCode;
    @Column(name = "airport_name")
    private String airportName;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;

    /*@Id
    @GeneratedValue
    private Long airoport_id;
    @Column(unique = true)
    private String airoport_code;
    private String airoport_name;
    private String city;
    private String country;*/
}
