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
        return "front/pages/center/common/frame";
    }

    @RequestMapping("/toMyCenter")
    public String toMyCenter(HttpServletRequest request) {
        return "front/pages/center/myCenter";
    }

    @RequestMapping("/toSetting")
    public String toSetting(HttpServletRequest request) {
        return "front/pages/center/mySetting";
    }

    @RequestMapping("/toMyResources")
    public String toMyResources(HttpServletRequest request) {
        return "front/pages/center/myResources";
    }

    @RequestMapping("/toTaskCenter")
    public String toTaskCenter(HttpServletRequest request) {
        return "front/pages/center/myTaskCenter";
    }

    @RequestMapping("/toVoucher")
    public String toVoucher(HttpServletRequest request) {
        return "front/pages/center/myVoucher";
    }

    @RequestMapping("/toMoney")
    public String toMoney(HttpServletRequest request) {
        return "front/pages/center/myMoney";
    }

    @RequestMapping("/toInvite")
    public String toInvite(HttpServletRequest request) {
        return "front/pages/center/myInvite";
    }

    @RequestMapping("/toMessages")
    public String toMessages(HttpServletRequest request) {
        return "front/pages/center/myMessages";
    }


}
