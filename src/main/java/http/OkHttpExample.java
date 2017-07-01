package http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wanshao on 2017/6/27.
 */
public class OkHttpExample {

    Logger logger = LoggerFactory.getLogger(OkHttpExample.class);

    public static void main(String[] args) {

    }


    private JSONObject sendCommandToRemoteNew(String command, String teamCode, int randomIndex) throws IOException {

        String url = System.getProperty("client.url") + "?command=" + command + "&teamcode=" + teamCode + "&server_ip="
            + System.getProperty("server.ip") + "&index=" + String.valueOf(randomIndex);

        OkHttpClient client = new OkHttpClient();

        client.setConnectTimeout(15, TimeUnit.SECONDS);
        client.setReadTimeout(300, TimeUnit.SECONDS);
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            logger.error("Http server error:" + response);
        }

        String responseStr = response.body().string();
        JSONObject jsonObject = JSONObject.parseObject(responseStr);
        logger.info("收到来自响应: " + jsonObject.toJSONString());
        return jsonObject;

    }
}
