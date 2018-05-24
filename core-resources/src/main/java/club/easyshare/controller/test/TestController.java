package club.easyshare.controller.test;

import com.itextpdf.text.pdf.BaseFont;
import org.apache.commons.io.FileUtils;
import org.dom4j.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

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

    @RequestMapping("/jdbg_base64")
    public String jdbg_base64() {
        return "test/jdbg/jdbg_base64";
    }

    public static void main(String[] args) throws Exception {

        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("/Users/dannyhoo/Desktop/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        OutputStream os = new FileOutputStream("/Users/dannyhoo/Desktop/FlyingSaucer_base641.pdf");
        String htmlstr = HttpHandler.sendGet("http://localhost:10086/test/jdbg_base64.html");
        //解决图片的相对路径问题
        //renderer.getSharedContext().setBaseURL("file:/D:/");
        renderer.setDocumentFromString(htmlstr);
        renderer.layout();
        renderer.createPDF(os);
    }

    @RequestMapping("/downloadjdbg")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        //生成pdf
        String htmlPageUrl = request.getParameter("htmlPageUrl") == null ? "" : request.getParameter("htmlPageUrl").toString();
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

    public void createPdf() {
        try {
            String shellPath = "/home/felven/word2vec/demo-classes.sh";
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
