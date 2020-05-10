package com.hedgehogs.statistics.utils;

/**
 * @author natalya_ezhkova@mail.ru
 */

import com.hedgehogs.statistics.entities.Event;
import com.hedgehogs.statistics.repositories.specifications.EventSpecifications;
import org.springframework.data.jpa.domain.Specification;
import javax.servlet.http.HttpServletRequest;

public class EventFilter {
    private Specification<Event> specification;
    private StringBuilder filtersString;

    public Specification<Event> getSpecification() {
        return specification;
    }

    public StringBuilder getFiltersString() {
        return filtersString;
    }

    public EventFilter(HttpServletRequest request) {
        filtersString = new StringBuilder();
        specification = Specification.where(null);

        if (request.getParameter("word") != null && !request.getParameter("word").isEmpty()) {
            specification = specification.and(EventSpecifications.titleContains(request.getParameter("word")));
            filtersString.append("&word=" + request.getParameter("word"));
        }

        if (request.getParameter("classId") != null && !request.getParameter("classId").isEmpty()) {
            specification = specification.and(EventSpecifications.classcode(request.getParameter("classcode")));
            filtersString.append("&classcode=" + request.getParameter("classcode"));
        }
    }
}