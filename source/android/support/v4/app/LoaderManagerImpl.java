package android.support.v4.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.j;
import android.arch.lifecycle.k;
import android.arch.lifecycle.n;
import android.arch.lifecycle.o;
import android.arch.lifecycle.o.a;
import android.arch.lifecycle.p;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  @NonNull
  private final e mLifecycleOwner;
  @NonNull
  private final LoaderViewModel mLoaderViewModel;
  
  LoaderManagerImpl(@NonNull e parame, @NonNull p paramp)
  {
    this.mLifecycleOwner = parame;
    this.mLoaderViewModel = LoaderViewModel.getInstance(paramp);
  }
  
  @MainThread
  @NonNull
  private <D> Loader<D> createAndInstallLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks, @Nullable Loader<D> paramLoader)
  {
    try
    {
      this.mLoaderViewModel.startCreatingLoader();
      Loader localLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
      if (localLoader != null)
      {
        if ((localLoader.getClass().isMemberClass()) && (!Modifier.isStatic(localLoader.getClass().getModifiers())))
        {
          paramBundle = new StringBuilder();
          paramBundle.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
          paramBundle.append(localLoader);
          throw new IllegalArgumentException(paramBundle.toString());
        }
        paramBundle = new LoaderInfo(paramInt, paramBundle, localLoader, paramLoader);
        if (DEBUG)
        {
          paramLoader = new StringBuilder();
          paramLoader.append("  Created new loader ");
          paramLoader.append(paramBundle);
          Log.v("LoaderManager", paramLoader.toString());
        }
        this.mLoaderViewModel.putLoader(paramInt, paramBundle);
        return paramBundle.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
      }
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
    }
    finally
    {
      this.mLoaderViewModel.finishCreatingLoader();
    }
  }
  
  @MainThread
  public void destroyLoader(int paramInt)
  {
    if (!this.mLoaderViewModel.isCreatingLoader())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        if (DEBUG)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("destroyLoader in ");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(" of ");
          ((StringBuilder)localObject).append(paramInt);
          Log.v("LoaderManager", ((StringBuilder)localObject).toString());
        }
        Object localObject = this.mLoaderViewModel.getLoader(paramInt);
        if (localObject != null)
        {
          ((LoaderInfo)localObject).destroy(true);
          this.mLoaderViewModel.removeLoader(paramInt);
        }
        return;
      }
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.mLoaderViewModel.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (!this.mLoaderViewModel.isCreatingLoader())
    {
      LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
      if (localLoaderInfo != null) {
        return localLoaderInfo.getLoader();
      }
      return null;
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public boolean hasRunningLoaders()
  {
    return this.mLoaderViewModel.hasRunningLoaders();
  }
  
  @MainThread
  @NonNull
  public <D> Loader<D> initLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (!this.mLoaderViewModel.isCreatingLoader())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
        if (DEBUG)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initLoader in ");
          localStringBuilder.append(this);
          localStringBuilder.append(": args=");
          localStringBuilder.append(paramBundle);
          Log.v("LoaderManager", localStringBuilder.toString());
        }
        if (localLoaderInfo == null) {
          return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, null);
        }
        if (DEBUG)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("  Re-using existing loader ");
          paramBundle.append(localLoaderInfo);
          Log.v("LoaderManager", paramBundle.toString());
        }
        return localLoaderInfo.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
      }
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public void markForRedelivery()
  {
    this.mLoaderViewModel.markForRedelivery();
  }
  
  @MainThread
  @NonNull
  public <D> Loader<D> restartLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (!this.mLoaderViewModel.isCreatingLoader())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        if (DEBUG)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restartLoader in ");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(": args=");
          ((StringBuilder)localObject).append(paramBundle);
          Log.v("LoaderManager", ((StringBuilder)localObject).toString());
        }
        LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
        Object localObject = null;
        if (localLoaderInfo != null) {
          localObject = localLoaderInfo.destroy(false);
        }
        return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, (Loader)localObject);
      }
      throw new IllegalStateException("restartLoader must be called on the main thread");
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mLifecycleOwner, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public static class LoaderInfo<D>
    extends j<D>
    implements Loader.OnLoadCompleteListener<D>
  {
    @Nullable
    private final Bundle mArgs;
    private final int mId;
    private e mLifecycleOwner;
    @NonNull
    private final Loader<D> mLoader;
    private LoaderManagerImpl.LoaderObserver<D> mObserver;
    private Loader<D> mPriorLoader;
    
    LoaderInfo(int paramInt, @Nullable Bundle paramBundle, @NonNull Loader<D> paramLoader1, @Nullable Loader<D> paramLoader2)
    {
      this.mId = paramInt;
      this.mArgs = paramBundle;
      this.mLoader = paramLoader1;
      this.mPriorLoader = paramLoader2;
      this.mLoader.registerListener(paramInt, this);
    }
    
    @MainThread
    Loader<D> destroy(boolean paramBoolean)
    {
      if (LoaderManagerImpl.DEBUG)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  Destroying: ");
        ((StringBuilder)localObject).append(this);
        Log.v("LoaderManager", ((StringBuilder)localObject).toString());
      }
      this.mLoader.cancelLoad();
      this.mLoader.abandon();
      Object localObject = this.mObserver;
      if (localObject != null)
      {
        removeObserver((k)localObject);
        if (paramBoolean) {
          ((LoaderManagerImpl.LoaderObserver)localObject).reset();
        }
      }
      this.mLoader.unregisterListener(this);
      if (((localObject != null) && (!((LoaderManagerImpl.LoaderObserver)localObject).hasDeliveredData())) || (paramBoolean))
      {
        this.mLoader.reset();
        return this.mPriorLoader;
      }
      return this.mLoader;
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.mId);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.mArgs);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.mLoader);
      Loader localLoader = this.mLoader;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("  ");
      localLoader.dump(localStringBuilder.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      if (this.mObserver != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(this.mObserver);
        paramFileDescriptor = this.mObserver;
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append(paramString);
        paramArrayOfString.append("  ");
        paramFileDescriptor.dump(paramArrayOfString.toString(), paramPrintWriter);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      paramPrintWriter.println(getLoader().dataToString(getValue()));
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.println(hasActiveObservers());
    }
    
    @NonNull
    Loader<D> getLoader()
    {
      return this.mLoader;
    }
    
    boolean isCallbackWaitingForData()
    {
      boolean bool1 = hasActiveObservers();
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      bool1 = bool2;
      if (this.mObserver != null)
      {
        bool1 = bool2;
        if (!this.mObserver.hasDeliveredData()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    void markForRedelivery()
    {
      e locale = this.mLifecycleOwner;
      LoaderManagerImpl.LoaderObserver localLoaderObserver = this.mObserver;
      if ((locale != null) && (localLoaderObserver != null))
      {
        super.removeObserver(localLoaderObserver);
        observe(locale, localLoaderObserver);
      }
    }
    
    protected void onActive()
    {
      if (LoaderManagerImpl.DEBUG)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Starting: ");
        localStringBuilder.append(this);
        Log.v("LoaderManager", localStringBuilder.toString());
      }
      this.mLoader.startLoading();
    }
    
    protected void onInactive()
    {
      if (LoaderManagerImpl.DEBUG)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Stopping: ");
        localStringBuilder.append(this);
        Log.v("LoaderManager", localStringBuilder.toString());
      }
      this.mLoader.stopLoading();
    }
    
    public void onLoadComplete(@NonNull Loader<D> paramLoader, @Nullable D paramD)
    {
      if (LoaderManagerImpl.DEBUG)
      {
        paramLoader = new StringBuilder();
        paramLoader.append("onLoadComplete: ");
        paramLoader.append(this);
        Log.v("LoaderManager", paramLoader.toString());
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramD);
        return;
      }
      if (LoaderManagerImpl.DEBUG) {
        Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
      }
      postValue(paramD);
    }
    
    public void removeObserver(@NonNull k<? super D> paramk)
    {
      super.removeObserver(paramk);
      this.mLifecycleOwner = null;
      this.mObserver = null;
    }
    
    @MainThread
    @NonNull
    Loader<D> setCallback(@NonNull e parame, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
    {
      paramLoaderCallbacks = new LoaderManagerImpl.LoaderObserver(this.mLoader, paramLoaderCallbacks);
      observe(parame, paramLoaderCallbacks);
      if (this.mObserver != null) {
        removeObserver(this.mObserver);
      }
      this.mLifecycleOwner = parame;
      this.mObserver = paramLoaderCallbacks;
      return this.mLoader;
    }
    
    public void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.mPriorLoader != null)
      {
        this.mPriorLoader.reset();
        this.mPriorLoader = null;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mId);
      localStringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static class LoaderObserver<D>
    implements k<D>
  {
    @NonNull
    private final LoaderManager.LoaderCallbacks<D> mCallback;
    private boolean mDeliveredData = false;
    @NonNull
    private final Loader<D> mLoader;
    
    LoaderObserver(@NonNull Loader<D> paramLoader, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
    {
      this.mLoader = paramLoader;
      this.mCallback = paramLoaderCallbacks;
    }
    
    public void dump(String paramString, PrintWriter paramPrintWriter)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mDeliveredData=");
      paramPrintWriter.println(this.mDeliveredData);
    }
    
    boolean hasDeliveredData()
    {
      return this.mDeliveredData;
    }
    
    public void onChanged(@Nullable D paramD)
    {
      if (LoaderManagerImpl.DEBUG)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  onLoadFinished in ");
        localStringBuilder.append(this.mLoader);
        localStringBuilder.append(": ");
        localStringBuilder.append(this.mLoader.dataToString(paramD));
        Log.v("LoaderManager", localStringBuilder.toString());
      }
      this.mCallback.onLoadFinished(this.mLoader, paramD);
      this.mDeliveredData = true;
    }
    
    @MainThread
    void reset()
    {
      if (this.mDeliveredData)
      {
        if (LoaderManagerImpl.DEBUG)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("  Resetting: ");
          localStringBuilder.append(this.mLoader);
          Log.v("LoaderManager", localStringBuilder.toString());
        }
        this.mCallback.onLoaderReset(this.mLoader);
      }
    }
    
    public String toString()
    {
      return this.mCallback.toString();
    }
  }
  
  static class LoaderViewModel
    extends n
  {
    private static final o.a FACTORY = new o.a()
    {
      @NonNull
      public <T extends n> T create(@NonNull Class<T> paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    private boolean mCreatingLoader = false;
    private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();
    
    @NonNull
    static LoaderViewModel getInstance(p paramp)
    {
      return (LoaderViewModel)new o(paramp, FACTORY).a(LoaderViewModel.class);
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      if (this.mLoaders.size() > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Loaders:");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("    ");
        localObject = ((StringBuilder)localObject).toString();
        int i = 0;
        while (i < this.mLoaders.size())
        {
          LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(this.mLoaders.keyAt(i));
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localLoaderInfo.toString());
          localLoaderInfo.dump((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i += 1;
        }
      }
    }
    
    void finishCreatingLoader()
    {
      this.mCreatingLoader = false;
    }
    
    <D> LoaderManagerImpl.LoaderInfo<D> getLoader(int paramInt)
    {
      return (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    }
    
    boolean hasRunningLoaders()
    {
      int j = this.mLoaders.size();
      int i = 0;
      while (i < j)
      {
        if (((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).isCallbackWaitingForData()) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    boolean isCreatingLoader()
    {
      return this.mCreatingLoader;
    }
    
    void markForRedelivery()
    {
      int j = this.mLoaders.size();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).markForRedelivery();
        i += 1;
      }
    }
    
    protected void onCleared()
    {
      super.onCleared();
      int j = this.mLoaders.size();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).destroy(true);
        i += 1;
      }
      this.mLoaders.clear();
    }
    
    void putLoader(int paramInt, @NonNull LoaderManagerImpl.LoaderInfo paramLoaderInfo)
    {
      this.mLoaders.put(paramInt, paramLoaderInfo);
    }
    
    void removeLoader(int paramInt)
    {
      this.mLoaders.remove(paramInt);
    }
    
    void startCreatingLoader()
    {
      this.mCreatingLoader = true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\LoaderManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */