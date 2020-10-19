/**
 * 
 */
package com.graphql_java_generator.mavenplugin;

import org.apache.maven.plugins.annotations.Parameter;

import com.graphql_java_generator.plugin.conf.GraphQLConfiguration;
import com.graphql_java_generator.plugin.conf.PluginMode;

/**
 * This class is the class that contains all parameters that needed for the {@link GraphQLMojo}, that is all parameters
 * that are common to all generate code Mojos. The parameters from the generateServerCode are inherited from
 * {@link AbstractGenerateServerCodeMojo}, and the parameters that are specific to the generateClientCode must be
 * manually added here, as a class may not inherit from two superclasses.<BR/>
 * This avoids to redeclare each common parameter in each Mojo, including its comment. When a comment is updated, only
 * one update is necessary, instead of updating it in each Mojo.
 * 
 * @author etienne-sf
 */
public abstract class AbstractGraphQLMojo extends AbstractGenerateServerCodeMojo implements GraphQLConfiguration {

	/**
	 * <P>
	 * <I>Since 1.7.1 version</I>
	 * </P>
	 * <P>
	 * Generates a XxxxResponse class for each query/mutation/subscription, and (if separateUtilityClasses is true) Xxxx
	 * classes in the util subpackage. This allows to keep compatibility with code Developed with the 1.x versions of
	 * the plugin.
	 * </P>
	 * <P>
	 * The best way to use the plugin is to directly use the Xxxx query/mutation/subscription classes, where Xxxx is the
	 * query/mutation/subscription name defined in the GraphQL schema.
	 * </P>
	 */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.generateDeprecatedRequestResponse", defaultValue = GraphQLConfiguration.DEFAULT_GENERATE_DEPRECATED_REQUEST_RESPONSE)
	boolean generateDeprecatedRequestResponse;

	/**
	 * The generation mode: either <I>client</I> or <I>server</I>. Choose client to generate the code which can query a
	 * graphql server or server to generate a code for the server side.
	 */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.mode", defaultValue = GraphQLConfiguration.DEFAULT_MODE)
	PluginMode mode;

	@Override
	public PluginMode getMode() {
		return mode;
	}

	@Override
	public boolean isGenerateDeprecatedRequestResponse() {
		return generateDeprecatedRequestResponse;
	}

	protected AbstractGraphQLMojo(Class<?> springConfigurationClass) {
		super(springConfigurationClass);
	}
}
