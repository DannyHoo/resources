package club.easysharing.model.bean.chooseblacka;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Card
 * @Copyright: Copyright (c) 2016
 * @Description: 扑克牌
 * @Company: lxjr.com
 * @Created on 2018-02-03 23:05:30
 */
public class Card {
    /* 扑克牌号码：A 2 3 4 5 6 7 8 9 10 J Q K  */
    private Integer cardNo;
    /* 扑克牌花色：♠ ♥ ♣ ♦ */
    private Integer cardType;

    public Card() {
    }

    public Card(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public Card(Integer cardNo, Integer cardType) {
        this.cardNo = cardNo;
        this.cardType = cardType;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public Card setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public Integer getCardType() {
        return cardType;
    }

    public Card setCardType(Integer cardType) {
        this.cardType = cardType;
        return this;
    }
}
