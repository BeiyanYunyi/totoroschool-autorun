package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.bumptech.glide.h;
import java.util.HashSet;

public class SupportRequestManagerFragment
  extends Fragment
{
  private h a;
  private final a b;
  private final l c = new a(null);
  private final HashSet<SupportRequestManagerFragment> d = new HashSet();
  private SupportRequestManagerFragment e;
  
  public SupportRequestManagerFragment()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  public SupportRequestManagerFragment(a parama)
  {
    this.b = parama;
  }
  
  private void a(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.d.add(paramSupportRequestManagerFragment);
  }
  
  private void b(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    this.d.remove(paramSupportRequestManagerFragment);
  }
  
  a a()
  {
    return this.b;
  }
  
  public void a(h paramh)
  {
    this.a = paramh;
  }
  
  public h b()
  {
    return this.a;
  }
  
  public l c()
  {
    return this.c;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.e = k.a().a(getActivity().getSupportFragmentManager());
    if (this.e != this) {
      this.e.a(this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.c();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.e != null)
    {
      this.e.b(this);
      this.e = null;
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.b.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.b.b();
  }
  
  private class a
    implements l
  {
    private a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\manager\SupportRequestManagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */