package com.riverluoo.excel.read;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @auther: wangyang
 * @since: 2019-10-11 09:25
 */
public class IndexOrNameData {

    @ExcelProperty(index = 1)
    private Double doubleData;

    @ExcelProperty("字符串标题")
    private String string;

    @ExcelProperty("日期标题")
    private Date date;

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }

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
}
