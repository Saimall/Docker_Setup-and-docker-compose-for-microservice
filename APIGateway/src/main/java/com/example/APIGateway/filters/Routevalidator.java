package com.example.APIGateway.filters;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class Routevalidator {
	public static final List<String> openApiEndpoints = List.of("/register","/users/validate","/validate/token");	
	
	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints
			.stream()
			.noneMatch(uri -> request
								.getURI()
								.getPath()
								.contains(uri));

}
