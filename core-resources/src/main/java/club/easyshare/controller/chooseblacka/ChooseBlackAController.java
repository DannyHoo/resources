package club.easyshare.controller.chooseblacka;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ChooseBlackAController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-03 22:15:56
 */
@Controller
public class ChooseBlackAController {

    @RequestMapping("/choose")
    public String index(){
        return "chooseblacka/index";
    }
    
}
