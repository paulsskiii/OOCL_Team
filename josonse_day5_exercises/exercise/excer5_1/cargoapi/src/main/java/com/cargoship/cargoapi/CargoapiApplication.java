
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CargoapiApplication {
	@Autowired
    private ShipService shipService;

	public static void main(String[] args) {
		SpringApplication.run(CargoapiApplication.class, args);
	}
}
