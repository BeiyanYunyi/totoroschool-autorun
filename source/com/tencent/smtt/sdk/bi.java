package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

class bi
{
  protected DexLoader a = null;
  
  public bi(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public Object a(Context paramContext)
  {
    DexLoader localDexLoader = this.a;
    DexClassLoader localDexClassLoader = this.a.getClassLoader();
    return localDexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[] { Context.class, DexClassLoader.class }, new Object[] { paramContext, localDexClassLoader });
  }
  
  public void a(Object paramObject)
  {
    this.a.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
  }
  
  public void a(Object paramObject, Activity paramActivity, int paramInt)
  {
    this.a.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[] { Activity.class, Integer.TYPE }, new Object[] { paramActivity, Integer.valueOf(paramInt) });
  }
  
  public boolean a(Object paramObject1, Bundle paramBundle, FrameLayout paramFrameLayout, Object paramObject2)
  {
    Object localObject1;
    Object localObject2;
    if (paramObject2 != null)
    {
      localObject1 = this.a;
      localObject2 = new Class[3];
      localObject2[0] = Bundle.class;
      localObject2[1] = FrameLayout.class;
      localObject2[2] = Object.class;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramBundle;
      arrayOfObject[1] = paramFrameLayout;
      arrayOfObject[2] = paramObject2;
      paramObject2 = arrayOfObject;
      paramFrameLayout = (FrameLayout)localObject2;
      paramBundle = (Bundle)localObject1;
    }
    for (;;)
    {
      paramObject1 = paramBundle.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", paramFrameLayout, (Object[])paramObject2);
      break;
      localObject2 = this.a;
      localObject1 = new Class[2];
      localObject1[0] = Bundle.class;
      localObject1[1] = FrameLayout.class;
      paramObject2 = new Object[2];
      paramObject2[0] = paramBundle;
      paramObject2[1] = paramFrameLayout;
      paramBundle = (Bundle)localObject2;
      paramFrameLayout = (FrameLayout)localObject1;
    }
    if ((paramObject1 instanceof Boolean)) {
      return ((Boolean)paramObject1).booleanValue();
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */