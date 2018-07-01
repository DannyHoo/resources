package club.easyshare.glue.resource;

import club.easyshare.dao.data.resource.ResourceDO;
import club.easyshare.dao.jpa.resource.ResourceDAO;
import club.easyshare.glue.base.BaseGlue;
import club.easysharing.model.bean.resource.Resource;
import com.alibaba.druid.filter.AutoLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
