package topkn;

import java.io.IOException;

/**
 * Created by wanshao on 2017/6/29.
 */
public class TopknServer2 {

    private final String dataDirPath = "/Users/wanshao/work/final_data";

    public static void main(String[] args) throws IOException {
        //启动server
        TopknHttpUtils.startHttpServer(5528);
    }
}
