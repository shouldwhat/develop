package string.chars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringToChar {

	private static final Logger LOG = LoggerFactory.getLogger(StringToChar.class);
	
	public static void main(String[] args) {
		new StringToChar().tocharArray();
	}

	private void tocharArray() {
		
		String source = "won kyu ";
		
		char[] charArray = source.trim().toCharArray();
		for(int index=0; index<charArray.length; index++) {
			LOG.debug("{}", charArray[index]);
		}
	}
}
