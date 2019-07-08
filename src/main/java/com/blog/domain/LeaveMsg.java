package com.blog.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveMsg {
    private Long id;

    private String name;

    private String email;

    private String message;

    private Date times;

    public LeaveMsg() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimes() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        String dates = df.format(times);
        return dates;
    }

    public void setTimes(Date times) {
        this.times = times;
    }
/* public String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        String dates = df.format(times);
        return dates;
    }

    public void setTimes(Date time) {
        this.times = times;
    }*/

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "LeaveMsg{" +
                "id=" + id +
                ", times=" + times +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
