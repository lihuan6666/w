package li.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "roadrepair")
@Data
public class Roadrepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String road_name;
    private String  Road_damage;
    private String road_repairman;
    private String is_completed;
}
