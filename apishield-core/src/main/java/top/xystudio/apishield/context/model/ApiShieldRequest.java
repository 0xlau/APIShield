package top.xystudio.apishield.context.model;

import top.xystudio.apishield.exception.ApiShieldException;
import top.xystudio.apishield.utils.ApiShieldUtil;

import java.util.Map;

/**
 * Request 包装类
 * @author liupeiqiang
 */
public interface ApiShieldRequest {

    /**
     * 获取底层源对象
     * @return see note
     */
    public Object getSource();

    /**
     * 获取QueryString
     * @return
     */
    public String getQueryString();

    /**
     * 获取 body 的值
     * @return
     */
    public String getBody();

    /**
     * 在请求体里获取一个值
     * @param name 键
     * @return 值
     */
    public String getParam(String name);

    /**
     * 获取整个请求体并用Map返回
     *
     * @return 值
     */
    public Map<String, String[]> getParamMap();

    /**
     * 在请求体里获取一个值，值为空时返回默认值
     * @param name 键
     * @param defaultValue 值为空时的默认值
     * @return 值
     */
    public default String getParam(String name, String defaultValue) {
        String value = getParam(name);
        if(ApiShieldUtil.isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 检测提供的参数是否为指定值
     * @param name 键
     * @param value 值
     * @return 是否相等
     */
    public default boolean isParam(String name, String value) {
        String paramValue = getParam(name);
        return ApiShieldUtil.isNotEmpty(paramValue) && paramValue.equals(value);
    }

    /**
     * 检测请求是否提供了指定参数
     * @param name 参数名称
     * @return 是否提供
     */
    public default boolean hasParam(String name) {
        return ApiShieldUtil.isNotEmpty(getParam(name));
    }

    /**
     * 在请求体里获取一个值 （此值必须存在，否则抛出异常 ）
     * @param name 键
     * @return 参数值
     */
    public default String getParamNotNull(String name) {
        String paramValue = getParam(name);
        if(ApiShieldUtil.isEmpty(paramValue)) {
            throw new ApiShieldException("缺少参数：" + name);
        }
        return paramValue;
    }


    /**
     * 在 [请求头] 里获取一个值
     * @param name 键
     * @return 值
     */
    public String getHeader(String name);

    /**
     * 在 [请求头] 里获取一个值
     * @param name 键
     * @param defaultValue 值为空时的默认值
     * @return 值
     */
    public default String getHeader(String name, String defaultValue) {
        String value = getHeader(name);
        if(ApiShieldUtil.isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 在 [Cookie作用域] 里获取一个值
     * @param name 键
     * @return 值
     */
    public String getCookieValue(String name);

    /**
     * 返回当前请求path (不包括上下文名称)
     * @return see note
     */
    public String getRequestPath();

    /**
     * 返回当前请求path是否为指定值
     * @param path path
     * @return see note
     */
    public default boolean isPath(String path) {
        return getRequestPath().equals(path);
    }

    /**
     * 返回当前请求的url，不带query参数，例：http://xxx.com/test
     * @return see note
     */
    public String getUrl();

    /**
     * 返回当前请求的类型
     * @return see note
     */
    public String getMethod();

    /**
     * 此请求是否为Ajax请求
     * @return see note
     */
    public default boolean isAjax() {
        return getHeader("X-Requested-With") != null;
    }

    /**
     * 返回头部的Referer
     */
    public default String getReferer(){
        String referer = getHeader("referer");
        return referer == null ? getHeader("Referer") : referer;
    }

    /**
     * 返回头部的User-Agent
     */
    public default String getUserAgent(){
        String referer = getHeader("user-agent");
        return referer == null ? getHeader("User-Agent") : referer;
    }

    /**
     * 返回头部的Content-Type
     */
    public default String getContentType(){
        String contentType = getHeader("content-type");
        return contentType == null ? getHeader("Content-Type") : contentType;
    }

    /**
     * 返回QueryString的某个值
     * @return
     */
    public default String getQuery(String name){
        Map map = ApiShieldUtil.splitQueryString(getQueryString());
        return (String) map.get(name);
    };
}
