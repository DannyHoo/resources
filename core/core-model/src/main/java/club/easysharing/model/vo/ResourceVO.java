package club.easysharing.model.vo;

import club.easysharing.model.bean.resource.Resource;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ResourceVO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-07-02 11:42:03
 */
public class ResourceVO extends Resource {
    /* 资源分类名称 */
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public ResourceVO setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }
}
