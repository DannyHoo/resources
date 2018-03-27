package club.easyshare.controller.test;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author huyuyang@lxfintech.com
 * @Title: TestController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-03-26 17:32:57
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/jdbg")
    public String jdbg() {
        return "test/jdbg/jdbg";
    }

    @RequestMapping("/downloadjdbg")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        //生成pdf
        String htmlPageUrl=request.getParameter("htmlPageUrl")==null?"":request.getParameter("htmlPageUrl").toString();
        if ("".equals(htmlPageUrl)) return null;

        //下载pdf
        String path = "D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\springMVC\\WEB-INF\\upload\\图片10（定价后）.xlsx";
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        String fileName = new String("你好.xlsx".getBytes("UTF-8"), "iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    public void createPdf(){
        try {
            String shellPath="/home/felven/word2vec/demo-classes.sh";
            Process ps = Runtime.getRuntime().exec(shellPath);
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
