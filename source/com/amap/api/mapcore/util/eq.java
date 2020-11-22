package com.amap.api.mapcore.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener;
import com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.offlineservice.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class eq
  extends a
  implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener
{
  private ImageView b;
  private RelativeLayout c;
  private DownLoadExpandListView d;
  private ListView e;
  private ExpandableListView f;
  private ImageView g;
  private ImageView h;
  private AutoCompleteTextView i;
  private RelativeLayout j;
  private RelativeLayout k;
  private ImageView l;
  private ImageView m;
  private RelativeLayout n;
  private List<OfflineMapProvince> o = new ArrayList();
  private ek p;
  private OfflineMapManager q = null;
  private ej r;
  private el s;
  private boolean t = true;
  private boolean u = true;
  private int v = -1;
  private long w = 0L;
  private em x;
  private boolean y = true;
  
  private void j()
  {
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      localLayoutParams.leftMargin = a(18.0F);
      this.m.setLayoutParams(localLayoutParams);
      this.i.setPadding(a(30.0F), 0, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    l();
    this.s = new el(this.o, this.q, this.a);
    this.e.setAdapter(this.s);
  }
  
  private void l()
  {
    Object localObject3 = this.q.getOfflineMapProvinceList();
    this.o.clear();
    this.o.add(null);
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    int i1 = 0;
    while (i1 < ((List)localObject3).size())
    {
      OfflineMapProvince localOfflineMapProvince = (OfflineMapProvince)((List)localObject3).get(i1);
      if (localOfflineMapProvince.getCityList().size() != 1)
      {
        this.o.add(i1 + 1, localOfflineMapProvince);
      }
      else
      {
        String str = localOfflineMapProvince.getProvinceName();
        if (str.contains("香港")) {
          localArrayList.addAll(localOfflineMapProvince.getCityList());
        } else if (str.contains("澳门")) {
          localArrayList.addAll(localOfflineMapProvince.getCityList());
        } else if (str.contains("全国概要图")) {
          ((ArrayList)localObject2).addAll(0, localOfflineMapProvince.getCityList());
        } else {
          ((ArrayList)localObject2).addAll(localOfflineMapProvince.getCityList());
        }
      }
      i1 += 1;
    }
    localObject3 = new OfflineMapProvince();
    ((OfflineMapProvince)localObject3).setProvinceName("基本功能包+直辖市");
    ((OfflineMapProvince)localObject3).setCityList((ArrayList)localObject2);
    this.o.set(0, localObject3);
    localObject2 = new OfflineMapProvince();
    ((OfflineMapProvince)localObject2).setProvinceName("直辖市");
    ((OfflineMapProvince)localObject2).setCityList((ArrayList)localObject1);
    localObject1 = new OfflineMapProvince();
    ((OfflineMapProvince)localObject1).setProvinceName("港澳");
    ((OfflineMapProvince)localObject1).setCityList(localArrayList);
    this.o.add(localObject1);
  }
  
  private void m()
  {
    if ((this.i != null) && (this.i.isFocused()))
    {
      this.i.clearFocus();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getSystemService("input_method");
      boolean bool = false;
      if (localInputMethodManager != null) {
        bool = localInputMethodManager.isActive();
      }
      if (bool) {
        localInputMethodManager.hideSoftInputFromWindow(this.i.getWindowToken(), 2);
      }
    }
  }
  
  public void a()
  {
    View localView = es.a(this.a, 2130903040, null);
    this.d = ((DownLoadExpandListView)localView.findViewById(2131165187));
    this.d.setOnTouchListener(this);
    this.j = ((RelativeLayout)localView.findViewById(2131165184));
    this.g = ((ImageView)localView.findViewById(2131165186));
    this.j.setOnClickListener(this.a);
    this.k = ((RelativeLayout)localView.findViewById(2131165189));
    this.h = ((ImageView)localView.findViewById(2131165190));
    this.k.setOnClickListener(this.a);
    this.n = ((RelativeLayout)localView.findViewById(2131165188));
    this.b = ((ImageView)this.c.findViewById(2131165205));
    this.b.setOnClickListener(this.a);
    this.m = ((ImageView)this.c.findViewById(2131165207));
    this.l = ((ImageView)this.c.findViewById(2131165209));
    this.l.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          eq.a(eq.this).setText("");
          eq.b(eq.this).setVisibility(8);
          eq.this.a(false);
          paramAnonymousView = (RelativeLayout.LayoutParams)eq.c(eq.this).getLayoutParams();
          paramAnonymousView.leftMargin = eq.this.a(95.0F);
          eq.c(eq.this).setLayoutParams(paramAnonymousView);
          eq.a(eq.this).setPadding(eq.this.a(105.0F), 0, 0, 0);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          paramAnonymousView.printStackTrace();
        }
      }
    });
    this.c.findViewById(2131165210).setOnTouchListener(this);
    this.i = ((AutoCompleteTextView)this.c.findViewById(2131165208));
    this.i.addTextChangedListener(this);
    this.i.setOnTouchListener(this);
    this.e = ((ListView)this.c.findViewById(2131165212));
    this.f = ((ExpandableListView)this.c.findViewById(2131165211));
    this.f.addHeaderView(localView);
    this.f.setOnTouchListener(this);
    this.f.setOnScrollListener(this);
    this.q = new OfflineMapManager(this.a, this);
    this.q.setOnOfflineLoadedListener(this);
    l();
    this.p = new ek(this.o, this.q, this.a);
    this.f.setAdapter(this.p);
    this.f.setOnGroupCollapseListener(this.p);
    this.f.setOnGroupExpandListener(this.p);
    this.f.setGroupIndicator(null);
    if (this.t)
    {
      this.h.setBackgroundResource(2130837504);
      this.f.setVisibility(0);
    }
    else
    {
      this.h.setBackgroundResource(2130837508);
      this.f.setVisibility(8);
    }
    if (this.u)
    {
      this.g.setBackgroundResource(2130837504);
      this.d.setVisibility(0);
      return;
    }
    this.g.setBackgroundResource(2130837508);
    this.d.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    try
    {
      int i1 = paramView.getId();
      if (i1 == 2131165205)
      {
        this.a.closeScr();
        return;
      }
      if (i1 == 2131165184)
      {
        if (this.u)
        {
          this.d.setVisibility(8);
          this.g.setBackgroundResource(2130837508);
          this.u = false;
          return;
        }
        this.d.setVisibility(0);
        this.g.setBackgroundResource(2130837504);
        this.u = true;
        return;
      }
      if (i1 == 2131165189)
      {
        if (this.t)
        {
          this.p.b();
          this.h.setBackgroundResource(2130837508);
          this.t = false;
          return;
        }
        this.p.a();
        this.h.setBackgroundResource(2130837504);
        this.t = true;
        return;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void a(OfflineMapCity paramOfflineMapCity)
  {
    try
    {
      if (this.x == null) {
        this.x = new em(this.a, this.q);
      }
      this.x.a(paramOfflineMapCity.getState(), paramOfflineMapCity.getCity());
      this.x.show();
      return;
    }
    catch (Exception paramOfflineMapCity)
    {
      paramOfflineMapCity.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i2 = 0;
    if (paramBoolean)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      this.d.setVisibility(8);
      this.f.setVisibility(8);
      this.n.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.j.setVisibility(0);
    this.k.setVisibility(0);
    this.n.setVisibility(0);
    Object localObject = this.d;
    int i1;
    if (this.u) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((DownLoadExpandListView)localObject).setVisibility(i1);
    localObject = this.f;
    if (this.t) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((ExpandableListView)localObject).setVisibility(i1);
    this.e.setVisibility(8);
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public RelativeLayout b()
  {
    if (this.c == null) {
      this.c = ((RelativeLayout)es.a(this.a, 2130903044, null));
    }
    return this.c;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    this.q.destroy();
  }
  
  public void d()
  {
    this.r = new ej(this.a, this, this.q, this.o);
    this.d.setAdapter(this.r);
    this.r.notifyDataSetChanged();
  }
  
  public boolean e()
  {
    try
    {
      if (this.e.getVisibility() == 0)
      {
        this.i.setText("");
        this.l.setVisibility(8);
        a(false);
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.e();
  }
  
  public void onCheckUpdate(boolean paramBoolean, String paramString) {}
  
  public void onDownload(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      }
      break;
    }
    try
    {
      Toast.makeText(this.a, "网络异常", 0).show();
      this.q.pause();
      if (paramInt1 == 2) {
        this.r.a();
      }
      if (this.v != paramInt1)
      {
        if (this.p != null) {
          this.p.notifyDataSetChanged();
        }
        if (this.r != null) {
          this.r.notifyDataSetChanged();
        }
        if (this.s != null) {
          this.s.notifyDataSetChanged();
        }
        this.v = paramInt1;
        return;
      }
      if (System.currentTimeMillis() - this.w <= 'Ұ') {
        break label219;
      }
      Log.i("SHIXIN", "UPDATE_DOWNLOAD_LIST");
      if (this.y) {
        this.r.notifyDataSetChanged();
      }
      this.w = System.currentTimeMillis();
      return;
    }
    catch (Exception paramString)
    {
      label219:
      for (;;) {}
    }
    paramString.printStackTrace();
  }
  
  public void onRemove(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.r != null) {
      this.r.b();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2)
    {
      this.y = false;
      return;
    }
    this.y = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      a(false);
      this.l.setVisibility(8);
      return;
    }
    this.l.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    if ((this.o != null) && (this.o.size() > 0))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = this.o.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).addAll(((OfflineMapProvince)((Iterator)localObject2).next()).getCityList());
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (OfflineMapCity)((Iterator)localObject1).next();
        String str1 = ((OfflineMapCity)localObject2).getCity();
        String str2 = ((OfflineMapCity)localObject2).getPinyin();
        String str3 = ((OfflineMapCity)localObject2).getJianpin();
        if (paramCharSequence.length() == 1)
        {
          if (str3.startsWith(String.valueOf(paramCharSequence))) {
            localArrayList.add(localObject2);
          }
        }
        else if ((str3.startsWith(String.valueOf(paramCharSequence))) || (str2.startsWith(String.valueOf(paramCharSequence))) || (str1.startsWith(String.valueOf(paramCharSequence)))) {
          localArrayList.add(localObject2);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      a(true);
      Collections.sort(localArrayList, new Comparator()
      {
        public int a(OfflineMapCity paramAnonymousOfflineMapCity1, OfflineMapCity paramAnonymousOfflineMapCity2)
        {
          paramAnonymousOfflineMapCity1 = paramAnonymousOfflineMapCity1.getJianpin().toCharArray();
          paramAnonymousOfflineMapCity2 = paramAnonymousOfflineMapCity2.getJianpin().toCharArray();
          if (paramAnonymousOfflineMapCity1[0] < paramAnonymousOfflineMapCity2[0]) {
            return 1;
          }
          if (paramAnonymousOfflineMapCity1[1] < paramAnonymousOfflineMapCity2[1]) {
            return 1;
          }
          return 0;
        }
      });
      this.s.a(localArrayList);
      this.s.notifyDataSetChanged();
      return;
    }
    Toast.makeText(this.a, "未找到相关城市", 0).show();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    m();
    if (paramView.getId() == 2131165208) {
      j();
    }
    return false;
  }
  
  public void onVerifyComplete()
  {
    k();
    d();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */