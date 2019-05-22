package by.java.hibernate.training.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@ToString(of = "name", includeFieldNames = false)

public class Book {
    private int id;
    private String name;
    private String title;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "title", nullable = true, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(int id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Charters.class, mappedBy = "book")

    public List<Charters> charters = new ArrayList<>();

    public List<Charters> getCharters() {
        return charters;
    }
}
