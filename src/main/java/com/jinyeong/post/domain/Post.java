package com.jinyeong.post.domain;

import com.jinyeong.common.domain.PositiveIntegerCounter;
import com.jinyeong.post.domain.content.PostContent;
import com.jinyeong.post.domain.content.PostPublicationState;
import com.jinyeong.user.domain.User;

public class Post {
    private final Long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationState postPublicationState; // 변경 가능한 변수로 non-final

    public Post(Long id, User author, PostContent content) {
        if (author == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.postPublicationState = PostPublicationState.PUBLIC;
    }

    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        likeCount.increase();
    }

    public void unlike() {
        this.likeCount.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationState postPublicationState) {
        if (!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        this.postPublicationState = postPublicationState;
        this.content.updateContent(updateContent);
    }
}
