package com.zhxh.xhandler.simulation;


/**
 * Created by zhxh on 2018/4/19.
 */

public class Post {

    private Integer senderId;
    private Integer receiverId;
    private String message;

    public Post(Integer senderId, Integer receiverId, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
