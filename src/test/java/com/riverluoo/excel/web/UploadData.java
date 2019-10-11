package com.riverluoo.excel.web;

import java.util.Date;

/**
 * @auther: wangyang
 * @since: 2019-10-11 10:36
 */
public class UploadData {
    private String string;
    private Date date;
    private Double doubleData;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }
}
