package ${package};

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * @author generated by graphql-maven-plugin
 */
public interface ${interface.name} #if($interface.implementz.size()>0)implements #foreach($impl in $interface.implementz)$impl#if($foreach.hasNext), #end#end#end {
#foreach ($field in $interface.fields)

	public void set${field.pascalCaseName}(${field.type.javaClassSimpleName} ${field.name});

	public ${field.type.javaClassSimpleName} get${field.pascalCaseName}();
#end
}
