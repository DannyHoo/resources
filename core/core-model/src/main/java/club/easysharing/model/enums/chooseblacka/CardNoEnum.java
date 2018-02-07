package club.easysharing.model.enums.chooseblacka;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CardNoEnum
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 21:39:28
 */
public enum CardNoEnum {
    ONE(1,"A"),
    TWO(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"),
    ELEVEN(11,"J"),
    TWELVE(12,"Q"),
    THIRTEEN(13,"K"),
    SMALL_JOKER(14,"JOKER"),
    BIG_JOKER(15,"JOKER"),
    ;
    private Integer code;
    private String value;

    CardNoEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public CardNoEnum setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getValue() {
        return value;
    }

    public CardNoEnum setValue(String value) {
        this.value = value;
        return this;
    }

    private static Map<Integer, CardNoEnum> valueMap = new HashMap<>();
    /**
     * 根据code获得枚举值
     *
     * @param code
     * @return
     */
    public static CardNoEnum getByCode(Integer code) {
        if (valueMap.isEmpty()) {
            CardNoEnum[] enums = CardNoEnum.values();
            for (CardNoEnum e : enums) {
                valueMap.put(e.getCode(), e);
            }
        }
        return valueMap.get(code);
    }
}
