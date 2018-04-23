package com.viki.concurrent.concurency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xunruibo
 * @Description:
 * @Date: Created in 16:37 2018/4/23
 * @Modified By:
 */
@RestController
public class TestController {


    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
