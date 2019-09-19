package com.riverluoo;

import com.riverluoo.common.Utils;
import org.junit.Test;

/**
 * @auther: wangyang
 * @since: 2019-09-19 16:54
 */
public class RuntimeTest {

    @Test
    public void test1(){
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(() -> Utils.print("关闭应用后")));

        Utils.print("服务启动完成");
    }


}
