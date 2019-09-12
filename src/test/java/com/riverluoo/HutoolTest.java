package com.riverluoo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.riverluoo.common.AuthSource;
import org.junit.Test;

/**
 * @auther: wangyang
 * @since: 2019-09-12 14:12
 */
public class HutoolTest {


    @Test
    public void meituApiTest(){
        HttpResponse httpResponse = HttpRequest.get(AuthSource.meituApi()).execute();
        JSONObject accessTokenObject = JSONObject.parseObject(httpResponse.body());
        Object data = accessTokenObject.get("data");

        System.out.println(data);

    }


}
