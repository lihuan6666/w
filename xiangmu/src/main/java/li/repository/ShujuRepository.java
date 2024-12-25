package li.repository;

import li.model.Shuju;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShujuRepository extends JpaRepository<Shuju, Integer> {
    List<Shuju> findByRoadNameContainingOrRoadLevelContaining(String roadName, String roadLevel);
}

