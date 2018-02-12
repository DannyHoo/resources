package club.easysharing.model.bean.chooseblacka;

import club.easysharing.model.bean.system.User;

import javax.swing.plaf.ListUI;
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
    private List<User> userList=new ArrayList<>();
    /* 本组用户持有纸牌(用户id：持有纸牌集合) */
    private Map<String, List<Card>> userCardListMap = new HashMap<>();
    /* 当前比赛出牌的一个回合 */
    private List<PokerCircle> circle=new ArrayList<>();
    /* 黑队（拿到黑色A的玩家）*/
    private List<User> blackTeamUserList=new ArrayList<>();
    /* 红队（拿到红色A的玩家）*/
    private List<User> redTeamUserList=new ArrayList<>();
    /* 是否亮牌（用户id：是/否）*/
    private Map<String,Integer> isShowAMap =new HashMap<>();

    public PokerGroup() {
        this.pokerCode= UUID.randomUUID().toString();
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

    public Map<String, List<Card>> getUserCardListMap() {
        return userCardListMap;
    }

    public PokerGroup setUserCardListMap(Map<String, List<Card>> userCardListMap) {
        this.userCardListMap = userCardListMap;
        return this;
    }

    public List<PokerCircle> getCircle() {
        return circle;
    }

    public PokerGroup setCircle(List<PokerCircle> circle) {
        this.circle = circle;
        return this;
    }

    public List<User> getBlackTeamUserList() {
        return blackTeamUserList;
    }

    public PokerGroup setBlackTeamUserList(List<User> blackTeamUserList) {
        this.blackTeamUserList = blackTeamUserList;
        return this;
    }

    public List<User> getRedTeamUserList() {
        if (redTeamUserList.isEmpty()){
            for (User user:userList){
                if (!blackTeamUserList.contains(user)){
                    redTeamUserList.add(user);
                }
            }
        }
        return redTeamUserList;
    }

    public PokerGroup setRedTeamUserList(List<User> redTeamUserList) {
        this.redTeamUserList = redTeamUserList;
        return this;
    }

    public Map<String, Integer> getIsShowAMap() {
        return isShowAMap;
    }

    public PokerGroup setIsShowAMap(Map<String, Integer> isShowAMap) {
        this.isShowAMap = isShowAMap;
        return this;
    }
}
