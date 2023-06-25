package ru.vetyugov.springMiddle.service.impl;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.vetyugov.springMiddle.config.AppMainProps;
import ru.vetyugov.springMiddle.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;

    private final AppMainProps appMainProps;

    public MessageServiceImpl(MessageSource messageSource, AppMainProps appMainProps) {
        this.messageSource = messageSource;
        this.appMainProps = appMainProps;
    }

    @Override
    public String getMessageByKey(String key) {
        return messageSource.getMessage(key, null, appMainProps.getLocale());
    }

    @Override
    public String getMessageByKey(String key, String[] props) {
        return messageSource.getMessage(key, props, appMainProps.getLocale());
    }

}
