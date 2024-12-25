package li.repository;

import li.model.TrafficAccident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficAccidentRepository extends JpaRepository<TrafficAccident, Integer> {
}