import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String getInfo() {
        // TODO: Get current date and time

        // TODO: Format it as "yyyy-MM-dd HH:mm:ss"

        // TODO: Return formatted string like: "Current date and time: 2025-08-07 10:30:00"
        return null; // Replace this
    }
}