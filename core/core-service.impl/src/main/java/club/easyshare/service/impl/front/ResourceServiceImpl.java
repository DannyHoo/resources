package club.easyshare.service.impl.front;

import club.easyshare.glue.resource.ResourceGlue;
import club.easyshare.service.impl.base.BaseServiceImpl;
import club.easyshare.service.resource.ResourceService;
import club.easysharing.model.bean.resource.Resource;
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

    @Override
    public Resource saveResource(Resource resource) {
        return resourceGlue.saveResource(resource);
    }
}
