package club.easyshare.dao.jpa.resource;

import club.easyshare.dao.data.resource.ResourceDO;
import club.easyshare.dao.jpa.base.BaseDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ResourceDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-30 15:05:50
 */
public interface ResourceDAO extends BaseDao<ResourceDO>, PagingAndSortingRepository<ResourceDO, Long> {

    ResourceDO findByResourceCode(String resourceCode);

    /*@Query(value = "select r.id,r.resourceCode,r.categoryCode,r.title,r.note,r.picture,r.size,r.language,r.resourceDate,r.shareWay,r.type,r.star,r.environment,r.marks,r.authorUserName,r.pageTemplate,r.status,r.viewCount,r.comment,r.createTime,r.updateTime from ResourceDO r where r.categoryCode=?1 and r.status=?2")*/
    Page<ResourceDO> findAllByCategoryCodeAndStatus(String categoryCode, String status, Pageable pageable);

    /*@Query(value = "select r.id,r.resourceCode,r.categoryCode,r.title,r.note,r.picture,r.size,r.language,r.resourceDate,r.shareWay,r.type,r.star,r.environment,r.marks,r.authorUserName,r.pageTemplate,r.status,r.viewCount,r.comment,r.createTime,r.updateTime from ResourceDO r where r.status=?1")*/
    Page<ResourceDO> findAllByStatus(String status, Pageable pageable);

    /*@Query(value = "select id,resourceCode,categoryCode,title,note,picture,size,language,resourceDate,shareWay,type,star,environment,marks,authorUserName,pageTemplate,status,viewCount,comment,createTime,updateTime from t_resource where status=?1 order by rand() limit ?2 ", nativeQuery = true)*/
    @Query(value = "select * from t_resource where status=?1 order by rand() limit ?2 ", nativeQuery = true)
    List<ResourceDO> queryOrderByRand(String status, int recordCount);
}
