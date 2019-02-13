package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.service.AddImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class AddImgImpl implements AddImgService {
    private Logger logger = LoggerFactory.getLogger("AddImg");
    public String addImg(String img,String tmpImg){
        logger.info("addImg-----------------------------------------------------------");
        try{
            //获取跟目录
            File tmpPath = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!tmpPath.exists()) {
                tmpPath = new File("");
            }
            //如果上传目录为/static/icon/，则可以如下获取：
            File upload = new File(tmpPath.getAbsolutePath(),"static/icon/");
            if(!upload.exists()){
                upload.mkdirs();
            }
            String path = upload.getAbsolutePath();
            logger.info("上传路径：" + path);
            logger.info("上传文件：" + img);
            //base64解码
            String base64 = tmpImg.substring(tmpImg.indexOf(",") + 1);
            FileOutputStream write = new FileOutputStream(new File(path + "/" + img));
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] decoderBytes = decoder.decodeBuffer(base64);
            write.write(decoderBytes);
            write.close();
            logger.info("上传成功");
            return "success";
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
