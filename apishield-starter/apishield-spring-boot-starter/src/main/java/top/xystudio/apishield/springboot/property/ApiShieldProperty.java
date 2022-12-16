package top.xystudio.apishield.springboot.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 基础参数类
 * @author liupeiqiang
 * @date 2022/12/7 17:37
 */
@ConfigurationProperties(prefix = "apishield")
public class ApiShieldProperty {

    /** 是否启用ApiShield **/
    private Boolean enable = true;

    /** sign名称 (同时也是cookie名称) */
    private String signName = "apishield-sign";

    /** sign盐（生产环境请务必覆盖掉） */
    private String signSalt = "apishield.xystudio.top";

    /** 时间戳服务是否启动 **/
    private Boolean tsServiceEnable = true;

    /** 时间戳名称 */
    private String tsName = "apishield-ts";

    /** 默认时间戳有效期 */
    private Integer tsLifetime = 30000;

    /** 是否尝试从请求体里读取token */
    private Boolean isReadBody = true;

    /** 是否尝试从header里读取token */
    private Boolean isReadHeader  = true;

    /** 是否尝试从cookie里读取token */
    private Boolean isReadCookie  = true;

    /** 是否尝试从query里读取关键词 */
    private Boolean isReadQuery = true;

    public Boolean getTsServiceEnable() {
        return tsServiceEnable;
    }

    public void setTsServiceEnable(Boolean tsServiceEnable) {
        this.tsServiceEnable = tsServiceEnable;
    }

    public String getTsName() {
        return tsName;
    }

    public void setTsName(String tsName) {
        this.tsName = tsName;
    }

    public Integer getTsLifetime() {
        return tsLifetime;
    }

    public void setTsLifetime(Integer tsLifetime) {
        this.tsLifetime = tsLifetime;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getIsReadBody() {
        return isReadBody;
    }

    public void setIsReadBody(Boolean readBody) {
        isReadBody = readBody;
    }

    public Boolean getIsReadHeader() {
        return isReadHeader;
    }

    public void setIsReadHeader(Boolean readHeader) {
        isReadHeader = readHeader;
    }

    public Boolean getIsReadCookie() {
        return isReadCookie;
    }

    public void setIsReadCookie(Boolean readCookie) {
        isReadCookie = readCookie;
    }

    public Boolean getIsReadQuery() {
        return isReadQuery;
    }

    public void setIsReadQuery(Boolean readQuery) {
        isReadQuery = readQuery;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSignSalt() {
        return signSalt;
    }

    public void setSignSalt(String signSalt) {
        this.signSalt = signSalt;
    }
}
