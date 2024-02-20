package com.kainat.learnspringbootwebservices.api.dtos;


import com.kainat.learnspringbootwebservices.api.validators.ValidColor;
import com.kainat.learnspringbootwebservices.api.validators.ValidIcon;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CourseModuleDTO {

    private Integer id;

    @NotNull
    private Integer number;

    @NotBlank
    @Size(max=100)
    private String title;

    @NotBlank
    @Size(max=1000)
    private String description;

    @NotNull
    @Size(max = 25)
    @ValidIcon
    private String icon;

    @NotNull
    @Size(max = 25)
    @ValidColor
    private String color;

    private List<TutorialDTO> tutorials;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TutorialDTO> getTutorials() {
        return this.tutorials;
    }

    public void setTutorials(List<TutorialDTO> tutorials) {
        this.tutorials = tutorials;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
