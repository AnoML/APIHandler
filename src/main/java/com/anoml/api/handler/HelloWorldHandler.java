package com.anoml.api.handler;

import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.rest.AbstractHandler;

/**
 * Created by ashenwgt on 6/11/18.
 */
public class HelloWorldHandler extends AbstractHandler implements ManagedLifecycle {
    @Override
    public boolean handleRequest(MessageContext mc) {
        System.out.println("Request: Hello World!");
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext mc) {
        System.out.println("Response: Hello World!");
        return true;
    }

    @Override
    public void init(SynapseEnvironment se) {
        System.out.println("Initialize: Hello World!");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy: Hello World!");
    }
}
