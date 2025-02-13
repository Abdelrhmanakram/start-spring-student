package com.boot.start.service.bundel;

import com.boot.start.dto.ExceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocalBundleMessageService {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public LocalBundleMessageService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static ExceptionDto getMessages(String key){
        return new ExceptionDto(
                messageSource.getMessage(key ,null , new Locale("ar")),
                messageSource.getMessage(key ,null , new Locale("en"))
        );
    }
}
