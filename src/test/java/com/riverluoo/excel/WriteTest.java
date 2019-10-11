package com.riverluoo.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.riverluoo.excel.write.ComplexHeadData;
import com.riverluoo.excel.write.DemoData;
import com.riverluoo.excel.write.ImageData;
import com.riverluoo.excel.write.IndexData;
import com.riverluoo.util.TestFileUtil;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther: wangyang
 * @since: 2019-10-11 09:51
 */
public class WriteTest {

    /**
     * 简单写
     */
    @Test
    public void write1() {
        String fileName = TestFileUtil.getPath() + "simpleWrite1-" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

    }

    /**
     * 简单写
     */
    @Test
    public void test2() {
        String fileName = TestFileUtil.getPath() + "simpleWrite2-" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模版").build();
        excelWriter.write(data(), writeSheet);

        excelWriter.finish();

    }

    /**
     * 写指定列
     */
    @Test
    public void test3() {
        String fileName = TestFileUtil.getPath() + "simpleWrite3-" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, IndexData.class).sheet("模板").doWrite(data());

    }

    /**
     * 复杂头
     */
    @Test
    public void test4() {
        String fileName = TestFileUtil.getPath() + "simpleWrite4-" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("模版").doWrite(data());

    }

    /**
     * 重复写 同一个sheet
     */
    @Test
    public void test5() {
        String fileName = TestFileUtil.getPath() + "simpleWrite5-" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();

        for (int i = 0; i < 5; i++) {
            List<DemoData> data = data();
            excelWriter.write(data, writeSheet);
        }
        excelWriter.finish();
    }


    /**
     * 重复写 不同一个sheet
     */
    @Test
    public void test6() {
        String fileName = TestFileUtil.getPath() + "simpleWrite-6-" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        for (int i = 0; i < 5; i++) {
            // 每次都要创建writeSheet 这里注意必须指定sheetNo
            WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<DemoData> data = data();
            excelWriter.write(data, writeSheet);
        }
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }

    /**
     * 写图片
     *
     * @throws Exception
     */
    @Test
    public void test7() throws Exception {
        String fileName = TestFileUtil.getPath() + "imageWrite" + System.currentTimeMillis() + ".xlsx";
        // 如果使用流 记得关闭
        InputStream inputStream = null;
        try {
            List<ImageData> list = new ArrayList<ImageData>();
            ImageData imageData = new ImageData();
            list.add(imageData);
            String imagePath = TestFileUtil.getPath() + "demo" + File.separator + "IMG_0412.jpg";
            // 放入四种类型的图片 实际使用只要选一种即可
            //imageData.setByteArray(FileUtils.readFileToByteArray(new File(imagePath)));
            //imageData.setFile(new File(imagePath));
            imageData.setString(imagePath);
            //inputStream = FileUtils.openInputStream(new File(imagePath));
            //imageData.setInputStream(inputStream);
            EasyExcel.write(fileName, ImageData.class).sheet().doWrite(list);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
