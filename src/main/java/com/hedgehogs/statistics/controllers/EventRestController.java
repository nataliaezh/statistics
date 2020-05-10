package com.hedgehogs.statistics.controllers;

import com.hedgehogs.statistics.entities.Event;
import com.hedgehogs.statistics.repositories.specifications.EventSpecifications;
import com.hedgehogs.statistics.services.ClassifierService;
import com.hedgehogs.statistics.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */
@RestController
@RequestMapping("api/v1/events")
public class EventRestController {

    @Autowired
    private EventService eventService;
    @Autowired
    private ClassifierService classifierService;


    @GetMapping("/")
    @ResponseBody
    //http://localhost:8189/statistics/api/v1/events/
    public List<Event> showEvents(
                               @RequestParam(name = "word", required = false) String word,
                               @RequestParam(name = "pageNumber", required = false) Integer pageNumber
    ) {
        Specification<Event> spec = Specification.where(null);
        StringBuilder filtersBuilder = new StringBuilder();
        if (word != null && !word.isEmpty()) {
            spec = spec.and(EventSpecifications.titleContains(word));
            filtersBuilder.append("&word=" + word);
        }
        if (pageNumber == null) {
            pageNumber = 1;
        }
       Page<Event> page = eventService.findAllByPagingAndFiltering(spec, PageRequest.of(pageNumber - 1, 2, Sort.by("createdAt")));
         return (List<Event>)eventService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Event addEvent(@RequestBody Event event){
        event.setId(null);
        return eventService.save(event);
    }

}
