package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.UserMapper;
import com.xiaobai.springbootdemo.service.SaveHeadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class SaveHeadImpl implements SaveHeadService {
    private Logger logger = LoggerFactory.getLogger("SaveHead");
    @Autowired
    private UserMapper userMapper;
    public String saveHead(String username, String tmpImg, HttpSession session){
        logger.info("saveHead---------------------------------------------------------");
        try {
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
            String name = username + ".jpg";
            logger.info("上传路径：" + path);
            logger.info("上传文件：" + name);
            //base64解码
            String base64 = tmpImg.substring(tmpImg.indexOf(",") + 1);
            FileOutputStream write = new FileOutputStream(new File(path + "/" + name));
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] decoderBytes = decoder.decodeBuffer(base64);
            write.write(decoderBytes);
            write.close();
            logger.info("上传成功");
            //修改用户信息表
            logger.info("更新用户信息表...");
            userMapper.saveHead(username,name);
            logger.info("更新成功");
            logger.info("更新session...");
            session.setAttribute("head",name);
            logger.info("更新成功");
            return "success";
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
