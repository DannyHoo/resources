package club.easyshare.controller.front;

import club.easyshare.controller.common.AbstractController;
import club.easyshare.framework.cache.ICache;
import club.easyshare.framework.cache.ICacheImpl;
import club.easyshare.framework.utils.ListUtil;
import club.easyshare.service.resource.ResourceService;
import club.easysharing.model.bean.resource.Resource;
import club.easysharing.model.enums.resource.ResourceStatusEnum;
import club.easysharing.model.vo.Pagenation;
import club.easysharing.model.vo.ResourceVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private ICache iCache=new ICacheImpl();

    @Autowired
    private ResourceService resourceService;

    /**
     * 查看某个资源分类详情页面
     *
     * @param request
     * @param categoryCode
     * @return
     */
    @RequestMapping("/category/{categoryCode}")
    public ModelAndView categoryPage(HttpServletRequest request, @PathVariable String categoryCode) {
        ModelAndView modelAndView = new ModelAndView("front/pages/resource_category");
        Integer pageNum = getIntValueFromRequest(request, "pageNum") <= 0 ? 1 : getIntValueFromRequest(request, "pageNum");
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("categoryCode", categoryCode);
        return modelAndView;
    }

    /**
     * 分页查询某个资源分类详情页面
     *
     * @param request
     * @param categoryCode
     * @param pageNum
     * @return
     */
    @RequestMapping("/category/{categoryCode}/{pageNum}")
    @ResponseBody
    public JSONObject categoryDetail(HttpServletRequest request, @PathVariable String categoryCode, @PathVariable Integer pageNum) {
        JSONObject jsonObject = new JSONObject();
        int pageSize = 20;
        Pagenation<ResourceVO> resourceData = resourceService.findAllByCategoryCodeAndStatus(categoryCode, pageNum - 1, pageSize, "40", true);
        jsonObject.put("pageNum", pageNum);
        jsonObject.put("pageSize", pageSize);
        jsonObject.put("categoryCode", categoryCode);
        jsonObject.put("pageCount", resourceData.getPageCount());
        jsonObject.put("dataCount", resourceData.getDataCount());
        jsonObject.put("resourceDataList", resourceData.getDataList());
        return jsonObject;
    }

    /**
     * 分页查询某个资源分类详情页面
     *
     * @param request
     * @param categoryCode
     * @param pageNum
     * @return
     */
    @RequestMapping("/category/{categoryCode}/{pageNum}/{pageSize}")
    @ResponseBody
    public JSONObject pageResourceList(HttpServletRequest request, @PathVariable String categoryCode, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        JSONObject jsonObject = new JSONObject();
        Pagenation<ResourceVO> resourceData=null;
        if (iCache.get(categoryCode)!=null){
            resourceData=iCache.get(categoryCode);
        }else{
            resourceData = resourceService.findAllByCategoryCodeAndStatus(categoryCode, pageNum - 1, pageSize, "40", true);
            iCache.put(categoryCode,resourceData);
        }
        jsonObject.put("pageNum", pageNum);
        jsonObject.put("pageSize", pageSize);
        jsonObject.put("categoryCode", categoryCode);
        jsonObject.put("pageCount", resourceData.getPageCount());
        jsonObject.put("dataCount", resourceData.getDataCount());
        jsonObject.put("resourceDataList", resourceData.getDataList());
        return jsonObject;
    }

    /**
     * 根据浏览量倒序查询
     * @param request
     * @param recordCount
     * @return
     */
    @RequestMapping("/queryOrderByViewCount/{recordCount}")
    @ResponseBody
    public JSONObject queryOrderByViewCount(HttpServletRequest request,@PathVariable int recordCount) {
        String cacheKey="queryOrderByViewCount";
        JSONObject jsonObject = new JSONObject();
        List<ResourceVO> resourceDataList=null;
        if (iCache.get(cacheKey)!=null){
            resourceDataList=iCache.get(cacheKey);
        }else{
            resourceDataList = resourceService.queryByViewCount("40",recordCount);
            iCache.put(cacheKey,resourceDataList);
        }
        jsonObject.put("resourceDataList", resourceDataList);
        return jsonObject;
    }

    /**
     * 根据时间倒序查询
     * @param request
     * @param recordCount
     * @return
     */
    @RequestMapping("/queryOrderByCreateTime/{recordCount}")
    @ResponseBody
    public JSONObject queryOrderByCreateTime(HttpServletRequest request,@PathVariable int recordCount) {
        String cacheKey="queryOrderByCreateTime";
        JSONObject jsonObject = new JSONObject();
        List<ResourceVO> resourceDataList=null;
        if (iCache.get(cacheKey)!=null){
            resourceDataList=iCache.get(cacheKey);
        }else{
            resourceDataList = resourceService.queryOrderByCreateTime("40",recordCount);
            iCache.put(cacheKey,resourceDataList);
        }
        jsonObject.put("resourceDataList", resourceDataList);
        return jsonObject;
    }

    /**
     * 新增/保存资源
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

    /**
     * 查看资源页面
     *
     * @param request
     * @param resourceCode
     * @return
     */
    @RequestMapping("/view/{resourceCode}")
    public ModelAndView view(HttpServletRequest request, @PathVariable String resourceCode) {
        ModelAndView modelAndView = new ModelAndView();
        Resource resource = resourceService.findByResourceCode(resourceCode);
        if (resource == null) {
            modelAndView.setViewName("common/pages/404");
        } else {
            if ("read".equals(resource.getPageTemplate())) {
                modelAndView.setViewName("front/pages/resource_read");//阅读类资源
                modelAndView.addObject("resource", resource);
            } else if ("download".equals(resource.getPageTemplate())) {
                modelAndView.setViewName("front/pages/resource_download");//下载类资源
            }
        }
        return modelAndView;
    }

    /**
     * 编辑资源页面
     *
     * @param request
     * @param resourceCode
     * @return
     */
    @RequestMapping("/editPage/{resourceCode}")
    public String editPage(HttpServletRequest request, @PathVariable String resourceCode) {
        if (true) {
            return "front/pages/resource_read";//阅读类资源
        } else if (true) {
            return "front/pages/resource_download";//下载类资源
        }
        return "common/pages/404";
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
        String picture = getFirstPictureUrlFromContent(content);
        Resource resource = new Resource()
                .setResourceCode("R_" + getRandomTimeStr())
                .setTitle(title)
                .setNote(note)
                .setPicture(picture)
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

}
