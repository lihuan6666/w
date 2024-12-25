package li.model;

import lombok.Data;

@Data
public class shuju3 {
    private int id;
    private String name;
    private double density;
    private double length;
    private int count;
    private String level;
    private String start;

    public shuju3(int id, String roadName, double density, double length, int connectedVillages, String level, String start) {
        this.id = id;
        this.name = roadName;
        this.density = density;
        this.length = length;
        this.count = connectedVillages;
        this.level = level;
        this.start = start; // 新增参数
    }

    public shuju3() {
        super();
    }

    @Override
    public String toString() {
        return "Shuju3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", density=" + density +
                ", length=" + length +
                ", count=" + count +
                ", level='" + level + '\'' +
                ", start='" + start + '\'' +
                '}';
    }
}