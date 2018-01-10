package club.easysharing.model.bean.system;

import club.easysharing.model.bean.BaseBean;

import javax.persistence.Column;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ViewRecord
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 14:34:41
 */
public class ViewRecord extends BaseBean {
    //Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_3 like Mac OS X) AppleWebKit/603.3.8 (KHTML, like Gecko) Version/10.0 Mobile/14G60 Safari/602.1
    private String userAgent;
    //Mozilla/5.0 (iPhone
    private String userBrowser;
    //CPU iPhone OS 10_3_3 like Mac OS X) AppleWebKit/603.3.8 (KHTML, like Gecko) Version/10.0 Mobile/14G60 Safari/602.1
    private String userOS;
    //GET
    private String method;
    //172.30.9.175
    private String remoteAddr;
    //172.30.9.175
    private String remoteHost;
    //HTTP/1.1
    private String protocol;
    //上一个页面地址
    private String refer;

    public String getUserAgent() {
        return userAgent;
    }

    public ViewRecord setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public String getUserBrowser() {
        return userBrowser;
    }

    public ViewRecord setUserBrowser(String userBrowser) {
        this.userBrowser = userBrowser;
        return this;
    }

    public String getUserOS() {
        return userOS;
    }

    public ViewRecord setUserOS(String userOS) {
        this.userOS = userOS;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public ViewRecord setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public ViewRecord setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
        return this;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public ViewRecord setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
        return this;
    }

    public String getProtocol() {
        return protocol;
    }

    public ViewRecord setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public String getRefer() {
        return refer;
    }

    public ViewRecord setRefer(String refer) {
        this.refer = refer;
        return this;
    }
}
