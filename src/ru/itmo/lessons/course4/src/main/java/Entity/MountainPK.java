package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@ToString
@Getter
@NoArgsConstructor
public class MountainPK implements Serializable {

    @Column(name = "mountain_name", nullable = false)
    private String name;

    @Column(name = "mountain_country", nullable = false)
    private String country;

    public MountainPK(String name, String country) {
        this.setName(name);
        this.setCountry(country);
    }

    public void setName(String name) {
        if (name.length() < 4) throw new IllegalArgumentException("Длина названия горы не может быть менее 4-х символов");
        this.name = name;
    }

    public void setCountry(String country) {
        if (name.length() < 4) throw new IllegalArgumentException("Длина названия страны не может быть менее 4-х символов");
        this.country = country;
    }
}
