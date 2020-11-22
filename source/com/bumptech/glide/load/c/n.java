package com.bumptech.glide.load.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.a.c;

public class n<T>
  implements l<Integer, T>
{
  private final l<Uri, T> a;
  private final Resources b;
  
  public n(Context paramContext, l<Uri, T> paraml)
  {
    this(paramContext.getResources(), paraml);
  }
  
  public n(Resources paramResources, l<Uri, T> paraml)
  {
    this.b = paramResources;
    this.a = paraml;
  }
  
  public c<T> a(Integer paramInteger, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("android.resource://");
      ((StringBuilder)localObject).append(this.b.getResourcePackageName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceTypeName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceEntryName(paramInteger.intValue()));
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      paramInteger = (Integer)localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (Log.isLoggable("ResourceLoader", 5))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Received invalid resource id: ");
        localStringBuilder.append(paramInteger);
        Log.w("ResourceLoader", localStringBuilder.toString(), localNotFoundException);
      }
      paramInteger = null;
    }
    if (paramInteger != null) {
      return this.a.a(paramInteger, paramInt1, paramInt2);
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */