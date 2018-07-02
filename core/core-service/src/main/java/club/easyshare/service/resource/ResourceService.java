package club.easyshare.service.resource;

import club.easysharing.model.bean.resource.Resource;
import club.easysharing.model.vo.Pagenation;
import club.easysharing.model.vo.ResourceVO;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ResourceService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-30 15:37:27
 */
public interface ResourceService {

    /**
     * 添加资源
     *
     * @param resource
     * @return
     */
    Resource saveResource(Resource resource);

    /**
     * 根据资源编码查找资源
     *
     * @param resourceCode
     * @return
     */
    Resource findByResourceCode(String resourceCode);

    /**
     * 根据资源类别分页查询资源列表
     *
     * @param categoryCode 资源类别编码
     * @param pageNum 当前页号
     * @param pageSize 页面大小
     * @param isRealPage 是否真分页
     * @return
     */
    Pagenation<ResourceVO> findAllByCategoryCodeAndStatus(String categoryCode, int pageNum, int pageSize,String status, boolean isRealPage);
}
