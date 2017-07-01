package util;

import java.math.BigInteger;
import java.security.SecureRandom;

import com.google.common.primitives.Bytes;

/**
 * Created by wanshao on 2017/6/27.
 */
public class DataGenerator {
    public static void main(String[] args) {

        byte[] byteArray =  generateCharData(10);
        String filePath = "/Users/wanshao/work/final_data/data.txt";
        FlushToDiskUtil.flushToDisk(byteArray,filePath);
    }

    /**
     * 生成指定行数的随机字符文本，\n来换行
     * @param lineSize
     */
    private static byte[] generateCharData(long lineSize){
        SecureRandom random = new SecureRandom();
        byte[] byteArray = new byte[0];
        for(int i=0;i<lineSize;i++){
            int randomInt = abs(random.nextInt() % 650);
            String lineData = getRandomString(randomInt);
            byteArray = Bytes.concat(byteArray, lineData.getBytes());

        }

        return byteArray;

    }

    private static String getRandomString(int  randomInt){
        SecureRandom random = new SecureRandom();
        return new BigInteger(randomInt, random).toString(36)+"\n";
    }


    public static int abs(int x) throws ArithmeticException {
        if (x == Integer.MIN_VALUE) {
            throw new ArithmeticException("Math.abs(Integer.MIN_VALUE)");
        }
        return Math.abs(x);
    }
}
