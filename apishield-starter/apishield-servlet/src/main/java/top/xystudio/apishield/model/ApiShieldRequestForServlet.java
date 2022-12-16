package top.xystudio.apishield.model;

import top.xystudio.apishield.context.model.ApiShieldRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author liupeiqiang
 * @date 2022/12/12 15:09
 */
public class ApiShieldRequestForServlet implements ApiShieldRequest {

    /**
     * 底层Request对象
     */
    protected HttpServletRequest request;

    /**
     * 实例化
     * @param request request对象
     */
    public ApiShieldRequestForServlet(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Object getSource() {
        return request;
    }

    @Override
    public String getQueryString() {
        return request.getQueryString();
    }

    @Override
    public String getBody() {
        try{
            BufferedReader bufferReader = new BufferedReader(request.getReader());
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, String[]> getParamMap() {
        return request.getParameterMap();
    }

    @Override
    public String getParam(String name) {
        return request.getParameter(name);
    }

    @Override
    public String getHeader(String name) {
        return request.getHeader(name);
    }

    @Override
    public String getCookieValue(String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public String getRequestPath() {
        return request.getServletPath();
    }

    @Override
    public String getUrl() {
        return request.getRequestURL().toString();
    }

    @Override
    public String getMethod() {
        return request.getMethod();
    }

}
