package club.easyshare.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: FrontIndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-12-31 17:17:50
 */
@Controller
public class FrontIndexController {

    @RequestMapping("/")
    public String index1(HttpServletRequest request) {
        return "front/index";
    }

    @RequestMapping("/front/index")
    public String index(HttpServletRequest request) {
        return "front/index";
    }

}
