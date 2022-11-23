package com.completeTimeFlow.core.server.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="clocking")
public class Clocking {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    Person person;

    @Column(name = "clocking_date", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date clockingDate;

    @Column(name = "grade", nullable = true)
    Double grade;

    @Column(name = "subject", nullable = true, length = 255)
    String subject;

    @Column(name = "clocking_description", nullable = true, length = 255)
    String clockingDescription;

    @Column(name = "removed", nullable = true)
    private Boolean removed;

    public Clocking() {

    }

    public Clocking(Long id, Person person, Date clockingDate, Double grade, String subject, String clockingDescription) {
        this.id = id;
        this.person = person;
        this.clockingDate = clockingDate;
        this.grade = grade;
        this.subject = subject;
        this.clockingDescription = clockingDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getClockingDate() {
        return clockingDate;
    }

    public void setClockingDate(Date clockingDate) {
        this.clockingDate = clockingDate;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getClockingDescription() {
        return clockingDescription;
    }

    public void setClockingDescription(String clockingDescription) {
        this.clockingDescription = clockingDescription;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Clocking{" +
                "id=" + id +
                ", person=" + person +
                ", clockingDate=" + clockingDate +
                ", grade=" + grade +
                ", clockingDescription='" + clockingDescription + '\'' +
                ", removed=" + removed +
                '}';
    }
}
