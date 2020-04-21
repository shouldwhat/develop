package com.example.demo.yaml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class TYamlFormat {

	private static final Logger LOG = LoggerFactory.getLogger(TYamlFormat.class);
	
	public void test() {
		
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
//		options.setIndent(2);
//		options.setDefaultScalarStyle(ScalarStyle.SINGLE_QUOTED);
		options.setPrettyFlow(true);
		options.setSplitLines(true);
		
		Yaml yaml = new Yaml(options);
		LOG.debug("dump = {}", yaml.dump(new UserData()));
	}
}
