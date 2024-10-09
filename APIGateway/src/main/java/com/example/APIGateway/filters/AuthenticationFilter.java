package com.example.APIGateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Autowired
	private Routevalidator validator;

	public static class Config {

	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			// for the uris NOT specified in the RouteValidator do the following steps
			if (validator.isSecured.test(exchange.getRequest())) {
				// check if the exchange request header contains the Authorization header
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing Authorization Header");
				}
				// take out the AUthorization header
				String authHeaderToken = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authHeaderToken != null && authHeaderToken.startsWith("Bearer")) {
					// remove Bearer from front
					authHeaderToken = authHeaderToken.substring(7);
				}
				try {
					// now consume /api/auth/validate/token of authentication-service using
					// RestClient
					// can keep this call in a seperate JwtUtil class and call
					RestClient restClient = RestClient.create();
					Boolean validBoolean = restClient.get()
							.uri("http://localhost:8060/authenticate/validate/token?token=" + authHeaderToken)
							.retrieve().body(Boolean.class);

					if (!validBoolean) {

						exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
						return exchange.getResponse().setComplete(); // Terminate the request

					}
					// also instead of making a RestClient call for every request, we can validate
					// the token here in api-gateway itself
				} catch (Exception e) {
//					System.out.println(e.getMessage());
//					throw new RuntimeException("Inavlid Access!! : " + e.getMessage());
					exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
					return exchange.getResponse().setComplete();
				}
			}
			// for other uris simply chain the request.
			return chain.filter(exchange);
		});
	}

}
