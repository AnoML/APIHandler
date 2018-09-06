package com.anoml.api.handler;

import com.anoml.api.handler.utils.FileLogger;
import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.rest.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by ashenwgt on 6/11/18.
 */

public class CustomAPIHandler extends AbstractHandler implements ManagedLifecycle {
    private static final Logger logger = LoggerFactory.getLogger(CustomAPIHandler.class);

    public boolean handleRequest(MessageContext messageContext) {
        logger.error("Inside CustomAPIHandler - handleRequest");
        try {
            FileLogger.writeFile("Inside CustomAPIHandler - handleRequest");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }

        return true;
    }

    public boolean handleResponse(MessageContext messageContext) {
        logger.error("Inside CustomAPIHandler - handleResponse");
        try {
            FileLogger.writeFile("Inside CustomAPIHandler - handleResponse");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public void init(SynapseEnvironment se){
        logger.error("Inside CustomAPIHandler - init");


//      To simulate high heap usage
        int dummyArraySize = 15;
        long memoryConsumed = 0;
        long[] memoryAllocated = null;
        for (int loop = 0; loop < Integer.MAX_VALUE; loop++) {
            memoryAllocated = new long[dummyArraySize];
            memoryAllocated[0] = 0;
            memoryConsumed += dummyArraySize * Long.SIZE;
            logger.info("Memory Consumed till now: " + memoryConsumed);

            dummyArraySize *= dummyArraySize * 2;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
//       End simulation
        try {
            FileLogger.createFile("Inside CustomAPIHandler - init");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {
        logger.error("Inside CustomAPIHandler - destroy");
        try {
            FileLogger.writeFile("Inside CustomAPIHandler - destroy");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
