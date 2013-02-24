package com.mikalai.spring.collection;

public class FtpArtworkSender implements ArtWorkSender {

    @Override
    public void sendArtWork(String path, Recipient recipient) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getFriendlyName() {
        return "FTP";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
