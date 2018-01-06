package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.system.UserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-06 15:34:02
 */
public class UserDAOTest extends BaseDaoSpringTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findUser(){
        UserDO userDO=userDAO.findOne(1l);

    }
}
