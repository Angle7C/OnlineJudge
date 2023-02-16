package com.onlinejudge.aop;

import com.onlinejudge.bean.ResponseData;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class ControllerAop {
    static final Logger log=LoggerFactory.getLogger(ControllerAop.class);
    public Properties properties;
    @PostConstruct
    final void postConstruct() throws IOException {
        properties=new Properties();
        InputStreamReader reader=new InputStreamReader(Files.newInputStream(Paths.get("message.properties")), StandardCharsets.UTF_8);
        properties.load(reader);
        log.info("加载错误消息日志文件成功");
    }
    @Before(value="pointCut()")
    public void before(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("请求路径： {}",request.getRequestURL().toString());
        log.info("请求方法:  {}",request.getMethod());
    }
    // 监视controller
    @Pointcut("execution(* com.onlinejudge.moudle.*.controller.*.*(..))")
    public void pointCut(){}

    @AfterReturning(value="pointCut()",returning = "data")
    public ResponseData<Object> after(ResponseData<Object> data){
        // 携带信息
        if(data.getCode()!=-1){
            data.setMsg(properties.getProperty(String.valueOf(data.getCode())));
            return data;
        }
        log.info("ResponseData没有设置状态码");
        if(data.isSucess){
            data.setMsg("操作成功");
        }else{
            data.setMsg("未知异常请联系管理员");
        }
        return data;

    }
    @AfterThrowing(value = "pointCut()",throwing = "err")
    public ResponseData<Object> after(Throwable err){
        log.error("controller 异常:{}",err.getMessage());
        err.printStackTrace();
        return new ResponseData<> (-1,"未知异常",null,false);
    }
}
