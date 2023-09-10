package hua.group42.rentCar.api;

import hua.group42.rentCar.model.Car;
import hua.group42.rentCar.model.Produce;
import hua.group42.rentCar.model.Rent;
import hua.group42.rentCar.service.CarService;
import hua.group42.rentCar.service.ProduceService;
import hua.group42.rentCar.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarFormController { // to vasiko controller tou programmatos, ipefthino gia tin allagi metaksi arxeion html

    @Autowired
    private RentService rentService;

    @Autowired
    private CarService carService;

    @Autowired
    private ProduceService produceService;

    @GetMapping("/")
    public String index(){
        return "start";
    }

    @GetMapping("/cars")
    public String showCarList(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("Cars", cars);
        return "car";
    }

   @GetMapping("/rent")
   public String showRentForm(@RequestParam("carId") int carId, Model model) {
       Rent rent = new Rent();
       rent.setCarID(carId);
       System.out.println(rent.getCarID());
       model.addAttribute("rent", rent);
       model.addAttribute("id", carId);
       System.out.println(rent.getCarID());
       return "rent";
   }

    @GetMapping("/renters")
    public String showRentersList(Model model) {
        List<Rent> renters = rentService.getAllRents();
        model.addAttribute("Rents", renters);
        System.out.println(renters);
        System.out.println(renters.isEmpty());
        return "renters";
    }


   @PostMapping("/saveRent")
   public ModelAndView saveRent(@ModelAttribute("rent") Rent rent) {
        rentService.saveRent(rent);
        return new ModelAndView("redirect:/");
   }

    @GetMapping("/produce")
    public String showProduceForm(Model model) {
        Produce produce = new Produce();
        model.addAttribute("produce", produce);
        return "produce";
    }

    @GetMapping("/producers")
    public String showProducersList(Model model) {
        List<Produce> producers = produceService.getAllProduces();
        model.addAttribute("Producers", producers);
        System.out.println(producers);
        System.out.println(producers.isEmpty());
        return "producers";
    }

    @PostMapping("/saveProduce")
    public ModelAndView saveProduce(@ModelAttribute("produce") Produce produce) {
        produceService.saveProduce(produce);
        return new ModelAndView("redirect:/");
    }

}
