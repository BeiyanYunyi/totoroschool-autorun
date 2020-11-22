package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.StyleRes;
import android.support.v7.appcompat.R.style;
import android.view.LayoutInflater;

public class ContextThemeWrapper
  extends ContextWrapper
{
  private LayoutInflater mInflater;
  private Configuration mOverrideConfiguration;
  private Resources mResources;
  private Resources.Theme mTheme;
  private int mThemeResource;
  
  public ContextThemeWrapper()
  {
    super(null);
  }
  
  public ContextThemeWrapper(Context paramContext, @StyleRes int paramInt)
  {
    super(paramContext);
    this.mThemeResource = paramInt;
  }
  
  public ContextThemeWrapper(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.mTheme = paramTheme;
  }
  
  private Resources getResourcesInternal()
  {
    if (this.mResources == null) {
      if (this.mOverrideConfiguration == null) {
        this.mResources = super.getResources();
      } else if (Build.VERSION.SDK_INT >= 17) {
        this.mResources = createConfigurationContext(this.mOverrideConfiguration).getResources();
      }
    }
    return this.mResources;
  }
  
  private void initializeTheme()
  {
    boolean bool;
    if (this.mTheme == null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      this.mTheme = getResources().newTheme();
      Resources.Theme localTheme = getBaseContext().getTheme();
      if (localTheme != null) {
        this.mTheme.setTo(localTheme);
      }
    }
    onApplyThemeResource(this.mTheme, this.mThemeResource, bool);
  }
  
  public void applyOverrideConfiguration(Configuration paramConfiguration)
  {
    if (this.mResources == null)
    {
      if (this.mOverrideConfiguration == null)
      {
        this.mOverrideConfiguration = new Configuration(paramConfiguration);
        return;
      }
      throw new IllegalStateException("Override configuration has already been set");
    }
    throw new IllegalStateException("getResources() or getAssets() has already been called");
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public AssetManager getAssets()
  {
    return getResources().getAssets();
  }
  
  public Resources getResources()
  {
    return getResourcesInternal();
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null) {
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.mInflater;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    if (this.mTheme != null) {
      return this.mTheme;
    }
    if (this.mThemeResource == 0) {
      this.mThemeResource = R.style.Theme_AppCompat_Light;
    }
    initializeTheme();
    return this.mTheme;
  }
  
  public int getThemeResId()
  {
    return this.mThemeResource;
  }
  
  protected void onApplyThemeResource(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    paramTheme.applyStyle(paramInt, true);
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mThemeResource != paramInt)
    {
      this.mThemeResource = paramInt;
      initializeTheme();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\view\ContextThemeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */