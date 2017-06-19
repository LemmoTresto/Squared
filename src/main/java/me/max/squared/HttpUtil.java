package me.max.squared;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by max on 19-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class HttpUtil {

    public static String requestHttp(String requestUrl) {
        try {
            return IOUtils.toString(new URL(requestUrl), Charset.forName("UTF-8"));
        } catch (IOException e) {
            return "";
        }
    }
}
