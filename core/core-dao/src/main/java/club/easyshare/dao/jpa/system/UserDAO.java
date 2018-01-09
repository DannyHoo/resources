package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.system.UserDO;
import club.easyshare.dao.jpa.base.BaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 14:54:43
 */
public interface UserDAO extends BaseDao<UserDO>,PagingAndSortingRepository<UserDO,Long>{

    @Modifying
    @Query("update UserDO u set u.userName=?2 where u.id=?1")
    int updateUserName(Long userId, String userName);


    UserDO findByUserNameAndPassword(String userName, String password);


    UserDO findByUserName(String userName);
}
