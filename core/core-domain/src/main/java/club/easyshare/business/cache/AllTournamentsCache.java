package club.easyshare.business.cache;

import club.easysharing.model.bean.chooseblacka.Card;
import club.easysharing.model.bean.chooseblacka.PokerGroup;
import club.easysharing.model.bean.system.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AllTournamentsCache
 * @Copyright: Copyright (c) 2016
 * @Description: 捉黑A游戏 公共缓存类
 * @Company: lxjr.com
 * @Created on 2018-02-04 10:50:44
 */
public class AllTournamentsCache {
    /* 所有在线用户信息 */
    private static Map<String,User> onLineUserListMap=new HashMap<>();
    /* 所有比赛（房间）信息*/
    private static Map<String, PokerGroup> pokerGroupList = new HashMap<>();

    /**
     * 用户上线
     * @param user
     */
    public static void addOnLineUser(User user){
        onLineUserListMap.put(String.valueOf(user.getId()),user);
    }

    /**
     * 用户下线
     * @param user
     */
    public static void removeOnLineUser(User user){
        onLineUserListMap.remove(user.getId());
    }

    /**
     * 获取上线用户列表
     * @return
     */
    public static List<User> getOnLineUserList(){
        List<User> userList=new ArrayList<>();

        return userList;
    }

    /**
     * 添加比赛信息
     * @param pokerGroup
     */
    public static void putPokerGroup(PokerGroup pokerGroup) {
        pokerGroupList.put(pokerGroup.getPokerCode(),pokerGroup);
    }

    /**
     * 获取比赛信息
     * @param groupCode
     * @return
     */
    public static PokerGroup getPokerGroup(String groupCode) {
        return pokerGroupList.get(groupCode);
    }

    /**
     * 删除比赛信息
     * @param groupCode
     * @return
     */
    public static boolean removeCardList(String groupCode) {
        pokerGroupList.remove(groupCode);
        return true;
    }

}
