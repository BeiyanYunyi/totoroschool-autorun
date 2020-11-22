package com.google.gson.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD})
public @interface b
{
  Class<?> a();
  
  boolean b() default true;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */