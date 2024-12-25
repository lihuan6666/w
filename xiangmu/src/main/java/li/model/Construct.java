package li.model;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "construct")
@Data
public class Construct {
    @Id
    private int id;
    private String new_road_name;
    private String road_constructcompany;
    private Date start_time;
    private String road_level;
    private String density;
    private double length;
    private Integer  connected_villages;
    private String road_start;
}
