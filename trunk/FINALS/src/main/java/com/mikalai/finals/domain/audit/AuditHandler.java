package com.mikalai.finals.domain.audit;

import org.hibernate.envers.RevisionListener;

public class AuditHandler implements RevisionListener {

    @Override
    public void newRevision(Object revision) {
        RevisionEntity revisionEntity = (RevisionEntity) revision;
        revisionEntity.setUser("MIKALAI");
    }

}
