package com.mikalai.finals.dao.audit;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "MIKALAI";
    }


}
