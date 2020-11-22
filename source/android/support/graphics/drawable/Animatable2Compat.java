package android.support.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

public abstract interface Animatable2Compat
  extends Animatable
{
  public abstract void clearAnimationCallbacks();
  
  public abstract void registerAnimationCallback(@NonNull AnimationCallback paramAnimationCallback);
  
  public abstract boolean unregisterAnimationCallback(@NonNull AnimationCallback paramAnimationCallback);
  
  public static abstract class AnimationCallback
  {
    Animatable2.AnimationCallback mPlatformCallback;
    
    @RequiresApi(23)
    Animatable2.AnimationCallback getPlatformCallback()
    {
      if (this.mPlatformCallback == null) {
        this.mPlatformCallback = new Animatable2.AnimationCallback()
        {
          public void onAnimationEnd(Drawable paramAnonymousDrawable)
          {
            Animatable2Compat.AnimationCallback.this.onAnimationEnd(paramAnonymousDrawable);
          }
          
          public void onAnimationStart(Drawable paramAnonymousDrawable)
          {
            Animatable2Compat.AnimationCallback.this.onAnimationStart(paramAnonymousDrawable);
          }
        };
      }
      return this.mPlatformCallback;
    }
    
    public void onAnimationEnd(Drawable paramDrawable) {}
    
    public void onAnimationStart(Drawable paramDrawable) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\graphics\drawable\Animatable2Compat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */