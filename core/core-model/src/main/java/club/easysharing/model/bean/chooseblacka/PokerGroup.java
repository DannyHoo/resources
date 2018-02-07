package club.easysharing.model.bean.chooseblacka;

import club.easysharing.model.bean.system.User;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: PokerGroup
 * @Copyright: Copyright (c) 2016
 * @Description: 一局比赛
 * @Company: lxjr.com
 * @Created on 2018-02-04 11:04:31
 */
public class PokerGroup {
    private String pokerCode;

    /* 本组玩家 */
    private List<User> userList;
    /* 本组纸牌 */
    private List<Card> cardList;

    public String getPokerCode() {
        return pokerCode;
    }

    public PokerGroup setPokerCode(String pokerCode) {
        this.pokerCode = pokerCode;
        return this;
    }

    public List<User> getUserList() {
        return userList;
    }

    public PokerGroup setUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public PokerGroup setCardList(List<Card> cardList) {
        this.cardList = cardList;
        return this;
    }
}
