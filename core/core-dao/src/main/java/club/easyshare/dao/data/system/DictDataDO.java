package club.easyshare.dao.data.system;

import club.easyshare.dao.data.base.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DictDataDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-09 22:57:53
 */
@Entity
@Table(name="t_dict_data")
@DynamicUpdate(true)
public class DictDataDO extends BaseEntity {
    /** 字典类型编码 **/
    @Column(name = "dictTypeCode")
    private String dictTypeCode;

    /** 字典数据项编码 **/
    @Column(name = "dictDataCode")
    private String dictDataCode;

    /** 字典数据项名称 **/
    @Column(name = "dictDataName")
    private String dictDataName;

    /** 字典数据值 **/
    @Column(name = "dictDataValue")
    private String dictDataValue;

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public DictDataDO setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
        return this;
    }

    public String getDictDataCode() {
        return dictDataCode;
    }

    public DictDataDO setDictDataCode(String dictDataCode) {
        this.dictDataCode = dictDataCode;
        return this;
    }

    public String getDictDataName() {
        return dictDataName;
    }

    public DictDataDO setDictDataName(String dictDataName) {
        this.dictDataName = dictDataName;
        return this;
    }

    public String getDictDataValue() {
        return dictDataValue;
    }

    public DictDataDO setDictDataValue(String dictDataValue) {
        this.dictDataValue = dictDataValue;
        return this;
    }
}
