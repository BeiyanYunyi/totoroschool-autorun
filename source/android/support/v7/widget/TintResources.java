package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class TintResources
  extends ResourcesWrapper
{
  private final WeakReference<Context> mContextRef;
  
  public TintResources(@NonNull Context paramContext, @NonNull Resources paramResources)
  {
    super(paramResources);
    this.mContextRef = new WeakReference(paramContext);
  }
  
  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.mContextRef.get();
    if ((localDrawable != null) && (localContext != null))
    {
      AppCompatDrawableManager.get();
      AppCompatDrawableManager.tintDrawableUsingColorFilter(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\TintResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */