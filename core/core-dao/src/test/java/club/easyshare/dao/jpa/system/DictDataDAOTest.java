package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.system.DictDataDO;
import club.easyshare.dao.jpa.BaseDaoSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DictDataDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-09 23:10:42
 */
public class DictDataDAOTest extends BaseDaoSpringTest {

    @Autowired
    private DictDataDAO dictDataDAO;

    @Test
    public void findOneTest(){
        DictDataDO dictDataDO=dictDataDAO.findByDictDataCode("RsaPrivateKey");
        Assert.assertNotNull(dictDataDO);
    }
}
