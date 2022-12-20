package top.xystudio.apishield.consts;

/**
 * User-Agent 标识正则表达式
 * 该部分尚未完善
 * 欢迎贡献者积极补充更多UA的正则表达式
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class UA {

    private UA(){

    }

    // =================== User-Agent 标识 ===================

    /** Constant <code>IE="(?=^mozilla/)(?=.*msie)(?=.*compatible)"</code> */
    public static final String IE = "(?=^mozilla/)(?=.*msie)(?=.*compatible)";
    /** Constant <code>FIREFOX="(?=^mozilla/)(?=.*gecko/)(?=.*firefox/)"</code> */
    public static final String FIREFOX = "(?=^mozilla/)(?=.*gecko/)(?=.*firefox/)";
    /** Constant <code>CHROME="(?=^mozilla/)(?=.*applewebkit/)(?=.*chr"{trunked}</code> */
    public static final String CHROME = "(?=^mozilla/)(?=.*applewebkit/)(?=.*chrome/)";
    /** Constant <code>OPERA="(?=^opera/)(?=.*presto/)"</code> */
    public static final String OPERA = "(?=^opera/)(?=.*presto/)";
    /** Constant <code>SAFARI="(?=^mozilla/)(?=.*applewebkit/)(?=.*saf"{trunked}</code> */
    public static final String SAFARI = "(?=^mozilla/)(?=.*applewebkit/)(?=.*safari/)";

    // =================== 操作系统 标识 ===================
    /** Constant <code>OS_WINDOWS="(?=.*windows nt)"</code> */
    public static final String OS_WINDOWS = "(?=.*windows nt)";
    /** Constant <code>OS_MAC="(?=.*mac)"</code> */
    public static final String OS_MAC = "(?=.*mac)";
    /** Constant <code>OS_IOS="(?=.*(iphone|ipod|ipad))"</code> */
    public static final String OS_IOS = "(?=.*(iphone|ipod|ipad))";
    /** Constant <code>OS_ANDROID="(?=.*android)"</code> */
    public static final String OS_ANDROID = "(?=.*android)";
    /** Constant <code>OS_LINUX="(?=.*linux)"</code> */
    public static final String OS_LINUX = "(?=.*linux)";
    /** Constant <code>OS_UBUNTU="(?=.*ubuntu)"</code> */
    public static final String OS_UBUNTU = "(?=.*ubuntu)";
    /** Constant <code>OS_UNIX="(?=.*unix)"</code> */
    public static final String OS_UNIX = "(?=.*unix)";

    // =================== 设备 标识 ===================
    /** Constant <code>DEV_MOBILE="(?=.*(iphone|ipad|ipad|slik|android|bla"{trunked}</code> */
    public static final String DEV_MOBILE = "(?=.*(iphone|ipad|ipad|slik|android|blackberry|opera mini|iemobile).*)";
    /** Constant <code>DEV_WECHAT="(?=.*micromessenger)"</code> */
    public static final String DEV_WECHAT = "(?=.*micromessenger)";
    /** Constant <code>DEV_WEBVIEW="(?=.*enjoyrv)"</code> */
    public static final String DEV_WEBVIEW = "(?=.*enjoyrv)";

    // =================== 组合 标识 ===================
    /** Constant <code>GRP_IOS_WECHAT="DEV_WECHAT + OS_IOS"</code> */
    public static final String GRP_IOS_WECHAT = DEV_WECHAT + OS_IOS;
    /** Constant <code>GRP_ANDROID_WECHAT="DEV_WECHAT + OS_ANDROID"</code> */
    public static final String GRP_ANDROID_WECHAT = DEV_WECHAT + OS_ANDROID;
    /** Constant <code>GRP_IOS_APP="DEV_WEBVIEW + OS_IOS"</code> */
    public static final String GRP_IOS_APP = DEV_WEBVIEW + OS_IOS;
    /** Constant <code>GRP_ANDROID_APP="DEV_WEBVIEW + OS_ANDROID"</code> */
    public static final String GRP_ANDROID_APP = DEV_WEBVIEW + OS_ANDROID;

}
