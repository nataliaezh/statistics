package com.hedgehogs.statistics.services;

import com.hedgehogs.statistics.entities.Event;
import com.hedgehogs.statistics.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Service
public class EventService {
    @Autowired
    public EventService(EventRepository eventRepository, ClassifierService classifierService) {
        this.eventRepository = eventRepository;
        this.classifierService = classifierService;
    }
    private EventRepository eventRepository;
    private ClassifierService classifierService;

    public Page<Event> findAllByPagingAndFiltering(Specification<Event> specification, Pageable pageable) {
        return eventRepository.findAll(specification, pageable);
    }
    public List<Event> findAll() {
        return (List<Event>) eventRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public Event save(Event event) {
    return eventRepository.save(event);
    }
}
