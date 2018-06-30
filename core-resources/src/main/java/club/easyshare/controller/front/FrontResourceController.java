package club.easyshare.controller.front;

import club.easyshare.controller.common.AbstractController;
import club.easyshare.service.resource.ResourceService;
import club.easysharing.model.bean.resource.Resource;
import club.easysharing.model.enums.resource.ResourceStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        Resource resource = new Resource()
                .setResourceCode("R_"+getRandomTimeStr())
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
                .setAuthorUserName(getCurrentUser(request)!=null?getCurrentUser(request).getUserName():"游客");
                ;
        return resource;
    }

    @RequestMapping("/view/{resourceCode}")
    public ModelAndView view(HttpServletRequest request, @PathVariable String resourceCode) {
        ModelAndView modelAndView = new ModelAndView();
        if (true) {
            modelAndView.setViewName("front/pages/resource_read");//阅读类资源
        } else if (true) {
            modelAndView.setViewName("front/pages/resource_download");//下载类资源
        } else {
            modelAndView.setViewName("common/pages/404");
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
}
