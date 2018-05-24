package club.easyshare.service.component.spider.lagou;


import club.easysharing.model.entity.UrlCache;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouPageProcessor
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 00:29:41
 */
public interface LaGouPageProcessor {

    UrlCache getUrlCache();

    boolean spider(String beginUrl) throws InterruptedException;

    void cleanData();

}
