package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.system.DictTypeDO;
import club.easyshare.dao.data.system.UserDO;
import club.easyshare.dao.jpa.base.BaseDao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DictTypeDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-09 23:05:12
 */
public interface DictTypeDAO extends BaseDao<DictTypeDO>,PagingAndSortingRepository<DictTypeDO,Long> {

    DictTypeDO findByCode(String code);
}
