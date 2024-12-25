package li.service;

import li.model.Roadrepair;
import li.repository.RoadrepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoadrepairService {
    @Autowired
    private RoadrepairRepository roadrepairRepository;

    public List<Roadrepair> getAllroadrepairs() {
        return roadrepairRepository.findAll();
    }

    public Roadrepair addroadrepair(Roadrepair roadrepair) {
        return roadrepairRepository.save(roadrepair);
    }

    public void deleteRoadrepair(int id) {
        roadrepairRepository.deleteById(id);
    }

    // 实现搜索功能
    public List<Roadrepair> searchRoadrepairs(String query) {
        return roadrepairRepository.findAll().stream()
                .filter(roadrepair -> roadrepair.getRoad_name().contains(query) ||
                        roadrepair.getRoad_repairman().contains(query))
                .collect(Collectors.toList());
    }
}