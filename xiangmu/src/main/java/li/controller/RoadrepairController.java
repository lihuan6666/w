package li.controller;

import li.model.Roadrepair;
import li.service.RoadrepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RoadrepairController {
    @Autowired
    private RoadrepairService roadrepairService;
    @GetMapping("/roadrepairs")
    public ResponseEntity<List<Roadrepair>> getAllRoadrepairs() {
        List<Roadrepair> roadrepairs = roadrepairService.getAllroadrepairs();
        return ResponseEntity.ok(roadrepairs);
    }

    @PostMapping("/roadrepairs/add")
    public ResponseEntity<Roadrepair> addRoadrepair(@RequestBody Roadrepair roadrepair) {
        Roadrepair addedRoadrepair = roadrepairService.addroadrepair(roadrepair);
        return ResponseEntity.ok(addedRoadrepair);
    }

    @DeleteMapping("/roadrepairs/{id}")
    public ResponseEntity<Void> deleteRoadrepair(@PathVariable("id") int id) {
        roadrepairService.deleteRoadrepair(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/roadrepairs/search")
    public ResponseEntity<List<Roadrepair>> searchRoadrepairs(@RequestParam String query) {
        List<Roadrepair> roadrepairs = roadrepairService.searchRoadrepairs(query);
        return ResponseEntity.ok(roadrepairs);
    }

}