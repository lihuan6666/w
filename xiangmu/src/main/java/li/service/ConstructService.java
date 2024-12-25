package li.service;

import li.model.Construct;
import li.repository.ConstructRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstructService {
    @Autowired
    private ConstructRepository constructRepository;

    public List<Construct> getAllConstructs() {
        return constructRepository.findAll();
    }

    public Construct addConstruct(Construct construct) {
        return constructRepository.save(construct);
    }

    public void deleteConstruct(int id) {
        constructRepository.deleteById(id);
    }

    public List<Construct> searchConstructs(String query) {
        return constructRepository.findAll().stream()
                .filter(construct -> construct.getNew_road_name().contains(query) ||
                        construct.getRoad_constructcompany().contains(query))
                .collect(Collectors.toList());
    }

    public Construct updateConstruct(Construct construct) {
        return constructRepository.save(construct);
    }

    public Construct getConstructById(int id) {
        return constructRepository.findById(id).orElse(null);
    }
}