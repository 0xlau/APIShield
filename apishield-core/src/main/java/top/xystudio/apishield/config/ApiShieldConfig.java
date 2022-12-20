package top.xystudio.apishield.config;

/**
 * <p>ApiShieldConfig class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class ApiShieldConfig {

    private Boolean enable = false;

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

    /** 是否尝试从请求体里读取关键词 */
    private Boolean isReadBody = true;

    /** 是否尝试从header里读取关键词 */
    private Boolean isReadHeader = true;

    /** 是否尝试从cookie里读取关键词 */
    private Boolean isReadCookie = true;

    /** 是否尝试从query里读取关键词 */
    private Boolean isReadQuery = true;

    /**
     * <p>Getter for the field <code>tsServiceEnable</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getTsServiceEnable() {
        return tsServiceEnable;
    }

    /**
     * <p>Setter for the field <code>tsServiceEnable</code>.</p>
     *
     * @param tsServiceEnable a {@link java.lang.Boolean} object.
     */
    public void setTsServiceEnable(Boolean tsServiceEnable) {
        this.tsServiceEnable = tsServiceEnable;
    }

    /**
     * <p>Getter for the field <code>tsName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTsName() {
        return tsName;
    }

    /**
     * <p>Setter for the field <code>tsName</code>.</p>
     *
     * @param tsName a {@link java.lang.String} object.
     */
    public void setTsName(String tsName) {
        this.tsName = tsName;
    }

    /**
     * <p>Getter for the field <code>tsLifetime</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getTsLifetime() {
        return tsLifetime;
    }

    /**
     * <p>Setter for the field <code>tsLifetime</code>.</p>
     *
     * @param tsLifetime a {@link java.lang.Integer} object.
     */
    public void setTsLifetime(Integer tsLifetime) {
        this.tsLifetime = tsLifetime;
    }

    /**
     * <p>Getter for the field <code>isReadBody</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIsReadBody() {
        return isReadBody;
    }

    /**
     * <p>Setter for the field <code>isReadBody</code>.</p>
     *
     * @param readBody a {@link java.lang.Boolean} object.
     */
    public void setIsReadBody(Boolean readBody) {
        isReadBody = readBody;
    }

    /**
     * <p>Getter for the field <code>isReadHeader</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIsReadHeader() {
        return isReadHeader;
    }

    /**
     * <p>Setter for the field <code>isReadHeader</code>.</p>
     *
     * @param readHeader a {@link java.lang.Boolean} object.
     */
    public void setIsReadHeader(Boolean readHeader) {
        isReadHeader = readHeader;
    }

    /**
     * <p>Getter for the field <code>isReadCookie</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIsReadCookie() {
        return isReadCookie;
    }

    /**
     * <p>Setter for the field <code>isReadCookie</code>.</p>
     *
     * @param readCookie a {@link java.lang.Boolean} object.
     */
    public void setIsReadCookie(Boolean readCookie) {
        isReadCookie = readCookie;
    }

    /**
     * <p>Getter for the field <code>isReadQuery</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIsReadQuery() {
        return isReadQuery;
    }

    /**
     * <p>Setter for the field <code>isReadQuery</code>.</p>
     *
     * @param readQuery a {@link java.lang.Boolean} object.
     */
    public void setIsReadQuery(Boolean readQuery) {
        isReadQuery = readQuery;
    }

    /**
     * <p>Getter for the field <code>enable</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * <p>Setter for the field <code>enable</code>.</p>
     *
     * @param enable a {@link java.lang.Boolean} object.
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * <p>Getter for the field <code>signName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSignName() {
        return signName;
    }

    /**
     * <p>Setter for the field <code>signName</code>.</p>
     *
     * @param signName a {@link java.lang.String} object.
     */
    public void setSignName(String signName) {
        this.signName = signName;
    }

    /**
     * <p>Getter for the field <code>signSalt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSignSalt() {
        return signSalt;
    }

    /**
     * <p>Setter for the field <code>signSalt</code>.</p>
     *
     * @param signSalt a {@link java.lang.String} object.
     */
    public void setSignSalt(String signSalt) {
        this.signSalt = signSalt;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ApiShieldConfig{" +
                "enable=" + enable +
                ", signName='" + signName + '\'' +
                ", signSalt='" + signSalt + '\'' +
                ", tsServiceEnable=" + tsServiceEnable +
                ", tsName='" + tsName + '\'' +
                ", tsLifetime=" + tsLifetime +
                ", isReadBody=" + isReadBody +
                ", isReadHeader=" + isReadHeader +
                ", isReadCookie=" + isReadCookie +
                ", isReadQuery=" + isReadQuery +
                '}';
    }
}
