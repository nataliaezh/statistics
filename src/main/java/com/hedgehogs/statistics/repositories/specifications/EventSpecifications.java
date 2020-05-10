package com.hedgehogs.statistics.repositories.specifications;

import com.hedgehogs.statistics.entities.Event;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author natalya_ezhkova@mail.ru
 */
public class EventSpecifications {
    public static Specification<Event> titleContains(String word) {
        return (Specification<Event>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Event> classcode(String classcode) {
               return (Specification<Event>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("classcode"), "%" + classcode + "%");
        };

    }

