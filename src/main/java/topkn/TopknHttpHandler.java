package topkn;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * Created by wanshao on 2017/6/29.
 */
public class TopknHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {
        // 获取请求内容
        Map<String, String> map = new HashMap<>();
        String message = t.getRequestURI().getQuery();
        String[] paramList = message.split("[&;]", -1);
        for (String pair : paramList) {
            String[] purePairList = pair.split("=", 2);
            String key = decodeUrlComponent(purePairList[0]);
            String value = decodeUrlComponent(purePairList[1]);
            map.put(key, value);
        }
    }

    private static String decodeUrlComponent(final String urlComponent) {
        try {
            return URLDecoder.decode(urlComponent, StandardCharsets.UTF_8.name());
        } catch (final UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

}
