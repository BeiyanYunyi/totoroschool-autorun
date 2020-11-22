package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(24)
class MediaSessionCompatApi24
{
  private static final String TAG = "MediaSessionCompatApi24";
  
  public static Object createCallback(Callback paramCallback)
  {
    return new CallbackProxy(paramCallback);
  }
  
  public static String getCallingPackage(Object paramObject)
  {
    paramObject = (MediaSession)paramObject;
    try
    {
      paramObject = (String)paramObject.getClass().getMethod("getCallingPackage", new Class[0]).invoke(paramObject, new Object[0]);
      return (String)paramObject;
    }
    catch (NoSuchMethodException|InvocationTargetException|IllegalAccessException paramObject)
    {
      Log.e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", (Throwable)paramObject);
    }
    return null;
  }
  
  public static abstract interface Callback
    extends MediaSessionCompatApi23.Callback
  {
    public abstract void onPrepare();
    
    public abstract void onPrepareFromMediaId(String paramString, Bundle paramBundle);
    
    public abstract void onPrepareFromSearch(String paramString, Bundle paramBundle);
    
    public abstract void onPrepareFromUri(Uri paramUri, Bundle paramBundle);
  }
  
  static class CallbackProxy<T extends MediaSessionCompatApi24.Callback>
    extends MediaSessionCompatApi23.CallbackProxy<T>
  {
    public CallbackProxy(T paramT)
    {
      super();
    }
    
    public void onPrepare()
    {
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepare();
    }
    
    public void onPrepareFromMediaId(String paramString, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromMediaId(paramString, paramBundle);
    }
    
    public void onPrepareFromSearch(String paramString, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromSearch(paramString, paramBundle);
    }
    
    public void onPrepareFromUri(Uri paramUri, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromUri(paramUri, paramBundle);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */