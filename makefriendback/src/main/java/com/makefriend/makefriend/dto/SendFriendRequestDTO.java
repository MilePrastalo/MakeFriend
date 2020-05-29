package com.makefriend.makefriend.dto;

public class SendFriendRequestDTO {
    private Long senderId;
    private Long reviewerId;

    public SendFriendRequestDTO() {
    }

    public SendFriendRequestDTO(Long senderId, Long reviewerId) {
        this.senderId = senderId;
        this.reviewerId = reviewerId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }
}
