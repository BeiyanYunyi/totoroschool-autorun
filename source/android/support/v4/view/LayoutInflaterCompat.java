package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat
{
  private static final String TAG = "LayoutInflaterCompatHC";
  private static boolean sCheckedField;
  private static Field sLayoutInflaterFactory2Field;
  
  private static void forceSetFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!sCheckedField)
    {
      try
      {
        sLayoutInflaterFactory2Field = LayoutInflater.class.getDeclaredField("mFactory2");
        sLayoutInflaterFactory2Field.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
        localStringBuilder2.append(LayoutInflater.class.getName());
        localStringBuilder2.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", localStringBuilder2.toString(), localNoSuchFieldException);
      }
      sCheckedField = true;
    }
    if (sLayoutInflaterFactory2Field != null) {
      try
      {
        sLayoutInflaterFactory2Field.set(paramLayoutInflater, paramFactory2);
        return;
      }
      catch (IllegalAccessException paramFactory2)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
        localStringBuilder1.append(paramLayoutInflater);
        localStringBuilder1.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", localStringBuilder1.toString(), paramFactory2);
      }
    }
  }
  
  @Deprecated
  public static LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.getFactory();
    if ((paramLayoutInflater instanceof Factory2Wrapper)) {
      return ((Factory2Wrapper)paramLayoutInflater).mDelegateFactory;
    }
    return null;
  }
  
  @Deprecated
  public static void setFactory(@NonNull LayoutInflater paramLayoutInflater, @NonNull LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject2 = null;
    Object localObject1 = null;
    if (i >= 21)
    {
      if (paramLayoutInflaterFactory != null) {
        localObject1 = new Factory2Wrapper(paramLayoutInflaterFactory);
      }
      paramLayoutInflater.setFactory2((LayoutInflater.Factory2)localObject1);
      return;
    }
    localObject1 = localObject2;
    if (paramLayoutInflaterFactory != null) {
      localObject1 = new Factory2Wrapper(paramLayoutInflaterFactory);
    }
    paramLayoutInflater.setFactory2((LayoutInflater.Factory2)localObject1);
    paramLayoutInflaterFactory = paramLayoutInflater.getFactory();
    if ((paramLayoutInflaterFactory instanceof LayoutInflater.Factory2))
    {
      forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)paramLayoutInflaterFactory);
      return;
    }
    forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localObject1);
  }
  
  public static void setFactory2(@NonNull LayoutInflater paramLayoutInflater, @NonNull LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21)
    {
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2))
      {
        forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        return;
      }
      forceSetFactory2(paramLayoutInflater, paramFactory2);
    }
  }
  
  static class Factory2Wrapper
    implements LayoutInflater.Factory2
  {
    final LayoutInflaterFactory mDelegateFactory;
    
    Factory2Wrapper(LayoutInflaterFactory paramLayoutInflaterFactory)
    {
      this.mDelegateFactory = paramLayoutInflaterFactory;
    }
    
    public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      return this.mDelegateFactory.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    
    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      return this.mDelegateFactory.onCreateView(null, paramString, paramContext, paramAttributeSet);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getName());
      localStringBuilder.append("{");
      localStringBuilder.append(this.mDelegateFactory);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\LayoutInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */