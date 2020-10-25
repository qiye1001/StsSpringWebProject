package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 	自定义注解
 */
 
 // 用于生成文档 
@Documented
// 表示注解可以继承给子类
@Inherited
// 表示注解的范围在运行期有效
@Retention(RetentionPolicy.RUNTIME)
// 注释的范围(构造器， 属性，常数， 类型， 方法， 包， annotation)
//@Target(value = {ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD})
public @interface MyAnnotation {
	// 定义属性
	public String name();
	public int age() default 4;	// 设置默认值
	public String[] like();	// 定义一个数组
	public Color color();	// 定义一个枚举类型 
}
