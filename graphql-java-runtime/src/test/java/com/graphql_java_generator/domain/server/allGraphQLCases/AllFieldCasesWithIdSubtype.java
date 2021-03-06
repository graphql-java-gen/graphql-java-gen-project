/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@Entity
@GraphQLObjectType("AllFieldCasesWithIdSubtype")
public class AllFieldCasesWithIdSubtype 
{

	public AllFieldCasesWithIdSubtype(){
		// No action
	}

	@Id
	@GeneratedValue
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	UUID id;


	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = String.class)
	String name;



	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public String toString() {
        return "AllFieldCasesWithIdSubtype {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Id("id"),
		Name("name");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public Class<?> getGraphQLType() {
			return this.getClass().getDeclaringClass();
		}

	}

	public static Builder builder() {
			return new Builder();
		}



	/**
	 * Builder
	 */
	public static class Builder {
		private UUID id;
		private String name;


		public Builder withId(UUID id) {
			this.id = id;
			return this;
		}
		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public AllFieldCasesWithIdSubtype build() {
			AllFieldCasesWithIdSubtype _object = new AllFieldCasesWithIdSubtype();
			_object.setId(id);
			_object.setName(name);
			return _object;
		}
	}
}
