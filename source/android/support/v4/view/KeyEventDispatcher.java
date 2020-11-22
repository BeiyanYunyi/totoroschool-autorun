package android.support.v4.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class KeyEventDispatcher
{
  private static boolean sActionBarFieldsFetched = false;
  private static Method sActionBarOnMenuKeyMethod;
  private static boolean sDialogFieldsFetched = false;
  private static Field sDialogKeyListenerField;
  
  private static boolean actionBarOnMenuKeyEventPre28(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    if (!sActionBarFieldsFetched) {}
    try
    {
      sActionBarOnMenuKeyMethod = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      sActionBarFieldsFetched = true;
      if (sActionBarOnMenuKeyMethod != null) {}
      try
      {
        boolean bool = ((Boolean)sActionBarOnMenuKeyMethod.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        return bool;
      }
      catch (IllegalAccessException|InvocationTargetException paramActionBar) {}
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static boolean activitySuperDispatchKeyEventPre28(Activity paramActivity, KeyEvent paramKeyEvent)
  {
    paramActivity.onUserInteraction();
    Object localObject = paramActivity.getWindow();
    if (((Window)localObject).hasFeature(8))
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      if ((paramKeyEvent.getKeyCode() == 82) && (localActionBar != null) && (actionBarOnMenuKeyEventPre28(localActionBar, paramKeyEvent))) {
        return true;
      }
    }
    if (((Window)localObject).superDispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    localObject = ((Window)localObject).getDecorView();
    if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)localObject, paramKeyEvent)) {
      return true;
    }
    if (localObject != null) {
      localObject = ((View)localObject).getKeyDispatcherState();
    } else {
      localObject = null;
    }
    return paramKeyEvent.dispatch(paramActivity, (KeyEvent.DispatcherState)localObject, paramActivity);
  }
  
  private static boolean dialogSuperDispatchKeyEventPre28(Dialog paramDialog, KeyEvent paramKeyEvent)
  {
    Object localObject = getDialogKeyListenerPre28(paramDialog);
    if ((localObject != null) && (((DialogInterface.OnKeyListener)localObject).onKey(paramDialog, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
      return true;
    }
    localObject = paramDialog.getWindow();
    if (((Window)localObject).superDispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    localObject = ((Window)localObject).getDecorView();
    if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)localObject, paramKeyEvent)) {
      return true;
    }
    if (localObject != null) {
      localObject = ((View)localObject).getKeyDispatcherState();
    } else {
      localObject = null;
    }
    return paramKeyEvent.dispatch(paramDialog, (KeyEvent.DispatcherState)localObject, paramDialog);
  }
  
  public static boolean dispatchBeforeHierarchy(@NonNull View paramView, @NonNull KeyEvent paramKeyEvent)
  {
    return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(paramView, paramKeyEvent);
  }
  
  public static boolean dispatchKeyEvent(@NonNull Component paramComponent, @Nullable View paramView, @Nullable Window.Callback paramCallback, @NonNull KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramComponent == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      return paramComponent.superDispatchKeyEvent(paramKeyEvent);
    }
    if ((paramCallback instanceof Activity)) {
      return activitySuperDispatchKeyEventPre28((Activity)paramCallback, paramKeyEvent);
    }
    if ((paramCallback instanceof Dialog)) {
      return dialogSuperDispatchKeyEventPre28((Dialog)paramCallback, paramKeyEvent);
    }
    if (((paramView != null) && (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(paramView, paramKeyEvent))) || (paramComponent.superDispatchKeyEvent(paramKeyEvent))) {
      bool = true;
    }
    return bool;
  }
  
  private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog paramDialog)
  {
    if (!sDialogFieldsFetched) {}
    try
    {
      sDialogKeyListenerField = Dialog.class.getDeclaredField("mOnKeyListener");
      sDialogKeyListenerField.setAccessible(true);
      sDialogFieldsFetched = true;
      if (sDialogKeyListenerField != null) {}
      try
      {
        paramDialog = (DialogInterface.OnKeyListener)sDialogKeyListenerField.get(paramDialog);
        return paramDialog;
      }
      catch (IllegalAccessException paramDialog)
      {
        for (;;) {}
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
  
  public static abstract interface Component
  {
    public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\KeyEventDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */