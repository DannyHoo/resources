package club.easyshare.controller.bg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println( System.getProperty("user.dir"));
        return "bg/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        return "bg/pages/login/login";
    }

    @RequestMapping("/pages/main")
    public String main(HttpServletRequest request) {
        return "bg/pages/main";
    }

    @RequestMapping("/resourceManage")
    public String resourceManage(HttpServletRequest request) {
        return "bg/pages/resource/resources";
    }

    @RequestMapping("/spiderManage")
    public String spiderManage(HttpServletRequest request) {
        return "bg/pages/resource/resources";
    }

    @RequestMapping("/menuManage")
    public String menuManage(HttpServletRequest request) {
        return "bg/pages/resource/resources";
    }

    @RequestMapping("/authManage")
    public String authManage(HttpServletRequest request) {
        return "bg/pages/resource/resources";
    }

    @RequestMapping("/paramManage")
    public String paramManage(HttpServletRequest request) {
        return "bg/pages/resource/resources";
    }


    @RequestMapping("/json/images.json")
    @ResponseBody
    public String images(HttpServletRequest request) {
        return getImages();
    }


    @RequestMapping("/json/newsList.json")
    @ResponseBody
    public String newsList(HttpServletRequest request) throws IOException {
        String result=FileUtils.readFileToString(new File( System.getProperty("user.dir")+"/src/main/webapp/WEB-INF/bg/json/newsList.json"));
        return result;
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

        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("title","后台首页");
        jsonObject1.put("icon","icon-computer");
        jsonObject1.put("href","/bg/index.html");
        jsonObject1.put("spread","false");

        JSONObject jsonObject2=new JSONObject();
        jsonObject2.put("title","资源列表");
        jsonObject2.put("icon","icon-text");
        jsonObject2.put("href","/bg/resourceManage.html");
        jsonObject2.put("spread","false");

        JSONObject jsonObject3=new JSONObject();
        jsonObject3.put("title","爬虫管理");
        jsonObject3.put("icon","icon-camera");
        jsonObject3.put("href","/bg/spiderManage.html");
        jsonObject3.put("spread","false");

        JSONObject jsonObject4=new JSONObject();
        jsonObject4.put("title","菜单管理");
        jsonObject4.put("icon","&#xe64c;");
        jsonObject4.put("href","/bg/menuManage.html");
        jsonObject4.put("spread","false");

        JSONObject jsonObject5=new JSONObject();
        jsonObject5.put("title","系统管理");
        jsonObject5.put("icon","&#xe631");
        jsonObject5.put("href","");
        jsonObject5.put("spread","false");

        JSONObject jsonObject5_1=new JSONObject();
        jsonObject5_1.put("title","权限管理");
        jsonObject5_1.put("icon","icon-computer");
        jsonObject5_1.put("href","/bg/authManage.html");
        jsonObject5_1.put("spread","false");
        JSONObject jsonObject5_2=new JSONObject();
        jsonObject5_2.put("title","系统参数");
        jsonObject5_2.put("icon","icon-computer");
        jsonObject5_2.put("href","/bg/paramManage.html");
        jsonObject5_2.put("spread","false");

        List<JSONObject> jsonObjects=new ArrayList<>();
        jsonObjects.add(jsonObject5_1);
        jsonObjects.add(jsonObject5_2);
        jsonObject5.put("children",jsonObjects);

        List<JSONObject> jsonObjectList=new ArrayList<>();
        jsonObjectList.add(jsonObject1);
        jsonObjectList.add(jsonObject2);
        jsonObjectList.add(jsonObject3);
        jsonObjectList.add(jsonObject4);
        jsonObjectList.add(jsonObject5);

        return JSON.toJSONString(jsonObjectList);

        /*return "[{\n" +
                "\t\"title\" : \"后台首页\",\n" +
                "\t\"icon\" : \"icon-computer\",\n" +
                "\t\"href\" : \"/bg/index.html\",\n" +
                "\t\"spread\" : false\n" +
                "},{\n" +
                "\t\"title\" : \"文章列表\",\n" +
                "\t\"icon\" : \"icon-text\",\n" +
                "\t\"href\" : \"bg/news/resources.html\",\n" +
                "\t\"spread\" : false\n" +
                "},{\n" +
                "\t\"title\" : \"友情链接\",\n" +
                "\t\"icon\" : \"&#xe64c;\",\n" +
                "\t\"href\" : \"pages/links/linksList.html\",\n" +
                "\t\"spread\" : false\n" +
                "},{\n" +
                "\t\"title\" : \"系统基本参数\",\n" +
                "\t\"icon\" : \"&#xe631;\",\n" +
                "\t\"href\" : \"pages/systemParameter/systemParameter.html\",\n" +
                "\t\"spread\" : false\n" +
                "},{\n" +
                "\t\"title\" : \"其他页面\",\n" +
                "\t\"icon\" : \"&#xe630;\",\n" +
                "\t\"href\" : \"\",\n" +
                "\t\"spread\" : false,\n" +
                "\t\"children\" : [\n" +
                "\t\t{\n" +
                "\t\t\t\"title\" : \"404页面\",\n" +
                "\t\t\t\"icon\" : \"&#xe61c;\",\n" +
                "\t\t\t\"href\" : \"pages/404.html\",\n" +
                "\t\t\t\"spread\" : false\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\" : \"登录\",\n" +
                "\t\t\t\"icon\" : \"&#xe609;\",\n" +
                "\t\t\t\"href\" : \"pages/login/login.html\",\n" +
                "\t\t\t\"spread\" : false,\n" +
                "\t\t\t\"target\" : \"_blank\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}]";*/
    }


    private String getImages() {
        return "";
    }
}
