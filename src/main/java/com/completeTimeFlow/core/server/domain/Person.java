package com.completeTimeFlow.core.server.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="person")
public class Person {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "register_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    @Column(name = "removed", nullable = true)
    private Boolean removed;

    public Person() {

    }

    public Person(Long id, String name, Date registerDate) {
        this.id = id;
        this.name = name;
        this.registerDate = registerDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registerDate=" + registerDate +
                ", removed=" + removed +
                '}';
    }
}
