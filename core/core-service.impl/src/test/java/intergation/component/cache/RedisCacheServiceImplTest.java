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
        JedisPool pool = new JedisPool(new JedisPoolConfig(), redisAddress, redisPort, redisTimeout,"KgCnm250SbSb",0);
        Jedis jedis = pool.getResource();
        for (int i=0;i<5000;i++){
            //jedis.set("test"+i, generateValue());
            jedis.del("test"+i);
        }
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

    private String generateValue() {
        return "{\"appId\":12345,\"appInfo\":\"{\\\"app_index_pic\\\":\\\"844bc067d81e431a87d6565d1c8eb340.gif\\\",\\\"app_description\\\":\\\"APP介绍\\\",\\\"app_product_detail\\\":\\\"e0b782e4890344d2a043b3ffaa6d8c11.jpg\\\",\\\"app_product_category\\\":\\\"1be4b424cfda45ce8341963bc3d7d04b.jpg\\\",\\\"app_product_tail\\\":\\\"e869487681a747188772f2c8fe5a1e2c.gif\\\",\\\"app_product_cashier\\\":\\\"aa56e4f5a8fc4bdcb1955d7aa33374d9.jpg\\\",\\\"app_name\\\":\\\"APP名称\\\",\\\"app_icon\\\":\\\"bfdc8ff9eb99421a892f4a9c0787667b.jpg\\\"}\",\"applyTime\":1541728993611,\"auditDescription\":\"不就科技有限送你的饭有限公司\",\"auditRecord\":\"不就科技有限送你的饭有限公司\",\"auditTime\":1541728993611,\"bankInfo\":\"{\\\"account_subbranch\\\":\\\"银行卡所在支行\\\",\\\"account_licence\\\":\\\"10ba3932acfb4860928e38078606c668.png\\\",\\\"account_name\\\":\\\"银行账户名称\\\",\\\"account_no\\\":\\\"银行对公账号\\\"}\",\"cardType\":\"dfdfdfdfd\",\"category\":\"dfdfdfdfd\",\"channelConfigId\":12345,\"code\":\"dfdfdfdfd\",\"companyInfo\":\"{\\\"company_operator_idcard_front\\\":\\\"f1de1203b77142a687e0624e1f15bd1f.png\\\",\\\"company_operator_idcard_back\\\":\\\"921a1b5271044e0d99b96a32d0484ea7.jpg\\\",\\\"company_customer_service_phone\\\":\\\"客服电话\\\",\\\"company_website_icp\\\":\\\"ICP 备案号\\\",\\\"company_website\\\":\\\"需接入支付的网站地址/公司网站\\\",\\\"company_official_letter\\\":\\\"申请公函\\\",\\\"company_legal_person_idcard_front\\\":\\\"e987e0a0507644a595a1f529b8f7a5f4.png\\\",\\\"company_legal_person_idcard_back\\\":\\\"a6c977d186f14ff8adea1ece7aaa49a5.jpg\\\"}\",\"description\":\"不就科技有限送你的饭有限公司\",\"emailInfo\":\"{\\\"email_login_url\\\":\\\"邮箱登录网址\\\",\\\"email_account\\\":\\\"邮箱帐号\\\",\\\"email_password\\\":\\\"邮箱密码\\\"}\",\"id\":12345,\"name\":\"不就科技有限送你的饭有限公司\",\"operatorId\":23234,\"parameters\":\"{\\\"email_login_url\\\":\\\"邮箱登录网址\\\",\\\"email_account\\\":\\\"邮箱帐号\\\",\\\"email_password\\\":\\\"邮箱密码\\\"}\",\"rate\":1,\"status\":\"SUCCWSS\"}\n";
    }
}
