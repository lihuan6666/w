package li.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "trafficaccident")
@Data
public class TrafficAccident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accident_type;
    private String triggeringfactors;
    private Integer data_statistics;
    private String road_name;
    private String time;
    @Override
    public String toString() {
        return "TrafficAccident [id=" + id + ", accidentType=" + accident_type
                + ", triggeringfactors=" + triggeringfactors + ", dataStatistics="
                + data_statistics + ", road_name=" + road_name + ", time=" + time + "]";
    }
}