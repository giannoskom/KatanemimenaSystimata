package hua.group42.rentCar.api;

import hua.group42.rentCar.model.Rent;
import hua.group42.rentCar.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController { //controller gia to Rent

    @Autowired
    private RentService rentService;

    @PostMapping("/add")
    public String add(@RequestBody Rent rent){
        rentService.saveRent(rent);
        return "Success";
    }

    @GetMapping("/getList")
    public List<Rent> getRents(){
        return rentService.getAllRents();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){ // to id epistrefei apo to Delete request san String opote edo otan kalite i deleteRent tis rentService, to id ginete integer prin perasei os parametros.
        rentService.deleteRent(Integer.valueOf(id));
    }
}
