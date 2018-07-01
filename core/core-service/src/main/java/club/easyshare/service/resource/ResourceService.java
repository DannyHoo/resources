package club.easyshare.service.resource;

import club.easysharing.model.bean.resource.Resource;

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

}
