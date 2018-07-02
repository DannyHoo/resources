package club.easyshare.service.impl.front;

import club.easyshare.glue.resource.ResourceGlue;
import club.easyshare.service.impl.base.BaseServiceImpl;
import club.easyshare.service.resource.ResourceService;
import club.easysharing.model.bean.resource.Resource;
import club.easysharing.model.vo.Pagenation;
import club.easysharing.model.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ResourceServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-30 15:39:37
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl implements ResourceService {

    @Autowired
    private ResourceGlue resourceGlue;

    /**
     * 添加资源
     *
     * @param resource
     * @return
     */
    @Override
    public Resource saveResource(Resource resource) {
        return resourceGlue.saveResource(resource);
    }

    /**
     * 根据资源编码查找资源
     *
     * @param resourceCode
     * @return
     */
    @Override
    public Resource findByResourceCode(String resourceCode) {
        return resourceGlue.findByResourceCode(resourceCode);
    }

    /**
     * 根据资源类别分页查询资源列表
     *
     * @param categoryCode 资源类别编码
     * @param pageNum      当前页号
     * @param pageSize     页面大小
     * @param isRealPage   是否真分页
     * @return
     */
    @Override
    public Pagenation<ResourceVO> findPageByCategoryCode(String categoryCode, int pageNum, int pageSize, boolean isRealPage) {
        Pagenation<ResourceVO> result = resourceGlue.findPageByCategoryCode(categoryCode, pageNum, pageSize, isRealPage);
        return result;
    }
}
