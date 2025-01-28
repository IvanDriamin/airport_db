package ru.ikm.flight.schedule.Controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ikm.flight.schedule.model.Airports;
import ru.ikm.flight.schedule.repository.RepAirports;
import ru.ikm.flight.schedule.service.AirportsService;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api/v1/port")
//@AllArgsConstructor
public class port {

    @Autowired
    private AirportsService airportService;

    @GetMapping("/api/airports")
    public List<Airports> getAllAirports() {
        return airportService.getAllAirports();
    }
    @GetMapping("/api/airports/{code}")
    public ResponseEntity<Airports> getAirportByCode(@PathVariable String code) {
        Optional<Airports> airport = airportService.getAirportsByCode(code);
        return airport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/airports")
    public ResponseEntity<Airports> createAirport(@RequestBody Airports airport) {
        Airports createdAirport = airportService.createAirports(airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAirport);
    }

    @PutMapping("/api/airports/{code}")
    public ResponseEntity<Airports> updateAirport(@PathVariable String code, @RequestBody Airports updatedAirports) {
        Airports updated =  airportService.updateAirports(code, updatedAirports);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/api/airports/{code}")
    public ResponseEntity<Void> deleteAirports(@PathVariable String code) {
        airportService.deleteAirports(code);
        return ResponseEntity.noContent().build();
    }

    /*private final AirportsS service;

    @GetMapping
    public List<Airports> findAllAirports() {
        return service.findAllAirports();
    }

    @PostMapping("SaveAirports")
    public Airports SaveAirports (@RequestBody Airports air) {
        return service.SaveAirports(air);
    }

    @GetMapping ("/{airoport_code}")
    public Airports findAirportsByCode (@PathVariable String airoport_code) {
        return service.findAirportsByCode(airoport_code);
    }

    @PutMapping ("UpdateAirports")
    public Airports UpdateAirports (Airports air) {
        return service.UpdateAirports(air);
    }

    @DeleteMapping ("DeleteAirports/{airoport_code}")
    public void DeleteAirports (@PathVariable String airoport_code) {
        service.DeleteAirports (airoport_code);
    }*/
}
