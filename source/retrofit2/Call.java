package retrofit2;

import e.aa;
import java.io.IOException;

public abstract interface Call<T>
  extends Cloneable
{
  public abstract void cancel();
  
  public abstract Call<T> clone();
  
  public abstract void enqueue(Callback<T> paramCallback);
  
  public abstract Response<T> execute()
    throws IOException;
  
  public abstract boolean isCanceled();
  
  public abstract boolean isExecuted();
  
  public abstract aa request();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */