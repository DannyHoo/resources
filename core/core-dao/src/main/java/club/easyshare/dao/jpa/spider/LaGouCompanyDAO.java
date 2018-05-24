package club.easyshare.dao.jpa.spider;

import club.easyshare.dao.data.spider.LaGouCompanyDO;
import club.easyshare.dao.jpa.base.BaseDao;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 14:54:43
 */
public interface LaGouCompanyDAO extends BaseDao<LaGouCompanyDO>,PagingAndSortingRepository<LaGouCompanyDO,Long>{

    LaGouCompanyDO findByCompanyNameAndJobName(String companyName, String jobName);

    List<LaGouCompanyDO> findByPageUrl(String pageUrl);

}
