package com.kainat.learnspringbootwebservices.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TutorialDTO {
    private Integer id;

    @NotNull
    private Integer moduleId;

    @NotNull
    private Integer number;

    @NotBlank
    private String title;

    @NotNull
    private Integer durationSeconds;

    @NotBlank
    private String videoUrl;

    private String starterCodeUrl;

    private String finishedCodeUrl;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
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
