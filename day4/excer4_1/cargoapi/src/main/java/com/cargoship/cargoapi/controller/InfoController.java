import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // Get current date and time

        // Format it (yyyy-MM-dd HH:mm:ss)

        // Return formatted date and time as a string
        return null; // replace this
    }
}