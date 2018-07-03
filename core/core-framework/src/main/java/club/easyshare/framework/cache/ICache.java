package club.easyshare.framework.cache;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ICache
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-05 23:17:14
 */
public interface ICache {
    <K,V>V put(K key, V value);
    <K,V>V get(K key);
}
