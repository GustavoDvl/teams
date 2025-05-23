package com.championship.championship.DTO;

import com.championship.championship.entities.TeamModel;

public class TeamDTO {

    private Long id;
    private String name;
    private String stadium;
    private String color;

    public TeamDTO() {}

    public TeamDTO(Long id, String name, String stadium, String color) {
        this.id = id;
        this.name = name;
        this.stadium = stadium;
        this.color = color;
    }

    public TeamDTO(TeamModel teamModel) {
        id = teamModel.getId();
        name = teamModel.getName();
        stadium = teamModel.getStadium();
        color = teamModel.getColor();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStadium() {
        return stadium;
    }

    public String getColor() {
        return color;
    }
}
