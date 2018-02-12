package club.easyshare.framework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: MapUtil
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-11 18:41:52
 */
public class MapUtil {
   public static List getListFromMap (Map map){
       List list=new ArrayList();
       for (Object value:map.values()){
           list.add(value);
       }
       return list;
   }
}
