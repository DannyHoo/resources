package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.system.ViewRecordDO;
import club.easyshare.dao.jpa.base.BaseDao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ViewRecordDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 14:36:18
 */
public interface ViewRecordDAO extends BaseDao<ViewRecordDO>,PagingAndSortingRepository<ViewRecordDO,Long> {


}
