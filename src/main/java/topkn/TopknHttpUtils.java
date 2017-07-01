package topkn;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wanshao on 2017/6/29.
 */
public class TopknHttpUtils {

    private static Logger logger = LoggerFactory.getLogger(TopknHttpUtils.class);

    public static void startHttpServer(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/middleware", new TopknHttpHandler());
        server.start();
        logger.info("start http server at port "+port+" successfully...");
    }


}
