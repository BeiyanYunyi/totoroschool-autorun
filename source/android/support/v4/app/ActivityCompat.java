package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v13.view.DragAndDropPermissionsCompat;
import android.support.v4.content.ContextCompat;
import android.view.DragEvent;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat
  extends ContextCompat
{
  private static PermissionCompatDelegate sDelegate;
  
  public static void finishAffinity(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }
  
  public static void finishAfterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static PermissionCompatDelegate getPermissionCompatDelegate()
  {
    return sDelegate;
  }
  
  @Nullable
  public static Uri getReferrer(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return paramActivity.getReferrer();
    }
    paramActivity = paramActivity.getIntent();
    Uri localUri = (Uri)paramActivity.getParcelableExtra("android.intent.extra.REFERRER");
    if (localUri != null) {
      return localUri;
    }
    paramActivity = paramActivity.getStringExtra("android.intent.extra.REFERRER_NAME");
    if (paramActivity != null) {
      return Uri.parse(paramActivity);
    }
    return null;
  }
  
  @Deprecated
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    paramActivity.invalidateOptionsMenu();
    return true;
  }
  
  public static void postponeEnterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
  }
  
  @Nullable
  public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity paramActivity, DragEvent paramDragEvent)
  {
    return DragAndDropPermissionsCompat.request(paramActivity, paramDragEvent);
  }
  
  public static void requestPermissions(@NonNull final Activity paramActivity, @NonNull String[] paramArrayOfString, @IntRange(from=0L) final int paramInt)
  {
    if ((sDelegate != null) && (sDelegate.requestPermissions(paramActivity, paramArrayOfString, paramInt))) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof RequestPermissionsRequestCodeValidator)) {
        ((RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
      return;
    }
    if ((paramActivity instanceof OnRequestPermissionsResultCallback)) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          int[] arrayOfInt = new int[this.val$permissions.length];
          PackageManager localPackageManager = paramActivity.getPackageManager();
          String str = paramActivity.getPackageName();
          int j = this.val$permissions.length;
          int i = 0;
          while (i < j)
          {
            arrayOfInt[i] = localPackageManager.checkPermission(this.val$permissions[i], str);
            i += 1;
          }
          ((ActivityCompat.OnRequestPermissionsResultCallback)paramActivity).onRequestPermissionsResult(paramInt, this.val$permissions, arrayOfInt);
        }
      });
    }
  }
  
  @NonNull
  public static <T extends View> T requireViewById(@NonNull Activity paramActivity, @IdRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramActivity.requireViewById(paramInt);
    }
    paramActivity = paramActivity.findViewById(paramInt);
    if (paramActivity != null) {
      return paramActivity;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this Activity");
  }
  
  public static void setEnterSharedElementCallback(@NonNull Activity paramActivity, @Nullable SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      paramActivity.setEnterSharedElementCallback(paramSharedElementCallback);
    }
  }
  
  public static void setExitSharedElementCallback(@NonNull Activity paramActivity, @Nullable SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      paramActivity.setExitSharedElementCallback(paramSharedElementCallback);
    }
  }
  
  public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate paramPermissionCompatDelegate)
  {
    sDelegate = paramPermissionCompatDelegate;
  }
  
  public static boolean shouldShowRequestPermissionRationale(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public static void startActivityForResult(@NonNull Activity paramActivity, @NonNull Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void startIntentSenderForResult(@NonNull Activity paramActivity, @NonNull IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void startPostponedEnterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
  }
  
  public static abstract interface OnRequestPermissionsResultCallback
  {
    public abstract void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt);
  }
  
  public static abstract interface PermissionCompatDelegate
  {
    public abstract boolean onActivityResult(@NonNull Activity paramActivity, @IntRange(from=0L) int paramInt1, int paramInt2, @Nullable Intent paramIntent);
    
    public abstract boolean requestPermissions(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @IntRange(from=0L) int paramInt);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static abstract interface RequestPermissionsRequestCodeValidator
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
  
  @RequiresApi(21)
  private static class SharedElementCallback21Impl
    extends android.app.SharedElementCallback
  {
    private final SharedElementCallback mCallback;
    
    SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
    {
      this.mCallback = paramSharedElementCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
    {
      this.mCallback.onMapSharedElements(paramList, paramMap);
    }
    
    public void onRejectSharedElements(List<View> paramList)
    {
      this.mCallback.onRejectSharedElements(paramList);
    }
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementStart(paramList, paramList1, paramList2);
    }
    
    @RequiresApi(23)
    public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final android.app.SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
    {
      this.mCallback.onSharedElementsArrived(paramList, paramList1, new SharedElementCallback.OnSharedElementsReadyListener()
      {
        public void onSharedElementsReady()
        {
          paramOnSharedElementsReadyListener.onSharedElementsReady();
        }
      });
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\ActivityCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */