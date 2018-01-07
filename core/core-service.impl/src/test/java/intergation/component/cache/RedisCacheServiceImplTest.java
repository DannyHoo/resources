package intergation.component.cache;

import club.easyshare.service.component.cache.CacheService;
import intergation.BaseServiceSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huyuyang@lxfintech.com
 * @Title: RedisCacheServiceImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-12-29 12:02:23
 */
public class RedisCacheServiceImplTest extends BaseServiceSpringTest {

    @Autowired
    private CacheService redisCacheService;

    @Test
    public void putStringTest(){
        String key="testKey";
        String value="DannyHoo";
        String result=redisCacheService.putString(key,value);
        System.out.println(result);
    }

    @Test
    public void getString(){
        String key="testKey";
        String value=redisCacheService.getString(key);
        System.out.println(value);
    }
}
