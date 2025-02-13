package ru.ikm.flight.schedule.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "scheduled_flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Schedules {

    @Id
    @Column(name = "flight_id")
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name = "aircraft_code")
    private Aircraft aircraft;

    @Column(name="scheduled_date")
    private LocalDate scheduledDate;
}
