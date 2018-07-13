package club.easyshare.controller.common;

import club.easyshare.framework.utils.ListUtil;
import club.easysharing.model.bean.system.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AbstractController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-09 22:40:13
 */
public class AbstractController {

    protected String getStringValueFromRequest(HttpServletRequest request, String paramName) {
        if (request != null) {
            Object paramValue = request.getParameter(paramName);
            if (paramValue != null) {
                return paramValue.toString();
            }
        }
        return null;
    }

    protected Integer getIntValueFromRequest(HttpServletRequest request, String paramName) {
        try {
            if (request != null) {
                Object paramValue = request.getParameter(paramName);
                if (paramValue != null && paramValue != "") {
                    return Integer.parseInt(paramValue.toString());
                }
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 从html文本中获取第一张图片地址
     *
     * @param content
     * @return
     */
    protected String getFirstPictureUrlFromContent(String content) {
        List<String> list = getImg(content);
        if (ListUtil.isNotEmpty(list)) {
            String imgUrl = list.get(0);
            imgUrl = imgUrl.substring(imgUrl.indexOf("\"") + 1, imgUrl.length() - 1);
            return imgUrl;
        }
        return "http://p57nljn39.bkt.clouddn.com/%E5%81%87%E8%A3%85%E6%9C%89%E5%9B%BE.jpeg";
    }

    /**
     * @param s
     * @return 获得图片
     */
    public static List<String> getImg(String s) {
        String regex;
        List<String> list = new ArrayList<String>();
        regex = "src=\"(.*?)\"";
        Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
        Matcher ma = pa.matcher(s);
        while (ma.find()) {
            list.add(ma.group());
        }
        return list;
    }

    /**
     * 返回存有图片地址的数组
     *
     * @param tar
     * @return
     */
    public static String[] getImgaddress(String tar) {
        List<String> imgList = getImg(tar);

        String res[] = new String[imgList.size()];

        if (imgList.size() > 0) {
            for (int i = 0; i < imgList.size(); i++) {
                int begin = imgList.get(i).indexOf("\"") + 1;
                int end = imgList.get(i).lastIndexOf("\"");
                String url[] = imgList.get(i).substring(begin, end).split("/");
                res[i] = url[url.length - 1];
            }
        } else {
        }
        return res;
    }
}
