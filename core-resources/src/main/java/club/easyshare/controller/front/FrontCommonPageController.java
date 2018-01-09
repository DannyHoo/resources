package club.easyshare.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: FrontCommonPageController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-03 15:14:24
 */
@Controller
@RequestMapping("/front/commonPage")
public class FrontCommonPageController {

    @RequestMapping("/header")
    public String header(HttpServletRequest request) {
        return "front/pages/common/header";
    }

    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest request) {
        return "front/pages/login";
    }



    @RequestMapping("/template1")
    public String template1(HttpServletRequest request) {
        return "front/pages/templates/template1";
    }

}