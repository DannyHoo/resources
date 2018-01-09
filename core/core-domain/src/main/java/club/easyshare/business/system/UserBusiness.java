package club.easyshare.business.system;

import club.easyshare.framework.utils.RSACrypt;
import club.easyshare.framework.utils.RSAUtil;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserBusiness
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 22:03:59
 */
@Component
public class UserBusiness {

    public String rsaDecrypt() throws Exception {
        // TODO Auto-generated method stub
        HashMap<String, Object> map = RSAUtil.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
        System.out.println("公钥：" + String.valueOf(Base64.encode(publicKey.getEncoded())));
        System.out.println("私钥：" + String.valueOf(Base64.encode(privateKey.getEncoded())));

        //模
        String modulus = publicKey.getModulus().toString();
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        //明文
        String ming = "123456789";
        //使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtil.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtil.getPrivateKey(modulus, private_exponent);
        //加密后的密文
        String mi = RSAUtil.encryptByPublicKey(ming, pubKey);
        System.err.println("密文：" + mi);
        //解密后的明文
        ming = RSAUtil.decryptByPrivateKey(mi, priKey);
        System.err.println("明文：" + ming);
        return "";
    }

    /**
     * 解密经过RSA加密后的密码
     *
     * @param password
     * @param privateKey
     * @return
     * @throws Exception
     */
    public String decryptPassword(String password, String privateKey) throws Exception {
        String decryptedPassword = RSACrypt.decrypt(RSACrypt.loadPrivateKey(privateKey), RSACrypt.strToBase64(password));
        return decryptedPassword;
    }
}
