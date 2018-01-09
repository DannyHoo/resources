package club.easyshare.dao.data.system;

import club.easyshare.dao.data.base.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DictTypeDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-09 22:59:50
 */
@Entity
@Table(name="t_dict_type")
@DynamicUpdate(true)
public class DictTypeDO extends BaseEntity {
    /** 类型编码 **/
    @Column(name = "code")
    private String code;

    /** 类型名称 **/
    @Column(name = "name")
    private String name;

    /** 父类型编码 **/
    @Column(name = "parentCode")
    private String parentCode;

    public String getCode() {
        return code;
    }

    public DictTypeDO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public DictTypeDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentCode() {
        return parentCode;
    }

    public DictTypeDO setParentCode(String parentCode) {
        this.parentCode = parentCode;
        return this;
    }
}
