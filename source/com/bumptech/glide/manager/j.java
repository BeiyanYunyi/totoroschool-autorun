package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.bumptech.glide.h;
import java.util.HashSet;

@TargetApi(11)
public class j
  extends Fragment
{
  private final a a;
  private final l b = new a(null);
  private h c;
  private final HashSet<j> d = new HashSet();
  private j e;
  
  public j()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  j(a parama)
  {
    this.a = parama;
  }
  
  private void a(j paramj)
  {
    this.d.add(paramj);
  }
  
  private void b(j paramj)
  {
    this.d.remove(paramj);
  }
  
  a a()
  {
    return this.a;
  }
  
  public void a(h paramh)
  {
    this.c = paramh;
  }
  
  public h b()
  {
    return this.c;
  }
  
  public l c()
  {
    return this.b;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.e = k.a().a(getActivity().getFragmentManager());
    if (this.e != this) {
      this.e.a(this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.c();
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
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.b();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.c != null) {
      this.c.a(paramInt);
    }
  }
  
  private class a
    implements l
  {
    private a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\manager\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */