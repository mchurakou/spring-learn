package com.mikalai.spring.jpa;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "prospring";
    }


}
