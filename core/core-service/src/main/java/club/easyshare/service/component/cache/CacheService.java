package club.easyshare.service.component.cache;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CacheService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-12-29 10:44:01
 */
public interface CacheService {

    String putString(String key, String value);

    String getString(String key);
}
