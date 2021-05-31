package restassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	public static String getEmail()
	
	{
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return(generatedString+"gmail.com");
		
	}

public static String getFirstName()
	
	{
		String generatedString=RandomStringUtils.randomAlphabetic(2);
		return("sagar"+generatedString);
		
	}
	

public static String getLastName()
	
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return("gowda"+generatedString);
		
	}
}
