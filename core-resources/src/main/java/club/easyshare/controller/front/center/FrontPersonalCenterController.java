package club.easyshare.controller.front.center;

import club.easyshare.controller.common.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: FrontPersonalCenterController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-11 12:58:10
 */
@Controller
@RequestMapping("/front/center")
public class FrontPersonalCenterController extends AbstractController {

    @RequestMapping("")
    public String header(HttpServletRequest request) {
        return "front/pages/center/personalCenter";
    }

}
