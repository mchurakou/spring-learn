package com.mikalai.spring.mybatis.domain;

import java.io.Serializable;

public class Hobby implements Serializable {
    private String hobbyId;

    @Override
    public String toString() {
        return "Hobby [hobbyId=" + hobbyId + "]";
    }

    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }
}
