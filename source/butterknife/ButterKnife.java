package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.CheckResult;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife
{
  @VisibleForTesting
  static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
  private static final String TAG = "ButterKnife";
  private static boolean debug = false;
  
  private ButterKnife()
  {
    throw new AssertionError("No instances.");
  }
  
  @TargetApi(14)
  @RequiresApi(14)
  @UiThread
  public static <T extends View, V> void apply(@NonNull T paramT, @NonNull Property<? super T, V> paramProperty, V paramV)
  {
    paramProperty.set(paramT, paramV);
  }
  
  @UiThread
  public static <T extends View> void apply(@NonNull T paramT, @NonNull Action<? super T> paramAction)
  {
    paramAction.apply(paramT, 0);
  }
  
  @UiThread
  public static <T extends View, V> void apply(@NonNull T paramT, @NonNull Setter<? super T, V> paramSetter, V paramV)
  {
    paramSetter.set(paramT, paramV, 0);
  }
  
  @SafeVarargs
  @UiThread
  public static <T extends View> void apply(@NonNull T paramT, @NonNull Action<? super T>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].apply(paramT, 0);
      i += 1;
    }
  }
  
  @TargetApi(14)
  @RequiresApi(14)
  @UiThread
  public static <T extends View, V> void apply(@NonNull List<T> paramList, @NonNull Property<? super T, V> paramProperty, V paramV)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramProperty.set(paramList.get(i), paramV);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View> void apply(@NonNull List<T> paramList, @NonNull Action<? super T> paramAction)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramAction.apply((View)paramList.get(i), i);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View, V> void apply(@NonNull List<T> paramList, @NonNull Setter<? super T, V> paramSetter, V paramV)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramSetter.set((View)paramList.get(i), paramV, i);
      i += 1;
    }
  }
  
  @SafeVarargs
  @UiThread
  public static <T extends View> void apply(@NonNull List<T> paramList, @NonNull Action<? super T>... paramVarArgs)
  {
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      int m = paramVarArgs.length;
      int j = 0;
      while (j < m)
      {
        paramVarArgs[j].apply((View)paramList.get(i), i);
        j += 1;
      }
      i += 1;
    }
  }
  
  @TargetApi(14)
  @RequiresApi(14)
  @UiThread
  public static <T extends View, V> void apply(@NonNull T[] paramArrayOfT, @NonNull Property<? super T, V> paramProperty, V paramV)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramProperty.set(paramArrayOfT[i], paramV);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View> void apply(@NonNull T[] paramArrayOfT, @NonNull Action<? super T> paramAction)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramAction.apply(paramArrayOfT[i], i);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View, V> void apply(@NonNull T[] paramArrayOfT, @NonNull Setter<? super T, V> paramSetter, V paramV)
  {
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramSetter.set(paramArrayOfT[i], paramV, i);
      i += 1;
    }
  }
  
  @SafeVarargs
  @UiThread
  public static <T extends View> void apply(@NonNull T[] paramArrayOfT, @NonNull Action<? super T>... paramVarArgs)
  {
    int k = paramArrayOfT.length;
    int i = 0;
    while (i < k)
    {
      int m = paramVarArgs.length;
      int j = 0;
      while (j < m)
      {
        paramVarArgs[j].apply(paramArrayOfT[i], i);
        j += 1;
      }
      i += 1;
    }
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Activity paramActivity)
  {
    return createBinding(paramActivity, paramActivity.getWindow().getDecorView());
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Dialog paramDialog)
  {
    return createBinding(paramDialog, paramDialog.getWindow().getDecorView());
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull View paramView)
  {
    return createBinding(paramView, paramView);
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Object paramObject, @NonNull Activity paramActivity)
  {
    return createBinding(paramObject, paramActivity.getWindow().getDecorView());
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Object paramObject, @NonNull Dialog paramDialog)
  {
    return createBinding(paramObject, paramDialog.getWindow().getDecorView());
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Object paramObject, @NonNull View paramView)
  {
    return createBinding(paramObject, paramView);
  }
  
  private static Unbinder createBinding(@NonNull Object paramObject, @NonNull View paramView)
  {
    Object localObject = paramObject.getClass();
    if (debug)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Looking up binding for ");
      localStringBuilder.append(((Class)localObject).getName());
      Log.d("ButterKnife", localStringBuilder.toString());
    }
    localObject = findBindingConstructorForClass((Class)localObject);
    if (localObject == null) {
      return Unbinder.EMPTY;
    }
    try
    {
      paramObject = (Unbinder)((Constructor)localObject).newInstance(new Object[] { paramObject, paramView });
      return (Unbinder)paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = ((InvocationTargetException)paramObject).getCause();
      if (!(paramObject instanceof RuntimeException))
      {
        if ((paramObject instanceof Error)) {
          throw ((Error)paramObject);
        }
        throw new RuntimeException("Unable to create binding instance.", (Throwable)paramObject);
      }
      throw ((RuntimeException)paramObject);
    }
    catch (InstantiationException paramObject)
    {
      paramView = new StringBuilder();
      paramView.append("Unable to invoke ");
      paramView.append(localObject);
      throw new RuntimeException(paramView.toString(), (Throwable)paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      paramView = new StringBuilder();
      paramView.append("Unable to invoke ");
      paramView.append(localObject);
      throw new RuntimeException(paramView.toString(), (Throwable)paramObject);
    }
  }
  
  @CheckResult
  @Nullable
  @UiThread
  private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> paramClass)
  {
    Object localObject1 = (Constructor)BINDINGS.get(paramClass);
    if (localObject1 != null)
    {
      if (debug) {
        Log.d("ButterKnife", "HIT: Cached in binding map.");
      }
      return (Constructor<? extends Unbinder>)localObject1;
    }
    String str = paramClass.getName();
    if ((!str.startsWith("android.")) && (!str.startsWith("java."))) {}
    try
    {
      try
      {
        localObject1 = paramClass.getClassLoader();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("_ViewBinding");
        localObject2 = ((ClassLoader)localObject1).loadClass(((StringBuilder)localObject2).toString()).getConstructor(new Class[] { paramClass, View.class });
        localObject1 = localObject2;
        if (!debug) {
          break label217;
        }
        Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
        localObject1 = localObject2;
      }
      catch (NoSuchMethodException paramClass)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unable to find binding constructor for ");
        ((StringBuilder)localObject1).append(str);
        throw new RuntimeException(((StringBuilder)localObject1).toString(), paramClass);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    if (debug)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Not found. Trying superclass ");
      ((StringBuilder)localObject1).append(paramClass.getSuperclass().getName());
      Log.d("ButterKnife", ((StringBuilder)localObject1).toString());
    }
    localObject1 = findBindingConstructorForClass(paramClass.getSuperclass());
    label217:
    BINDINGS.put(paramClass, localObject1);
    return (Constructor<? extends Unbinder>)localObject1;
    if (debug) {
      Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
    }
    return null;
  }
  
  @Deprecated
  @CheckResult
  public static <T extends View> T findById(@NonNull Activity paramActivity, @IdRes int paramInt)
  {
    return paramActivity.findViewById(paramInt);
  }
  
  @Deprecated
  @CheckResult
  public static <T extends View> T findById(@NonNull Dialog paramDialog, @IdRes int paramInt)
  {
    return paramDialog.findViewById(paramInt);
  }
  
  @Deprecated
  @CheckResult
  public static <T extends View> T findById(@NonNull View paramView, @IdRes int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    debug = paramBoolean;
  }
  
  public static abstract interface Action<T extends View>
  {
    @UiThread
    public abstract void apply(@NonNull T paramT, int paramInt);
  }
  
  public static abstract interface Setter<T extends View, V>
  {
    @UiThread
    public abstract void set(@NonNull T paramT, V paramV, int paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\butterknife\ButterKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */