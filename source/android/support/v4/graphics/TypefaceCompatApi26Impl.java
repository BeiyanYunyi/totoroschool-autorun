package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi26Impl
  extends TypefaceCompatApi21Impl
{
  private static final String ABORT_CREATION_METHOD = "abortCreation";
  private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
  private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String DEFAULT_FAMILY = "sans-serif";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String FREEZE_METHOD = "freeze";
  private static final int RESOLVE_BY_FONT_TABLE = -1;
  private static final String TAG = "TypefaceCompatApi26Impl";
  protected final Method mAbortCreation;
  protected final Method mAddFontFromAssetManager;
  protected final Method mAddFontFromBuffer;
  protected final Method mCreateFromFamiliesWithDefault;
  protected final Class mFontFamily;
  protected final Constructor mFontFamilyCtor;
  protected final Method mFreeze;
  
  public TypefaceCompatApi26Impl()
  {
    Object localObject9 = null;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject1;
    try
    {
      Class localClass = obtainFontFamily();
      localObject2 = obtainFontFamilyCtor(localClass);
      localObject3 = obtainAddFontFromAssetManagerMethod(localClass);
      localObject4 = obtainAddFontFromBufferMethod(localClass);
      localObject5 = obtainFreezeMethod(localClass);
      localObject6 = obtainAbortCreationMethod(localClass);
      localObject7 = obtainCreateFromFamiliesWithDefaultMethod(localClass);
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Unable to collect necessary methods for class ");
      ((StringBuilder)localObject2).append(localClassNotFoundException.getClass().getName());
      Log.e("TypefaceCompatApi26Impl", ((StringBuilder)localObject2).toString(), localClassNotFoundException);
      Object localObject8 = null;
      localObject1 = localObject8;
      localObject2 = localObject1;
      localObject3 = localObject2;
      localObject4 = localObject3;
      localObject7 = localObject4;
      localObject6 = localObject4;
      localObject5 = localObject3;
      localObject4 = localObject2;
      localObject3 = localObject1;
      localObject2 = localObject8;
      localObject1 = localObject9;
    }
    this.mFontFamily = ((Class)localObject1);
    this.mFontFamilyCtor = ((Constructor)localObject2);
    this.mAddFontFromAssetManager = ((Method)localObject3);
    this.mAddFontFromBuffer = ((Method)localObject4);
    this.mFreeze = ((Method)localObject5);
    this.mAbortCreation = ((Method)localObject6);
    this.mCreateFromFamiliesWithDefault = ((Method)localObject7);
  }
  
  private void abortCreation(Object paramObject)
  {
    try
    {
      this.mAbortCreation.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
  }
  
  private boolean addFontFromAssetManager(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      boolean bool = ((Boolean)this.mAddFontFromAssetManager.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
  }
  
  private boolean addFontFromBuffer(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)this.mAddFontFromBuffer.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
  }
  
  private boolean freeze(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.mFreeze.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
  }
  
  private boolean isFontFamilyPrivateAPIAvailable()
  {
    if (this.mAddFontFromAssetManager == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    }
    return this.mAddFontFromAssetManager != null;
  }
  
  private Object newFamily()
  {
    try
    {
      Object localObject = this.mFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException|InstantiationException|InvocationTargetException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }
  
  protected Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.mFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.mCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return (Typeface)paramObject;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
  }
  
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Typeface createFromFontInfo(Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    paramResources = newFamily();
    if (!addFontFromAssetManager(paramContext, paramResources, paramString, 0, -1, -1, null))
    {
      abortCreation(paramResources);
      return null;
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
  
  protected Method obtainAbortCreationMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("abortCreation", new Class[0]);
  }
  
  protected Method obtainAddFontFromAssetManagerMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class });
  }
  
  protected Method obtainAddFontFromBufferMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE });
  }
  
  protected Method obtainCreateFromFamiliesWithDefaultMethod(Class paramClass)
    throws NoSuchMethodException
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  protected Class obtainFontFamily()
    throws ClassNotFoundException
  {
    return Class.forName("android.graphics.FontFamily");
  }
  
  protected Constructor obtainFontFamilyCtor(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getConstructor(new Class[0]);
  }
  
  protected Method obtainFreezeMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("freeze", new Class[0]);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\graphics\TypefaceCompatApi26Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */