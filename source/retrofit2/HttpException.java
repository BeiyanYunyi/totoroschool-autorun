package retrofit2;

public class HttpException
  extends RuntimeException
{
  private final int code;
  private final String message;
  private final transient Response<?> response;
  
  public HttpException(Response<?> paramResponse)
  {
    super(getMessage(paramResponse));
    this.code = paramResponse.code();
    this.message = paramResponse.message();
    this.response = paramResponse;
  }
  
  private static String getMessage(Response<?> paramResponse)
  {
    Utils.checkNotNull(paramResponse, "response == null");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HTTP ");
    localStringBuilder.append(paramResponse.code());
    localStringBuilder.append(" ");
    localStringBuilder.append(paramResponse.message());
    return localStringBuilder.toString();
  }
  
  public int code()
  {
    return this.code;
  }
  
  public String message()
  {
    return this.message;
  }
  
  public Response<?> response()
  {
    return this.response;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\HttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */