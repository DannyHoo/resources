package club.easysharing.model.enums;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserStatusEnum
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 21:39:28
 */
public enum UserStatusEnum {
    DEFAULT(0,"默认/初始状态"),
    NORMAL(10,"正常状态"),
    DISABLED(20,"非正常状态"),
    ;
    private Integer status;
    private String code;

    UserStatusEnum(Integer status, String code) {
        this.status = status;
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public UserStatusEnum setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public UserStatusEnum setCode(String code) {
        this.code = code;
        return this;
    }
}
