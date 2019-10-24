package ${package};
#macro(inputParams)#foreach ($inputParameter in $field.inputParameters), #if(${inputParameter.list})List<#end${inputParameter.type.classSimpleName}#if(${inputParameter.list})>#end ${inputParameter.name}#end#end

#macro(inputValues)#foreach ($inputParameter in $field.inputParameters), ${inputParameter.name}#end#end

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLQuery;
import com.graphql_java_generator.client.QueryExecutor;
import com.graphql_java_generator.client.QueryExecutorImpl;
import com.graphql_java_generator.client.request.Builder;
import com.graphql_java_generator.client.request.InputParameter;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.client.response.GraphQLExecutionException;
import com.graphql_java_generator.client.response.GraphQLRequestPreparationException;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public class ${object.name} {

	/** Logger for this class */
	private static Logger logger = LogManager.getLogger();

	final QueryExecutor executor;

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for http servers, not for
	 * https ones.<BR/>
	 * For example: http://my.server.com/graphql
	 * 
	 * @param graphqlEndpoint
	 *            the http URI for the GraphQL endpoint
	 */
	public ${object.name}(String graphqlEndpoint) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint);
	}

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for https servers, not for
	 * http ones.<BR/>
	 * For example: https://my.server.com/graphql<BR/><BR/>
	 * {@link SSLContext} and {@link HostnameVerifier} are regular Java stuff. You'll find lots of documentation on the web. 
	 * The StarWars sample is based on the <A HREF="http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https">http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https</A> blog.
	 * But this sample implements a noHostVerification, which of course, is the simplest but the safest way to go.
	 * 
	 * @param graphqlEndpoint
	 *            the https URI for the GraphQL endpoint
	 * @param sslContext
	 * @param hostnameVerifier
	 */
	public ${object.name}(String graphqlEndpoint, SSLContext sslContext, HostnameVerifier hostnameVerifier) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint, sslContext, hostnameVerifier);
	}
	
#foreach ($field in $object.fields)
	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * This method takes care of writting the query name, and the parameter(s) for the query. The given queryResponseDef
	 * describes the format of the response of the server response, that is the expected fields of the {@link ${field.type.classSimpleName}}
	 * GraphQL type. It can be something like "{ id name }", if you want these fields of this type. Please take a look at
	 * the StarWars, Forum and other samples for more complex queries.
	 * 
	 * @param queryResponseDef
	 *            The response definition of the query, in the native GraphQL format (see here above)
	 * @param episode
	 *            Parameter 1 of this query
	 * @throws IOException
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphqlType = ${field.type.classSimpleName}.class)
	@GraphQLQuery
	public #if(${field.list})List<#end${field.type.classSimpleName}#if(${field.list})>#end ${field.name}(String queryResponseDef#inputParams())
			throws GraphQLExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing of query '${field.name}' in query mode: {} ", queryResponseDef);
		ObjectResponse objectResponse = get${field.pascalCaseName}ResponseBuilder().withQueryResponseDef(queryResponseDef).build();
		return ${field.name}(objectResponse#inputValues());
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param episode
	 * @throws IOException
	 * @throws GraphQLExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphqlType = ${field.type.classSimpleName}.class)
	@GraphQLQuery
	public #if(${field.list})List<#end${field.type.classSimpleName}#if(${field.list})>#end ${field.name}(ObjectResponse objectResponse#inputParams()) 
			throws GraphQLExecutionException  {
		if (logger.isTraceEnabled()) {
			logger.trace("Executing of $type '${field.name}' with parameters: #foreach ($inputParameter in $field.inputParameters){}#if($foreach.hasNext),#end #end"#foreach ($inputParameter in $field.inputParameters), ${inputParameter.name}#end);
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing of $type '${field.name}'");
		}
	
		// InputParameters
		List<InputParameter> parameters = new ArrayList<>();
#foreach ($inputParameter in $field.inputParameters)
		parameters.add(new InputParameter("${inputParameter.name}", ${inputParameter.name}));
#end

		if (!${field.type.classSimpleName}.class.equals(objectResponse.getFieldClass())) {
			throw new GraphQLExecutionException("The ObjectResponse parameter should be an instance of "
					+ ${field.type.classSimpleName}.class + ", but is an instance of " + objectResponse.getClass().getName());
		}

		${field.owningType.classSimpleName}${field.pascalCaseName} ret = executor.execute("${object.requestType}", objectResponse, parameters, ${field.owningType.classSimpleName}${field.pascalCaseName}.class);
		
		return ret.${field.name};
	}

	/**
	 * Get the {@link ObjectResponse.Builder} for the ${field.type.classSimpleName}, as expected by the ${field.name} query.
	 * 
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	public Builder get${field.pascalCaseName}ResponseBuilder() throws GraphQLRequestPreparationException {
		return ObjectResponse.newQueryResponseDefBuilder(getClass(), "${field.name}");
	}
	
#end
}