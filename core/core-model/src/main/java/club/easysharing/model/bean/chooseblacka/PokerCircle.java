package club.easysharing.model.bean.chooseblacka;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: PokerCircle
 * @Copyright: Copyright (c) 2016
 * @Description: 当前比赛出牌的一个回合
 * @Company: lxjr.com
 * @Created on 2018-02-08 11:37:14
 */
public class PokerCircle {
    /* 用户id */
    private String userId;
    /* 用户本次出的牌 */
    private List<Card> cardList;

    public PokerCircle(String userId, List<Card> cardList) {
        this.userId = userId;
        this.cardList = cardList;
    }

    public String getUserId() {
        return userId;
    }

    public PokerCircle setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public PokerCircle setCardList(List<Card> cardList) {
        this.cardList = cardList;
        return this;
    }
}
