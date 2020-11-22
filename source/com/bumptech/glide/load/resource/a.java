package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.b;
import java.io.OutputStream;

public class a<T>
  implements b<T>
{
  private static final a<?> a = new a();
  
  public static <T> b<T> b()
  {
    return a;
  }
  
  public String a()
  {
    return "";
  }
  
  public boolean a(T paramT, OutputStream paramOutputStream)
  {
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */