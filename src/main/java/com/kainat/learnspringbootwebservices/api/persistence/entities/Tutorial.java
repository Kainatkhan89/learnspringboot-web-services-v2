package com.kainat.learnspringbootwebservices.api.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "module_id", nullable = false)
    private CourseModule courseModule;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(name = "duration_seconds", nullable = false)
    private Integer durationSeconds;

    @Column(name = "video_url", length = 500, nullable = false)
    private String videoUrl;

    @Column(name = "starter_code_url", length = 500)
    private String starterCodeUrl;

    @Column(name = "finished_code_url", length = 500)
    private String finishedCodeUrl;

    public Tutorial() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CourseModule getCourseModule() {
        return this.courseModule;
    }

    public void setCourseModule(CourseModule courseModule) {
        this.courseModule = courseModule;
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

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getStarterCodeUrl() {
        return this.starterCodeUrl;
    }

    public void setStarterCodeUrl(String starterCodeUrl) {
        this.starterCodeUrl = starterCodeUrl;
    }

    public String getFinishedCodeUrl() {
        return this.finishedCodeUrl;
    }

    public void setFinishedCodeUrl(String finishedCodeUrl) {
        this.finishedCodeUrl = finishedCodeUrl;
    }
}
