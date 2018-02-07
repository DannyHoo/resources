package club.easysharing.model.enums.chooseblacka;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CardNoEnum
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 21:39:28
 */
public enum CardTypeEnum {
    BLACK_HEART(1, "♠"),
    RED_HEART(2, "♥"),
    BLACK_CLUB(3, "♣"),
    RED_DIAMOND(4, "♦"),;
    private Integer code;
    private String value;

    CardTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public CardTypeEnum setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getValue() {
        return value;
    }

    public CardTypeEnum setValue(String value) {
        this.value = value;
        return this;
    }
}
