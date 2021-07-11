/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.forum;

import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql_java_generator.annotation.RequestType;
import com.graphql_java_generator.client.GraphQLConfiguration;
import com.graphql_java_generator.client.GraphQLSubscriptionExecutor;
import com.graphql_java_generator.client.GraphqlClientUtils;
import com.graphql_java_generator.client.SubscriptionCallback;
import com.graphql_java_generator.client.SubscriptionClient;
import com.graphql_java_generator.client.request.InputParameter;
import com.graphql_java_generator.client.request.InputParameter.InputParameterType;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.customscalars.GraphQLScalarTypeDate;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import com.graphql_java_generator.util.GraphqlUtils;

/**
 * This class contains the methods that allows the execution of the subscriptions that are defined in the
 * SubscriptionType of the GraphQL schema.<BR/>
 * These methods allows:
 * <UL>
 * <LI>Preparation of partial subscription requests</LI>
 * <LI>Execution of partial prepared subscription requests</LI>
 * <LI>Execution of partial direct subscription requests</LI>
 * </UL>
 * You'll find all the documentation on the
 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client_subscription.html">subscription
 * client page doc</A>.
 * 
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@Component
public class SubscriptionTypeExecutor implements GraphQLSubscriptionExecutor {

	/** Logger for this class */
	private static Logger logger = LoggerFactory.getLogger(SubscriptionTypeExecutor.class);

	GraphqlClientUtils graphqlClientUtils = new GraphqlClientUtils();
	GraphqlUtils graphqlUtils = new GraphqlUtils();

	@Autowired
	GraphQLConfiguration graphQLConfigurationForum = null;

	/**
	 * This default constructor is used by Spring, when building the component, and by the Jackson deserializer.
	 */
	@Autowired
	public SubscriptionTypeExecutor() {
		if (!"local-SNAPSHOT".equals(graphqlUtils.getRuntimeVersion())) {
			throw new RuntimeException(
					"The GraphQL runtime version doesn't match the GraphQL plugin version. The runtime's version is '"
							+ graphqlUtils.getRuntimeVersion()
							+ "' whereas the GraphQL plugin version is 'local-SNAPSHOT'");
		}
		CustomScalarRegistryInitializer.initCustomScalarRegistry();
		DirectiveRegistryInitializer.initDirectiveRegistry();
	}

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for http servers, not for
	 * https ones.<BR/>
	 * For example: http://my.server.com/graphql
	 * 
	 * @param graphqlEndpoint
	 *            the http URI for the GraphQL endpoint
	 */
	public SubscriptionTypeExecutor(String graphqlEndpoint) {
		if (!"local-SNAPSHOT".equals(graphqlUtils.getRuntimeVersion())) {
			throw new RuntimeException(
					"The GraphQL runtime version doesn't match the GraphQL plugin version. The runtime's version is '"
							+ graphqlUtils.getRuntimeVersion()
							+ "' whereas the GraphQL plugin version is 'local-SNAPSHOT'");
		}
		this.graphQLConfigurationForum = new GraphQLConfiguration(graphqlEndpoint);
		CustomScalarRegistryInitializer.initCustomScalarRegistry();
		DirectiveRegistryInitializer.initDirectiveRegistry();
	}

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for https servers, not for
	 * http ones.<BR/>
	 * For example: https://my.server.com/graphql<BR/>
	 * <BR/>
	 * {@link SSLContext} and {@link HostnameVerifier} are regular Java stuff. You'll find lots of documentation on the
	 * web. The StarWars sample is based on the <A HREF=
	 * "http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https">http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https</A>
	 * blog. But this sample implements a noHostVerification, which of course, is the simplest but the safest way to go.
	 * 
	 * @param graphqlEndpoint
	 *            the https URI for the GraphQL endpoint
	 * @param sslContext
	 * @param hostnameVerifier
	 */
	public SubscriptionTypeExecutor(String graphqlEndpoint, SSLContext sslContext, HostnameVerifier hostnameVerifier) {
		this.graphQLConfigurationForum = new GraphQLConfiguration(graphqlEndpoint, sslContext, hostnameVerifier);
		CustomScalarRegistryInitializer.initCustomScalarRegistry();
		DirectiveRegistryInitializer.initDirectiveRegistry();
	}

	/**
	 * This constructor expects the URI of the GraphQL server and a configured JAX-RS client that gives the opportunity
	 * to customise the REST request<BR/>
	 * For example: http://my.server.com/graphql
	 *
	 * @param graphqlEndpoint
	 *            the http URI for the GraphQL endpoint
	 * @param client
	 *            {@link Client} javax.ws.rs.client.Client to support customization of the rest request
	 */
	public SubscriptionTypeExecutor(String graphqlEndpoint, Client client) {
		this.graphQLConfigurationForum = new GraphQLConfiguration(graphqlEndpoint, client);
		CustomScalarRegistryInitializer.initCustomScalarRegistry();
		DirectiveRegistryInitializer.initDirectiveRegistry();
	}

	/**
	 * This method takes a <B>full request</B> definition, and executes the it against the GraphQL server. That is, the
	 * request contains the full string that <B><U>follows</U></B> the query/mutation/subscription keyword.<BR/>
	 * It offers a logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * For instance:
	 * 
	 * <PRE>
	 * Map<String, Object> params = new HashMap<>();
	 * params.put("heroParam", heroParamValue);
	 * params.put("skip", Boolean.FALSE);
	 * 
	 * MyQueryType response = myQueryType.execWithBindValues("subscription {subscribeToNewHeros {id name}}", params);
	 * Character c = response.getHero();
	 * </PRE>
	 * 
	 * @param queryResponseDef
	 *            The response definition of the subscription, in the native GraphQL format (see here above). It must
	 *            ommit the query/mutation/subscription keyword, and start by the first { that follows.It may contain
	 *            directives, as explained in the GraphQL specs.
	 * @param parameters
	 *            The map of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}. The key is the parameter name, as
	 *            defined in the query (in the above sample: heroParam is an optional parameter and skip is a mandatory
	 *            one). The value is the parameter vale in its Java type (for instance a {@link Date} for the
	 *            {@link GraphQLScalarTypeDate}). The parameters which value is missing in this map will no be
	 *            transmitted toward the GraphQL server.
	 * @return The {@link SubscriptionClient} that allows the caller to act on the subscribed subscription.
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient execWithBindValues(String queryResponseDef, SubscriptionCallback<?> subscriptionCallback,
			Map<String, Object> parameters)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing subscription {} ", queryResponseDef);
		ObjectResponse objectResponse = getResponseBuilder().withQueryResponseDef(queryResponseDef).build();
		return exec(objectResponse, subscriptionCallback, parameters);
	}

	/**
	 * This method takes a <B>full request</B> definition, and executes it against the GraphQL server. That is, the
	 * query contains the full string that <B><U>follows</U></B> the query/mutation/subscription keyword.<BR/>
	 * It offers a logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * For instance:
	 * 
	 * <PRE>
	 * MyQueryType response = myQueryType.execWithBindValues(
	 * 		"{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}",
	 * 		"heroParam", heroParamValue, "skip", Boolean.FALSE);
	 * Character c = response.getHero();
	 * </PRE>
	 * 
	 * @param queryResponseDef
	 *            The response definition of the query, in the native GraphQL format (see here above). It must ommit the
	 *            query/mutation/subscription keyword, and start by the first { that follows.It may contain directives,
	 *            as explained in the GraphQL specs.
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @return The {@link SubscriptionClient} that allows the caller to act on the subscribed subscription.
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient exec(String queryResponseDef, SubscriptionCallback<?> subscriptionCallback,
			Object... paramsAndValues) throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing subscription {} ", queryResponseDef);
		ObjectResponse objectResponse = getResponseBuilder().withQueryResponseDef(queryResponseDef).build();
		return execWithBindValues(objectResponse, subscriptionCallback,
				graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues));
	}

	/**
	 * This method takes a <B>full request</B> definition, and executes it against the GraphQL server. That is, the
	 * query contains the full string that <B><U>follows</U></B> the query/mutation/subscription keyword.<BR/>
	 * It offers a logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * For instance:
	 * 
	 * <PRE>
	 * ObjectResponse response;
	 * 
	 * public void setup() {
	 * 	// Preparation of the query
	 * 	objectResponse = myQueryType.getResponseBuilder()
	 * 			.withQueryResponseDef("{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * Map<String, Object> params = new HashMap<>();
	 * params.put("heroParam", heroParamValue);
	 * params.put("skip", Boolean.FALSE);
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * MyQueryType response = queryType.execWithBindValues(objectResponse, params);
	 * Character c = response.getHero();
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @return The {@link SubscriptionClient} that allows the caller to act on the subscribed subscription.
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient execWithBindValues(ObjectResponse objectResponse,
			SubscriptionCallback<?> subscriptionCallback, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException {
		if (logger.isTraceEnabled()) {
			if (parameters == null) {
				logger.trace("Executing subscription without parameters");
			} else {
				StringBuffer sb = new StringBuffer("Executing root subscription with parameters: ");
				boolean addComma = false;
				for (String key : parameters.keySet()) {
					sb.append(key).append(":").append(parameters.get(key));
					if (addComma)
						sb.append(", ");
					addComma = true;
				}
				logger.trace(sb.toString());
			}
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing subscription 'SubscriptionType'");
		}

		// Given values for the BindVariables
		parameters = (parameters != null) ? parameters : new HashMap<>();

		// The subscription may only subscribe to one subscription at a time, even for a full request.
		// Let's check that, and find the type returned by this subscription (that is: the type of the notifications
		// that will be received)
		//
		// The subscription must query only one subscription
		if (objectResponse.getQuery() != null || objectResponse.getMutation() != null) {
			throw new GraphQLRequestExecutionException(
					"This method may only be called for subscription, but the given GraphQL request is a "
							+ (objectResponse.getQuery() != null ? "query" : "mutation"));
		}
		if (objectResponse.getSubscription() == null) {
			throw new GraphQLRequestExecutionException(
					"This method may only be called for subscription, but the given GraphQL request has no mutation field");
		}
		if (objectResponse.getSubscription().getFields().size() != 1) {
			throw new GraphQLRequestExecutionException(
					"Full Request for subscription may only be called for one subscription, but the given GraphQL request has "
							+ objectResponse.getSubscription().getFields().size() + " subscription fields");
		}

		// It's probably possible to do much better than this switch!
		// If someone has a better idea to call this parameterized method, please come in.
		switch (objectResponse.getSubscription().getFields().get(0).getName()) {
		case "subscribeToNewPost":
			return graphQLConfigurationForum.getQueryExecutor().execute(objectResponse, parameters,
					(SubscriptionCallback<Post>) subscriptionCallback, SubscriptionTypeResponse.class, Post.class);
		default:
			throw new GraphQLRequestExecutionException(
					"Unexpected field name: " + objectResponse.getSubscription().getFields().get(0).getName());
		}
	}

	/**
	 * This method takes a <B>full request</B> definition, and executes it against the GraphQL server. That is, the
	 * query contains the full string that <B><U>follows</U></B> the query/mutation/subscription keyword.<BR/>
	 * It offers a logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * For instance:
	 * 
	 * <PRE>
	 * ObjectResponse response;
	 * 
	 * public void setup() {
	 * 	// Preparation of the query
	 * 	 objectResponse = myQueryType.getResponseBuilder()
	 * 			.withQueryResponseDef("{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * MyQueryType response = queryType.exec(objectResponse, "heroParam", heroParamValue, "skip", Boolean.FALSE);
	 * Character c = response.getHero();
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @return The {@link SubscriptionClient} that allows the caller to act on the subscribed subscription.
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient exec(ObjectResponse objectResponse, SubscriptionCallback<?> subscriptionCallback,
			Object... paramsAndValues) throws GraphQLRequestExecutionException {
		return execWithBindValues(objectResponse, subscriptionCallback,
				graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues));
	}

	/**
	 * Get the {@link com.graphql_java_generator.client.request.Builder} for a <B>full request</B>, as expected by the
	 * exec and execWithBindValues methods.
	 * 
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	public com.graphql_java_generator.client.request.Builder getResponseBuilder()
			throws GraphQLRequestPreparationException {
		return new com.graphql_java_generator.client.request.Builder(GraphQLRequest.class);
	}

	/**
	 * Get the {@link GraphQLRequest} for <B>full request</B>. For instance:
	 * 
	 * <PRE>
	 * GraphQLRequest request = new GraphQLRequest(fullRequest);
	 * </PRE>
	 * 
	 * @param fullRequest
	 *            The full GraphQLRequest, as specified in the GraphQL specification
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	public GraphQLRequest getGraphQLRequest(String fullRequest) throws GraphQLRequestPreparationException {
		GraphQLRequest ret = new GraphQLRequest(fullRequest);
		ret.setInstanceConfiguration(graphQLConfigurationForum);
		return ret;
	}

	/**
	 * This method registers a subscription, by executing a direct partial request against the GraphQL server. This
	 * subscription is one of the fields defined in the GraphQL subscription object. The queryResponseDef contains the
	 * part of the subscription that <B><U>is after</U></B> the subscription name (see the sample below), for instance
	 * "{id name}" if you want these two fields to be sent in the notifications you'll receive for this
	 * subscription.<BR/>
	 * You must also provide a callback instance of the {@link SubscriptionCallback}, and the parameter for the
	 * subscription as parameter for this method. For instance, if the subscription subscribeToNewPost has one parameter
	 * <I>boardName</I> (as defined in the GraphQL schema):
	 * 
	 * <PRE>
	 * SubscriptionClient client;
	 * 
	 * void setup() {
	 * 	subscriptionType = new SubscriptionType("http://localhost:8180/graphql/subscription");
	 * }
	 * 
	 * void exec() {
	 * 	Map<String, Object> params = new HashMap<>();
	 * 	params.put("anOptionalParam", "a param value");
	 * 	// PostSubscriptionCallback implement SubscriptionCallback<Post>, as Post is the returned type for the
	 * 	// subscribeToNewPost subscription. Its onMessage(T) method will be called for each notification of this
	 * 	// subscription.
	 * 	client = subscriptionType.subscribeToNewPost(
	 * 			"{id date author publiclyAvailable title(param: ?anOptionalParam) content}",
	 * 			new PostSubscriptionCallback(), "Board name 1", // The parameter(s) of the subscription if any, are
	 * 															// directly sent as parameter for this method
	 * 			params // The bind variable you defined in your query are in this map.
	 * 	);
	 * }
	 * 
	 * void freeResources() {
	 * 	client.unsubscribe();
	 * }
	 * </PRE>
	 * 
	 * @param queryResponseDef
	 *            The response definition of the subscription, in the native GraphQL format (see here above)
	 * @param subscriptionCallback
	 *            An instance of SubscriptionCallback<Post>. Its {@link SubscriptionCallback#onMessage(Object)} will be
	 *            called for each notification received from this subscription.
	 * @param boardName
	 *            Parameter for the subscribeToNewPost field of SubscriptionType, as defined in the GraphQL schema
	 * @param parameters
	 *            The list of values, for the bind variables defined in the subscription. If there is no bind variable
	 *            in the defined subscription, this argument may be null or an empty {@link Map}
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient subscribeToNewPostWithBindValues(String queryResponseDef,
			SubscriptionCallback<Post> subscriptionCallback, String boardName, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing subscription 'subscribeToNewPost': {} ", queryResponseDef);
		ObjectResponse objectResponse = getSubscribeToNewPostResponseBuilder().withQueryResponseDef(queryResponseDef)
				.build();
		return subscribeToNewPost(objectResponse, subscriptionCallback, boardName, parameters);
	}

	/**
	 * This method registers a subscription, by executing a direct partial request against the GraphQL server. This
	 * subscription is one of the fields defined in the GraphQL subscription object. The queryResponseDef contains the
	 * part of the subscription that <B><U>is after</U></B> the subscription name (see the sample below), for instance
	 * "{id name}" if you want these two fields to be sent in the notifications you'll receive for this
	 * subscription.<BR/>
	 * You must also provide a callback instance of the {@link SubscriptionCallback}, and the parameter for the
	 * subscription as parameter for this method. For instance, if the subscription subscribeToNewPost has one parameter
	 * <I>boardName</I> (as defined in the GraphQL schema):
	 * 
	 * <PRE>
	 * SubscriptionClient client;
	 * 
	 * void setup() {
	 * 	subscriptionType = new SubscriptionType("http://localhost:8180/graphql/subscription");
	 * }
	 * 
	 * void exec() {
	 * 	// PostSubscriptionCallback implement SubscriptionCallback<Post>, as Post is the returned type for the
	 * 	// subscribeToNewPost subscription. Its onMessage(T) method will be called for each notification of this
	 * 	// subscription.
	 * 	client = subscriptionType.subscribeToNewPost(
	 * 			"{id date author publiclyAvailable title(param: ?anOptionalParam) content}",
	 * 			new PostSubscriptionCallback(), "Board name 1", // The parameter(s) of the subscription if any, are
	 * 															// directly sent as parameter for this method
	 * 			"anOptionalParam", "a param value" // The bind variables that you've defined in your query are given
	 * 												// as a listof couple of (name, value)
	 * 	);
	 * }
	 * 
	 * void freeResources() {
	 * 	client.unsubscribe();
	 * }
	 * </PRE>
	 * 
	 * @param queryResponseDef
	 *            The response definition of the subscription, in the native GraphQL format (see here above)
	 * @param subscriptionCallback
	 *            An instance of SubscriptionCallback<Post>. Its {@link SubscriptionCallback#onMessage(Object)} will be
	 *            called for each notification received from this subscription.
	 * @param boardName
	 *            Parameter for the subscribeToNewPost field of SubscriptionType, as defined in the GraphQL schema
	 * @param parameters
	 *            The list of values, for the bind variables defined in the subscription. If there is no bind variable
	 *            in the defined subscription, this argument may be null or an empty {@link Map}
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient subscribeToNewPost(String queryResponseDef,
			SubscriptionCallback<Post> subscriptionCallback, String boardName, Object... paramsAndValues)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing subscription 'subscribeToNewPost' in query mode: {} ", queryResponseDef);
		ObjectResponse objectResponse = getSubscribeToNewPostResponseBuilder().withQueryResponseDef(queryResponseDef)
				.build();
		return subscribeToNewPostWithBindValues(objectResponse, subscriptionCallback, boardName,
				graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues));
	}

	/**
	 * This method registers a subscription, by executing a direct partial request against the GraphQL server. This
	 * subscription is one of the fields defined in the GraphQL subscription object. The queryResponseDef contains the
	 * part of the subscription that <B><U>is after</U></B> the subscription name (see the sample below), for instance
	 * "{id name}" if you want these two fields to be sent in the notifications you'll receive for this
	 * subscription.<BR/>
	 * You must also provide a callback instance of the {@link SubscriptionCallback}, and the parameter for the
	 * subscription as parameter for this method. For instance, if the subscription subscribeToNewPost has one parameter
	 * <I>boardName</I> (as defined in the GraphQL schema):
	 * 
	 * <PRE>
	 * SubscriptionClient client;
	 * GraphQLRequest subscriptionRequest;
	 * 
	 * void setup() {
	 * 	subscriptionType = new SubscriptionType("http://localhost:8180/graphql/subscription");
	 * 	subscriptionRequest = subscriptionType.getSubscribeToNewPostGraphQLRequest(
	 * 			"{id date author publiclyAvailable title(param: ?anOptionalParam) content}");
	 * }
	 * 
	 * void exec() {
	 * 	Map<String, Object> params = new HashMap<>();
	 * 	params.put("anOptionalParam", "a param value");
	 * 	// PostSubscriptionCallback implement SubscriptionCallback<Post>, as Post is the returned type for the
	 * 	// subscribeToNewPost subscription. Its onMessage(T) method will be called for each notification of this
	 * 	// subscription.
	 * 	client = subscriptionType.subscribeToNewPost(subscriptionRequest, new PostSubscriptionCallback(),
	 * 			"Board name 1", // The parameter(s) of the subscription if any, are directly sent as parameter for
	 * 							// this method
	 * 			params // The bind variable you defined in your query are in this map.
	 * 	);
	 * }
	 * 
	 * void freeResources() {
	 * 	client.unsubscribe();
	 * }
	 * </PRE>
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param subscriptionCallback
	 *            An instance of SubscriptionCallback<Post>. Its {@link SubscriptionCallback#onMessage(Object)} will be
	 *            called for each notification received from this subscription.
	 * @param boardName
	 *            Parameter for the subscribeToNewPost field of SubscriptionType, as defined in the GraphQL schema
	 * @param parameters
	 *            The list of values, for the bind variables defined in the subscription. If there is no bind variable
	 *            in the defined Query, this argument may be null or an empty {@link Map}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient subscribeToNewPostWithBindValues(ObjectResponse objectResponse,
			SubscriptionCallback<Post> subscriptionCallback, String boardName, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException {
		if (logger.isTraceEnabled()) {
			logger.trace("Executing subscription 'subscribeToNewPost' with parameters: {} ", boardName);
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing subscription 'subscribeToNewPost'");
		}

		// Given values for the BindVariables
		parameters = (parameters != null) ? parameters : new HashMap<>();
		parameters.put("subscriptionTypeSubscribeToNewPostBoardName", boardName);

		return graphQLConfigurationForum.getQueryExecutor().execute(objectResponse, parameters, subscriptionCallback,
				SubscriptionType.class, Post.class);
	}

	/**
	 * This method registers a subscription, by executing a direct partial request against the GraphQL server. This
	 * subscription is one of the fields defined in the GraphQL subscription object. The queryResponseDef contains the
	 * part of the subscription that <B><U>is after</U></B> the subscription name (see the sample below), for instance
	 * "{id name}" if you want these two fields to be sent in the notifications you'll receive for this
	 * subscription.<BR/>
	 * You must also provide a callback instance of the {@link SubscriptionCallback}, and the parameter for the
	 * subscription as parameter for this method. For instance, if the subscription subscribeToNewPost has one parameter
	 * <I>boardName</I> (as defined in the GraphQL schema):
	 * 
	 * <PRE>
	 * SubscriptionClient client;
	 * GraphQLRequest subscriptionRequest;
	 * 
	 * void setup() {
	 * 	subscriptionType = new SubscriptionType("http://localhost:8180/graphql/subscription");
	 * 	subscriptionRequest = subscriptionType.getSubscribeToNewPostGraphQLRequest(
	 * 			"{id date author publiclyAvailable title(param: ?anOptionalParam) content}");
	 * }
	 * 
	 * void exec() {
	 * 	Map<String, Object> params = new HashMap<>();
	 * 	params.put("anOptionalParam", "a param value");
	 * 	// PostSubscriptionCallback implement SubscriptionCallback<Post>, as Post is the returned type for the
	 * 	// subscribeToNewPost subscription. Its onMessage(T) method will be called for each notification of this
	 * 	// subscription.
	 * 	client = subscriptionType.subscribeToNewPost(subscriptionRequest, new PostSubscriptionCallback(),
	 * 			"Board name 1", // The parameter(s) of the subscription if any, are directly sent as parameter for
	 * 							// this method
	 * 			"anOptionalParam", "a param value" // The bind variables that you've defined in your query are given
	 * 												// as a listof couple of (name, value)
	 * 	);
	 * }
	 * 
	 * void freeResources() {
	 * 	client.unsubscribe();
	 * }
	 * </PRE>
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param subscriptionCallback
	 *            An instance of SubscriptionCallback<Post>. Its {@link SubscriptionCallback#onMessage(Object)} will be
	 *            called for each notification received from this subscription.
	 * @param boardName
	 *            Parameter for the subscribeToNewPost field of SubscriptionType, as defined in the GraphQL schema
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public SubscriptionClient subscribeToNewPost(ObjectResponse objectResponse,
			SubscriptionCallback<Post> subscriptionCallback, String boardName, Object... paramsAndValues)
			throws GraphQLRequestExecutionException {
		if (logger.isTraceEnabled()) {
			StringBuffer sb = new StringBuffer();
			sb.append("Executing subscription 'subscribeToNewPost' with bind variables: ");
			boolean addComma = false;
			for (Object o : paramsAndValues) {
				if (o != null) {
					sb.append(o.toString());
					if (addComma)
						sb.append(", ");
					addComma = true;
				}
			}
			logger.trace(sb.toString());
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing subscription 'subscribeToNewPost' (with bind variables)");
		}

		Map<String, Object> parameters = graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues);
		parameters.put("subscriptionTypeSubscribeToNewPostBoardName", boardName);

		return graphQLConfigurationForum.getQueryExecutor().execute(objectResponse, parameters, subscriptionCallback,
				SubscriptionType.class, Post.class);
	}

	/**
	 * Get the {@link com.graphql_java_generator.client.request.Builder} for the Post, as expected by the
	 * subscribeToNewPost subscription.
	 * 
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	public com.graphql_java_generator.client.request.Builder getSubscribeToNewPostResponseBuilder()
			throws GraphQLRequestPreparationException {
		return new com.graphql_java_generator.client.request.Builder(GraphQLRequest.class, "subscribeToNewPost",
				RequestType.subscription,
				InputParameter.newBindParameter("boardName", "subscriptionTypeSubscribeToNewPostBoardName",
						InputParameterType.MANDATORY, "String", true, 0, false));
	}

	/**
	 * Get the {@link GraphQLRequest} for the subscribeToNewPost executor, created with the given Partial request.
	 * 
	 * @param partialRequest
	 *            The Partial GraphQLRequest, as explained in the
	 *            <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">plugin client
	 *            documentation</A>
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	public GraphQLRequest getSubscribeToNewPostGraphQLRequest(String partialRequest)
			throws GraphQLRequestPreparationException {
		GraphQLRequest ret = new GraphQLRequest(partialRequest, RequestType.subscription, "subscribeToNewPost",
				InputParameter.newBindParameter("boardName", "subscriptionTypeSubscribeToNewPostBoardName",
						InputParameterType.MANDATORY, "String", true, 0, false));
		ret.setInstanceConfiguration(graphQLConfigurationForum);
		return ret;
	}

}
