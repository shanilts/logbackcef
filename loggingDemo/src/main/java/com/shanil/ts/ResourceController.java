package com.shanil.ts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shanil.ts.cefmodule.CefLogger;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ResourceController {
	@Autowired
	public CefLogger cefLog;

	@RequestMapping("/home")
	public String home() throws FileNotFoundException, IOException, XmlPullParserException {

		log.info(cefLog.setDeviceEventClassID("112").setMessage("INFO information logged:").setSeverity("high")
				.setName(log.getName()).log());
//		
//		try {
//			int i=1/0;
//		} catch (Exception e) {
//			log.error(cefLog.setDeviceEventClassID("112").setMessage("Exception occured:").setSeverity("high").setName(log.getName()).setE(e).log());
//		}

		Marker eventClassId = MarkerFactory.getMarker("1234");
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			log.error(eventClassId, " Error Occured Exception={}", e.getStackTrace(), e.getMessage());
		}

		log.error(eventClassId, "accessed error data={} data2={}", "first data", "second data");
		log.debug(eventClassId, "accessed debug data={} data3={}", "first data", "second data");
		log.trace(eventClassId, "accessed trace  data={} data4{}", "first data", "second data");
		return "home";

	}

	@RequestMapping("/executiontime")
	public String defaultEntryPoint() {
		return "executiont time in log";

	}
}
