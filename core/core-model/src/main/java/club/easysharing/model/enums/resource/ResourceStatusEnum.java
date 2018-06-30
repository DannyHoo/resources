package club.easysharing.model.enums.resource;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserStatusEnum
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 21:39:28
 */
public enum ResourceStatusEnum {
    DRAFT("10", "草稿"),
    AUDIT("20", "审核中"),
    AUDIT_FAILURE("30", "审核失败"),
    AUDIT_SUCCESS("40", "审核成功"),
    ;
    private String status;
    private String description;

    ResourceStatusEnum(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public ResourceStatusEnum setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ResourceStatusEnum setDescription(String description) {
        this.description = description;
        return this;
    }
}


