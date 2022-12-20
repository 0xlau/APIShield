package top.xystudio.apishield.utils;

import top.xystudio.apishield.consts.ApiShieldConsts;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ApiShield 内部工具类
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class ApiShieldUtil {

    private ApiShieldUtil(){

    }

    /**
     * 打印 ApiShield 版本字符画
     */
    public static void printApiShield() {
        String str = ""
                + "   _   ___ ___ ___ _    _     _    _ \n" +
                "  /_\\ | _ \\_ _/ __| |_ (_)___| |__| |\n" +
                " / _ \\|  _/| |\\__ \\ ' \\| / -_) / _` |\n" +
                "/_/ \\_\\_| |___|___/_||_|_\\___|_\\__,_|"
                + "\r\n" + ApiShieldConsts.DEV_DOC_URL
                + " (" + ApiShieldConsts.VERSION_NO + ")";
        System.out.println(str);
    }

    /**
     * 指定元素是否为null或者空字符串
     *
     * @param str 指定元素
     * @return 是否为null或者空字符串
     */
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    /**
     * 指定元素是否不为 (null或者空字符串)
     *
     * @param str 指定元素
     * @return 是否为null或者空字符串
     */
    public static boolean isNotEmpty(Object str) {
        return isEmpty(str) == false;
    }

    /**
     * 指定数组是否为null或者空数组
     *
     * @param <T> /
     * @param array /
     * @return /
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 比较两个对象是否相等
     *
     * @param a 第一个对象
     * @param b 第二个对象
     * @return 两个对象是否相等
     */
    public static boolean equals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    /**
     * md5加密算法
     *
     * @param plantText a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String md5(String plantText){
        // 加密后的16进制字符串
        String hexStr = "";
        try {
            // 此 MessageDigest 类为应用程序提供信息摘要算法的功能
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 转换为MD5码
            byte[] digest = md5.digest(plantText.getBytes("utf-8"));
            hexStr = new BigInteger(1, digest).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexStr;
    }

    /**
     * <p>splitQueryString.</p>
     *
     * @param queryString a {@link java.lang.String} object.
     * @return a {@link java.util.Map} object.
     */
    public static Map splitQueryString(String queryString) {
        Map queryPairs = new LinkedHashMap();
        if (ApiShieldUtil.isEmpty(queryString)){
            return queryPairs;
        }
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            if (idx == -1) continue;
            try {
                queryPairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return queryPairs;
    }

    /**
     * <p>getTimeStamp.</p>
     *
     * @return a {@link java.lang.Long} object.
     */
    public static Long getTimeStamp(){
        return System.currentTimeMillis();
    }

}
