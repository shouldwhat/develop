package string.tokenize;

import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTokenizing {

	private static final Logger LOG = LoggerFactory.getLogger(StringTokenizing.class);
	
	public void stringTokenizer() {
		
		StringTokenizer st = null;
		{	// default ctor delimeter = ""(blank space)
			st = new StringTokenizer("My name is wonkyu");
			
			LOG.debug("{}", st.countTokens());	// 4
			
			LOG.debug(st.nextToken());
			LOG.debug(st.nextToken());
			LOG.debug(st.nextToken());
			LOG.debug(st.nextToken());
//			LOG.debug(st.nextToken());			// exception
			
			LOG.debug("{}", st.countTokens());	// 0
		}
		
		LOG.debug("\n");
		
		String delimiter = null;
		{
			delimiter = ",";
			st = new StringTokenizer("My,name is,wonkyu", delimiter);
			
			LOG.debug("{}", st.countTokens());	// 3
			
			LOG.debug(st.nextToken());
			LOG.debug(st.nextToken());
			LOG.debug(st.nextToken());
//			LOG.debug(st.nextToken());			// exception
		}
		
		LOG.debug("\n");
		
		{
			boolean containDelimiterToken = true;
			delimiter = "!@";
			st = new StringTokenizer("동해물과!백두산이@마르고!닳도록@하느님이!@보우하사", delimiter, containDelimiterToken);
			
			while(st.hasMoreTokens()) {
				LOG.debug(st.nextToken());
			}
		}
		
		LOG.debug("\n");
		
		String[] split = "동해물과!백두산이@마르고!닳도록@하느님이!@보우하사".split("!");
		for(int n=0; n<split.length; n++) {
			LOG.debug(split[n]);
		}
	}
	
	public static void main(String[] agrs) {
		new StringTokenizing().stringTokenizer();
	}
}
