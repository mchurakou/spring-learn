package com.mikalai.spring.collection;

public interface ArtWorkSender {
    public void sendArtWork(String path, Recipient recipient);
    public String getFriendlyName();
    public String getShortName();
}
