package com.solvd.navigator.domain;

public class Transition {

    private Long id;
    private Point from;
    private Point to;

    public Transition(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Transition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }
}
