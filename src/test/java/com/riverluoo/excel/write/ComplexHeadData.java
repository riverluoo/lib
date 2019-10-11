package com.riverluoo.excel.write;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @auther: wangyang
 * @since: 2019-10-11 10:04
 */
public class ComplexHeadData {
    @ExcelProperty({"我吃饱了", "字符串标题"})
    private String string;
    @ExcelProperty({"我吃饱了", "日期标题"})
    private Date date;
    @ExcelProperty({"我吃饱了", "数字标题"})
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
