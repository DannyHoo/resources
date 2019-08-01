package club.easyshare.dao.jpa.system;

import club.easyshare.dao.data.resource.ResourceDO;
import club.easyshare.dao.jpa.BaseDaoSpringTest;
import club.easyshare.dao.jpa.resource.ResourceDAO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ResourceDAOTest extends BaseDaoSpringTest {

    @Autowired
    private ResourceDAO resourceDAO;

    @Test
    public void findTest(){
        long start=System.currentTimeMillis();
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(1, 10, sort);
        Page<ResourceDO> resourceDOPage=resourceDAO.findAllByCategoryCodeAndStatus("","40",pageable);
        System.out.println("耗时："+(System.currentTimeMillis()-start));
        System.out.println(JSON.toJSONString(resourceDOPage));
    }
}
