package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wanshao on 2017/6/28.
 */
public class MyNetworkUtil {
    public static void main(String[] args) {
        try {
            System.out.println(getIpByHostName("e100069162094.zmf.tbsite.net"));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static String getIpByHostName(String hostName) throws UnknownHostException {
        return InetAddress.getByName(hostName).getHostAddress();
    }
}
