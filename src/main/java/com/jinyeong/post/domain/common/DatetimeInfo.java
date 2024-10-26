package com.jinyeong.post.domain.common;

import java.time.LocalDateTime;

public class DatetimeInfo {
    private boolean isEdited;
    private LocalDateTime dateTime;

    public DatetimeInfo() {
        this.isEdited = false;
        this.dateTime = LocalDateTime.now();
    }

    public void updateEditDateTime() {
        this.isEdited = true;
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isEdited() {
        return isEdited;
    }
}