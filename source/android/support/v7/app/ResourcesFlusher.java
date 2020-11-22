package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher
{
  private static final String TAG = "ResourcesFlusher";
  private static Field sDrawableCacheField;
  private static boolean sDrawableCacheFieldFetched;
  private static Field sResourcesImplField;
  private static boolean sResourcesImplFieldFetched;
  private static Class sThemedResourceCacheClazz;
  private static boolean sThemedResourceCacheClazzFetched;
  private static Field sThemedResourceCache_mUnthemedEntriesField;
  private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
  
  static void flush(@NonNull Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      flushNougats(paramResources);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      flushMarshmallows(paramResources);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      flushLollipops(paramResources);
    }
  }
  
  @RequiresApi(21)
  private static void flushLollipops(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    if (sDrawableCacheField != null)
    {
      try
      {
        paramResources = (Map)sDrawableCacheField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        paramResources = null;
      }
      if (paramResources != null) {
        paramResources.clear();
      }
    }
  }
  
  @RequiresApi(23)
  private static void flushMarshmallows(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    if (sDrawableCacheField != null) {
      try
      {
        paramResources = sDrawableCacheField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
      }
    } else {
      paramResources = null;
    }
    if (paramResources == null) {
      return;
    }
    flushThemedResourcesCache(paramResources);
  }
  
  @RequiresApi(24)
  private static void flushNougats(@NonNull Resources paramResources)
  {
    if (!sResourcesImplFieldFetched)
    {
      try
      {
        sResourcesImplField = Resources.class.getDeclaredField("mResourcesImpl");
        sResourcesImplField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
      }
      sResourcesImplFieldFetched = true;
    }
    if (sResourcesImplField == null) {
      return;
    }
    try
    {
      paramResources = sResourcesImplField.get(paramResources);
    }
    catch (IllegalAccessException paramResources)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", paramResources);
      paramResources = null;
    }
    if (paramResources == null) {
      return;
    }
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = paramResources.getClass().getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException2);
      }
      sDrawableCacheFieldFetched = true;
    }
    if (sDrawableCacheField != null) {
      try
      {
        paramResources = sDrawableCacheField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", paramResources);
      }
    } else {
      paramResources = null;
    }
    if (paramResources != null) {
      flushThemedResourcesCache(paramResources);
    }
  }
  
  @RequiresApi(16)
  private static void flushThemedResourcesCache(@NonNull Object paramObject)
  {
    if (!sThemedResourceCacheClazzFetched)
    {
      try
      {
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
      }
      sThemedResourceCacheClazzFetched = true;
    }
    if (sThemedResourceCacheClazz == null) {
      return;
    }
    if (!sThemedResourceCache_mUnthemedEntriesFieldFetched)
    {
      try
      {
        sThemedResourceCache_mUnthemedEntriesField = sThemedResourceCacheClazz.getDeclaredField("mUnthemedEntries");
        sThemedResourceCache_mUnthemedEntriesField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
      }
      sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    }
    if (sThemedResourceCache_mUnthemedEntriesField == null) {
      return;
    }
    try
    {
      paramObject = (LongSparseArray)sThemedResourceCache_mUnthemedEntriesField.get(paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", (Throwable)paramObject);
      paramObject = null;
    }
    if (paramObject != null) {
      ((LongSparseArray)paramObject).clear();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\app\ResourcesFlusher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */