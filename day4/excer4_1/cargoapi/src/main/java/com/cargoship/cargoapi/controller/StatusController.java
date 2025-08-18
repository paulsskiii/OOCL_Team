import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling API status requests.
 */
@RestController
public class StatusController {

    @GetMapping("/status")
    public String getStatus() {
        // Return a basic health check message
        return null; // replace this
    }
}
