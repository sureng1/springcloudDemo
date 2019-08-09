package com.research.exception;

import com.research.model.Bo.RestResponseBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionResolver {

//    private static Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);


    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public RestResponseBo resolveCommonException(IOException e) {
        e.printStackTrace();
//        log.error("Error info : " + e);

        return RestResponseBo.fail("文件保存出错");
    }

    @ExceptionHandler(value = TipException.class)
    @ResponseBody
    public RestResponseBo resolveTipException(TipException tip) {
        tip.printStackTrace();
        return RestResponseBo.fail(tip.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResponseBo resolveException(Exception e) {
        e.printStackTrace();
//        log.error("Error info : " + e);
        return RestResponseBo.fail(e.toString());
        // return new ModelAndView("error");
    }
}
