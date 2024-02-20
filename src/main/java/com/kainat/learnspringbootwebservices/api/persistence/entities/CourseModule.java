package com.kainat.learnspringbootwebservices.api.persistence.entities;

import com.kainat.learnspringbootwebservices.api.enums.Color;
import com.kainat.learnspringbootwebservices.api.enums.Icon;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course_modules")
public class CourseModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "courseModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tutorial> tutorials = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private Icon icon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private Color color;

    public CourseModule() {
    }

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

    public List<Tutorial> getTutorials() {
        return this.tutorials;
    }

    public void setTutorials(List<Tutorial> tutorials) {
        this.tutorials = tutorials;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
