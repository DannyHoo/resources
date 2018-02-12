package club.easysharing.model.enums.common;

/**
 * @author huyuyang@lxfintech.com
 * @Title: YesNoEnum
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 21:39:28
 */
public enum YesNoEnum {
    YES(1,"是"),
    NO(0,"否"),
    ;
    private Integer status;
    private String code;

    YesNoEnum(Integer status, String code) {
        this.status = status;
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public YesNoEnum setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public YesNoEnum setCode(String code) {
        this.code = code;
        return this;
    }
}
