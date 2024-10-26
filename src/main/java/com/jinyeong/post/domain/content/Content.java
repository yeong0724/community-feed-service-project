package com.jinyeong.post.domain.content;

import com.jinyeong.post.domain.common.DatetimeInfo;

/**
 * 1. SRP 원칙 ???
 * - 하나의 기능이 변깅 될때에는 하나의 객체에만 변경이 되어야 한다.
 *
 * 2. OCP 원칙
 * - 기능이 추가가 되어도 기존코드가 변경되지 않는다.
 */
public abstract class Content {
    String contentText;
    final DatetimeInfo datetimeInfo;

    protected Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.datetimeInfo = new DatetimeInfo();
    }

    protected abstract void checkText(String contentText);

    public void updateContent(String updateContent) {
        checkText(updateContent);

        this.contentText = updateContent;
        this.datetimeInfo.updateEditDateTime();
    }

    public String getContentText() {
        return contentText;
    }
}
