package com.mikalai.spring.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {
    
    private MessageProvider messageProvider = null;

    public void render() {
        if (messageProvider == null){
            throw new RuntimeException("set message provider");
        } else {
            System.out.println(messageProvider.getMessage());
        }

    }

    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;

    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

}
