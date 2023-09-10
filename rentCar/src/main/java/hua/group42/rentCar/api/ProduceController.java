package hua.group42.rentCar.api;

import hua.group42.rentCar.model.Produce;
import hua.group42.rentCar.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produces")
public class ProduceController {

    @Autowired
    private ProduceService produceService;

    @PostMapping("/add")
    public String add(@RequestBody Produce produce){
        produceService.saveProduce(produce);
        return "Success";
    }

    @GetMapping("/getList")
    public List<Produce> getProduces(){
        return produceService.getAllProduces();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){ // to id epistrefei apo to Delete request san String opote edo otan kalite i deleteRent tis rentService, to id ginete integer prin perasei os parametros.
        produceService.deleteProduce(Integer.valueOf(id));
    }
}
