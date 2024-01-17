package com.bluebird.bluebird.controller.common;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

//전역 공통 컨트롤러
@ControllerAdvice
public class GlobalBindingInitializer {

//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    //WebDataBinder 는 InitBinder 어노테이션 적용된 메서드의 파라미터로 받아올수 있게함
    //바인딩 관련 설정 수행
    /**
     * @InitBinder
     * MVC 컨트롤러 메서드가 실행되기전 사용되는 메서드를 지정하는데 사용
     * 주로 바인딩 설정을 초기화하거나 커스텀한 변환기를 등록할때 사용한다.
     * */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
