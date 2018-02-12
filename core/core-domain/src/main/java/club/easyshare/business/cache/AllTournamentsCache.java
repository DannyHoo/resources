package club.easyshare.business.cache;

import club.easyshare.framework.utils.ListUtil;
import club.easyshare.framework.utils.MapUtil;
import club.easysharing.model.bean.chooseblacka.Card;
import club.easysharing.model.bean.chooseblacka.PokerGroup;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.enums.chooseblacka.CardNoEnum;
import club.easysharing.model.enums.chooseblacka.CardTypeEnum;
import org.apache.commons.collections.MapUtils;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AllTournamentsCache
 * @Copyright: Copyright (c) 2016
 * @Description: 捉黑A游戏 公共缓存类
 * @Company: lxjr.com
 * @Created on 2018-02-04 10:50:44
 */
public class AllTournamentsCache {
    /* 一副洗好的牌 */
    private static List<Card> aPareOfCardList;
    /* 所有在线用户信息(用户id：用户) */
    private static Map<String, User> onLineUserListMap = new HashMap<>();
    /* 所有比赛（房间）信息(比赛code：比赛) */
    private static Map<String, PokerGroup> pokerGroupList = new HashMap<>();
    /* 所有用户-比赛关系信息(用户id：比赛) */
    private static Map<String, PokerGroup> userGroupRelationMap = new HashMap<>();

    /* 所有比赛-用户-socket关系信息(groupCode：用户-socket) */
    public static Map<String,GroupUserSessionMap> groupSocketSessionMap=new HashMap<>();

    /**
     * 用户上线
     *
     * @param user
     */
    public static void addOnLineUser(User user) {
        onLineUserListMap.put(String.valueOf(user.getId()), user);
    }

    /**
     * 用户下线
     *
     * @param user
     */
    public static void removeOnLineUser(User user) {
        onLineUserListMap.remove(user.getId());
    }

    /**
     * 获取上线用户列表
     *
     * @return
     */
    public static List<User> getOnLineUserList() {
        List<User> userList = new ArrayList<>();

        return userList;
    }

    /**
     * 添加该比赛到系统缓存
     *
     * @param pokerGroup
     */
    public static void putPokerGroup(PokerGroup pokerGroup) {
        pokerGroupList.put(pokerGroup.getPokerCode(), pokerGroup);
    }

    /**
     * 获取比赛信息
     *
     * @param groupCode
     * @return
     */
    public static PokerGroup getPokerGroup(String groupCode) {
        return pokerGroupList.get(groupCode);
    }

    /**
     * 比赛结束（删除比赛信息）
     *
     * @param groupCode
     * @return
     */
    public static boolean removeCardList(String groupCode) {
        pokerGroupList.remove(groupCode);
        return true;
    }

    /**
     * 获得一副重新洗过的牌
     *
     * @return
     */
    public static List<Card> getAPairOfCardList() {
        if (aPareOfCardList == null) {
            aPareOfCardList = getAPareOfInitCardList();
        }
        Collections.shuffle(aPareOfCardList);
        return aPareOfCardList;
    }

    private static List<Card> getAPareOfInitCardList() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            if (i>=2&&i<=4) continue;//除去值为2、3、4的牌
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.BLACK_HEART.getCode()));
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.RED_HEART.getCode()));
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.BLACK_CLUB.getCode()));
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.RED_DIAMOND.getCode()));
        }
        // 除去大小王
        /*cardList.add(new Card(CardNoEnum.SMALL_JOKER.getCode()));
        cardList.add(new Card(CardNoEnum.BIG_JOKER.getCode()));*/
        return cardList;
    }

    /**
     * 添加用户-比赛对应关系
     *
     * @param user
     * @param pokerGroup
     */
    public static void putUserGroupRelation(User user, PokerGroup pokerGroup) {
        pokerGroup.addUser(user);
        userGroupRelationMap.put(String.valueOf(user.getId()), pokerGroup);//添加用户-比赛对应关系
    }

    /**
     * 根据用户获取用户所在的比赛
     *
     * @param user
     * @return
     */
    public static PokerGroup getPokerGroupByUser(User user) {
        if (user != null && user.getId() != null) {
            return userGroupRelationMap.get(String.valueOf(user.getId()));
        }
        return null;
    }

    public static List<WebSocketSession> getWebSocketSessionListOfGroup(String groupCode){
        GroupUserSessionMap groupUserSessionMap=groupSocketSessionMap.get(groupCode);
        if (groupUserSessionMap==null){
            return new ArrayList<>();
        }
        List<WebSocketSession> webSocketSessionList= MapUtil.getListFromMap(groupUserSessionMap.getSessionMap());
        return webSocketSessionList;
    }

}
