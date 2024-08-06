package in.asish.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.asish.GreetFeignClient;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private GreetFeignClient greetClient;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		String welcomeMsg =  "Welcome to our web page";
		String greetMsg = greetClient.invokeGreetApi();
		return greetMsg + "," + welcomeMsg + "running on"+env.getProperty("server.port");
	}
}
