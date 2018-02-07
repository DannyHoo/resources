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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ChooseBlackAServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-03 23:13:00
 */
@Service("chooseBlackAService")
public class ChooseBlackAServiceImpl implements ChooseBlackAService {

    @Autowired
    private ChooseBlackABusiness chooseBlackABusiness;

    /**
     *【游戏规则说明】
     * A~K、大小王一共有13*4+2=54张牌
     * 把2、3、4、大小王除去（游戏不用），还剩40张牌。
     * 规则：
     * 1、游戏中花色不分大小，牌的权利由小到大的牌号分别为：5、6、7、8、9、10、J、Q、K、A
     * 2、可以出单张，对子、三张、四张、顺子(至少3张)
     *
     */

    /**
     * 用户上线（在线用户列表增加）
     */
    public void userGoOnLine(User user) {

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
     * 游戏开局
     *
     * @param groupCode 本局编码
     */
    public void begin(String groupCode) {
        List<Card> cardList = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.BLACK_HEART.getCode()));
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.RED_HEART.getCode()));
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.BLACK_CLUB.getCode()));
            cardList.add(new Card(CardNoEnum.getByCode(i).getCode(), CardTypeEnum.RED_DIAMOND.getCode()));
        }
        cardList.add(new Card(CardNoEnum.SMALL_JOKER.getCode()));
        cardList.add(new Card(CardNoEnum.BIG_JOKER.getCode()));
        Collections.shuffle(cardList);
        PokerGroup pokerGroup=AllTournamentsCache.getPokerGroup(groupCode);
        pokerGroup.setCardList(cardList);
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
