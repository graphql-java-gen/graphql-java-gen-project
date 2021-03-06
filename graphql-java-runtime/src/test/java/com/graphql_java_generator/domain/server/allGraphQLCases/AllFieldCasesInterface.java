/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInterfaceType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.List;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

/**
 *  This interface is a clone of the AllFieldCases type. 
 *  Both should contains all possible combinations of parameters, data type, list, mandatory field or items...
 * <BR/>
 * 
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInterfaceType("AllFieldCasesInterface")
public interface AllFieldCasesInterface  {

	@Id
	@GeneratedValue
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	public void setId(UUID id);

	@Id
	@GeneratedValue
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	public UUID getId();

	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = String.class)
	public void setName(String name);

	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = String.class)
	public String getName();

	@GraphQLScalar(fieldName = "forname", graphQLTypeSimpleName = "String", javaClass = String.class)
	public void setForname(String forname);

	@GraphQLScalar(fieldName = "forname", graphQLTypeSimpleName = "String", javaClass = String.class)
	public String getForname();

	@GraphQLScalar(fieldName = "age", graphQLTypeSimpleName = "Long", javaClass = Long.class)
	public void setAge(Long age);

	@GraphQLScalar(fieldName = "age", graphQLTypeSimpleName = "Long", javaClass = Long.class)
	public Long getAge();

	@GraphQLScalar(fieldName = "nbComments", graphQLTypeSimpleName = "Int", javaClass = Integer.class)
	public void setNbComments(Integer nbComments);

	@GraphQLScalar(fieldName = "nbComments", graphQLTypeSimpleName = "Int", javaClass = Integer.class)
	public Integer getNbComments();

	@Transient
	@GraphQLScalar(fieldName = "comments", graphQLTypeSimpleName = "String", javaClass = String.class)
	public void setComments(List<String> comments);

	@Transient
	@GraphQLScalar(fieldName = "comments", graphQLTypeSimpleName = "String", javaClass = String.class)
	public List<String> getComments();

	@Transient
	@GraphQLScalar(fieldName = "booleans", graphQLTypeSimpleName = "Boolean", javaClass = Boolean.class)
	public void setBooleans(List<Boolean> booleans);

	@Transient
	@GraphQLScalar(fieldName = "booleans", graphQLTypeSimpleName = "Boolean", javaClass = Boolean.class)
	public List<Boolean> getBooleans();

	@Transient
	@GraphQLScalar(fieldName = "aliases", graphQLTypeSimpleName = "String", javaClass = String.class)
	public void setAliases(List<String> aliases);

	@Transient
	@GraphQLScalar(fieldName = "aliases", graphQLTypeSimpleName = "String", javaClass = String.class)
	public List<String> getAliases();

	@Transient
	@GraphQLScalar(fieldName = "planets", graphQLTypeSimpleName = "String", javaClass = String.class)
	public void setPlanets(List<String> planets);

	@Transient
	@GraphQLScalar(fieldName = "planets", graphQLTypeSimpleName = "String", javaClass = String.class)
	public List<String> getPlanets();

	@Transient
	@GraphQLNonScalar(fieldName = "friends", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	public void setFriends(List<Human> friends);

	@Transient
	@GraphQLNonScalar(fieldName = "friends", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	public List<Human> getFriends();

	@GraphQLNonScalar(fieldName = "oneWithIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	public void setOneWithIdSubType(AllFieldCasesWithIdSubtype oneWithIdSubType);

	@GraphQLNonScalar(fieldName = "oneWithIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	public AllFieldCasesWithIdSubtype getOneWithIdSubType();

	@Transient
	@GraphQLNonScalar(fieldName = "listWithIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	public void setListWithIdSubTypes(List<AllFieldCasesWithIdSubtype> listWithIdSubTypes);

	@Transient
	@GraphQLNonScalar(fieldName = "listWithIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	public List<AllFieldCasesWithIdSubtype> getListWithIdSubTypes();

	@GraphQLNonScalar(fieldName = "oneWithoutIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	public void setOneWithoutIdSubType(AllFieldCasesWithoutIdSubtype oneWithoutIdSubType);

	@GraphQLNonScalar(fieldName = "oneWithoutIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	public AllFieldCasesWithoutIdSubtype getOneWithoutIdSubType();

	@Transient
	@GraphQLNonScalar(fieldName = "listWithoutIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	public void setListWithoutIdSubTypes(List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes);

	@Transient
	@GraphQLNonScalar(fieldName = "listWithoutIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	public List<AllFieldCasesWithoutIdSubtype> getListWithoutIdSubTypes();
}
