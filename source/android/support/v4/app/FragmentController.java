package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class FragmentController
{
  private final FragmentHostCallback<?> mHost;
  
  private FragmentController(FragmentHostCallback<?> paramFragmentHostCallback)
  {
    this.mHost = paramFragmentHostCallback;
  }
  
  public static FragmentController createController(FragmentHostCallback<?> paramFragmentHostCallback)
  {
    return new FragmentController(paramFragmentHostCallback);
  }
  
  public void attachHost(Fragment paramFragment)
  {
    this.mHost.mFragmentManager.attachController(this.mHost, this.mHost, paramFragment);
  }
  
  public void dispatchActivityCreated()
  {
    this.mHost.mFragmentManager.dispatchActivityCreated();
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    this.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    return this.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void dispatchCreate()
  {
    this.mHost.mFragmentManager.dispatchCreate();
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public void dispatchDestroy()
  {
    this.mHost.mFragmentManager.dispatchDestroy();
  }
  
  public void dispatchDestroyView()
  {
    this.mHost.mFragmentManager.dispatchDestroyView();
  }
  
  public void dispatchLowMemory()
  {
    this.mHost.mFragmentManager.dispatchLowMemory();
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    this.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu);
  }
  
  public void dispatchPause()
  {
    this.mHost.mFragmentManager.dispatchPause();
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
  }
  
  @Deprecated
  public void dispatchReallyStop() {}
  
  public void dispatchResume()
  {
    this.mHost.mFragmentManager.dispatchResume();
  }
  
  public void dispatchStart()
  {
    this.mHost.mFragmentManager.dispatchStart();
  }
  
  public void dispatchStop()
  {
    this.mHost.mFragmentManager.dispatchStop();
  }
  
  @Deprecated
  public void doLoaderDestroy() {}
  
  @Deprecated
  public void doLoaderRetain() {}
  
  @Deprecated
  public void doLoaderStart() {}
  
  @Deprecated
  public void doLoaderStop(boolean paramBoolean) {}
  
  @Deprecated
  public void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean execPendingActions()
  {
    return this.mHost.mFragmentManager.execPendingActions();
  }
  
  @Nullable
  public Fragment findFragmentByWho(String paramString)
  {
    return this.mHost.mFragmentManager.findFragmentByWho(paramString);
  }
  
  public List<Fragment> getActiveFragments(List<Fragment> paramList)
  {
    return this.mHost.mFragmentManager.getActiveFragments();
  }
  
  public int getActiveFragmentsCount()
  {
    return this.mHost.mFragmentManager.getActiveFragmentCount();
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.mHost.getFragmentManagerImpl();
  }
  
  @Deprecated
  public LoaderManager getSupportLoaderManager()
  {
    throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
  }
  
  public void noteStateNotSaved()
  {
    this.mHost.mFragmentManager.noteStateNotSaved();
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mHost.mFragmentManager.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  @Deprecated
  public void reportLoaderStart() {}
  
  public void restoreAllState(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    this.mHost.mFragmentManager.restoreAllState(paramParcelable, paramFragmentManagerNonConfig);
  }
  
  @Deprecated
  public void restoreAllState(Parcelable paramParcelable, List<Fragment> paramList)
  {
    this.mHost.mFragmentManager.restoreAllState(paramParcelable, new FragmentManagerNonConfig(paramList, null, null));
  }
  
  @Deprecated
  public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> paramSimpleArrayMap) {}
  
  @Deprecated
  public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig()
  {
    return null;
  }
  
  public FragmentManagerNonConfig retainNestedNonConfig()
  {
    return this.mHost.mFragmentManager.retainNonConfig();
  }
  
  @Deprecated
  public List<Fragment> retainNonConfig()
  {
    FragmentManagerNonConfig localFragmentManagerNonConfig = this.mHost.mFragmentManager.retainNonConfig();
    if (localFragmentManagerNonConfig != null) {
      return localFragmentManagerNonConfig.getFragments();
    }
    return null;
  }
  
  public Parcelable saveAllState()
  {
    return this.mHost.mFragmentManager.saveAllState();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\FragmentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */