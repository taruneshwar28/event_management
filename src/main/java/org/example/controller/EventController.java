package org.example.controller;

import org.example.model.Event;
import org.example.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    // ✅ Create Event
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@Valid @RequestBody Event event) {
        return service.createEvent(event);
    }

    // ✅ Read Event by ID
    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return service.getEventById(id);
    }

    // Read all events
    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    // Update event
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @Valid @RequestBody Event event) {
        return service.updateEvent(id, event);
    }

    // Delete event
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }
}

