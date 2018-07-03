package club.easyshare.framework.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ICacheImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-07-03 13:54:30
 */
public class ICacheImpl implements ICache {

    private static Map cacheMap=new ConcurrentHashMap();

    @Override
    public <K, V> V put(K key, V value) {
        cacheMap.put(key,value);
        return value;
    }

    @Override
    public <K, V> V get(K key) {
        return (V)cacheMap.get(key);
    }
}
