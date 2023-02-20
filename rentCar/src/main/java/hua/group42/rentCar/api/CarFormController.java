package hua.group42.rentCar.api;

import hua.group42.rentCar.model.Rent;
import hua.group42.rentCar.service.CarService;
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

    @GetMapping("/")
    public String index(){
        return "start";
    }

    @GetMapping("/cars")
    public String Cars(){
        return "car";
    }

   @GetMapping("/rent")
   public String showRentForm(Model model) {
       Rent rent = new Rent();
       model.addAttribute("rent", rent);
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



}
