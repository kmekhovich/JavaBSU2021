package by.kmekhovich.auto.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date departureTime;
    @NotNull
    String departurePlace;
    @NotNull
    String destinationPlace;
    @NotNull
    Integer availableSeats;
    @NotNull
    String automobile;

    @OneToMany
    List<Passenger> passengers;

    public boolean hasAvailableSeats() {
        return getAvailableSeats() > 0;
    }

    public static Order createDefaultOrder() {
        Order order = new Order();
        order.setDepartureTime(Date.from(Instant.now()));
        order.setDeparturePlace("бгу");
        order.setDestinationPlace("колодищи");
        order.setAvailableSeats(4);
        order.setAutomobile("mitsubishi asx");
        return order;
    }
}
