package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class o
{
  private final a a;
  private final p b;
  
  public o(@NonNull p paramp, @NonNull a parama)
  {
    this.a = parama;
    this.b = paramp;
  }
  
  @MainThread
  @NonNull
  public <T extends n> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
      localStringBuilder.append(str);
      return a(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @MainThread
  @NonNull
  public <T extends n> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    n localn = this.b.a(paramString);
    if (paramClass.isInstance(localn)) {
      return localn;
    }
    paramClass = this.a.create(paramClass);
    this.b.a(paramString, paramClass);
    return paramClass;
  }
  
  public static abstract interface a
  {
    @NonNull
    public abstract <T extends n> T create(@NonNull Class<T> paramClass);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */