package gr.hua.project.RentCar;

import gr.hua.project.RentCar.entity.Car;
import gr.hua.project.RentCar.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentCarApplication.class, args);
	}

	/*
	public CommandLineRunner demo(CarService carService) {
		return (args) -> {
			// save few person
			Car car1= new Car();
			car1.setName("Name1");
			car1.setModel("Model1");
			car1.setYear(1);

			Car car2= new Car();
			car2.setName("Name2");
			car2.setModel("Model2");
			car2.setYear(2);

			carService.saveCar(car1);
			carService.saveCar(car2);

			// fetch all Car
			System.out.println("-----List of Persons------");
			for(Car car: carService.getCars()){
				System.out.println("Car detail:"+ car);
			}
		};
	}
	*/

}
