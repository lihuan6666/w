package li.service;

import li.model.TrafficAccident;
import li.repository.TrafficAccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrafficAccidentService {

    @Autowired
    private TrafficAccidentRepository trafficAccidentRepository;

    public List<TrafficAccident> getAllTrafficAccidents() {
        return trafficAccidentRepository.findAll();
    }

    public List<TrafficAccident> searchTrafficAccidents(String query) {
        return trafficAccidentRepository.findAll().stream()
                .filter(accident -> accident.getRoad_name().contains(query) || accident.getTime().contains(query))
                .collect(Collectors.toList());
    }
    public  void deleteTrafficAccidents(int id) {

        trafficAccidentRepository.deleteById(id);
    }

    public TrafficAccident addTrafficAccident(TrafficAccident trafficAccident ) {
        return trafficAccidentRepository.save(trafficAccident);
    }
}