package day15.test.testing.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private String name;
    private double price;
    private String status;

    public Order(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
