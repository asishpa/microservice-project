package in.asish.rest;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
	
	@Autowired
	private Environment env;
	@GetMapping("/greet")
	public String greetMessage() {
		String port = env.getProperty("server.port");
		return "Hello User"+port;
		
	}
}
