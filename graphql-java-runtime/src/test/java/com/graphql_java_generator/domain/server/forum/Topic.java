/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.forum;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@Entity
@GraphQLObjectType("Topic")
public class Topic 
{

	public Topic(){
		// No action
	}

	@Id
	@GeneratedValue
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = String.class)
	String id;


	@GraphQLScalar(fieldName = "date", graphQLTypeSimpleName = "Date", javaClass = Date.class)
	Date date;


	@Transient
	@GraphQLNonScalar(fieldName = "author", graphQLTypeSimpleName = "Member", javaClass = Member.class)
	Member author;


	@GraphQLScalar(fieldName = "publiclyAvailable", graphQLTypeSimpleName = "Boolean", javaClass = Boolean.class)
	Boolean publiclyAvailable;


	@GraphQLScalar(fieldName = "nbPosts", graphQLTypeSimpleName = "Int", javaClass = Integer.class)
	Integer nbPosts;


	@GraphQLScalar(fieldName = "title", graphQLTypeSimpleName = "String", javaClass = String.class)
	String title;


	@GraphQLScalar(fieldName = "content", graphQLTypeSimpleName = "String", javaClass = String.class)
	String content;


	@Transient
	@GraphQLNonScalar(fieldName = "posts", graphQLTypeSimpleName = "Post", javaClass = Post.class)
	List<Post> posts;


	
	String boardId;


	
	String authorId;



	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setAuthor(Member author) {
		this.author = author;
	}

	public Member getAuthor() {
		return author;
	}

	public void setPubliclyAvailable(Boolean publiclyAvailable) {
		this.publiclyAvailable = publiclyAvailable;
	}

	public Boolean getPubliclyAvailable() {
		return publiclyAvailable;
	}

	public void setNbPosts(Integer nbPosts) {
		this.nbPosts = nbPosts;
	}

	public Integer getNbPosts() {
		return nbPosts;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorId() {
		return authorId;
	}

    public String toString() {
        return "Topic {"
				+ "id: " + id
				+ ", "
				+ "date: " + date
				+ ", "
				+ "author: " + author
				+ ", "
				+ "publiclyAvailable: " + publiclyAvailable
				+ ", "
				+ "nbPosts: " + nbPosts
				+ ", "
				+ "title: " + title
				+ ", "
				+ "content: " + content
				+ ", "
				+ "posts: " + posts
				+ ", "
				+ "boardId: " + boardId
				+ ", "
				+ "authorId: " + authorId
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Id("id"),
		Date("date"),
		Author("author"),
		PubliclyAvailable("publiclyAvailable"),
		NbPosts("nbPosts"),
		Title("title"),
		Content("content"),
		Posts("posts"),
		BoardId("boardId"),
		AuthorId("authorId");

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
		private String id;
		private Date date;
		private Member author;
		private Boolean publiclyAvailable;
		private Integer nbPosts;
		private String title;
		private String content;
		private List<Post> posts;
		private String boardId;
		private String authorId;


		public Builder withId(String id) {
			this.id = id;
			return this;
		}
		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}
		public Builder withAuthor(Member author) {
			this.author = author;
			return this;
		}
		public Builder withPubliclyAvailable(Boolean publiclyAvailable) {
			this.publiclyAvailable = publiclyAvailable;
			return this;
		}
		public Builder withNbPosts(Integer nbPosts) {
			this.nbPosts = nbPosts;
			return this;
		}
		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}
		public Builder withContent(String content) {
			this.content = content;
			return this;
		}
		public Builder withPosts(List<Post> posts) {
			this.posts = posts;
			return this;
		}
		public Builder withBoardId(String boardId) {
			this.boardId = boardId;
			return this;
		}
		public Builder withAuthorId(String authorId) {
			this.authorId = authorId;
			return this;
		}

		public Topic build() {
			Topic _object = new Topic();
			_object.setId(id);
			_object.setDate(date);
			_object.setAuthor(author);
			_object.setPubliclyAvailable(publiclyAvailable);
			_object.setNbPosts(nbPosts);
			_object.setTitle(title);
			_object.setContent(content);
			_object.setPosts(posts);
			_object.setBoardId(boardId);
			_object.setAuthorId(authorId);
			return _object;
		}
	}
}
