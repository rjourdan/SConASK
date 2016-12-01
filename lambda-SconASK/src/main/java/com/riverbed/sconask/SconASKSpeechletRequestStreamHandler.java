package com.riverbed.sconask;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;


/**
 * Amazon provides a Java library to streamline implementation of a custom skill as a Lambda function. The implementation utilizes a SpeechletRequestStreamHandler as an entry point to receive the requests. Then, SpeechletRequestStreamHandler dispatches the request to a Speechlet, which provides the main business logic for the custom skill, maintains a conversation with the user, and interfaces with an external software service if needed.
 * @author rjourdan
 *
 */

public final class SconASKSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

	private static final Set<String> supportedApplicationIds = new HashSet<String>();
    static {
        supportedApplicationIds.add("amzn1.ask.skill.d1819d29-39fc-411c-97df-816cc79c4383");
    }
    
    public SconASKSpeechletRequestStreamHandler(){
    	super(new SconASKSpeechlet(),supportedApplicationIds);
    }
    
	public SconASKSpeechletRequestStreamHandler(Speechlet speechlet, Set<String> supportedApplicationIds) {
		super(speechlet, supportedApplicationIds);
		// TODO Auto-generated constructor stub
	}

}
