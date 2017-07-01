package algs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 快速生成10G随机数据
 * Created by wanshao on 2017/4/22.
 */
public class GenerateDataExample {

    private static final int FILE_COUNT=10;
    private static final String FILE_PREFIX = "FILE_PREFIX";
    private static final String FILE_SUFFIX = "FILE_SUFFIX";
    private static final String DATA_DIR ="";
    private static final long FILE_SIZE=1024*1024*1024;

    public static void main(String[] args) throws IOException {

        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < FILE_COUNT; i++) {
            // 写出的文件名
            String fileName = FILE_PREFIX + i + FILE_SUFFIX;
            File file = new File(DATA_DIR + fileName);
            file.getParentFile().mkdirs(); // create dir if not exists
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file), 8192 * 8);
            int recordCount = 0;
            long startTime = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder(8192 * 8);
            long length = 0;
            while (length < FILE_SIZE) {
                while (sb.length() < 8192 * 7 && length + sb.length() < FILE_SIZE) {
                    long randomValue = random.nextLong();
                    recordCount++;
                    sb.append(randomValue > 0 ? randomValue : -randomValue).append('\n');
                }
                fileWriter.append(sb.toString());
                length += sb.length();
                sb.setLength(0);
            }
            long stopTime = System.currentTimeMillis();
            System.out.printf("[%d] file: [%s] record count: %d\n", (stopTime - startTime), fileName, recordCount);
            fileWriter.close();
            //            DataOutputStream a; // write byte[], write long
        }
    }
}
