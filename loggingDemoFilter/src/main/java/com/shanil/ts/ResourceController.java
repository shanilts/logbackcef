package com.shanil.ts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ResourceController {
	@RequestMapping("/home")
	public String home() throws FileNotFoundException, IOException {
//		MavenXpp3Reader reader = new MavenXpp3Reader();
//		Model model = reader.read(new FileReader("pom.xml"));
//		log.info("CEF:1|ECSFIN|" + model.getArtifactId() + "|" + model.getVersion() + "|DEBUG"
//				+ "|LoggingRestController" + "|LOW| msg=Testing out logging ");
		log.info("accessed info");
		log.warn("accessed warn");
		log.error("accessed error");
		log.debug("accessed debug");
		log.trace("accessed trace");
		return "home";

	}

	@RequestMapping("/executiontime")
	public String defaultEntryPoint() {
		return "executiont time in log";

	}
}
