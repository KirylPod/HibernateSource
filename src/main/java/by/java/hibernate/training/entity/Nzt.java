package by.java.hibernate.training.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity

public class Nzt {
    private String id;
    private Integer indic;
    private BigDecimal difficulty;
    private BigDecimal val;

    @Id
    @Column(name = "id", nullable = false, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "indic", nullable = true)
    public Integer getIndic() {
        return indic;
    }

    public void setIndic(Integer indic) {
        this.indic = indic;
    }

    @Basic
    @Column(name = "difficulty", nullable = true, precision = 1)
    public BigDecimal getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BigDecimal difficulty) {
        this.difficulty = difficulty;
    }

    @Basic
    @Column(name = "val", nullable = true, precision = 1)
    public BigDecimal getVal() {
        return val;
    }

    public void setVal(BigDecimal val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nzt nzt = (Nzt) o;
        return Objects.equals(id, nzt.id) &&
                Objects.equals(indic, nzt.indic) &&
                Objects.equals(difficulty, nzt.difficulty) &&
                Objects.equals(val, nzt.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, indic, difficulty, val);
    }
}
