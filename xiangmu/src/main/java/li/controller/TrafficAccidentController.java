package li.controller;

import li.model.TrafficAccident;
import li.service.TrafficAccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrafficAccidentController {

    @Autowired
    private TrafficAccidentService trafficAccidentService;

    @GetMapping("/trafficaccidents")
    public List<TrafficAccident> getAllTrafficAccidents() {
        return trafficAccidentService.getAllTrafficAccidents();
    }
    @GetMapping("/trafficaccidents/search")
    public List<TrafficAccident> searchTrafficAccidents(@RequestParam("query") String query) {
        return trafficAccidentService.searchTrafficAccidents(query);
    }
    @DeleteMapping("/trafficaccidents1/{id}")
    public ResponseEntity<Void> deleteTrafficAccidents(@PathVariable("id") int id) {
        trafficAccidentService.deleteTrafficAccidents(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/trafficaccidents/add")
    public TrafficAccident addTrafficAccident(@RequestBody TrafficAccident trafficAccident)
    {
        return trafficAccidentService.addTrafficAccident(trafficAccident);
    }
}