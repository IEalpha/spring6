package com.icbc.sd.beanInstantiation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringBean {

    private static final Logger logger = LoggerFactory.getLogger(SpringBean.class);
    public SpringBean() {
        logger.info("SpringBean's no args constructor...");
    }
}
