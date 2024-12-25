package li.service.shujuService;

import li.model.Shuju;
import li.model.Shuju2;
import li.model.shuju3;
import li.repository.ShujuRepository;
import li.repository.Shuju2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShujuService {

    @Autowired
    private ShujuRepository shujuRepository;

    @Autowired
    private Shuju2Repository shuju2Repository;

    public List<shuju3> getAllShujuData() {
        List<Shuju> shujuList = shujuRepository.findAll();
        List<Shuju2> shuju2List = shuju2Repository.findAll();

        return shujuList.stream().map(shuju -> {
            Shuju2 shuju2 = shuju2List.stream()
                    .filter(s2 -> s2.getRoadName().equals(shuju.getRoadName()))
                    .findFirst()
                    .orElse(null);

            if (shuju2 != null) {
                return new shuju3(
                        shuju.getId(),
                        shuju.getRoadName(),
                        shuju2.getDensity(),
                        shuju2.getLength(),
                        shuju2.getConnectedVillages(),
                        shuju.getRoadLevel(),
                        shuju2.getRoad_start() // 新增字段
                );
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<shuju3> searchShujuData(String query) {
        List<Shuju> shujuList = shujuRepository.findByRoadNameContainingOrRoadLevelContaining(query, query);
        List<Shuju2> shuju2List = shuju2Repository.findAll();

        return shujuList.stream().map(shuju -> {
            Shuju2 shuju2 = shuju2List.stream()
                    .filter(s2 -> s2.getRoadName().equals(shuju.getRoadName()))
                    .findFirst()
                    .orElse(null);

            if (shuju2 != null) {
                return new shuju3(
                        shuju.getId(),
                        shuju.getRoadName(),
                        shuju2.getDensity(),
                        shuju2.getLength(),
                        shuju2.getConnectedVillages(),
                        shuju.getRoadLevel(),
                        shuju2.getRoad_start()
                );
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
    public void deleteShujuData(int id) {
        shujuRepository.deleteById(id);
    }
    @Transactional
    public void addShujuData(Shuju shuju) {
        shujuRepository.save(shuju);
    }

    @Transactional
    public void addShuju2Data(Shuju2 shuju2) {
        shuju2Repository.save(shuju2);
    }
}