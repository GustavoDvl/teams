package com.championship.championship.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_team")
public class TeamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String stadium;
    private String color;

    public TeamModel() {}

    public TeamModel(Long id, String name, String stadium, String color) {
        this.id = id;
        this.name = name;
        this.stadium = stadium;
        this.color = color;
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

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
