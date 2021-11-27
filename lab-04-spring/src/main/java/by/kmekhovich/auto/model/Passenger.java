package by.kmekhovich.auto.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String name;

    public static Passenger createDefaultPassenger() {
        Passenger passenger = new Passenger();
        passenger.setName("препод рома");
        return passenger;
    }
}
