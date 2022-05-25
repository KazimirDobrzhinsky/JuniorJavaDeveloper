package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "tb_groups")
public class Group {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Mountain mountain;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST)
    @JoinColumn
    private final List<Climber> climbers = new ArrayList<>();

    @Column(name = "group_status", nullable = false)
    private boolean group_status = true;

    public void chooseMountain(Mountain mountain) {
        this.mountain = mountain;
        mountain.getGroupList().add(this);
    }

    public void setOpen(boolean open) {
        this.group_status = open;
    }

    public void addClimber(Climber ... climbers) {
        for (Climber climber: climbers) {
            if (this.group_status) {
                this.climbers.add(climber);
                climber.setGroup(this);
            }
        }
    }


}
