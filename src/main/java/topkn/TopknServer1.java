package topkn;

import java.io.IOException;

/**
 * Created by wanshao on 2017/6/29.
 */
public class TopknServer1 {

    private final String dataDirPath = "/Users/wanshao/work/final_data";

    public static void main(String[] args) throws IOException {
        //1. 启动server
        TopknHttpUtils.startHttpServer(5527);

        //2.

    }
}
