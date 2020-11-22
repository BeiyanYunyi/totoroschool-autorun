package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Timer;

public class DexClassLoaderProvider
  extends DexClassLoader
{
  private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
  private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
  private static final long LOAD_DEX_DELAY = 3000L;
  private static final String LOGTAG = "dexloader";
  protected static DexClassLoader mClassLoaderOriginal;
  private static Context mContext;
  private static boolean mForceLoadDexFlag = false;
  private static DexClassLoaderProvider mInstance;
  private static String mRealDexPath;
  protected static Service mService;
  private SpeedyDexClassLoader mClassLoader = null;
  
  private DexClassLoaderProvider(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    if (paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append("SpeedyDexClassLoader: ");
      paramString1.append(mRealDexPath);
      Log.e("dexloader", paramString1.toString());
      this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, paramString3, paramClassLoader);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("DexClassLoader: ");
    paramString1.append(mRealDexPath);
    Log.e("dexloader", paramString1.toString());
    this.mClassLoader = null;
  }
  
  public static DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
    mRealDexPath = paramString1;
    int i = paramString1.lastIndexOf("/") + 1;
    paramContext = paramString1.substring(0, i);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("fake_dex.jar");
    paramContext = ((StringBuilder)localObject).toString();
    localObject = paramString1.substring(i);
    if ((supportSpeedyClassLoader()) && (is_first_load_tbs_dex(paramString2, (String)localObject)))
    {
      set_first_load_tbs_dex(paramString2, (String)localObject);
      mInstance = new DexClassLoaderProvider(paramContext, paramString2, paramString3, paramClassLoader, true);
      doAsyncDexLoad((String)localObject, paramString1, paramString2, paramString3, paramClassLoader);
    }
    else
    {
      mInstance = new DexClassLoaderProvider(paramString1, paramString2, paramString3, paramClassLoader, false);
    }
    return mInstance;
  }
  
  private static void doAsyncDexLoad(String paramString1, String paramString2, String paramString3, String paramString4, ClassLoader paramClassLoader)
  {
    if (shouldUseDexLoaderService())
    {
      new Timer().schedule(new DexClassLoaderProvider.1(paramString1, paramString2, paramString3, paramString4), 3000L);
      return;
    }
    new Timer().schedule(new DexClassLoaderProvider.2(paramString2, paramString3, paramString4, paramClassLoader, paramString1), 3000L);
  }
  
  private static boolean is_first_load_tbs_dex(String paramString1, String paramString2)
  {
    if (mForceLoadDexFlag) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append("is_first_load_dex_flag_file");
    return !new File(paramString1, localStringBuilder.toString()).exists();
  }
  
  static void setForceLoadDexFlag(boolean paramBoolean, Service paramService)
  {
    mForceLoadDexFlag = paramBoolean;
    mService = paramService;
  }
  
  private static void set_first_load_tbs_dex(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append("is_first_load_dex_flag_file");
    paramString1 = new File(paramString1, localStringBuilder.toString());
    if (!paramString1.exists()) {
      try
      {
        paramString1.createNewFile();
        return;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private static boolean shouldUseDexLoaderService()
  {
    if (mForceLoadDexFlag) {
      return false;
    }
    return DexLoader.mCanUseDexLoaderProviderService;
  }
  
  private static boolean supportSpeedyClassLoader()
  {
    return (Build.VERSION.SDK_INT != 21) || (DexLoader.mCanUseDexLoaderProviderService);
  }
  
  private boolean useSelfClassloader()
  {
    return this.mClassLoader == null;
  }
  
  public void clearAssertionStatus()
  {
    if (useSelfClassloader())
    {
      super.clearAssertionStatus();
      return;
    }
    this.mClassLoader.clearAssertionStatus();
  }
  
  protected Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
  {
    if (useSelfClassloader()) {
      return super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
    }
    return this.mClassLoader.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
  }
  
  protected Class<?> findClass(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findClass(paramString);
    }
    return this.mClassLoader.findClass(paramString);
  }
  
  public String findLibrary(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findLibrary(paramString);
    }
    return this.mClassLoader.findLibrary(paramString);
  }
  
  protected URL findResource(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findResource(paramString);
    }
    return this.mClassLoader.findResource(paramString);
  }
  
  protected Enumeration<URL> findResources(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findResources(paramString);
    }
    return this.mClassLoader.findResources(paramString);
  }
  
  protected Package getPackage(String paramString)
  {
    try
    {
      if (useSelfClassloader())
      {
        paramString = super.getPackage(paramString);
        return paramString;
      }
      paramString = this.mClassLoader.getPackage(paramString);
      return paramString;
    }
    finally {}
  }
  
  protected Package[] getPackages()
  {
    if (useSelfClassloader()) {
      return super.getPackages();
    }
    return this.mClassLoader.getPackages();
  }
  
  public URL getResource(String paramString)
  {
    if (useSelfClassloader()) {
      return super.getResource(paramString);
    }
    return this.mClassLoader.getResource(paramString);
  }
  
  public InputStream getResourceAsStream(String paramString)
  {
    if (useSelfClassloader()) {
      return getResourceAsStream(paramString);
    }
    return this.mClassLoader.getResourceAsStream(paramString);
  }
  
  public Enumeration<URL> getResources(String paramString)
  {
    if (useSelfClassloader()) {
      return super.getResources(paramString);
    }
    return this.mClassLoader.getResources(paramString);
  }
  
  public Class<?> loadClass(String paramString)
  {
    if (useSelfClassloader()) {
      return super.loadClass(paramString);
    }
    return this.mClassLoader.loadClass(paramString);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader()) {
      return super.loadClass(paramString, paramBoolean);
    }
    return this.mClassLoader.loadClass(paramString, paramBoolean);
  }
  
  public void setClassAssertionStatus(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setClassAssertionStatus(paramString, paramBoolean);
      return;
    }
    this.mClassLoader.setClassAssertionStatus(paramString, paramBoolean);
  }
  
  public void setDefaultAssertionStatus(boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setDefaultAssertionStatus(paramBoolean);
      return;
    }
    this.mClassLoader.setDefaultAssertionStatus(paramBoolean);
  }
  
  public void setPackageAssertionStatus(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setPackageAssertionStatus(paramString, paramBoolean);
      return;
    }
    this.mClassLoader.setPackageAssertionStatus(paramString, paramBoolean);
  }
  
  public String toString()
  {
    if (useSelfClassloader()) {
      return super.toString();
    }
    return this.mClassLoader.toString();
  }
  
  private static class SpeedyDexClassLoader
    extends BaseDexClassLoader
  {
    public SpeedyDexClassLoader(String paramString1, File paramFile, String paramString2, ClassLoader paramClassLoader)
    {
      super(null, paramString2, paramClassLoader);
    }
    
    public Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
    {
      return super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
    }
    
    public Class<?> findClass(String paramString)
    {
      return super.findClass(paramString);
    }
    
    public URL findResource(String paramString)
    {
      return super.findResource(paramString);
    }
    
    public Enumeration<URL> findResources(String paramString)
    {
      return super.findResources(paramString);
    }
    
    public Package getPackage(String paramString)
    {
      try
      {
        paramString = super.getPackage(paramString);
        return paramString;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public Package[] getPackages()
    {
      return super.getPackages();
    }
    
    public Class<?> loadClass(String paramString, boolean paramBoolean)
    {
      return super.loadClass(paramString, paramBoolean);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\DexClassLoaderProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */