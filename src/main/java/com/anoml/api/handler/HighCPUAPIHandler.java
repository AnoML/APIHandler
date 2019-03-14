package com.anoml.api.handler;

import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.rest.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighCPUAPIHandler extends AbstractHandler implements ManagedLifecycle {
    private static final Logger logger = LoggerFactory.getLogger(HighCPUAPIHandler.class);

    public boolean handleRequest(MessageContext messageContext) {
        logger.error("Inside HighCPUAPIHandler - handleRequest");
        try {
            int numCore = 2;
            int numThreadsPerCore = 2;
            double load = 0.8;
            final long duration = 10000;
            for (int thread = 0; thread < numCore * numThreadsPerCore; thread++) {
                new BusyThread("Thread" + thread, load, duration).start();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    public boolean handleResponse(MessageContext messageContext) {
        logger.error("Inside HighCPUAPIHandler - handleResponse");
        try {
            int numCore = 2;
            int numThreadsPerCore = 2;
            double load = 0.8;
            final long duration = 10000;
            for (int thread = 0; thread < numCore * numThreadsPerCore; thread++) {
                new BusyThread("Thread" + thread, load, duration).start();
            }
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

    /**
     * Thread that actually generates the given load
     *
     * @author Sriram
     */
    private static class BusyThread extends Thread {
        private double load;
        private long duration;

        /**
         * Constructor which creates the thread
         *
         * @param name     Name of this thread
         * @param load     Load % that this thread should generate
         * @param duration Duration that this thread should generate the load for
         */
        public BusyThread(String name, double load, long duration) {
            super(name);
            this.load = load;
            this.duration = duration;
        }

        /**
         * Generates the load when run
         */
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            try {
                // Loop for the given duration
                while (System.currentTimeMillis() - startTime < duration) {
                    // Every 100ms, sleep for the percentage of unladen time
                    if (System.currentTimeMillis() % 100 == 0) {
                        Thread.sleep((long) Math.floor((1 - load) * 100));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
