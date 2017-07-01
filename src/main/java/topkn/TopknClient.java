package topkn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by wanshao on 2017/6/29.
 */
public class TopknClient {

    public static void main(String[] args) {
        //获取比赛使用的k,n值
        long k = Long.valueOf(args[0]);
        int n = Integer.valueOf(args[1]);

        //向两个server发送比赛的输入


    }


    private JSONObject sendDataToServer(long k,int n) throws IOException {

        String url = System.getProperty("client.url") + "?k=" + k + "&n=" + n;

        OkHttpClient client = new OkHttpClient();

        client.setConnectTimeout(15, TimeUnit.SECONDS);
        client.setReadTimeout(300, TimeUnit.SECONDS);
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
        }

        String responseStr = response.body().string();
        JSONObject jsonObject = JSONObject.parseObject(responseStr);
        return jsonObject;

    }
}
