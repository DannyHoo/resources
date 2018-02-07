package club.easyshare.controller.gateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ChooseBlackA
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-07 14:47:29
 */
@Controller
@RequestMapping("/chooseblacka")
public class ChooseBlackA {

    @RequestMapping("/index")
    @ResponseBody
    public String header(HttpServletRequest request) {
        return "霖哥你好~";
    }

}
