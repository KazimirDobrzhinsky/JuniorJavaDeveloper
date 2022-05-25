package Entity;

import jakarta.persistence.*;
import lombok.*;


@ToString(exclude = {"group"})
@Getter
@Entity
@Table(name = "tb_climbers")
public class Climber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "climber_id")
    private int id;

    @Column(name = "climber_name", nullable = false)
    private String name;

    @Column(name = "climber_address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    @Setter
    private Group group;


    public void setName(String name) {
        if (name.length() < 3) throw new IllegalArgumentException("Длинна имени не может быть менее 3-х символов");
        this.name = name;
    }

    public void setAddress(String address) {
        if (address.length() < 3) throw new IllegalArgumentException("Длинна адреса не может быть менее 5-ти символов");
        this.address = address;
    }
}
