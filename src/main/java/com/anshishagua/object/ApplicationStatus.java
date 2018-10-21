package com.anshishagua.object;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * ApplicationStatus.java
 *
 * @author lixiao
 * @date 2018-10-21
 */

public class ApplicationStatus {
    public static enum State {
        NEW,
        NEW_SAVING,
        SUBMITTED,
        ACCEPTED,
        RUNNING,
        FINISHED,
        FAILED,
        KILLED;
    }

    public static enum FinalStatus {
        UNDEFINED,
        SUCCEEDED,
        FAILED,
        KILLED;
    }

    private String id;
    private String user;
    private String name;
    private String queue;
    private String state;
    private String finalStatus;
    private float progress;
    private String trackingUrl;
    private long startedTime;
    private LocalDateTime startDateTime;
    private long finishedTime;
    private LocalDateTime finishDateTime;
    private long elapsedTime;

    public ApplicationStatus() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public long getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(long startedTime) {
        this.startedTime = startedTime;
        this.startDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(startedTime), ZoneId.systemDefault());
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getFinishDateTime() {
        return finishDateTime;
    }

    public long getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(long finishedTime) {
        this.finishedTime = finishedTime;
        this.finishDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(finishedTime), ZoneId.systemDefault());
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @Override
    public String toString() {
        return "ApplicationStatus{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", queue='" + queue + '\'' +
                ", state='" + state + '\'' +
                ", finalStatus='" + finalStatus + '\'' +
                ", progress=" + progress +
                ", trackingUrl='" + trackingUrl + '\'' +
                ", startedTime=" + startedTime +
                ", startDateTime=" + startDateTime +
                ", finishedTime=" + finishedTime +
                ", finishDateTime=" + finishDateTime +
                ", elapsedTime=" + elapsedTime +
                '}';
    }
}
