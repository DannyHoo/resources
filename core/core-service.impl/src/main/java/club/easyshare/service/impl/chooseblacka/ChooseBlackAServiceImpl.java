package club.easyshare.service.impl.chooseblacka;

import chooseblacka.ChooseBlackAService;
import club.easyshare.business.cache.AllTournamentsCache;
import club.easyshare.business.chooseblacka.ChooseBlackABusiness;
import club.easyshare.framework.utils.ListUtil;
import club.easysharing.model.bean.chooseblacka.Card;
import club.easysharing.model.bean.chooseblacka.PokerGroup;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.enums.chooseblacka.CardNoEnum;
import club.easysharing.model.enums.chooseblacka.CardTypeEnum;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ChooseBlackAServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description: 比赛 用户 扑克
 * @Company: lxjr.com
 * @Created on 2018-02-03 23:13:00
 */
@Service("chooseBlackAService")
public class ChooseBlackAServiceImpl implements ChooseBlackAService {

    @Autowired
    private ChooseBlackABusiness chooseBlackABusiness;

    /**
     * 【游戏规则说明】
     * A~K、大小王一共有13*4+2=54张牌
     * 把2、3、4、大小王除去（游戏不用），还剩40张牌。
     * 规则：
     * 1、游戏中花色不分大小，牌的权利由小到大的牌号分别为：5、6、7、8、9、10、J、Q、K、A
     * 2、可以出单张，对子、三张、四张、顺子(至少3张)
     */

    public static void main(String[] args) {
        // 初始化数据
        ChooseBlackAServiceImpl chooseBlackAService = new ChooseBlackAServiceImpl();
        User user1=(User) new User().setUserName("DannyHoo").setId(1l);
        User user2=(User) new User().setUserName("DannySong").setId(2l);
        User user3=(User) new User().setUserName("DannyHuXinRan").setId(3l);
        User user4=(User) new User().setUserName("DannyHuXinYi").setId(4l);

        // 用户1创建房间，用户2、用户3、用户4接收邀请
        PokerGroup pokerGroup = chooseBlackAService.createPokerGroup(user1);
        chooseBlackAService.accecptInvitation(user1,user2);
        chooseBlackAService.accecptInvitation(user1,user3);
        chooseBlackAService.accecptInvitation(user1,user4);
        // 开局
        chooseBlackAService.begin(pokerGroup.getPokerCode());
    }

    /**
     * 用户上线（在线用户列表增加）
     */
    public void userGoOnLine(User user) {
        AllTournamentsCache.addOnLineUser(user);
    }

    /**
     * 获取上线用户列表
     *
     * @param user
     * @return
     */
    public List<User> getOnLineUserList(User user) {
        return AllTournamentsCache.getOnLineUserList();
    }

    /**
     * 当前用户创建房间
     *
     * @param userCurrent
     * @return
     */
    public PokerGroup createPokerGroup(User userCurrent) {
        PokerGroup pokerGroup = new PokerGroup();//创建房间
        AllTournamentsCache.putPokerGroup(pokerGroup);//添加该比赛到系统缓存
        AllTournamentsCache.putUserGroupRelation(userCurrent, pokerGroup);//添加用户和组的关系到系统缓存
        return pokerGroup;
    }

    /**
     * 当前用户接受邀请，进入房间
     *
     * @param userFrom    邀请人
     * @param userCurrent 当前用户（被邀请人）
     * @return
     */
    public PokerGroup accecptInvitation(User userFrom, User userCurrent) {
        PokerGroup pokerGroup = AllTournamentsCache.getPokerGroupByUser(userFrom);
        AllTournamentsCache.putUserGroupRelation(userCurrent, pokerGroup);//添加用户和组的关系到系统缓存
        return pokerGroup;
    }

    /**
     * 匹配玩家
     */
    public void associatePlayers() {
        PokerGroup pokerGroup = new PokerGroup();
        // 获取本局对战用户
        List<User> userList = chooseBlackABusiness.getRandomUserList();
        pokerGroup.setUserList(userList);
        AllTournamentsCache.putPokerGroup(pokerGroup);
    }

    /**
     * 游戏开局，洗牌、发牌
     *
     * @param groupCode 本局编码
     */
    public void begin(String groupCode) {
        PokerGroup pokerGroup = AllTournamentsCache.getPokerGroup(groupCode);
        List<User> userList = pokerGroup.getUserList();
        /* 本组用户持有纸牌集合*/
        Map<String, List<Card>> userCardListMap = pokerGroup.getUserCardListMap();
        List<Card> allCardList = AllTournamentsCache.getAPairOfCardList();
        while (ListUtil.isNotEmpty(allCardList)) {
            // 轮流为每位用户发牌
            for (int i = 0; i < userList.size(); i++) {
                // 抽取剩余牌的第一张
                Card card = allCardList.get(0);
                // 当前用户持有牌的集合
                List<Card> cardListCurr = userCardListMap.get(String.valueOf(userList.get(i).getId()));
                if (cardListCurr == null) {
                    cardListCurr = new ArrayList<Card>();
                }
                cardListCurr.add(card);
                userCardListMap.put(String.valueOf(userList.get(i).getId()), cardListCurr);
                // 从总的牌中删除该张牌
                allCardList.remove(card);
            }
        }

        System.out.println(JSON.toJSONString(pokerGroup));
    }

    /**
     * 打牌（根据上家牌判断是否可以出牌）
     *
     * @param preCards
     * @return
     */
    @Override
    public Card[] play(Card[] preCards) {
        Card[] curCards = null;//当前用户最终出的牌

        return curCards;
    }

    /**
     * 判断是否为顺子
     *
     * @return
     */
    public boolean isStraight(List<Card> cardList) {
        if (ListUtil.isNotEmpty(cardList)) {
            for (int i = 0; i < cardList.size(); i++) {

            }
        }
        return false;
    }
}
