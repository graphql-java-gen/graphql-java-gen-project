/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import graphql.schema.GraphQLSchema;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	protected Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

	private final GraphQLSchema graphQLSchema;
	private final GraphQLWiring graphQLWiring;

	// This will search to the graphql.url property, in the application.properties or application.yml file.
	// IT defaults to "graphql"
	@Value("/${graphql.url:graphql}")
	private String url;
	
	@Autowired
	public WebSocketConfig(GraphQLWiring graphQLWiring, GraphQLSchema graphQLSchema) {
		this.graphQLWiring = graphQLWiring;
		this.graphQLSchema = graphQLSchema;
	}

	@Bean
	public ServletServerContainerFactoryBean createWebSocketContainer() {
		logger.trace("Creating ServletServerContainerFactoryBean");
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		// container.setMaxTextMessageBufferSize(8192);
		// container.setMaxBinaryMessageBufferSize(8192);
		return container;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		logger.debug("Registering WebSocketHandler for URL {}", url);
		registry.addHandler(new WebSocketHandler(graphQLWiring, graphQLSchema), url).setAllowedOrigins("*");
	}

}
