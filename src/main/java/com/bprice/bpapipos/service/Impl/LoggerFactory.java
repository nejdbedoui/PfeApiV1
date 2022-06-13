package com.bprice.bpapipos.service.Impl;

public class LoggerFactory {

    @SuppressWarnings("rawtypes")
    public static ch.qos.logback.classic.Logger getLogger(Class classDef) {
        return (ch.qos.logback.classic.Logger)org.slf4j.LoggerFactory.getLogger(classDef);
    }
}
