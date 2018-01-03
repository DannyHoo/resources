package club.easyshare.controller.bg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BgIndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-12-28 17:58:17
 */
@Controller
@RequestMapping("/bg")
public class BgIndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "bg/index";
    }

    @RequestMapping("/pages/main")
    public String main(HttpServletRequest request) {
        return "bg/pages/main";
    }

    @RequestMapping("/json/images.json")
    @ResponseBody
    public String images(HttpServletRequest request) {
        return getImages();
    }


    @RequestMapping("/json/newsList.json")
    @ResponseBody
    public String newsList(HttpServletRequest request) {
        return "";
    }

    @RequestMapping("/json/usersList.json")
    @ResponseBody
    public String usersList(HttpServletRequest request) {
        return "";
    }

    @RequestMapping("/json/message.json")
    @ResponseBody
    public String message(HttpServletRequest request) {
        return "";
    }


    @RequestMapping("/json/systemParameter.json")
    @ResponseBody
    public String systemParameter(HttpServletRequest request) {
        return "";
    }

    @RequestMapping("/json/navs.json")
    @ResponseBody
    public String navs(HttpServletRequest request) {
        return "";
    }


    private String getImages() {
        return "";
    }
}
