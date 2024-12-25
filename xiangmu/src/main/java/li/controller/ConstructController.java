package li.controller;

import li.model.Construct;
import li.service.ConstructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConstructController {
    @Autowired
    private ConstructService constructService;

    @GetMapping("/constructs")
    public ResponseEntity<List<Construct>> getAllConstructs() {
        List<Construct> constructs = constructService.getAllConstructs();
        return ResponseEntity.ok(constructs);
    }

    @PostMapping("/constructs/add")
    public ResponseEntity<Construct> addConstruct(@RequestBody Construct construct) {
        Construct addedConstruct = constructService.addConstruct(construct);
        return ResponseEntity.ok(addedConstruct);
    }

    @DeleteMapping("/constructs/{id}")
    public ResponseEntity<Void> deleteConstruct(@PathVariable("id") int id) {
        constructService.deleteConstruct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/constructs/search")
    public ResponseEntity<List<Construct>> searchConstructs(@RequestParam String query) {
        List<Construct> constructs = constructService.searchConstructs(query);
        return ResponseEntity.ok(constructs);
    }

    @PutMapping("/constructs/{id}")
    public ResponseEntity<Construct> updateConstruct(@PathVariable("id") int id, @RequestBody Construct construct) {
        construct.setId(id);
        Construct updatedConstruct = constructService.updateConstruct(construct);
        return ResponseEntity.ok(updatedConstruct);
    }

    @GetMapping("/constructs/{id}")
    public ResponseEntity<Construct> getConstructById(@PathVariable("id") int id) {
        Construct construct = constructService.getConstructById(id);
        return ResponseEntity.ok(construct);
    }
}