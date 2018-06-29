
package club.easyshare.controller.gateway;

import club.easyshare.framework.utils.Generator;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author huyuyang@lxfintech.com
 * @Title: FileUploadController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-03-09 14:44:48
 */
@Controller
@RequestMapping("/gateway/fileupload/")
public class FileUploadController {

    private static final String qiniuFileUrlPrex="http://p57nljn39.bkt.clouddn.com/";

    public static void main(String[] args) {
        JSONObject jsonObject1= JSON.parseObject("{\"status\":20,\"projectNo\":\"信贷工厂-考拉现金贷\"}");
        jsonObject1.remove("projectNo");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("errno","0");
        jsonObject.put("data","[\"图片1地址\", \"图片2地址\"]");
        System.out.println(jsonObject);
    }
    @RequestMapping("/image")
    @ResponseBody
    public String imageUpload(HttpServletRequest request,
                              @RequestParam("uploadPic") MultipartFile file){
        JSONObject jsonObject=new JSONObject();
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = "/data/files/images/";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String imageUrl=qiniuStorage(path+filename);
            jsonObject.put("errno",0);
            String[] strings=new String[]{imageUrl};
            jsonObject.put("data",strings);
        }else{
            jsonObject.put("errno",1);
            jsonObject.put("data","[]");
        }

        String result=jsonObject.toJSONString();
        System.out.println(result);
        return result;
    }

    public String qiniuStorage(String localFilePath){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone1());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "t12Htj_DOr4vaGnurfOpbSfZ5ZJG2Q_JjM1BxdTT";
        String secretKey = "v6UwgHtwd-tGUwBEDvr5MvGOrUf7LHY2SX-8zoi4";
        String bucket = "easysharing";
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        //String localFilePath = "/Users/dannyhoo/Downloads/健康助手.jpeg";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String suffix = localFilePath.substring(localFilePath.lastIndexOf(".") + 1);
        String key = Generator.getRandomTimeStr()+"."+suffix;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            if (response.statusCode==200){
                return key+qiniuFileUrlPrex;
            }
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "";
    }
}
