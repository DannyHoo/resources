package club.easysharing.model.bean.chooseblacka;

import club.easysharing.model.bean.system.User;

import java.util.*;

/**
 * @author huyuyang@lxfintech.com
 * @Title: PokerGroup
 * @Copyright: Copyright (c) 2016
 * @Description: 一局扑克比赛
 * @Company: lxjr.com
 * @Created on 2018-02-04 11:04:31
 */
public class PokerGroup {
    /* 本局编码 */
    private String pokerCode;
    /* 本组玩家 */
    private List<User> userList;
    /* 本组用户持有纸牌(用户id：持有纸牌集合) */
    private Map<String, List<Card>> userCardListMap = new HashMap<>();

    public PokerGroup() {
        this.pokerCode= UUID.randomUUID().toString();
    }

    public String getPokerCode() {
        return pokerCode;
    }

    public PokerGroup setPokerCode(String pokerCode) {
        this.pokerCode = pokerCode;
        return this;
    }

    /**
     * 加入用户
     *
     * @param user
     */
    public void addUser(User user) {
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public PokerGroup setUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }

    public Map<String, List<Card>> getUserCardListMap() {
        return userCardListMap;
    }

    public PokerGroup setUserCardListMap(Map<String, List<Card>> userCardListMap) {
        this.userCardListMap = userCardListMap;
        return this;
    }
}
