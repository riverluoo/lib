package com.riverluoo.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.riverluoo.excel.read.DemoData;
import com.riverluoo.excel.read.DemoDataListener;
import com.riverluoo.util.TestFileUtil;
import org.junit.Test;

import java.io.File;

/**
 * @auther: wangyang
 * @since: 2019-10-10 11:26
 */
public class ReadTest {

    @Test
    public void simpleRead() {
        // 写法1：
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        // 写法2：
        //fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        //ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
        //ReadSheet readSheet = EasyExcel.readSheet(0).build();
        //excelReader.read(readSheet);
        //// 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        //excelReader.finish();
    }

}
