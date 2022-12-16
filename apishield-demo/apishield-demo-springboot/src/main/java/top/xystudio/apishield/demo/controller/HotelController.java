package top.xystudio.apishield.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xystudio.apishield.annotation.ApiShieldCheckTimestamp;
import top.xystudio.apishield.demo.entity.Hotel;

import java.math.BigDecimal;

/**
 * @author liupeiqiang
 * @date 2022/12/8 18:53
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @GetMapping
    @ApiShieldCheckTimestamp
    public String getHotel(Hotel hotel){
        Hotel result = new Hotel();
        result.setName("豪华大酒店");
        result.setDesc("这是一家豪华大酒店");
        result.setPrice(BigDecimal.valueOf(10000));
        return result.toString();
    }

}
