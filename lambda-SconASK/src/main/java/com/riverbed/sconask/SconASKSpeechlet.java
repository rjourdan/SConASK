package com.riverbed.sconask;




import java.io.IOException;

import org.apache.log4j.Logger;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;
import com.riverbed.sconask.beans.SconApp;
import com.riverbed.sconask.beans.SconPathRules;
import com.riverbed.sconask.beans.SconSite;
import com.riverbed.sconask.beans.SconWan;
import com.riverbed.sconask.rest.SconAppAPI;
import com.riverbed.sconask.rest.SconObjectCallApi;
import com.riverbed.sconask.rest.SconSiteAPI;
import com.riverbed.sconask.rest.SconWanAPI;
import com.riverbed.sconask.util.StringModifier;

public class SconASKSpeechlet implements Speechlet {
	
	 static final Logger log = Logger.getLogger(SconASKSpeechlet.class);
	 private static final String URL = "URL";
	 private static final String ORGID = "ORGID";
	 private static final String SLOT_CITY = "City";
	 private static final String SLOT_STATE = "State";
	 private static final String SLOT_TYPE = "Type";
	 private static final String SLOT_COUNTRY = "Country";
	 private static final String SLOT_STREET = "Street";
	 private static final String SLOT_SITE = "Site";
	 private static final String SLOT_APP = "App";
	 private static final String SLOT_PRIMARY = "Primary";
	 private static final String SLOT_BACKUP = "Backup";
	 private static final String SLOT_QOS = "QoS";
	 private static final String SLOT_RULE = "Rule";
	
	public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
		log.debug("on Intent requestId={"+request.getRequestId()+"}, sessionId={}");
		getEnvironnmentData(session);
		
		Intent intent = request.getIntent();
        String intentName = intent.getName();

