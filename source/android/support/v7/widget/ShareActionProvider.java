package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.string;
import android.support.v7.content.res.AppCompatResources;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class ShareActionProvider
  extends ActionProvider
{
  private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
  public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
  final Context mContext;
  private int mMaxShownActivityCount = 4;
  private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
  private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener();
  OnShareTargetSelectedListener mOnShareTargetSelectedListener;
  String mShareHistoryFileName = "share_history.xml";
  
  public ShareActionProvider(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  private void setActivityChooserPolicyIfNeeded()
  {
    if (this.mOnShareTargetSelectedListener == null) {
      return;
    }
    if (this.mOnChooseActivityListener == null) {
      this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy();
    }
    ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
  }
  
  public boolean hasSubMenu()
  {
    return true;
  }
  
  public View onCreateActionView()
  {
    ActivityChooserView localActivityChooserView = new ActivityChooserView(this.mContext);
    if (!localActivityChooserView.isInEditMode()) {
      localActivityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
    }
    TypedValue localTypedValue = new TypedValue();
    this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, localTypedValue, true);
    localActivityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, localTypedValue.resourceId));
    localActivityChooserView.setProvider(this);
    localActivityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
    localActivityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
    return localActivityChooserView;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    paramSubMenu.clear();
    ActivityChooserModel localActivityChooserModel = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
    PackageManager localPackageManager = this.mContext.getPackageManager();
    int j = localActivityChooserModel.getActivityCount();
    int k = Math.min(j, this.mMaxShownActivityCount);
    int i = 0;
    ResolveInfo localResolveInfo;
    while (i < k)
    {
      localResolveInfo = localActivityChooserModel.getActivity(i);
      paramSubMenu.add(0, i, i, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
      i += 1;
    }
    if (k < j)
    {
      paramSubMenu = paramSubMenu.addSubMenu(0, k, k, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
      i = 0;
      while (i < j)
      {
        localResolveInfo = localActivityChooserModel.getActivity(i);
        paramSubMenu.add(0, i, i, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        i += 1;
      }
    }
  }
  
  public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener paramOnShareTargetSelectedListener)
  {
    this.mOnShareTargetSelectedListener = paramOnShareTargetSelectedListener;
    setActivityChooserPolicyIfNeeded();
  }
  
  public void setShareHistoryFileName(String paramString)
  {
    this.mShareHistoryFileName = paramString;
    setActivityChooserPolicyIfNeeded();
  }
  
  public void setShareIntent(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      if (("android.intent.action.SEND".equals(str)) || ("android.intent.action.SEND_MULTIPLE".equals(str))) {
        updateIntent(paramIntent);
      }
    }
    ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(paramIntent);
  }
  
  void updateIntent(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramIntent.addFlags(134742016);
      return;
    }
    paramIntent.addFlags(524288);
  }
  
  public static abstract interface OnShareTargetSelectedListener
  {
    public abstract boolean onShareTargetSelected(ShareActionProvider paramShareActionProvider, Intent paramIntent);
  }
  
  private class ShareActivityChooserModelPolicy
    implements ActivityChooserModel.OnChooseActivityListener
  {
    ShareActivityChooserModelPolicy() {}
    
    public boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent)
    {
      if (ShareActionProvider.this.mOnShareTargetSelectedListener != null) {
        ShareActionProvider.this.mOnShareTargetSelectedListener.onShareTargetSelected(ShareActionProvider.this, paramIntent);
      }
      return false;
    }
  }
  
  private class ShareMenuItemOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    ShareMenuItemOnMenuItemClickListener() {}
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      paramMenuItem = ActivityChooserModel.get(ShareActionProvider.this.mContext, ShareActionProvider.this.mShareHistoryFileName).chooseActivity(paramMenuItem.getItemId());
      if (paramMenuItem != null)
      {
        String str = paramMenuItem.getAction();
        if (("android.intent.action.SEND".equals(str)) || ("android.intent.action.SEND_MULTIPLE".equals(str))) {
          ShareActionProvider.this.updateIntent(paramMenuItem);
        }
        ShareActionProvider.this.mContext.startActivity(paramMenuItem);
      }
      return true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\ShareActionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */