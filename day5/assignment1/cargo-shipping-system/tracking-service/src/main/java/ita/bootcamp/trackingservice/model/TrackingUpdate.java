package ita.bootcamp.trackingservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingId;
    private Long cargoItemId;
    private String status;
    private String location;
    private LocalDateTime timestamp;
}
