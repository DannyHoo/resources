package club.easyshare.controller.front;

import club.easyshare.controller.common.AbstractController;
import club.easyshare.framework.utils.ListUtil;
import club.easyshare.service.resource.ResourceService;
import club.easysharing.model.bean.resource.Resource;
import club.easysharing.model.enums.resource.ResourceStatusEnum;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static club.easyshare.framework.utils.Generator.getRandomTimeStr;

/**
 * @author huyuyang@lxfintech.com
 * @Title: FrontArticleController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-05 20:10:43
 */
@Controller
@RequestMapping("/front/resource")
public class FrontResourceController extends AbstractController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/category/{categoryCode}")
    public String category(HttpServletRequest request, @PathVariable String categoryCode) {
        if (true) {
            return "front/pages/resource_category";//阅读类资源
        } else if (true) {
            return "";//下载类资源
        }
        return "common/pages/404";
    }

    @RequestMapping("/savePage/{resourceCode}")
    public String savePage(HttpServletRequest request, @PathVariable String resourceCode) {
        if (true) {
            return "front/pages/resource_read";//阅读类资源
        } else if (true) {
            return "front/pages/resource_download";//下载类资源
        }
        return "common/pages/404";
    }

    /**
     * 保存资源
     *
     * @param request
     * @param resourceCode
     * @return
     */
    @RequestMapping("/doSave/{resourceCode}")
    @ResponseBody
    public String doSave(HttpServletRequest request, @PathVariable String resourceCode) {
        Resource resource = getResource(request);
        resource = resourceService.saveResource(resource);
        if (resource.getId() != null) {
            return "true";
        } else {
            return "资源提交失败";
        }
    }

    private Resource getResource(HttpServletRequest request) {
        String title = getStringValueFromRequest(request, "title");
        String note = getStringValueFromRequest(request, "note");
        String secondCategorySelect = getStringValueFromRequest(request, "secondCategorySelect");
        String language = getStringValueFromRequest(request, "language");
        String resourceDate = getStringValueFromRequest(request, "resourceDate");
        String shareWay = getStringValueFromRequest(request, "shareWay");
        String type = getStringValueFromRequest(request, "type");
        int star = getIntValueFromRequest(request, "star");
        String environment = getStringValueFromRequest(request, "environment");
        String marks = getStringValueFromRequest(request, "marks");
        String size = getStringValueFromRequest(request, "size");
        String pageTemplate = getStringValueFromRequest(request, "pageTemplate");
        String content = getStringValueFromRequest(request, "content");
        String picture = getPictureFromContent(content);
        Resource resource = new Resource()
                .setResourceCode("R_" + getRandomTimeStr())
                .setTitle(title)
                .setNote(note)
                .setCategoryCode(secondCategorySelect)
                .setLanguage(language)
                .setResourceDate(resourceDate)
                .setShareWay(shareWay)
                .setType(type)
                .setStar(star)
                .setEnvironment(environment)
                .setMarks(marks)
                .setSize(size)
                .setPageTemplate(pageTemplate)
                .setContent(content)
                .setStatus(ResourceStatusEnum.DRAFT.getStatus())
                .setAuthorUserName(getCurrentUser(request) != null ? getCurrentUser(request).getUserName() : "游客");
        ;
        return resource;
    }

    private String getPictureFromContent(String content) {
        List<String> list = getImg(content);
        if (ListUtil.isNotEmpty(list)) {
            String imgUrl=list.get(0);
            imgUrl=imgUrl.substring(imgUrl.indexOf("\"")+1,imgUrl.length()-1);
            return imgUrl;
        }
        return null;
    }

    @RequestMapping("/view/{resourceCode}")
    public ModelAndView view(HttpServletRequest request, @PathVariable String resourceCode) {
        ModelAndView modelAndView = new ModelAndView();
        Resource resource = resourceService.findByResourceCode(resourceCode);
        if (resource == null) {
            modelAndView.setViewName("common/pages/404");
        } else {
            if ("read".equals(resource.getPageTemplate())) {
                modelAndView.setViewName("front/pages/resource_read");//阅读类资源
                modelAndView.addObject("title", resource.getTitle());
                modelAndView.addObject("note", resource.getNote());
                modelAndView.addObject("content", resource.getContent());
            } else if ("download".equals(resource.getPageTemplate())) {
                modelAndView.setViewName("front/pages/resource_download");//下载类资源
            }
        }
        return modelAndView;
    }

    @RequestMapping("/editPage/{resourceCode}")
    public String editPage(HttpServletRequest request, @PathVariable String resourceCode) {
        if (true) {
            return "front/pages/resource_read";//阅读类资源
        } else if (true) {
            return "front/pages/resource_download";//下载类资源
        }
        return "common/pages/404";
    }


    /**
     * @param s
     * @return 获得图片
     */
    public static List<String> getImg(String s) {
        String regex;
        List<String> list = new ArrayList<String>();
        regex = "src=\"(.*?)\"";
        Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
        Matcher ma = pa.matcher(s);
        while (ma.find()) {
            list.add(ma.group());
        }
        return list;
    }

    /**
     * 返回存有图片地址的数组
     *
     * @param tar
     * @return
     */
    public static String[] getImgaddress(String tar) {
        List<String> imgList = getImg(tar);

        String res[] = new String[imgList.size()];

        if (imgList.size() > 0) {
            for (int i = 0; i < imgList.size(); i++) {
                int begin = imgList.get(i).indexOf("\"") + 1;
                int end = imgList.get(i).lastIndexOf("\"");
                String url[] = imgList.get(i).substring(begin, end).split("/");
                res[i] = url[url.length - 1];
            }
        } else {
        }
        return res;
    }
}