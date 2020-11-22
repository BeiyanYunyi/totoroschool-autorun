package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
final class CompletableFutureCallAdapterFactory
  extends CallAdapter.Factory
{
  static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();
  
  @Nullable
  public CallAdapter<?, ?> get(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (getRawType(paramType) != CompletableFuture.class) {
      return null;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = getParameterUpperBound(0, (ParameterizedType)paramType);
      if (getRawType(paramType) != Response.class) {
        return new BodyCallAdapter(paramType);
      }
      if ((paramType instanceof ParameterizedType)) {
        return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType)paramType));
      }
      throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
    throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
  }
  
  @IgnoreJRERequirement
  private static final class BodyCallAdapter<R>
    implements CallAdapter<R, CompletableFuture<R>>
  {
    private final Type responseType;
    
    BodyCallAdapter(Type paramType)
    {
      this.responseType = paramType;
    }
    
    public CompletableFuture<R> adapt(final Call<R> paramCall)
    {
      final CompletableFuture local1 = new CompletableFuture()
      {
        public boolean cancel(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            paramCall.cancel();
          }
          return super.cancel(paramAnonymousBoolean);
        }
      };
      paramCall.enqueue(new Callback()
      {
        public void onFailure(Call<R> paramAnonymousCall, Throwable paramAnonymousThrowable)
        {
          local1.completeExceptionally(paramAnonymousThrowable);
        }
        
        public void onResponse(Call<R> paramAnonymousCall, Response<R> paramAnonymousResponse)
        {
          if (paramAnonymousResponse.isSuccessful())
          {
            local1.complete(paramAnonymousResponse.body());
            return;
          }
          local1.completeExceptionally(new HttpException(paramAnonymousResponse));
        }
      });
      return local1;
    }
    
    public Type responseType()
    {
      return this.responseType;
    }
  }
  
  @IgnoreJRERequirement
  private static final class ResponseCallAdapter<R>
    implements CallAdapter<R, CompletableFuture<Response<R>>>
  {
    private final Type responseType;
    
    ResponseCallAdapter(Type paramType)
    {
      this.responseType = paramType;
    }
    
    public CompletableFuture<Response<R>> adapt(final Call<R> paramCall)
    {
      final CompletableFuture local1 = new CompletableFuture()
      {
        public boolean cancel(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            paramCall.cancel();
          }
          return super.cancel(paramAnonymousBoolean);
        }
      };
      paramCall.enqueue(new Callback()
      {
        public void onFailure(Call<R> paramAnonymousCall, Throwable paramAnonymousThrowable)
        {
          local1.completeExceptionally(paramAnonymousThrowable);
        }
        
        public void onResponse(Call<R> paramAnonymousCall, Response<R> paramAnonymousResponse)
        {
          local1.complete(paramAnonymousResponse);
        }
      });
      return local1;
    }
    
    public Type responseType()
    {
      return this.responseType;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\CompletableFutureCallAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */