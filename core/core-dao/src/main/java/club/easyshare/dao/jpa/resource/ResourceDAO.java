package club.easyshare.dao.jpa.resource;

import club.easyshare.dao.data.resource.ResourceDO;
import club.easyshare.dao.jpa.base.BaseDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.QueryHint;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ResourceDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-30 15:05:50
 */
public interface ResourceDAO extends BaseDao<ResourceDO>,PagingAndSortingRepository<ResourceDO,Long> {

    ResourceDO findByResourceCode(String resourceCode);

    Page<ResourceDO> findAllByCategoryCodeAndStatus(String categoryCode,String status,Pageable pageable);
    Page<ResourceDO> findAllByStatus(String status,Pageable pageable);
}
