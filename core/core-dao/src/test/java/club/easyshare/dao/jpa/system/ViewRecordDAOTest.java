package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.system.ViewRecordDO;
import club.easyshare.dao.jpa.BaseDaoSpringTest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ViewRecordDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 16:54:20
 */
public class ViewRecordDAOTest extends BaseDaoSpringTest {

    @Autowired
    private ViewRecordDAO viewRecordDAO;

    @Test
    public void findTest(){
        viewRecordDAO.findAll();
    }

    @Test
    public void saveTest(){
        ViewRecordDO viewRecordDO=new ViewRecordDO()
                .setMethod("POST")
                .setProtocol("PROTOCOL");
        ViewRecordDO saved=viewRecordDAO.save(viewRecordDO);
        System.out.println(JSON.toJSONString(viewRecordDO));
    }
}
