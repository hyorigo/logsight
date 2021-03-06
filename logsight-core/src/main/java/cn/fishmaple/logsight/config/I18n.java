package cn.fishmaple.logsight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class I18n {
    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }

    public String getMessage(String code, Object[] args, String defaultMsg) {
        Locale locale = getLocale();
        return messageSource.getMessage(code, args, defaultMsg, locale);
    }


    public Locale getLocale(){
        return LocaleContextHolder.getLocale();
    }
}