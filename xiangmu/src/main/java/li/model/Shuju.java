package li.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "shuju")
@Data
public class Shuju {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roadName;
    private String roadLevel;


    public Shuju(int i, String road1, String level1) {
        this.id = i;
        this.roadName = road1;
        this.roadLevel = level1;
    }

    public Shuju() {

    }
}

