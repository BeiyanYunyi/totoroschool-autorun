package e.a.c;

public final class f
{
  public static boolean a(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE")) || (paramString.equals("MOVE"));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")) || (paramString.equals("PROPPATCH")) || (paramString.equals("REPORT"));
  }
  
  public static boolean c(String paramString)
  {
    return (!paramString.equals("GET")) && (!paramString.equals("HEAD"));
  }
  
  public static boolean d(String paramString)
  {
    return paramString.equals("PROPFIND");
  }
  
  public static boolean e(String paramString)
  {
    return paramString.equals("PROPFIND") ^ true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */