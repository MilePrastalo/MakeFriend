package com.makefriend.makefriend.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderConfiguration;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class KnowlageService {

    private final KieContainer kieContainer;
    private KieSession kieSession;

    public KnowlageService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    @PreDestroy
    private void release(){
        this.kieSession.dispose();
    }

    public KieContainer getKieContainer() {
        return kieContainer;
    }

    public KieSession getKieSession() {
        if(kieSession == null){
            kieSession = kieContainer.newKieSession("session");
        }
        return kieSession;
    }

    public void setKieSession(KieSession kieSession) {
        this.kieSession = kieSession;
    }
}
