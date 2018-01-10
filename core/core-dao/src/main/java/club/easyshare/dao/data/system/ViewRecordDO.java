package club.easyshare.dao.data.system;

import club.easyshare.dao.data.base.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ViewRecordDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 14:29:53
 */
@Entity
@Table(name="t_view_record")
@DynamicUpdate(true)
public class ViewRecordDO extends BaseEntity {
    @Column(name = "userAgent")
    private String userAgent;

    @Column(name = "userBrowser")
    private String userBrowser;

    @Column(name = "userOS")
    private String userOS;

    @Column(name = "method")
    private String method;

    @Column(name = "remoteAddr")
    private String remoteAddr;

    @Column(name = "remoteHost")
    private String remoteHost;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "refer")
    private String refer;

    public String getUserAgent() {
        return userAgent;
    }

    public ViewRecordDO setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public String getUserBrowser() {
        return userBrowser;
    }

    public ViewRecordDO setUserBrowser(String userBrowser) {
        this.userBrowser = userBrowser;
        return this;
    }

    public String getUserOS() {
        return userOS;
    }

    public ViewRecordDO setUserOS(String userOS) {
        this.userOS = userOS;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public ViewRecordDO setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public ViewRecordDO setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
        return this;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public ViewRecordDO setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
        return this;
    }

    public String getProtocol() {
        return protocol;
    }

    public ViewRecordDO setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public String getRefer() {
        return refer;
    }

    public ViewRecordDO setRefer(String refer) {
        this.refer = refer;
        return this;
    }
}
