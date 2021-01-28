package com.shanil.ts.cefmodule;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class CefLogger {
	private Model model;
	private static final String CEFVERSION = "CEF:1";
	private static final String DEVICEVENDOR = "ECSFIN";
	private String deviceProduct;
	private String deviceVersion;
	private String deviceEventClassID ;
	private String name;
	private String message ;
	private String severity ;
	private Exception e ;

	public CefLogger() throws IOException, XmlPullParserException {

		this.model = new MavenXpp3Reader().read(new FileReader("pom.xml"));
		this.deviceProduct = model.getArtifactId();
		this.deviceVersion = model.getVersion();
		this.deviceEventClassID = null;
		this.name = null;
		this.message = null;
		this.severity = null;
		this.e = null;
	}
	
	
	public String log() {
		return CEFVERSION+"|"+DEVICEVENDOR+"|"+ deviceProduct+"|"+deviceVersion+"|"+deviceEventClassID+"|"+name+"|"+severity+"|"+"msg="+message;
	}


	public CefLogger setDeviceEventClassID(String deviceEventClassID) {
		this.deviceEventClassID = deviceEventClassID;
		return this;
	}


	public CefLogger setName(String name) {
		this.name = name;
		return this ;
	}


	public CefLogger setMessage(String message) {
		this.message = message;
		return this ;
	}


	public CefLogger setSeverity(String severity) {
		this.severity = severity;
		return this ;
	}


	public CefLogger setE(Exception e) {

		this.message = message+e;	
		return this;
	}

//	public static String  log(String eventClassId, String message, String logger,String Severity) throws FileNotFoundException, IOException, XmlPullParserException {
//		MavenXpp3Reader reader = new MavenXpp3Reader();
//		Model model = reader.read(new FileReader("pom.xml"));
//		String logstr = "CEF:1|ECSFIN|"+ model.getArtifactId()+"|"+model.getVersion()+"|"+eventClassId+"|"+logger+"|"+Severity+"|"+"msg="+message;
//		return logstr;
//	}

}
