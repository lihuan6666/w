package li.service.shujuService;

import li.model.Shuju2;
import li.repository.Shuju2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Shuju2tianjiaService {

    @Autowired
    private Shuju2Repository shuju2Repository;

    public Shuju2 addShuju2Data(Shuju2 shuju2)
    {
        return shuju2Repository.save(shuju2);
    }
}
