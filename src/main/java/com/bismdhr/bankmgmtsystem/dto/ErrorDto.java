package com.bismdhr.bankmgmtsystem.dto;

import java.util.Date;

public class ErrorDto {

    private String error;
    private Date date;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ErrorDto() {
        this.date = new Date(); //object create garda auto create hoss date vanera
    }
}
