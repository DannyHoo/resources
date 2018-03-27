package club.easyshare.controller.gateway;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: QiNiuController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-03-07 17:55:14
 */
@Controller
@RequestMapping("/gateway/qiniu")
public class QiNiuController {

    @RequestMapping("/uptoken")
    @ResponseBody
    public String getToken(HttpServletRequest request){
        String accessKey = "t12Htj_DOr4vaGnurfOpbSfZ5ZJG2Q_JjM1BxdTT";
        String secretKey = "v6UwgHtwd-tGUwBEDvr5MvGOrUf7LHY2SX-8zoi4";
        String bucket = "easysharing";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }

    public static void main(String[] args) {
        String accessKey = "t12Htj_DOr4vaGnurfOpbSfZ5ZJG2Q_JjM1BxdTT";
        String secretKey = "v6UwgHtwd-tGUwBEDvr5MvGOrUf7LHY2SX-8zoi4";
        String bucket = "easysharing";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
    }
}
