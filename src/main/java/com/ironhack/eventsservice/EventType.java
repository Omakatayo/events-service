package com.ironhack.eventsservice;

public enum EventType {

    MASTERCLASS("MASTERCLASS"),
    REGULAR_CLASS("REGULAR-CLASS"),
    NONE("NONE");


    private String value;

    private EventType(String value) {
        this.value=value;
    }

    public static EventType getEventType(String sValue) {
        for (EventType event: values()) {
            if(event.value.equals(sValue))
                return event;
        }
        return EventType.NONE;
    }
}
