package retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class Platform
{
  private static final Platform PLATFORM = ;
  
  private static Platform findPlatform()
  {
    try
    {
      Class.forName("android.os.Build");
      if (Build.VERSION.SDK_INT != 0)
      {
        localObject = new Android();
        return (Platform)localObject;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      Object localObject;
      label38:
      for (;;) {}
    }
    try
    {
      Class.forName("java.util.Optional");
      localObject = new Java8();
      return (Platform)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label38;
    }
    return new Platform();
  }
  
  static Platform get()
  {
    return PLATFORM;
  }
  
  List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor paramExecutor)
  {
    if (paramExecutor != null) {
      return Collections.singletonList(new ExecutorCallAdapterFactory(paramExecutor));
    }
    return Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
  }
  
  int defaultCallAdapterFactoriesSize()
  {
    return 1;
  }
  
  @Nullable
  Executor defaultCallbackExecutor()
  {
    return null;
  }
  
  List<? extends Converter.Factory> defaultConverterFactories()
  {
    return Collections.emptyList();
  }
  
  int defaultConverterFactoriesSize()
  {
    return 0;
  }
  
  @Nullable
  Object invokeDefaultMethod(Method paramMethod, Class<?> paramClass, Object paramObject, @Nullable Object... paramVarArgs)
    throws Throwable
  {
    throw new UnsupportedOperationException();
  }
  
  boolean isDefaultMethod(Method paramMethod)
  {
    return false;
  }
  
  static class Android
    extends Platform
  {
    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor paramExecutor)
    {
      if (paramExecutor != null)
      {
        paramExecutor = new ExecutorCallAdapterFactory(paramExecutor);
        if (Build.VERSION.SDK_INT >= 24) {
          return Arrays.asList(new CallAdapter.Factory[] { CompletableFutureCallAdapterFactory.INSTANCE, paramExecutor });
        }
        return Collections.singletonList(paramExecutor);
      }
      throw new AssertionError();
    }
    
    int defaultCallAdapterFactoriesSize()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return 2;
      }
      return 1;
    }
    
    public Executor defaultCallbackExecutor()
    {
      return new MainThreadExecutor();
    }
    
    List<? extends Converter.Factory> defaultConverterFactories()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return Collections.singletonList(OptionalConverterFactory.INSTANCE);
      }
      return Collections.emptyList();
    }
    
    int defaultConverterFactoriesSize()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return 1;
      }
      return 0;
    }
    
    @IgnoreJRERequirement
    boolean isDefaultMethod(Method paramMethod)
    {
      if (Build.VERSION.SDK_INT < 24) {
        return false;
      }
      return paramMethod.isDefault();
    }
    
    static class MainThreadExecutor
      implements Executor
    {
      private final Handler handler = new Handler(Looper.getMainLooper());
      
      public void execute(Runnable paramRunnable)
      {
        this.handler.post(paramRunnable);
      }
    }
  }
  
  @IgnoreJRERequirement
  static class Java8
    extends Platform
  {
    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor paramExecutor)
    {
      ArrayList localArrayList = new ArrayList(2);
      localArrayList.add(CompletableFutureCallAdapterFactory.INSTANCE);
      if (paramExecutor != null) {
        localArrayList.add(new ExecutorCallAdapterFactory(paramExecutor));
      } else {
        localArrayList.add(DefaultCallAdapterFactory.INSTANCE);
      }
      return Collections.unmodifiableList(localArrayList);
    }
    
    int defaultCallAdapterFactoriesSize()
    {
      return 2;
    }
    
    List<? extends Converter.Factory> defaultConverterFactories()
    {
      return Collections.singletonList(OptionalConverterFactory.INSTANCE);
    }
    
    int defaultConverterFactoriesSize()
    {
      return 1;
    }
    
    Object invokeDefaultMethod(Method paramMethod, Class<?> paramClass, Object paramObject, @Nullable Object... paramVarArgs)
      throws Throwable
    {
      Constructor localConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[] { Class.class, Integer.TYPE });
      localConstructor.setAccessible(true);
      return ((MethodHandles.Lookup)localConstructor.newInstance(new Object[] { paramClass, Integer.valueOf(-1) })).unreflectSpecial(paramMethod, paramClass).bindTo(paramObject).invokeWithArguments(paramVarArgs);
    }
    
    boolean isDefaultMethod(Method paramMethod)
    {
      return paramMethod.isDefault();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */