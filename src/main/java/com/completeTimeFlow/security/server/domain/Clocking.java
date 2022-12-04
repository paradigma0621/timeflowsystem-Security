package com.completeTimeFlow.security.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="clocking")
public class Clocking {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Person person;

    @Column(name = "clocking_start_date", nullable = true)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date clockingStartDate;

    @Column(name = "clocking_finish_date", nullable = true)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date clockingFinishDate;

    @Column(name = "minutes_duration", nullable = true)
    private Integer minutesDuration;


    @Column(name = "grade", nullable = true)
    private Double grade;

    @Column(name = "subject", nullable = true, length = 500)
    private String subject;

    @Column(name = "clocking_description", nullable = true, length = 500)
    private String clockingDescription;

    @Column(name = "localization", length = 255)
    private String localization;

    @Column(name = "removed", nullable = true)
    private Boolean removed;

    public Clocking() {

    }

    public Clocking(Long id, Person person, Date clockingStartDate, Date clockingFinishDate, Integer minutesDuration, Double grade, String subject, String clockingDescription, String localization) {
        this.id = id;
        this.person = person;
        this.clockingStartDate = clockingStartDate;
        this.clockingFinishDate = clockingFinishDate;
        this.minutesDuration = minutesDuration;
        this.grade = grade;
        this.subject = subject;
        this.clockingDescription = clockingDescription;
        this.localization = localization;
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

    public Date getClockingStartDate() {
        return clockingStartDate;
    }

    public void setClockingStartDate(Date clockingStartDate) {
        this.clockingStartDate = clockingStartDate;
    }

    public Date getClockingFinishDate() {
        return clockingFinishDate;
    }

    public void setClockingFinishDate(Date clockingFinishDate) {
        this.clockingFinishDate = clockingFinishDate;
    }

    public Integer getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(Integer minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    @Override
    public String toString() {
        return "Clocking{" +
                "id=" + id +
                ", person=" + person +
                ", clockingStartDate=" + clockingStartDate +
                ", clockingFinishDate=" + clockingFinishDate +
                ", minutesDuration=" + minutesDuration +
                ", grade=" + grade +
                ", subject='" + subject + '\'' +
                ", clockingDescription='" + clockingDescription + '\'' +
                ", localization='" + localization + '\'' +
                ", removed=" + removed +
                '}';
    }
}
