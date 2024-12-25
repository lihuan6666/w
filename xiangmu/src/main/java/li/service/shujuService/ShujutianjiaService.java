package li.service.shujuService;

import li.model.Shuju;
import li.repository.ShujuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShujutianjiaService {

    @Autowired
    private ShujuRepository shujuRepository;

    public Shuju addShujuData(Shuju shuju) {
        return shujuRepository.save(shuju);
    }
}

