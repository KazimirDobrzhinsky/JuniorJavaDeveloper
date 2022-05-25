package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString (exclude = {"groupList"})
@Getter
@Table(name = "tb_mountains")
public class Mountain {
    @EmbeddedId
    private final MountainPK mountainPK = new MountainPK();

    @Column(name = "mountain_height", nullable = false)
    private long height;

    @Getter
    @OneToMany(mappedBy = "mountain", orphanRemoval = true)
    private final List<Group> groupList = new ArrayList<>();

    public void setMountainPK(String name, String country) {
        this.mountainPK.setName(name);
        this.mountainPK.setCountry(country);
    }

    public void setHeight(long height) {
        if (height < 100) throw new IllegalArgumentException("Высота горы не может быть менее 100");
        this.height = height;
    }
}
