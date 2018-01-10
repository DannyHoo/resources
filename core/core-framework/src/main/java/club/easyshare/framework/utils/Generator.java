package club.easyshare.framework.utils;

import java.util.Random;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Generator
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-10 22:19:29
 */
public class Generator {

    public static void main(String[] args) {
        System.out.println(getStringRandom(8));
        System.out.println(getRandomNum(6));
        System.out.println(getRundomDiffNum());
    }
    //生成随机数字和字母,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();
        //length为几位密码
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    //随机不重复的6-8位
    public static int getRundomDiffNum() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result = result * 10 + array[i];
        }
        return result;
    }

    public static String getRandomNum(int length){
        String code="";
        Random rand=new Random();//生成随机数
        for(int a=0;a<length;a++){
            code+=rand.nextInt(10);//生成6位验证码
        }
        return code;
    }
}
