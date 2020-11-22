package retrofit2;

import e.aa.a;
import e.ac;
import e.ac.a;
import e.ad;
import e.s;
import e.y;
import javax.annotation.Nullable;

public final class Response<T>
{
  @Nullable
  private final T body;
  @Nullable
  private final ad errorBody;
  private final ac rawResponse;
  
  private Response(ac paramac, @Nullable T paramT, @Nullable ad paramad)
  {
    this.rawResponse = paramac;
    this.body = paramT;
    this.errorBody = paramad;
  }
  
  public static <T> Response<T> error(int paramInt, ad paramad)
  {
    if (paramInt >= 400) {
      return error(paramad, new ac.a().a(paramInt).a("Response.error()").a(y.HTTP_1_1).a(new aa.a().a("http://localhost/").a()).a());
    }
    paramad = new StringBuilder();
    paramad.append("code < 400: ");
    paramad.append(paramInt);
    throw new IllegalArgumentException(paramad.toString());
  }
  
  public static <T> Response<T> error(ad paramad, ac paramac)
  {
    Utils.checkNotNull(paramad, "body == null");
    Utils.checkNotNull(paramac, "rawResponse == null");
    if (!paramac.c()) {
      return new Response(paramac, null, paramad);
    }
    throw new IllegalArgumentException("rawResponse should not be successful response");
  }
  
  public static <T> Response<T> success(int paramInt, @Nullable T paramT)
  {
    if ((paramInt >= 200) && (paramInt < 300)) {
      return success(paramT, new ac.a().a(paramInt).a("Response.success()").a(y.HTTP_1_1).a(new aa.a().a("http://localhost/").a()).a());
    }
    paramT = new StringBuilder();
    paramT.append("code < 200 or >= 300: ");
    paramT.append(paramInt);
    throw new IllegalArgumentException(paramT.toString());
  }
  
  public static <T> Response<T> success(@Nullable T paramT)
  {
    return success(paramT, new ac.a().a(200).a("OK").a(y.HTTP_1_1).a(new aa.a().a("http://localhost/").a()).a());
  }
  
  public static <T> Response<T> success(@Nullable T paramT, ac paramac)
  {
    Utils.checkNotNull(paramac, "rawResponse == null");
    if (paramac.c()) {
      return new Response(paramac, paramT, null);
    }
    throw new IllegalArgumentException("rawResponse must be successful response");
  }
  
  public static <T> Response<T> success(@Nullable T paramT, s params)
  {
    Utils.checkNotNull(params, "headers == null");
    return success(paramT, new ac.a().a(200).a("OK").a(y.HTTP_1_1).a(params).a(new aa.a().a("http://localhost/").a()).a());
  }
  
  @Nullable
  public T body()
  {
    return (T)this.body;
  }
  
  public int code()
  {
    return this.rawResponse.b();
  }
  
  @Nullable
  public ad errorBody()
  {
    return this.errorBody;
  }
  
  public s headers()
  {
    return this.rawResponse.f();
  }
  
  public boolean isSuccessful()
  {
    return this.rawResponse.c();
  }
  
  public String message()
  {
    return this.rawResponse.d();
  }
  
  public ac raw()
  {
    return this.rawResponse;
  }
  
  public String toString()
  {
    return this.rawResponse.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */