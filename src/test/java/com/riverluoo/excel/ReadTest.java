package com.riverluoo.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.riverluoo.excel.read.DemoData;
import com.riverluoo.excel.read.DemoDataListener;
import com.riverluoo.excel.read.IndexOrNameData;
import com.riverluoo.excel.read.IndexOrNameDataListener;
import com.riverluoo.util.TestFileUtil;
import org.junit.Test;

import java.io.File;

/**
 * @auther: wangyang
 * @since: 2019-10-10 11:26
 */
public class ReadTest {

    /**
     * 简单读
     */
    @Test
    public void read1() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();


    }


    /**
     * 简单读
     */
    @Test
    public void read2() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }


    /**
     * 简单读
     */
    @Test
    public void read3(){
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        EasyExcel.read(fileName, IndexOrNameData.class,new IndexOrNameDataListener()).sheet().doRead();

    }

    /**
     *
     * 读多个sheet sheet1和sheet2数据一致
     */
    @Test
    public void read4() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
        ReadSheet readSheet1 = EasyExcel.readSheet(0).build();
        ReadSheet readSheet2 = EasyExcel.readSheet(1).build();
        excelReader.read(readSheet1);
        excelReader.read(readSheet2);

        excelReader.finish();
    }

    /**
     * 读多个sheet sheet1和sheet2数据不一致
     */
    @Test
    public void read5() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        ReadSheet readSheet1 = EasyExcel.readSheet(0).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
        ReadSheet readSheet2 = EasyExcel.readSheet(1).head(DemoData.class).registerReadListener(new DemoDataListener()).build();

        excelReader.read(readSheet1);
        excelReader.read(readSheet2);

        excelReader.finish();

    }
}
