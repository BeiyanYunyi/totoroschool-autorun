package com.totoro.school.frament.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bumptech.glide.e;
import com.totoro.school.R.id;
import com.totoro.school.activity.common.HTMLActivity;
import com.totoro.school.adapter.main.NewRecommendNewsAdapter;
import com.totoro.school.adapter.main.NewRecommendNewsAdapter.b;
import com.totoro.school.entity.HeaderModel;
import com.totoro.school.entity.find.HomeActivityListModel;
import com.totoro.school.entity.find.HomeFocusListModel;
import com.totoro.school.entity.find.MainHomePageBodyModel;
import com.totoro.school.entity.find.MainHomePageReturnModel;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.recyclerView.FullyLinearLayoutManager;
import com.totoro.school.recyclerView.SpacesItemDecoration;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.utils.i;
import com.totoro.school.view.MySwipeRefreshLayout;
import com.totoro.school.view.MyViewPager;
import com.totoro.school.view.ShapedImageView;
import d.g.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class NewFindFragment
  extends Fragment
  implements c
{
  private com.totoro.school.e.b a;
  private List<HomeFocusListModel> b = (List)new ArrayList();
  private MyPagerAdapter c;
  private a d;
  private NewRecommendNewsAdapter e;
  private List<HomeActivityListModel> f = (List)new ArrayList();
  private boolean g = true;
  private final long h = 'ஸ';
  private final int i;
  private int j = 1;
  private int k = 100;
  private HashMap l;
  
  private final void c()
  {
    ((MySwipeRefreshLayout)a(R.id.swipe_container)).setColorSchemeResources(new int[] { 17170450, 17170454, 17170456, 17170452 });
    ((MySwipeRefreshLayout)a(R.id.swipe_container)).setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)new d(this));
  }
  
  private final void d()
  {
    com.totoro.school.e.b localb = this.a;
    if (localb != null)
    {
      int m = this.k;
      int n = this.j;
      LoginReturnModel localLoginReturnModel = i.a();
      d.c.b.h.a(localLoginReturnModel, "LoginUtil.getLoginModel()");
      localb.a(String.valueOf(m), String.valueOf(n), localLoginReturnModel.getSchoolID(), "");
    }
  }
  
  private final void e()
  {
    MyViewPager localMyViewPager = (MyViewPager)a(R.id.view_pager);
    if (localMyViewPager != null) {
      localMyViewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener)new ViewPager.OnPageChangeListener()
      {
        public void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public void onPageSelected(int paramAnonymousInt)
        {
          NewFindFragment.h(this.a);
        }
      });
    }
  }
  
  private final void f()
  {
    if (this.b != null)
    {
      Object localObject1 = this.b;
      if (localObject1 == null) {
        d.c.b.h.a();
      }
      if (((List)localObject1).size() > 0)
      {
        localObject1 = (MyViewPager)a(R.id.view_pager);
        Object localObject2 = null;
        if (localObject1 != null) {
          localObject1 = Integer.valueOf(((MyViewPager)localObject1).getCurrentItem());
        } else {
          localObject1 = null;
        }
        if (localObject1 == null) {
          d.c.b.h.a();
        }
        int m = ((Integer)localObject1).intValue();
        localObject1 = this.b;
        if (localObject1 == null) {
          d.c.b.h.a();
        }
        int n = m % ((List)localObject1).size();
        TextView localTextView = (TextView)a(R.id.tv_new_title);
        if (localTextView != null)
        {
          Object localObject3 = this.b;
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = (HomeFocusListModel)((List)localObject3).get(n);
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((HomeFocusListModel)localObject3).getAdvTittle();
            }
          }
          localTextView.setText((CharSequence)localObject1);
        }
        localObject1 = (LinearLayout)a(R.id.dot_layout);
        if (localObject1 == null) {
          d.c.b.h.a();
        }
        int i1 = ((LinearLayout)localObject1).getChildCount();
        m = 0;
        while (m < i1)
        {
          localObject1 = (LinearLayout)a(R.id.dot_layout);
          if (localObject1 == null) {
            d.c.b.h.a();
          }
          localObject1 = ((LinearLayout)localObject1).getChildAt(m);
          d.c.b.h.a(localObject1, "dot_layout!!.getChildAt(i)");
          boolean bool;
          if (m == n) {
            bool = true;
          } else {
            bool = false;
          }
          ((View)localObject1).setEnabled(bool);
          m += 1;
        }
      }
    }
  }
  
  private final void g()
  {
    ((NestedScrollView)a(R.id.my_scrollView)).setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)new NestedScrollView.OnScrollChangeListener()
    {
      public void onScrollChange(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        d.c.b.h.b(paramAnonymousNestedScrollView, "v");
        if (paramAnonymousInt2 == paramAnonymousNestedScrollView.getChildAt(0).getMeasuredHeight() - paramAnonymousNestedScrollView.getMeasuredHeight())
        {
          paramAnonymousNestedScrollView = NewFindFragment.i(this.a);
          if ((paramAnonymousNestedScrollView == null) || (paramAnonymousNestedScrollView.a != 12))
          {
            paramAnonymousNestedScrollView = this.a;
            NewFindFragment.a(paramAnonymousNestedScrollView, NewFindFragment.f(paramAnonymousNestedScrollView) + 1);
            paramAnonymousNestedScrollView = NewFindFragment.i(this.a);
            if (paramAnonymousNestedScrollView != null) {
              paramAnonymousNestedScrollView.a(11);
            }
            NewFindFragment.g(this.a);
          }
        }
      }
    });
    this.e = new NewRecommendNewsAdapter((Context)getActivity(), this.f);
    Object localObject = new FullyLinearLayoutManager((Context)getActivity(), 1, false);
    RecyclerView localRecyclerView = (RecyclerView)a(R.id.rv_recommend_news_list);
    if (localRecyclerView != null) {
      localRecyclerView.setNestedScrollingEnabled(false);
    }
    localRecyclerView = (RecyclerView)a(R.id.rv_recommend_news_list);
    if (localRecyclerView != null) {
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    }
    localObject = (RecyclerView)a(R.id.rv_recommend_news_list);
    if (localObject != null) {
      ((RecyclerView)localObject).addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(5));
    }
    localObject = this.e;
    if (localObject != null) {
      ((NewRecommendNewsAdapter)localObject).setOnItemClickListener((NewRecommendNewsAdapter.b)new c(this));
    }
    localObject = (RecyclerView)a(R.id.rv_recommend_news_list);
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.Adapter)this.e);
    }
  }
  
  private final void h()
  {
    if (this.b != null)
    {
      Object localObject1 = this.b;
      if ((localObject1 != null) && (((List)localObject1).size() == 0)) {
        return;
      }
      int m = 0;
      localObject1 = this.b;
      if (localObject1 == null) {
        d.c.b.h.a();
      }
      int n = ((List)localObject1).size();
      while (m < n)
      {
        localObject1 = new View((Context)getActivity());
        Object localObject2 = new LinearLayout.LayoutParams(15, 15);
        if (m != 0) {
          ((LinearLayout.LayoutParams)localObject2).leftMargin = 10;
        }
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setBackgroundResource(2131230855);
        localObject2 = (LinearLayout)a(R.id.dot_layout);
        if (localObject2 != null) {
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
        m += 1;
      }
      return;
    }
  }
  
  private final void i()
  {
    if (this.d == null) {
      this.d = new a();
    }
    Object localObject = this.d;
    if (localObject == null) {
      d.c.b.h.a();
    }
    ((a)localObject).sendEmptyMessageDelayed(this.i, this.h);
    localObject = (MyViewPager)a(R.id.view_pager);
    if (localObject != null) {
      ((MyViewPager)localObject).setOnTouchListener((View.OnTouchListener)new b(this));
    }
  }
  
  public View a(int paramInt)
  {
    if (this.l == null) {
      this.l = new HashMap();
    }
    View localView2 = (View)this.l.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.l.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.hashCode() != -1662046138) {
      return;
    }
    if (paramString.equals("get_home_page"))
    {
      paramString = (MainHomePageReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, MainHomePageReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getHeader();
        if ((paramObject != null) && (((HeaderModel)paramObject).getCode() != null) && (d.c.b.h.a("0", ((HeaderModel)paramObject).getCode())))
        {
          paramString = paramString.getBody();
          if ((this.g) && (paramString != null))
          {
            if (this.j == 1)
            {
              paramObject = this.f;
              if (paramObject != null) {
                ((List)paramObject).clear();
              }
              this.b = paramString.getAdvList();
              if (this.b != null)
              {
                paramObject = this.b;
                if (paramObject == null) {
                  d.c.b.h.a();
                }
                if (((List)paramObject).size() > 0)
                {
                  h();
                  this.c = new MyPagerAdapter();
                  paramObject = (MyViewPager)a(R.id.view_pager);
                  d.c.b.h.a(paramObject, "view_pager");
                  ((MyViewPager)paramObject).setAdapter((PagerAdapter)this.c);
                  f();
                  i();
                }
              }
            }
            if ((paramString.getActivityList() != null) && (paramString.getActivityList().size() > 0))
            {
              paramObject = this.f;
              if (paramObject != null)
              {
                List localList = paramString.getActivityList();
                d.c.b.h.a(localList, "body.activityList");
                ((List)paramObject).addAll((Collection)localList);
              }
              paramObject = this.e;
              if (paramObject != null) {
                ((NewRecommendNewsAdapter)paramObject).notifyDataSetChanged();
              }
              if (paramString.getActivityList().size() < this.k)
              {
                paramString = this.e;
                if (paramString != null) {
                  paramString.a(12);
                }
              }
              else
              {
                paramString = this.e;
                if (paramString != null) {
                  paramString.a(10);
                }
              }
            }
            else
            {
              paramString = this.e;
              if (paramString != null) {
                paramString.a(12);
              }
            }
            this.g = false;
            paramString = (MySwipeRefreshLayout)a(R.id.swipe_container);
            d.c.b.h.a(paramString, "swipe_container");
            if (paramString.isRefreshing())
            {
              paramString = (MySwipeRefreshLayout)a(R.id.swipe_container);
              if (paramString != null) {
                paramString.setRefreshing(false);
              }
            }
          }
        }
      }
      else
      {
        paramString = (MySwipeRefreshLayout)a(R.id.swipe_container);
        if (paramString != null) {
          paramString.setRefreshing(false);
        }
      }
    }
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    paramString = (MySwipeRefreshLayout)a(R.id.swipe_container);
    if (paramString != null) {
      paramString.setRefreshing(false);
    }
  }
  
  public void a_(String paramString) {}
  
  public void b()
  {
    if (this.l != null) {
      this.l.clear();
    }
  }
  
  public void d_() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    d.c.b.h.b(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131492947, paramViewGroup, false);
    this.a = new com.totoro.school.e.b((c)this);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    if (this.g)
    {
      c();
      e();
      g();
      d();
    }
    super.onResume();
  }
  
  public final class MyPagerAdapter
    extends PagerAdapter
  {
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      d.c.b.h.b(paramViewGroup, "container");
      d.c.b.h.b(paramObject, "object");
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return Integer.MAX_VALUE;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      d.c.b.h.b(paramViewGroup, "container");
      final Object localObject1 = (Context)this.a.getActivity();
      String str = null;
      View localView = View.inflate((Context)localObject1, 2131492957, null);
      localObject1 = localView.findViewById(2131296427);
      if (localObject1 != null)
      {
        ShapedImageView localShapedImageView = (ShapedImageView)localObject1;
        localObject1 = this.a.getResources();
        d.c.b.h.a(localObject1, "resources");
        localObject1 = ((Resources)localObject1).getDisplayMetrics();
        int i = ((DisplayMetrics)localObject1).widthPixels;
        int j = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = localShapedImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = (i * 400 / 1125);
        localShapedImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (NewFindFragment.d(this.a) != null)
        {
          localObject1 = NewFindFragment.d(this.a);
          if (localObject1 == null) {
            d.c.b.h.a();
          }
          if (((List)localObject1).size() > 0)
          {
            localObject1 = NewFindFragment.d(this.a);
            if (localObject1 != null)
            {
              localObject2 = NewFindFragment.d(this.a);
              if (localObject2 == null) {
                d.c.b.h.a();
              }
              localObject1 = (HomeFocusListModel)((List)localObject1).get(paramInt % ((List)localObject2).size());
            }
            else
            {
              localObject1 = null;
            }
            Object localObject2 = e.a(this.a.getActivity());
            if (localObject1 != null) {
              str = ((HomeFocusListModel)localObject1).getAdvImgUrl();
            }
            ((com.bumptech.glide.h)localObject2).a(str).a((ImageView)localShapedImageView);
            localView.setOnClickListener((View.OnClickListener)new a(this, (HomeFocusListModel)localObject1));
            paramViewGroup.addView(localView);
          }
        }
        d.c.b.h.a(localView, "myView");
        return localView;
      }
      throw new d.b("null cannot be cast to non-null type com.totoro.school.view.ShapedImageView");
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      d.c.b.h.b(paramView, "view");
      d.c.b.h.b(paramObject, "object");
      return paramView == paramObject;
    }
    
    static final class a
      implements View.OnClickListener
    {
      a(NewFindFragment.MyPagerAdapter paramMyPagerAdapter, HomeFocusListModel paramHomeFocusListModel) {}
      
      public final void onClick(View paramView)
      {
        paramView = localObject1;
        Object localObject = null;
        if (paramView != null) {
          paramView = paramView.getAdvUrl();
        } else {
          paramView = null;
        }
        paramView = (CharSequence)paramView;
        int i;
        if ((paramView != null) && (paramView.length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          Intent localIntent = new Intent((Context)this.a.a.getActivity(), HTMLActivity.class);
          paramView = localObject1;
          if (paramView != null) {
            paramView = paramView.getAdvUrl();
          } else {
            paramView = null;
          }
          localIntent.putExtra("url", paramView);
          HomeFocusListModel localHomeFocusListModel = localObject1;
          paramView = (View)localObject;
          if (localHomeFocusListModel != null) {
            paramView = localHomeFocusListModel.getAdvTittle();
          }
          localIntent.putExtra("title", paramView);
          localIntent.putExtra("canComment", false);
          paramView = this.a.a.getActivity();
          if (paramView != null) {
            paramView.startActivity(localIntent);
          }
        }
      }
    }
  }
  
  public final class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      d.c.b.h.b(paramMessage, "msg");
      if ((paramMessage.what == NewFindFragment.a(this.a)) && ((MyViewPager)this.a.a(R.id.view_pager) != null))
      {
        paramMessage = (MyViewPager)this.a.a(R.id.view_pager);
        d.c.b.h.a(paramMessage, "view_pager");
        int i = paramMessage.getCurrentItem();
        paramMessage = (MyViewPager)this.a.a(R.id.view_pager);
        d.c.b.h.a(paramMessage, "view_pager");
        paramMessage.setCurrentItem(i + 1);
        paramMessage = NewFindFragment.b(this.a);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(NewFindFragment.a(this.a), NewFindFragment.c(this.a));
        }
      }
    }
  }
  
  static final class b
    implements View.OnTouchListener
  {
    b(NewFindFragment paramNewFindFragment) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      d.c.b.h.a(paramMotionEvent, "event");
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      case 2: 
        paramView = (MySwipeRefreshLayout)this.a.a(R.id.swipe_container);
        if (paramView != null) {
          paramView.setEnabled(false);
        }
        paramView = NewFindFragment.b(this.a);
        if (paramView != null)
        {
          paramView.removeMessages(NewFindFragment.a(this.a));
          return false;
        }
        break;
      case 1: 
      case 3: 
        paramView = (MySwipeRefreshLayout)this.a.a(R.id.swipe_container);
        if (paramView != null) {
          paramView.setEnabled(true);
        }
        paramView = NewFindFragment.b(this.a);
        if (paramView != null) {
          paramView.sendEmptyMessageDelayed(NewFindFragment.a(this.a), NewFindFragment.c(this.a));
        }
        break;
      }
      return false;
    }
  }
  
  public static final class c
    implements NewRecommendNewsAdapter.b
  {
    public void a(View paramView, int paramInt)
    {
      d.c.b.h.b(paramView, "v");
      paramView = NewFindFragment.e(this.a);
      if (paramView != null)
      {
        paramView = (HomeActivityListModel)paramView.get(paramInt);
        if (paramView != null)
        {
          paramView = paramView.getActivityType();
          break label43;
        }
      }
      paramView = null;
      label43:
      if (!m.a(paramView, "4", false, 2, null))
      {
        paramView = new Intent((Context)this.a.getActivity(), HTMLActivity.class);
        List localList = NewFindFragment.e(this.a);
        if (localList == null) {
          d.c.b.h.a();
        }
        paramView.putExtra("title", ((HomeActivityListModel)localList.get(paramInt)).getActivityTittle());
        localList = NewFindFragment.e(this.a);
        if (localList == null) {
          d.c.b.h.a();
        }
        paramView.putExtra("url", ((HomeActivityListModel)localList.get(paramInt)).getActivityUrl());
        localList = NewFindFragment.e(this.a);
        if (localList == null) {
          d.c.b.h.a();
        }
        paramView.putExtra("fkId", ((HomeActivityListModel)localList.get(paramInt)).getFocusId());
        paramView.putExtra("canComment", true);
        this.a.startActivity(paramView);
      }
    }
    
    public void b(View paramView, int paramInt)
    {
      d.c.b.h.b(paramView, "v");
    }
  }
  
  static final class d
    implements SwipeRefreshLayout.OnRefreshListener
  {
    d(NewFindFragment paramNewFindFragment) {}
    
    public final void onRefresh()
    {
      if (NewFindFragment.b(this.a) != null)
      {
        localObject = NewFindFragment.b(this.a);
        if (localObject != null) {
          ((NewFindFragment.a)localObject).removeMessages(NewFindFragment.a(this.a));
        }
      }
      Object localObject = NewFindFragment.d(this.a);
      if (localObject != null) {
        ((List)localObject).clear();
      }
      localObject = (LinearLayout)this.a.a(R.id.dot_layout);
      if (localObject != null) {
        ((LinearLayout)localObject).removeAllViews();
      }
      localObject = NewFindFragment.e(this.a);
      if (localObject != null) {
        ((List)localObject).clear();
      }
      NewFindFragment.a(this.a, 1);
      NewFindFragment.g(this.a);
      NewFindFragment.a(this.a, true);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\NewFindFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */