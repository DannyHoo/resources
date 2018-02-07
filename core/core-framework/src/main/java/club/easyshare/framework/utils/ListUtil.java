package club.easyshare.framework.utils;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ListUtil
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-05 16:31:59
 */
public class ListUtil {
    public static boolean isEmpty(List list) {
        return list == null?true:list.isEmpty();
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }
}
