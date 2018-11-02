package com.anshishagua.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Events implements Serializable {
    public static final Events NO_EVENTS = new Events(null);

    private List<Event> events;

    public Events() {
        this.events = new ArrayList<>();
    }

    public Events(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }
}
