package top.xystudio.apishield.springboot.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xystudio.apishield.utils.ApiShieldUtil;

/**
 * 时间戳服务 Controller
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
@RestController
@RequestMapping("/apishield-service/timestamp")
@ConditionalOnProperty(prefix = "apishield", name = "ts-service-enable", havingValue = "true")
public class TsServiceController {

    /**
     * <p>getTimeStamp.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    @GetMapping
    public String getTimeStamp(){
        return ApiShieldUtil.getTimeStamp().toString();
    }

}
