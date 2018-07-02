package club.easyshare.glue.resource;

import club.easyshare.dao.data.resource.ResourceDO;
import club.easyshare.dao.jpa.resource.ResourceDAO;
import club.easyshare.framework.utils.ListUtil;
import club.easyshare.glue.base.BaseGlue;
import club.easysharing.model.bean.resource.Resource;
import club.easysharing.model.vo.Pagenation;
import club.easysharing.model.vo.ResourceVO;
import com.alibaba.druid.filter.AutoLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ResourceGlue
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-30 15:34:33
 */
@Component
public class ResourceGlue extends BaseGlue {

    @Autowired
    private ResourceDAO resourceDAO;

    public Resource saveResource(Resource resource) {
        ResourceDO saveResult = resourceDAO.save(convertIgnoreNullProperty(resource, ResourceDO.class));
        return convertIgnoreNullProperty(saveResult, Resource.class);
    }

    public Resource findByResourceCode(String resourceCode) {
        ResourceDO findResult = resourceDAO.findByResourceCode(resourceCode);
        return convertIgnoreNullProperty(findResult, Resource.class);
    }

    public Pagenation<ResourceVO> findAllByCategoryCodeAndStatus(String categoryCode, int pageNum, int pageSize, String status,boolean isRealPage) {
        Pagenation<ResourceVO> result = null;
        //真分页
        if (isRealPage) {
            Sort sort = new Sort(Sort.Direction.DESC,"createTime");
            Pageable pageable = new PageRequest(pageNum,pageSize,sort);
            Page<ResourceDO> pageResult=resourceDAO.findAllByCategoryCodeAndStatus(categoryCode,status,pageable);
            if (ListUtil.isNotEmpty(pageResult.getContent())){
                result=new Pagenation<>(pageNum,pageSize,pageResult.getTotalElements(),pageResult.getTotalPages());
                List<ResourceDO> resourceDOList=pageResult.getContent();
                List<ResourceVO> resourceVOList=new ArrayList<>();
                for (int i=0;i<resourceDOList.size();i++){
                    ResourceVO resourceVO=convertIgnoreNullProperty(resourceDOList.get(i),ResourceVO.class);
                    resourceVO.setCategoryName(getCategoryName(resourceVO.getCategoryCode()));
                    resourceVOList.add(resourceVO);
                }
                result.setDataList(resourceVOList);
            }
        }
        return result;
    }

    private String getCategoryName(String categoryCode) {
        Map<String,String> categoryMap=new HashMap<>();
        categoryMap.put("SourceCode","源码分享");
        categoryMap.put("News","今日头条");
        categoryMap.put("Entertainment","娱乐放松");
        categoryMap.put("Activity","社区活动");
        categoryMap.put("Softwares_Security","安全杀毒");
        categoryMap.put("Softwares_StudyOffice","学习办公");
        categoryMap.put("Softwares_Tools","实用工具");
        categoryMap.put("Softwares_System","系统软件");
        categoryMap.put("Course_ProgramLanguage","编程语言");
        categoryMap.put("Course_FrontDesign","前端设计");
        categoryMap.put("Course_SysOperation","系统运维");
        categoryMap.put("Course_Security","安全攻防");
        categoryMap.put("Course_Architecture","架构设计");
        categoryMap.put("SourceCode_Front","前端源码");
        categoryMap.put("SourceCode_PageFunction","网页特效");
        categoryMap.put("SourceCode_DevelopDemo","开发实例");
        categoryMap.put("SourceCode_SystemCode","系统源码");
        categoryMap.put("News_Life","生活咨询");
        categoryMap.put("News_Culturl","文化娱乐");
        categoryMap.put("News_Finance","金融动态");
        categoryMap.put("News_SportsEconomic","体育财经");
        categoryMap.put("News_HotNews","实时热点");
        categoryMap.put("Entertainment_Movies","电影资源");
        categoryMap.put("Entertainment_Pictures","精美壁纸");
        categoryMap.put("Activity_OnLine","线上互动");
        categoryMap.put("Activity_OffLine","线下分享");
        categoryMap.put("Activity_Party","交友聚会");
        return categoryMap.get(categoryCode);
    }
}
