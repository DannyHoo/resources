package club.easyshare.controller.front;

import club.easyshare.service.common.system.ViewRecordService;
import club.easysharing.model.parameter.system.ViewRecordParameter;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Map;
import java.util.StringTokenizer;

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

    protected final static boolean isSkipSaveViewRecord = Boolean.parseBoolean(System.getProperty("isSkipSaveViewRecord", "false")); //默认记录访问记录

    @Autowired
    private ViewRecordService viewRecordService;

    @RequestMapping("/")
    public String index1(HttpServletRequest request) {
        saveViewRecords(request);
        return "front/index";
    }

    @RequestMapping("/front/index")
    public String index(HttpServletRequest request) {
        saveViewRecords(request);
        return "front/index";
    }

    @RequestMapping("/jsontest")
    public void test(@RequestBody Map<String,Object> params){
        System.out.println("username: " + params.get("username"));
        System.out.println("password: " + params.get("password"));
    }

    private void saveViewRecords(HttpServletRequest request) {
        if (!isSkipSaveViewRecord){
            ViewRecordParameter viewRecordParameter = getViewRecordParameter(request);
            viewRecordService.saveViewRecord(viewRecordParameter);
        }
    }


    private ViewRecordParameter getViewRecordParameter(HttpServletRequest request) {
        String agent = request.getHeader("user-agent");
        StringTokenizer st = new StringTokenizer(agent, ";");
        String userbrowser = st.nextToken();
        String useros = st.nextToken();
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String method = request.getMethod();
        String protocol = request.getProtocol();
        String refer = request.getHeader("referer");
        ViewRecordParameter viewRecordParameter = new ViewRecordParameter();
        viewRecordParameter.setUserAgent(agent)
                .setUserBrowser(userbrowser)
                .setUserOS(useros)
                .setRemoteAddr(remoteAddr)
                .setRemoteHost(remoteHost)
                .setMethod(method)
                .setProtocol(protocol)
                .setRefer(refer);
        return viewRecordParameter;
    }

}
