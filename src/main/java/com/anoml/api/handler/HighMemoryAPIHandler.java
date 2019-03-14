package com.anoml.api.handler;

import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.rest.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighMemoryAPIHandler extends AbstractHandler implements ManagedLifecycle {
    private static final Logger logger = LoggerFactory.getLogger(HighMemoryAPIHandler.class);

    public boolean handleRequest(MessageContext messageContext) {
        logger.error("Inside HighCPUAPIHandler - handleRequest");
        try {
            final int arraySize = 5000000;

            Thread thread = new Thread() {
                public void run() {
                    long[] memoryAllocated = null;
                    for (int loop = 0; loop < 1000; loop++) {
                        memoryAllocated = new long[arraySize];
                        logger.info("Access array: " + memoryAllocated[0]);
                    }
                }
            };

            thread.start();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    public boolean handleResponse(MessageContext messageContext) {
        logger.error("Inside HighMemoryAPIHandler - handleResponse");
        try {
            final int arraySize = 5000000;

            Thread thread = new Thread() {
                public void run() {
                    long[] memoryAllocated = null;
                    for (int loop = 0; loop < 1000; loop++) {
                        memoryAllocated = new long[arraySize];
                        logger.info("Access array: " + memoryAllocated[0]);
                    }
                }
            };

            thread.start();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public void init(SynapseEnvironment se) {
        logger.error("Inside HighCPUAPIHandler - init");
    }

    @Override
    public void destroy() {
        logger.error("Inside HighAPIHandler - destroy");
    }
}
