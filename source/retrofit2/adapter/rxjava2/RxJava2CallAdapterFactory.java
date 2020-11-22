package retrofit2.adapter.rxjava2;

import b.a.b;
import b.a.f;
import b.a.h;
import b.a.l;
import b.a.t;
import b.a.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class RxJava2CallAdapterFactory
  extends CallAdapter.Factory
{
  private final boolean isAsync;
  @Nullable
  private final t scheduler;
  
  private RxJava2CallAdapterFactory(@Nullable t paramt, boolean paramBoolean)
  {
    this.scheduler = paramt;
    this.isAsync = paramBoolean;
  }
  
  public static RxJava2CallAdapterFactory create()
  {
    return new RxJava2CallAdapterFactory(null, false);
  }
  
  public static RxJava2CallAdapterFactory createAsync()
  {
    return new RxJava2CallAdapterFactory(null, true);
  }
  
  public static RxJava2CallAdapterFactory createWithScheduler(t paramt)
  {
    if (paramt != null) {
      return new RxJava2CallAdapterFactory(paramt, false);
    }
    throw new NullPointerException("scheduler == null");
  }
  
  @Nullable
  public CallAdapter<?, ?> get(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    paramArrayOfAnnotation = getRawType(paramType);
    if (paramArrayOfAnnotation == b.class) {
      return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
    }
    boolean bool2;
    if (paramArrayOfAnnotation == f.class) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (paramArrayOfAnnotation == u.class) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if (paramArrayOfAnnotation == h.class) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    if ((paramArrayOfAnnotation != l.class) && (!bool2) && (!bool3) && (!bool4)) {
      return null;
    }
    if (!(paramType instanceof ParameterizedType))
    {
      if (!bool2)
      {
        if (!bool3)
        {
          if (bool4) {
            paramType = "Maybe";
          } else {
            paramType = "Observable";
          }
        }
        else {
          paramType = "Single";
        }
      }
      else {
        paramType = "Flowable";
      }
      paramArrayOfAnnotation = new StringBuilder();
      paramArrayOfAnnotation.append(paramType);
      paramArrayOfAnnotation.append(" return type must be parameterized as ");
      paramArrayOfAnnotation.append(paramType);
      paramArrayOfAnnotation.append("<Foo> or ");
      paramArrayOfAnnotation.append(paramType);
      paramArrayOfAnnotation.append("<? extends Foo>");
      throw new IllegalStateException(paramArrayOfAnnotation.toString());
    }
    paramType = getParameterUpperBound(0, (ParameterizedType)paramType);
    paramArrayOfAnnotation = getRawType(paramType);
    if (paramArrayOfAnnotation == Response.class) {
      if ((paramType instanceof ParameterizedType)) {
        paramType = getParameterUpperBound(0, (ParameterizedType)paramType);
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      bool5 = false;
      break label304;
      throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
      if (paramArrayOfAnnotation != Result.class) {
        break label298;
      }
      if (!(paramType instanceof ParameterizedType)) {
        break;
      }
      paramType = getParameterUpperBound(0, (ParameterizedType)paramType);
    }
    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
    label298:
    bool1 = false;
    boolean bool5 = true;
    label304:
    return new RxJava2CallAdapter(paramType, this.scheduler, this.isAsync, bool1, bool5, bool2, bool3, bool4, false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\adapter\rxjava2\RxJava2CallAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */