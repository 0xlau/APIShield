package top.xystudio.apishield.consts;

/**
 * User-Agent 标识正则表达式
 * 该部分尚未完善
 * 欢迎贡献者积极补充更多UA的正则表达式
 * @author liupeiqiang
 * @date 2022/12/12 17:21
 */
public class UA {

    private UA(){

    }

    // =================== User-Agent 标识 ===================

    public static final String IE = "(?=^mozilla/)(?=.*msie)(?=.*compatible)";
    public static final String FIREFOX = "(?=^mozilla/)(?=.*gecko/)(?=.*firefox/)";
    public static final String CHROME = "(?=^mozilla/)(?=.*applewebkit/)(?=.*chrome/)";
    public static final String OPERA = "(?=^opera/)(?=.*presto/)";
    public static final String SAFARI = "(?=^mozilla/)(?=.*applewebkit/)(?=.*safari/)";

    // =================== 操作系统 标识 ===================
    public static final String OS_WINDOWS = "(?=.*windows nt)";
    public static final String OS_MAC = "(?=.*mac)";
    public static final String OS_IOS = "(?=.*(iphone|ipod|ipad))";
    public static final String OS_ANDROID = "(?=.*android)";
    public static final String OS_LINUX = "(?=.*linux)";
    public static final String OS_UBUNTU = "(?=.*ubuntu)";
    public static final String OS_UNIX = "(?=.*unix)";

    // =================== 设备 标识 ===================
    public static final String DEV_MOBILE = "(?=.*(iphone|ipad|ipad|slik|android|blackberry|opera mini|iemobile).*)";
    public static final String DEV_WECHAT = "(?=.*micromessenger)";
    public static final String DEV_WEBVIEW = "(?=.*enjoyrv)";

    // =================== 组合 标识 ===================
    public static final String GRP_IOS_WECHAT = DEV_WECHAT + OS_IOS;
    public static final String GRP_ANDROID_WECHAT = DEV_WECHAT + OS_ANDROID;
    public static final String GRP_IOS_APP = DEV_WEBVIEW + OS_IOS;
    public static final String GRP_ANDROID_APP = DEV_WEBVIEW + OS_ANDROID;

}
