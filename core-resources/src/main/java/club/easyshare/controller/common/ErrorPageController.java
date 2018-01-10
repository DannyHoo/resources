package club.easyshare.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ErrorPageController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 21:09:55
 */
@Controller
@RequestMapping("/error/")
public class ErrorPageController extends AbstractController {
    @RequestMapping("notAccess")
    public String index1(HttpServletRequest request) {
        return "common/pages/no_access";
    }
}
