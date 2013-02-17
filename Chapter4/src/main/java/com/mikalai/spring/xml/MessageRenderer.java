package com.mikalai.spring.xml;

public interface MessageRenderer {
    public void render();

    public void setMessageProvider(MessageProvider provider);

    public MessageProvider getMessageProvider();
}
