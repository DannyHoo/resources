package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.system.DictDataDO;
import club.easyshare.dao.data.system.DictTypeDO;
import club.easyshare.dao.jpa.base.BaseDao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DictDataDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-09 23:05:25
 */
public interface DictDataDAO  extends BaseDao<DictDataDO>,PagingAndSortingRepository<DictDataDO,Long> {

    DictDataDO findByDictDataCode(String dictDataCode);

}
