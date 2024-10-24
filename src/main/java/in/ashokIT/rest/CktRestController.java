package in.ashokIT.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CktRestController {

	@GetMapping("/data")

	@CircuitBreaker(name = "Resilence_4j_Demo", fallbackMethod = "datBaseConfingMethod")

	public String getRedis() {

		System.out.println("redis method call");

	int i = 10 / 0;
//not writen any try catch menthod to through exception ckt breaker config
		return "RedisMethod";
	}

	public String datBaseConfingMethod(Throwable t) {

		System.out.println("Database Method call...");

		return "database Method calll";
	}
}
