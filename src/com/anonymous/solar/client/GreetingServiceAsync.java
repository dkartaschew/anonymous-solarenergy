package com.anonymous.solar.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

//sdfsdf
//dabba be dabba die
/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
