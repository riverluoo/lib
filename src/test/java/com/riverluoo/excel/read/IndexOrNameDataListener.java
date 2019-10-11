package com.riverluoo.excel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.riverluoo.common.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: wangyang
 * @since: 2019-10-10 13:07
 */
public class IndexOrNameDataListener extends AnalysisEventListener<IndexOrNameData> {


    private static final int BATCH_COUNT = 5;
    List<IndexOrNameData> list = new ArrayList<IndexOrNameData>();

    @Override
    public void invoke(IndexOrNameData data, AnalysisContext context) {
        Utils.print("解析到一条数据:" + JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        Utils.print("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        Utils.print("，开始存储数据库！" + list.size());
        Utils.print("存储数据库成功！");
    }
}