        if ("CreateSiteIntent".equals(intentName)) {
            return handleCreateSiteRequest(intent, session);
            
        } else if ("ListSitesIntent".equals(intentName)) {
            return handleListSitesRequest(session);
        } else if ("CleanOrgIntent".equals(intentName)) {
            return handleCleanOrgRequest(session);
        } else if("PathRuleIntent".equals(intentName)){
        	return handlePathRuleRequest(intent,session);
        } else if("SpaceOdysseyIntent".equals(intentName)){
        	String speechOutput = "I’m sorry Dave, I am afraid I can’t do that";
        	String repromptText = "";
        	return newAskResponse(speechOutput,repromptText);
        } 
        else if ("AMAZON.HelpIntent".equals(intentName)) {
            // Create the plain text output.
            String speechOutput =
                    "With SteelConnect App for Amazon Echo , you can"
                            + " configure new sites in your organisation"
                            + " list all your sites"
                            + " for example, you can say I want a shop in Miami Florida"
                            + "or ask what are the site in my org";

            String repromptText = "What do you want to do?";

            return newAskResponse(speechOutput, false, repromptText, false);
        } else if ("AMAZON.StopIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
            
        } else if ("AMAZON.CancelIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
        } else {
            throw new SpeechletException("Invalid Intent");
}
	}

	/**
	 * The service receives a LaunchRequest when the user invokes the skill with the invocation name, 
	 * but does not provide any command mapping to an intent. 
	 * Alexa will ask for the Google Authenticator token to open the encrypted file containing
	 * SCM url
	 * org id
	 * username
	 * password
	 * 
	 *
	 */
	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		////log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),session.getSessionId());
		log.debug("onLaunch requestId={"+request.getRequestId()+"}, sessionId={}");
		getEnvironnmentData(session);
		return newAskResponse("Welcome to SteelConnect App for Amazon Echo","Please tell me what you want to do like create a site or list me the sites");
	
	}

	public void onSessionEnded(SessionEndedRequest arg0, Session arg1) throws SpeechletException {
		// TODO Auto-generated method stub
		
	}

	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		log.debug("onSessionStarted requestId={"+request.getRequestId()+"}, sessionId={}");
		getEnvironnmentData(session);
	}
	
	/**
	 * 
	 * @param intent
	 * @param session
	 * @return
	 */
	private SpeechletResponse handleCreateSiteRequest(Intent intent, Session session) {
		Slot citySlot = intent.getSlot(SLOT_CITY);
        Slot countrySlot = intent.getSlot(SLOT_COUNTRY);
        Slot stateSlot = intent.getSlot(SLOT_STATE);
        Slot typeSlot = intent.getSlot(SLOT_TYPE);
        Slot streetSlot = intent.getSlot(SLOT_STREET);
        
        boolean testCity = false;
        boolean testCountry = false;
        boolean testType = false;
        boolean testStreet = false;
        
        
        if (streetSlot != null && streetSlot.getValue() != null) {
        	session.setAttribute(SLOT_STREET, streetSlot.getValue());
        	testStreet = true;
        	testType = true;
        }
      //if reprompted and street already in session testStreet is true
        if(session.getAttribute(SLOT_STREET) != null) {
        	testStreet=true;
        	testType = true;
        }
        
        if (citySlot != null && citySlot.getValue() != null) {
        	session.setAttribute(SLOT_CITY, citySlot.getValue());
        	testCity=true;
        }
        //if reprompted and city already in session testCity is true
        if(session.getAttribute(SLOT_CITY) != null) testCity=true;
        
        if (countrySlot != null && countrySlot.getValue() != null) {
        	session.setAttribute(SLOT_COUNTRY, countrySlot.getValue());
        	testCountry = true;
        }
      //if reprompted and country already in session testCountry is true
        if(session.getAttribute(SLOT_COUNTRY) != null) testCountry=true;
        
        if (stateSlot != null && stateSlot.getValue() != null) {
        	session.setAttribute(SLOT_STATE, stateSlot.getValue());
        	//if a state is indicated then country is US
        	session.setAttribute(SLOT_COUNTRY, "United States");
        	testCountry = true;
        }
        
        if (typeSlot != null && typeSlot.getValue() != null) {
        	session.setAttribute(SLOT_TYPE, typeSlot.getValue());
        	testType = true;
        }
      //if reprompted and type already in session testType is true
        if(session.getAttribute(SLOT_TYPE) != null) testType=true;
        
        //city was not indicated, it must be reprompted
        if(!testCity) return handleCityDialogRequest(intent, session);
        
        //if country was not indicated nor states for the US then it must be reprompted
        if(!testCountry) return handleCountryDialogRequest(intent, session);
        
      //if name was not indicated then it must be reprompted
        if(!testType) return handleTypeDialogRequest(intent, session);
        
        //if street was not indicated, add "" in session
        if(!testStreet) session.setAttribute(SLOT_STREET, "");
        
        return createSite(session);		
	}
	
	
	private void getEnvironnmentData(Session session){
		session.setAttribute(URL,System.getenv("url"));

		session.setAttribute(ORGID,System.getenv("orgid"));
		
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	private SpeechletResponse handleListSitesRequest(Session session) {
		String stringOutput = "";
		String repromptText = "";
    	String[] list = SconObjectCallApi.listSconObjectsText((String)session.getAttribute("URL"),(String) session.getAttribute("ORGID"),SconObjectCallApi.SITE);
		if(list == null){
			return newAskResponse("There is no site configured on SteelConnect yet", repromptText);	
		}
		stringOutput = "There are "+list.length+" sites created on SteelConnect.";
    	for(int i=0;i<list.length;i++){
			stringOutput = stringOutput.concat(list[i]);
			stringOutput = stringOutput.concat(" ");
		}
    	return newAskResponse(stringOutput, repromptText);			
	}
	
	private SpeechletResponse handleCityDialogRequest(Intent intent, Session session) {
		String stringOutput = "";
    	Slot citySlot = intent.getSlot(SLOT_CITY);
    	
    	//there was no city indicated
    	if(citySlot == null) stringOutput = "Please specify a city";
    	//value was null so not listed
    	else stringOutput = "This city is not recognized. "
    			+ "At the moment, SteelConnect for Amazon Echo supports "
    			+ "only major cities in the US, Canada, Europe or Asia";
    		
    	return newAskResponse(stringOutput, stringOutput);
		
	}
	
	private SpeechletResponse handleCountryDialogRequest(Intent intent, Session session) {
		String stringOutput = "";
    	String repromptText = "";
    	Slot countrySlot = intent.getSlot(SLOT_COUNTRY);
    	
    	//there was no country indicated
    	if(countrySlot == null) stringOutput = "Please specify a country";
    	//value was null so not listed
    	else stringOutput = "This country is not recognized. "
    			+ "At the moment, SteelConnect for Amazon Echo supports "
    			+ "only few countries";
    	return newAskResponse(stringOutput, repromptText);
		
	}
	
	private SpeechletResponse handleTypeDialogRequest(Intent intent, Session session) {
		String stringOutput = "";
    	String repromptText = "";
    	
    	Slot typeSlot = intent.getSlot(SLOT_TYPE);
    	
    	//there was no type indicated
    	if(typeSlot == null) stringOutput = "Please specify a type";
    	//value was null so not listed
    	else stringOutput = "This type is not recognized";
    	repromptText = "You can create Plant, branch, shop, boutique or Headquarter";
    	return newAskResponse(stringOutput, repromptText);
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	private SpeechletResponse handleCleanOrgRequest(Session session) {
		String stringOutput = "";
    	String repromptText = "";
    	if(SconObjectCallApi.cleanOrg((String)session.getAttribute("URL"),(String) session.getAttribute("ORGID"))){
    		stringOutput = "Your org is now cleared, all items have been deleted";
    	};
    	
    	return newAskResponse(stringOutput, repromptText);
	}
	
	/**
     * Wrapper for creating the Ask response from the input strings with
     * plain text output and reprompt speeches.
     *
     * @param stringOutput
     *            the output to be spoken
     * @param repromptText
     *            the reprompt for if the user doesn't reply or is misunderstood.
     * @return SpeechletResponse the speechlet response
     */
    private SpeechletResponse newAskResponse(String stringOutput, String repromptText) {
        return newAskResponse(stringOutput, false, repromptText, false);
    }

    /**
     * Wrapper for creating the Ask response from the input strings.
     *
     * @param stringOutput
     *            the output to be spoken
     * @param isOutputSsml
     *            whether the output text is of type SSML
     * @param repromptText
     *            the reprompt for if the user doesn't reply or is misunderstood.
     * @param isRepromptSsml
     *            whether the reprompt text is of type SSML
     * @return SpeechletResponse the speechlet response
     */
    private SpeechletResponse newAskResponse(String stringOutput, boolean isOutputSsml,
            String repromptText, boolean isRepromptSsml) {
        OutputSpeech outputSpeech, repromptOutputSpeech;
        if (isOutputSsml) {
            outputSpeech = new SsmlOutputSpeech();
            ((SsmlOutputSpeech) outputSpeech).setSsml(stringOutput);
        } else {
            outputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) outputSpeech).setText(stringOutput);
        }

        if (isRepromptSsml) {
            repromptOutputSpeech = new SsmlOutputSpeech();
            ((SsmlOutputSpeech) repromptOutputSpeech).setSsml(stringOutput);
        } else {
            repromptOutputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) repromptOutputSpeech).setText(repromptText);
        }

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);
        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }
	
    /**
     * creates a site in SteelConnnect
     * @return confirmation the site was created
     */
    private SpeechletResponse createSite(Session session) {
		
    	String stringOutput = "";
    	String repromptText = "";
		String address = (String)session.getAttribute(SLOT_STREET);
		String type =  (String)session.getAttribute(SLOT_TYPE);
		String url = (String)session.getAttribute("URL");
		String orgID = (String) session.getAttribute("ORGID");
		String city = (String)session.getAttribute(SLOT_CITY);
		String name = "";
		String longname ="";
		String country = (String) session.getAttribute(SLOT_COUNTRY);
		SconSite site = null; 
		boolean testAddress = false;
		
		//if there is a street, site name = street address
		if(!address.isEmpty()) {
			longname = address;
			name = StringModifier.replaceSpaceByUnderscore(address);
			testAddress = true;
		}
		else{
			name = type+"_"+city;
			longname = type+" "+city;
		}
		site = new SconSite(name, longname, address, city, country);
		try {
			site = (SconSite) SconObjectCallApi.createSconObject(url,orgID, site);
			if(!testAddress) SconObjectCallApi.applySiteTemplate(url,orgID,site,type);	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			site = null;
			e.printStackTrace();
		}
		
		if(site!=null){
			stringOutput = "The site named "+StringModifier.replaceUnderscoreBySpace(name)+" has been successfuly created in "+city;
			session.setAttribute("site_name", name);
			session.setAttribute("site_id", site.getId());
		} else{
			stringOutput = "The system faced a problem, please try again later on";
		}
		
		return newAskResponse(stringOutput, repromptText);
	}
    
    private SpeechletResponse handlePathRuleRequest(Intent intent, Session session) {
		Slot siteSlot = intent.getSlot(SLOT_SITE);
		Slot appSlot = intent.getSlot(SLOT_APP);
		Slot primarySlot = intent.getSlot(SLOT_PRIMARY);
		Slot backupSlot = intent.getSlot(SLOT_BACKUP);
		Slot qosSlot = intent.getSlot(SLOT_QOS);
		Slot ruleSlot = intent.getSlot(SLOT_RULE);
		String pathRuleId = (String)session.getAttribute("pathrule_id");
		
        boolean testSite = false;
        boolean testApp = false;
        boolean testPrimary = false;
       boolean testQos = false;
        
        
        if (siteSlot != null && siteSlot.getValue() != null) {
        	session.setAttribute(SLOT_SITE, siteSlot.getValue());
        	testSite=true;
        }
        
        if (appSlot != null && appSlot.getValue() != null) {
        	session.setAttribute(SLOT_APP, appSlot.getValue());
        	testApp=true;
        }
        
        if (primarySlot != null && primarySlot.getValue() != null) {
        	session.setAttribute(SLOT_PRIMARY, primarySlot.getValue());
        	System.out.println("SLOT PRIMARY = "+primarySlot.getValue()+"\n");
        	testPrimary=true;
        }
        
        if (backupSlot != null && backupSlot.getValue() != null) {
        	session.setAttribute(SLOT_BACKUP, backupSlot.getValue());
        	System.out.println("SLOT BACKUP = "+backupSlot.getValue()+"\n");
        	
        }
        
        if (qosSlot != null && qosSlot.getValue() != null) {
        	session.setAttribute(SLOT_QOS, qosSlot.getValue().toLowerCase());
        	testQos=true;
        }
        
        if ((ruleSlot != null && ruleSlot.getValue() != null) || pathRuleId!=null) {
        	return activePathRule(session,pathRuleId);
        }
        
        //if there is no SLOTS nor a previous rule created, user said "add a new path rule"
        if(!testSite && !testApp && !testPrimary && !testQos && pathRuleId==null){
        	return newAskResponse("","");
        }
        /*
      //site was not indicated, it must be reprompted
        if(!testSite) return handleSiteDialogRequest(intent, session);
        
        //if country was not indicated nor states for the US then it must be reprompted
        if(!testCountry) return handleCountryDialogRequest(intent, session);
        
      //if name was not indicated then it must be reprompted
        if(!testType) return handleTypeDialogRequest(intent, session);
        
        //if street was not indicated, add "" in session
        if(!testStreet) session.setAttribute(SLOT_STREET, "");
        */
        return createPathRule(session);
	}
    
    /**
     * 
     * @param session
     * @return
     */
    private SpeechletResponse createPathRule(Session session) {
		
    	String stringOutput = "";
    	String repromptText = "";
    	
    	String url = (String)session.getAttribute("URL");
    	String orgID = (String) session.getAttribute("ORGID");
    	
    	String dsttype = SconPathRules.DST_ANY;
    	String srctype = SconPathRules.SRC_ALL;
    
    	String sapps = "";
    	String appli = (String)session.getAttribute(SLOT_APP);
    	String[] apps = new String[1];
    	SconApp app = null;
		SconAppAPI api = new SconAppAPI();
		app = (SconApp)api.getByName(url, appli,orgID);
		if(app==null) {
			System.out.println("appli not found "+appli+"\n");
			apps[0] = "";
			
		}
		else {
			sapps = app.getId();
			dsttype = SconPathRules.DST_APPS;
		}
    	
		
    			
    	String qos = (String)session.getAttribute(SLOT_QOS);
    	String marking = "dscp_0";
    	String[] zones =  new String[0];
    	
    	String[] sites = new String[1];
    	String siteName = (String)session.getAttribute(SLOT_SITE);
    	siteName = StringModifier.replaceSpaceByUnderscore(siteName);
    	SconSite site = null;
    	SconSiteAPI siteApi = new SconSiteAPI();
    	site = (SconSite)siteApi.getByName(url, siteName, orgID);
    	if(site!=null) sites[0] = site.getId();
    	
    	
    	String primaryName = (String)session.getAttribute(SLOT_PRIMARY);
    	String backupName = (String)session.getAttribute(SLOT_BACKUP);
    	SconWanAPI wanApi = new SconWanAPI();
    	SconWan wanPrimary = (SconWan)wanApi.getByName(url, primaryName,orgID);
    	SconWan wanBackup = (SconWan)wanApi.getByName(url, backupName,orgID);
    	
    	String primaryId="";
    	if(wanPrimary!=null) primaryId = wanPrimary.getId();
    	
    	String backupId="";
    	if(wanBackup!=null) backupId = wanBackup.getId();
    	
    	String[] path_preference = {primaryId,backupId};
    	boolean active = false;
    	String dscp = "";
    	String[] devices =  new String[0];
    	String tags = "";
    	String[] users =  new String[0];
    	
    	SconPathRules pathrule = new SconPathRules(dsttype, srctype, qos, marking, zones, sites, path_preference, active, dscp, apps, devices, tags, users,sapps);
    	
    	try {
    		pathrule = (SconPathRules) SconObjectCallApi.createSconObject(url,orgID, pathrule);	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			pathrule = null;
			e.printStackTrace();
		}
		
		if(pathrule!=null){
			stringOutput = "The rule has been successfuly created";
			session.setAttribute("pathrule_id", pathrule.getId());
		} else{
			stringOutput = "The system faced a problem, please try again later on";
		}
    	
    	return newAskResponse(stringOutput, repromptText);
    }
    
    /**
     * 
     * @param session
     * @param pathRuleId
     * @return
     */
    private SpeechletResponse activePathRule(Session session, String pathRuleId) {
    	String stringOutput = "";
    	String repromptText = "";
    	
    	String url = (String)session.getAttribute("URL");
    	String orgId = (String) session.getAttribute("ORGID");
    	
    	SconPathRules pathRule = (SconPathRules) SconObjectCallApi.findSconObject(url, "path_rule", pathRuleId);
		if(pathRule == null) System.out.println("pathRule not found?");
		pathRule.setActive(true);
		try {
			pathRule = (SconPathRules) SconObjectCallApi.updateSconObject(url,orgId, pathRule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			pathRule = null;
			e.printStackTrace();
		}
		
		if(pathRule!=null){
			stringOutput = "The rule has been successfuly enabled";
		} else{
			stringOutput = "The system faced a problem, please try again later on";
		}
    	
    	return newAskResponse(stringOutput, repromptText);
    }
    	
}
