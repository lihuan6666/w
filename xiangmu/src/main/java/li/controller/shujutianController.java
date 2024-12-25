package li.controller;

import li.model.Shuju;
import li.model.Shuju2;
import li.service.shujuService.Shuju2tianjiaService;
import li.service.shujuService.ShujutianjiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class shujutianController {

    @Autowired
    private ShujutianjiaService shujutianjiaService;

    @Autowired
    private Shuju2tianjiaService shuju2tianjiaService;


    @PostMapping("/add-shuju")
    public Shuju addShujuData(@RequestBody Shuju shuju) {
        return shujutianjiaService.addShujuData(shuju);
    }

    @PostMapping("/add-shuju2")
    public Shuju2 addShuju2Data(@RequestBody Shuju2 shuju2) {
        return shuju2tianjiaService.addShuju2Data(shuju2);
    }
}

