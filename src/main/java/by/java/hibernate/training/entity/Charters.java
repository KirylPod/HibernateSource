package by.java.hibernate.training.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

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

    @ManyToOne
    @JoinColumn (name = "book_id")
    public Book book;


}
