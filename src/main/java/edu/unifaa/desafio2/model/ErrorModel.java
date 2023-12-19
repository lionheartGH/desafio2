package edu.unifaa.desafio2.model;

import java.util.Date;

public class ErrorModel {
    private String title;
    private String message;
    private Integer status;
    private Date date;

    public ErrorModel(String title, String message, Integer status) {
        this.title = title;
        this.message = message;
        this.status = status;
        this.date = new Date();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
}
