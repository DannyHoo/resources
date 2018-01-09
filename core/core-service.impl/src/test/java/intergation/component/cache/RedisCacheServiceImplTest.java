package intergation.component.cache;

import club.easyshare.service.component.cache.CacheService;
import intergation.BaseServiceSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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
    public void testa(){
        String redisAddress = "39.106.124.34";
        int redisPort = 6379;
        int redisTimeout = 2000;
        JedisPool pool = new JedisPool(new JedisPoolConfig(), redisAddress, redisPort, redisTimeout,"111",0);
        Jedis jedis = pool.getResource();
        jedis.set("test123", "lulu");
        pool.returnResource(jedis);
    }

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
