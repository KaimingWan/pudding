package jdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanshao on 2017/6/2.
 */
public class RawCollectionDemo {

    public static void main(String[] args) throws IOException {
        printInput(args);
        // duplicatedKeysDemo();
    }

    private static void printInput(String[] args) {
        // 第一个参数是Schema Name
        System.out.println("Schema:" + args[0]);
        // 第二个参数是Schema Name
        System.out.println("table:" + args[1]);
        // 第三个参数是start pk Id
        System.out.println("start:" + args[2]);
        // 第四个参数是end pk Id
        System.out.println("end:" + args[3]);

    }

    /**
     * Map<String, List<String>>和其toString对象互转
     */
    private static void duplicatedKeysDemo() throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        List<String> studentList = new ArrayList<>();
        studentList.add("1");
        studentList.add("2");
        studentList.add("3");

        map.put("student", studentList);

        String str = map.toString();
        System.out.println(str);

        String s1 = str.substring(1, str.length() - 1);
        s1 = s1.replaceAll(" ", "");
        String[] keyValuePair = s1.replaceAll("[\\[\\]]", "").split("=");
        String key = keyValuePair[0];
        String[] valueArray = keyValuePair[1].split(",");
        for (String s : valueArray) {
            System.out.println("Key:" + key + ",Value:" + s);

        }

    }
}
