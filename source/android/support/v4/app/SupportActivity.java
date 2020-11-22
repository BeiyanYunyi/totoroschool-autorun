package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.c;
import android.arch.lifecycle.c.b;
import android.arch.lifecycle.e;
import android.arch.lifecycle.f;
import android.arch.lifecycle.m;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v4.view.KeyEventDispatcher.Component;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SupportActivity
  extends Activity
  implements e, KeyEventDispatcher.Component
{
  private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap();
  private f mLifecycleRegistry = new f(this);
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (KeyEventDispatcher.dispatchBeforeHierarchy(localView, paramKeyEvent))) {
      return true;
    }
    return KeyEventDispatcher.dispatchKeyEvent(this, localView, this, paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (KeyEventDispatcher.dispatchBeforeHierarchy(localView, paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public <T extends ExtraData> T getExtraData(Class<T> paramClass)
  {
    return (ExtraData)this.mExtraDataMap.get(paramClass);
  }
  
  public c getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    m.a(this);
  }
  
  @CallSuper
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLifecycleRegistry.a(c.b.CREATED);
    super.onSaveInstanceState(paramBundle);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void putExtraData(ExtraData paramExtraData)
  {
    this.mExtraDataMap.put(paramExtraData.getClass(), paramExtraData);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static class ExtraData {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\SupportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */