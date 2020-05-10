package com.hedgehogs.statistics.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classifiers")

public class Classifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "classcode")
    private String classcode;
    @OneToMany(targetEntity = Event.class, mappedBy = "classifier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Event> events;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classifier)) return false;
        Classifier that = (Classifier) o;
        return Objects.equals(getId(), that.getId()); }
        @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
