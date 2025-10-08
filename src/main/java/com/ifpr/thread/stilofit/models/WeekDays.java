package com.ifpr.thread.stilofit.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "week_days")
public class WeekDays implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean monday;

    @Column(nullable = false)
    private boolean tuesday;

    @Column(nullable = false)
    private boolean wednesday;

    @Column(nullable = false)
    private boolean thursday;

    @Column(nullable = false)
    private boolean friday;

    @Column(nullable = false)
    private boolean saturday;

    @Column(nullable = false)
    private boolean sunday;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public boolean isMonday() { return monday; }
    public void setMonday(boolean monday) { this.monday = monday; }
    public boolean isTuesday() { return tuesday; }
    public void setTuesday(boolean tuesday) { this.tuesday = tuesday; }
    public boolean isWednesday() { return wednesday; }
    public void setWednesday(boolean wednesday) { this.wednesday = wednesday; }
    public boolean isThursday() { return thursday; }
    public void setThursday(boolean thursday) { this.thursday = thursday; }
    public boolean isFriday() { return friday; }
    public void setFriday(boolean friday) { this.friday = friday; }
    public boolean isSaturday() { return saturday; }
    public void setSaturday(boolean saturday) { this.saturday = saturday; }
    public boolean isSunday() { return sunday; }
    public void setSunday(boolean sunday) { this.sunday = sunday; }
}