package uniajc.proyecto.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PGradoSicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PGradoSicoApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World juancho") String name) {
	return String.format("Hello %s!", name);
	}
	
}
