package li.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shuju2")
@Data
public class Shuju2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double density;
    private double length;
    private int connectedVillages;
    private String roadName;
    private String road_start;

    public Shuju2(int i, double v, double v1, int i1, String road1, String start1) {
        id = i;
        density = v;
        length = v1;
        connectedVillages = i1;
        roadName = road1;
        road_start = start1;
    }

    public Shuju2() {

    }
}