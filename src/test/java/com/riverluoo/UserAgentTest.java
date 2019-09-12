package com.riverluoo;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.junit.Test;

/**
 * @auther: wangyang
 * @since: 2019-09-12 14:36
 */
public class UserAgentTest {


    private static final String UA = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36";

    private static final String ANDROID = "Mozilla/5.0 (Linux; U; Android 4.4.4; zh-cn; HTC_D820u Build/KTU84P) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";

    @Test
    public void userAgentTest() {
        UserAgent userAgent = UserAgent.parseUserAgentString(ANDROID);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        DeviceType deviceType = operatingSystem.getDeviceType();

        System.out.println("browser: " + browser);
        System.out.println("deviceType: " + deviceType);


    }

}
