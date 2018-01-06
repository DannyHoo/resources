package club.easyshare.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: FrontArticleController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-05 20:10:43
 */
@Controller
@RequestMapping("/front/article")
public class FrontArticleController {
    @RequestMapping("/{pageNo}")
    public String header(HttpServletRequest request) {
        return "front/pages/article";
    }

}
