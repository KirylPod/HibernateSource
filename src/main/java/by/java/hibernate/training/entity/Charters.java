package by.java.hibernate.training.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Charters {
    private String id;
    private String section;

    @Id
    @Column(name = "id", nullable = false, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "section", nullable = true, length = 255)
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charters charters = (Charters) o;
        return Objects.equals(id, charters.id) &&
                Objects.equals(section, charters.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, section);
    }
}
