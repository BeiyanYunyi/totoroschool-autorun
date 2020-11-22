package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class RxPermissionsFragment
  extends Fragment
{
  private Map<String, b.a.j.a<a>> a = new HashMap();
  private boolean b;
  
  public void a(@NonNull String paramString, @NonNull b.a.j.a<a> parama)
  {
    this.a.put(paramString, parama);
  }
  
  @TargetApi(23)
  void a(@NonNull String[] paramArrayOfString)
  {
    requestPermissions(paramArrayOfString, 42);
  }
  
  void a(String[] paramArrayOfString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRequestPermissionsResult  ");
      ((StringBuilder)localObject).append(paramArrayOfString[i]);
      e(((StringBuilder)localObject).toString());
      localObject = (b.a.j.a)this.a.get(paramArrayOfString[i]);
      if (localObject == null)
      {
        Log.e(b.a, "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
        return;
      }
      this.a.remove(paramArrayOfString[i]);
      boolean bool;
      if (paramArrayOfInt[i] == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((b.a.j.a)localObject).onNext(new a(paramArrayOfString[i], bool, paramArrayOfBoolean[i]));
      ((b.a.j.a)localObject).onComplete();
      i += 1;
    }
  }
  
  @TargetApi(23)
  boolean a(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      return localFragmentActivity.checkSelfPermission(paramString) == 0;
    }
    throw new IllegalStateException("This fragment must be attached to an activity.");
  }
  
  @TargetApi(23)
  boolean b(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      return localFragmentActivity.getPackageManager().isPermissionRevokedByPolicy(paramString, getActivity().getPackageName());
    }
    throw new IllegalStateException("This fragment must be attached to an activity.");
  }
  
  public b.a.j.a<a> c(@NonNull String paramString)
  {
    return (b.a.j.a)this.a.get(paramString);
  }
  
  public boolean d(@NonNull String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  void e(String paramString)
  {
    if (this.b) {
      Log.d(b.a, paramString);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  @TargetApi(23)
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt != 42) {
      return;
    }
    boolean[] arrayOfBoolean = new boolean[paramArrayOfString.length];
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      arrayOfBoolean[paramInt] = shouldShowRequestPermissionRationale(paramArrayOfString[paramInt]);
      paramInt += 1;
    }
    a(paramArrayOfString, paramArrayOfInt, arrayOfBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tbruyelle\rxpermissions2\RxPermissionsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */