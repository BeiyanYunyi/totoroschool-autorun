package retrofit2.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Nonnull
@TypeQualifierDefault({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface EverythingIsNonNull {}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\internal\EverythingIsNonNull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */