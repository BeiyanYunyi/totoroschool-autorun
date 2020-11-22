package com.totoro.school.activity.run;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.PolylineOptions;
import com.totoro.school.R.id;
import com.totoro.school.e.f;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.run.reg.RunRegRequestModel;
import com.totoro.school.entity.run.reg.RunRegReturnModel;
import com.totoro.school.entity.run.routePoint.RoutePointModel;
import com.totoro.school.utilpub.a.a;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.utils.i;
import com.totoro.school.utils.o;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import d.c.b.h;
import d.g.j;
import d.g.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public final class LocalSportRecordActivity
  extends BaseActivity
{
  private f a;
  private AMap b;
  private AMapLocationClient c;
  private LoginReturnModel d;
  private RunRegRequestModel e;
  private RoutePointModel f;
  private boolean g;
  private boolean h;
  private HashMap i;
  
  private final void b()
  {
    Object localObject1 = (TextView)a(R.id.title_text);
    h.a(localObject1, "title_text");
    ((TextView)localObject1).setText((CharSequence)getString(2131689698));
    if (this.e != null)
    {
      Object localObject3 = (TextView)a(R.id.km_value);
      h.a(localObject3, "km_value");
      localObject1 = this.e;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((RunRegRequestModel)localObject1).getUserkm();
      } else {
        localObject1 = null;
      }
      ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
      localObject3 = (TextView)a(R.id.start_date);
      h.a(localObject3, "start_date");
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((RunRegRequestModel)localObject1).getBegdate();
      } else {
        localObject1 = null;
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject3 = (TextView)a(R.id.start_time);
      h.a(localObject3, "start_time");
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((RunRegRequestModel)localObject1).getUserbegtime();
      } else {
        localObject1 = null;
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = (TextView)a(R.id.avg_speed);
      h.a(localObject1, "avg_speed");
      ((TextView)localObject1).setText((CharSequence)c());
      localObject1 = (TextView)a(R.id.speed_value);
      h.a(localObject1, "speed_value");
      ((TextView)localObject1).setText((CharSequence)d());
      localObject3 = (TextView)a(R.id.used_time);
      h.a(localObject3, "used_time");
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((RunRegRequestModel)localObject1).getUsertime();
      } else {
        localObject1 = null;
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = this.e;
      if (localObject1 != null)
      {
        localObject1 = ((RunRegRequestModel)localObject1).getUserkm();
        if (localObject1 != null)
        {
          localObject1 = Float.valueOf(Float.parseFloat((String)localObject1));
          break label359;
        }
      }
      localObject1 = null;
      label359:
      if (localObject1 == null) {
        h.a();
      }
      double d1 = ((Float)localObject1).floatValue();
      Double.isNaN(d1);
      int j = (int)(d1 * 67.34D);
      localObject1 = (TextView)a(R.id.kcal_value);
      h.a(localObject1, "kcal_value");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(j));
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = Boolean.valueOf(((RunRegRequestModel)localObject1).isTask());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        h.a();
      }
      if (((Boolean)localObject1).booleanValue())
      {
        localObject1 = (TextView)a(R.id.run_type);
        h.a(localObject1, "run_type");
        ((TextView)localObject1).setText((CharSequence)getString(2131689713));
        localObject1 = (LinearLayout)a(R.id.score_layout);
        h.a(localObject1, "score_layout");
        ((LinearLayout)localObject1).setVisibility(0);
        localObject1 = this.e;
        if (localObject1 != null) {
          localObject1 = Boolean.valueOf(((RunRegRequestModel)localObject1).isCanAppeal());
        } else {
          localObject1 = null;
        }
        if (localObject1 == null) {
          h.a();
        }
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = (TextView)a(R.id.appeal_btn);
          h.a(localObject1, "appeal_btn");
          ((TextView)localObject1).setVisibility(0);
          localObject1 = this.e;
          if (localObject1 != null) {
            localObject1 = Boolean.valueOf(((RunRegRequestModel)localObject1).isAlreadyAppeal());
          } else {
            localObject1 = null;
          }
          if (localObject1 == null) {
            h.a();
          }
          if (((Boolean)localObject1).booleanValue())
          {
            localObject1 = (TextView)a(R.id.appeal_btn);
            h.a(localObject1, "appeal_btn");
            ((TextView)localObject1).setClickable(false);
            localObject1 = (TextView)a(R.id.appeal_btn);
            h.a(localObject1, "appeal_btn");
            ((TextView)localObject1).setText((CharSequence)getString(2131689699));
            ((TextView)a(R.id.appeal_btn)).setBackgroundResource(2131230866);
          }
          else
          {
            localObject1 = (TextView)a(R.id.appeal_btn);
            h.a(localObject1, "appeal_btn");
            ((TextView)localObject1).setClickable(true);
            localObject1 = (TextView)a(R.id.appeal_btn);
            h.a(localObject1, "appeal_btn");
            ((TextView)localObject1).setText((CharSequence)getString(2131689703));
            ((TextView)a(R.id.appeal_btn)).setBackgroundResource(2131230863);
          }
        }
        else
        {
          localObject1 = (TextView)a(R.id.appeal_btn);
          h.a(localObject1, "appeal_btn");
          ((TextView)localObject1).setVisibility(8);
        }
        localObject3 = this.e;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Boolean.valueOf(((RunRegRequestModel)localObject3).isQualified());
        }
        if (localObject1 == null) {
          h.a();
        }
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = (TextView)a(R.id.run_score);
          h.a(localObject1, "run_score");
          ((TextView)localObject1).setText((CharSequence)getString(2131689682));
          ((TextView)a(R.id.run_score)).setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099696));
          return;
        }
        localObject1 = (TextView)a(R.id.run_score);
        h.a(localObject1, "run_score");
        ((TextView)localObject1).setText((CharSequence)getString(2131689680));
        ((TextView)a(R.id.run_score)).setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099697));
        return;
      }
      localObject1 = (TextView)a(R.id.run_type);
      h.a(localObject1, "run_type");
      ((TextView)localObject1).setText((CharSequence)getString(2131689562));
      localObject1 = (TextView)a(R.id.appeal_btn);
      h.a(localObject1, "appeal_btn");
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (LinearLayout)a(R.id.score_layout);
      h.a(localObject1, "score_layout");
      ((LinearLayout)localObject1).setVisibility(4);
    }
  }
  
  private final String c()
  {
    String str = "0.0";
    Object localObject1 = this.e;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((RunRegRequestModel)localObject1).getUsertime();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return "0.0";
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      localObject1 = ((RunRegRequestModel)localObject1).getUsertime();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      h.a();
    }
    if (m.a((CharSequence)localObject1, (CharSequence)":", false, 2, null))
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((RunRegRequestModel)localObject1).getUsertime();
      } else {
        localObject1 = null;
      }
      str = o.b((String)localObject1);
      Object localObject3 = this.e;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((RunRegRequestModel)localObject3).getUserkm();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Double.valueOf(Double.parseDouble((String)localObject3));
        }
      }
      if (localObject1 == null) {
        h.a();
      }
      double d1 = ((Double)localObject1).doubleValue();
      h.a(str, "longTime");
      double d2 = Float.parseFloat(str) / 'ฐ';
      Double.isNaN(d2);
      str = String.valueOf(new BigDecimal(d1 / d2).setScale(2, 4).doubleValue());
    }
    return str;
  }
  
  private final void c(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    paramString = new OneButtonDialog((Context)this, 2131755512, "", paramString, "", (OneButtonDialog.a)new c(this));
    Window localWindow = paramString.getWindow();
    if (localWindow == null) {
      h.a();
    }
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(17);
    localWindow.setAttributes(localLayoutParams);
    paramString.setCanceledOnTouchOutside(true);
    paramString.setCancelable(true);
    paramString.show();
  }
  
  private final String d()
  {
    Object localObject1 = this.e;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((RunRegRequestModel)localObject1).getUsertime();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return "--";
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      localObject1 = ((RunRegRequestModel)localObject1).getUsertime();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      h.a();
    }
    if (m.a((CharSequence)localObject1, (CharSequence)":", false, 2, null))
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((RunRegRequestModel)localObject1).getUsertime();
      } else {
        localObject1 = null;
      }
      localObject1 = o.b((String)localObject1);
      h.a(localObject1, "longTime");
      double d1 = Float.parseFloat((String)localObject1);
      Object localObject3 = this.e;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((RunRegRequestModel)localObject3).getUserkm();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Double.valueOf(Double.parseDouble((String)localObject3));
        }
      }
      if (localObject1 == null) {
        h.a();
      }
      double d2 = ((Double)localObject1).doubleValue();
      Double.isNaN(d1);
      localObject1 = o.a(d1 / d2);
      h.a(localObject1, "TimeUtil.getPace(pace)");
      return (String)localObject1;
    }
    return "--";
  }
  
  private final void e()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new a(this));
    ((TextView)a(R.id.appeal_btn)).setOnClickListener((View.OnClickListener)new b(this));
  }
  
  private final void f()
  {
    this.e = ((RunRegRequestModel)getIntent().getSerializableExtra("runRegRequestModel"));
    this.f = ((RoutePointModel)getIntent().getSerializableExtra("routePointModel"));
  }
  
  private final void h()
  {
    Object localObject = (MapView)a(R.id.map);
    h.a(localObject, "map");
    this.b = ((MapView)localObject).getMap();
    localObject = a.a();
    h.a(localObject, "GlobalShared.getInstance()");
    localObject = ((a)localObject).b();
    AMap localAMap = this.b;
    if (localAMap != null) {
      localAMap.moveCamera(CameraUpdateFactory.newLatLngZoom((LatLng)localObject, 17.0F));
    }
    localObject = this.b;
    if (localObject != null)
    {
      localObject = ((AMap)localObject).getUiSettings();
      if (localObject != null) {
        ((UiSettings)localObject).setZoomControlsEnabled(false);
      }
    }
    j();
    i();
    k();
  }
  
  private final void i()
  {
    Object localObject1 = this.e;
    ArrayList localArrayList = null;
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((RunRegRequestModel)localObject1).getRoute();
    } else {
      localObject2 = null;
    }
    localObject1 = localArrayList;
    int j;
    if (localObject2 != null)
    {
      localObject1 = (CharSequence)localObject2;
      localObject2 = new j(";").split((CharSequence)localObject1, 0);
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = ((List)localObject2).listIterator(((List)localObject2).size());
          while (((ListIterator)localObject1).hasPrevious())
          {
            if (((CharSequence)((ListIterator)localObject1).previous()).length() == 0) {
              j = 1;
            } else {
              j = 0;
            }
            if (j == 0)
            {
              localObject2 = d.a.b.a((Iterable)localObject2, ((ListIterator)localObject1).nextIndex() + 1);
              break label165;
            }
          }
        }
        localObject2 = d.a.b.a();
        label165:
        localObject1 = localArrayList;
        if (localObject2 != null)
        {
          localObject1 = ((Collection)localObject2).toArray(new String[0]);
          if (localObject1 != null) {
            localObject1 = (String[])localObject1;
          } else {
            throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
      }
    }
    localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      int n = localObject1.length;
      j = 0;
      int k = 1;
      while (j < n)
      {
        localObject2 = (CharSequence)localObject1[j];
        localObject2 = new j(",").split((CharSequence)localObject2, 0);
        Object localObject3;
        int m;
        if (!((List)localObject2).isEmpty())
        {
          localObject3 = ((List)localObject2).listIterator(((List)localObject2).size());
          while (((ListIterator)localObject3).hasPrevious())
          {
            if (((CharSequence)((ListIterator)localObject3).previous()).length() == 0) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0)
            {
              localObject2 = d.a.b.a((Iterable)localObject2, ((ListIterator)localObject3).nextIndex() + 1);
              break label367;
            }
          }
        }
        localObject2 = d.a.b.a();
        label367:
        localObject2 = ((Collection)localObject2).toArray(new String[0]);
        if (localObject2 != null)
        {
          localObject2 = (String[])localObject2;
          localArrayList.add(new LatLng(Double.parseDouble(localObject2[1]), Double.parseDouble(localObject2[0])));
          m = k;
          if (k != 0)
          {
            localObject3 = this.b;
            if (localObject3 != null) {
              ((AMap)localObject3).animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(Double.parseDouble(localObject2[1]), Double.parseDouble(localObject2[0]))));
            }
            m = 0;
          }
          j += 1;
          k = m;
        }
        else
        {
          throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((AMap)localObject1).addPolyline(new PolylineOptions().addAll((Iterable)localArrayList).width(20.0F).color(ContextCompat.getColor((Context)this, 2131099725)));
      }
    }
  }
  
  private final void j()
  {
    if (this.f != null)
    {
      Object localObject1 = this.f;
      ArrayList localArrayList = null;
      Object localObject2;
      if (localObject1 != null) {
        localObject2 = ((RoutePointModel)localObject1).getRoute();
      } else {
        localObject2 = null;
      }
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        localObject1 = (CharSequence)localObject2;
        localObject2 = new j(";").split((CharSequence)localObject1, 0);
        localObject1 = localArrayList;
        if (localObject2 != null)
        {
          if (!((List)localObject2).isEmpty())
          {
            localObject1 = ((List)localObject2).listIterator(((List)localObject2).size());
            while (((ListIterator)localObject1).hasPrevious())
            {
              if (((CharSequence)((ListIterator)localObject1).previous()).length() == 0) {
                j = 1;
              } else {
                j = 0;
              }
              if (j == 0)
              {
                localObject2 = d.a.b.a((Iterable)localObject2, ((ListIterator)localObject1).nextIndex() + 1);
                break label172;
              }
            }
          }
          localObject2 = d.a.b.a();
          label172:
          localObject1 = localArrayList;
          if (localObject2 != null)
          {
            localObject1 = ((Collection)localObject2).toArray(new String[0]);
            if (localObject1 != null) {
              localObject1 = (String[])localObject1;
            } else {
              throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
            }
          }
        }
      }
      localArrayList = new ArrayList();
      if (localObject1 == null) {
        h.a();
      }
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        localObject2 = (CharSequence)localObject1[j];
        localObject2 = new j(",").split((CharSequence)localObject2, 0);
        if (!((List)localObject2).isEmpty())
        {
          ListIterator localListIterator = ((List)localObject2).listIterator(((List)localObject2).size());
          while (localListIterator.hasPrevious())
          {
            int k;
            if (((CharSequence)localListIterator.previous()).length() == 0) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              localObject2 = d.a.b.a((Iterable)localObject2, localListIterator.nextIndex() + 1);
              break label373;
            }
          }
        }
        localObject2 = d.a.b.a();
        label373:
        localObject2 = ((Collection)localObject2).toArray(new String[0]);
        if (localObject2 != null)
        {
          localObject2 = (String[])localObject2;
          localArrayList.add(new LatLng(Double.parseDouble(localObject2[1]), Double.parseDouble(localObject2[0])));
          j += 1;
        }
        else
        {
          throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((AMap)localObject1).addPolyline(new PolylineOptions().addAll((Iterable)localArrayList).width(18.0F).color(ContextCompat.getColor(getApplicationContext(), 2131099700)));
      }
    }
  }
  
  private final void k()
  {
    Object localObject1 = this.f;
    double d1 = 90.0D;
    double d5 = 180.0D;
    double d6 = -180.0D;
    double d7 = -90.0D;
    double d2 = d5;
    double d3 = d6;
    double d4 = d7;
    int j;
    label198:
    label248:
    int m;
    ListIterator localListIterator;
    int k;
    if (localObject1 != null)
    {
      localObject1 = this.f;
      if (localObject1 != null) {
        localObject1 = ((RoutePointModel)localObject1).getRoute();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        localObject1 = new j(";").split((CharSequence)localObject1, 0);
        if (localObject1 != null)
        {
          if (!((List)localObject1).isEmpty())
          {
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            while (((ListIterator)localObject2).hasPrevious())
            {
              if (((CharSequence)((ListIterator)localObject2).previous()).length() == 0) {
                j = 1;
              } else {
                j = 0;
              }
              if (j == 0)
              {
                localObject1 = d.a.b.a((Iterable)localObject1, ((ListIterator)localObject2).nextIndex() + 1);
                break label198;
              }
            }
          }
          localObject1 = d.a.b.a();
          if (localObject1 != null)
          {
            localObject1 = ((Collection)localObject1).toArray(new String[0]);
            if (localObject1 != null)
            {
              localObject1 = (String[])localObject1;
              break label248;
            }
            throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
      }
      localObject1 = null;
      if (localObject1 == null) {
        h.a();
      }
      m = localObject1.length;
      d1 = 90.0D;
      j = 0;
      d4 = d7;
      d3 = d6;
      d2 = d5;
      while (j < m)
      {
        localObject2 = (CharSequence)localObject1[j];
        localObject2 = new j(",").split((CharSequence)localObject2, 0);
        if (!((List)localObject2).isEmpty())
        {
          localListIterator = ((List)localObject2).listIterator(((List)localObject2).size());
          while (localListIterator.hasPrevious())
          {
            if (((CharSequence)localListIterator.previous()).length() == 0) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              localObject2 = d.a.b.a((Iterable)localObject2, localListIterator.nextIndex() + 1);
              break label412;
            }
          }
        }
        localObject2 = d.a.b.a();
        label412:
        localObject2 = ((Collection)localObject2).toArray(new String[0]);
        if (localObject2 != null)
        {
          localObject2 = (String[])localObject2;
          d5 = d4;
          if (Double.parseDouble(localObject2[1]) > d4) {
            d5 = Double.parseDouble(localObject2[1]);
          }
          d6 = d1;
          if (Double.parseDouble(localObject2[1]) < d1) {
            d6 = Double.parseDouble(localObject2[1]);
          }
          d1 = d3;
          if (Double.parseDouble(localObject2[0]) > d3) {
            d1 = Double.parseDouble(localObject2[0]);
          }
          d3 = d2;
          if (Double.parseDouble(localObject2[0]) < d2) {
            d3 = Double.parseDouble(localObject2[0]);
          }
          j += 1;
          d2 = d3;
          d3 = d1;
          d4 = d5;
          d1 = d6;
        }
        else
        {
          throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
    }
    d5 = d1;
    d6 = d2;
    d7 = d3;
    double d8 = d4;
    if (this.e != null)
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        localObject1 = ((RunRegRequestModel)localObject1).getRoute();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        localObject1 = new j(";").split((CharSequence)localObject1, 0);
        if (localObject1 != null)
        {
          if (!((List)localObject1).isEmpty())
          {
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            while (((ListIterator)localObject2).hasPrevious())
            {
              if (((CharSequence)((ListIterator)localObject2).previous()).length() == 0) {
                j = 1;
              } else {
                j = 0;
              }
              if (j == 0)
              {
                localObject1 = d.a.b.a((Iterable)localObject1, ((ListIterator)localObject2).nextIndex() + 1);
                break label749;
              }
            }
          }
          localObject1 = d.a.b.a();
          label749:
          if (localObject1 != null)
          {
            localObject1 = ((Collection)localObject1).toArray(new String[0]);
            if (localObject1 != null)
            {
              localObject1 = (String[])localObject1;
              break label799;
            }
            throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
      }
      localObject1 = null;
      label799:
      d5 = d1;
      d6 = d2;
      d7 = d3;
      d8 = d4;
      if (localObject1 != null)
      {
        m = localObject1.length;
        j = 0;
        for (;;)
        {
          d5 = d1;
          d6 = d2;
          d7 = d3;
          d8 = d4;
          if (j >= m) {
            break label1135;
          }
          localObject2 = (CharSequence)localObject1[j];
          localObject2 = new j(",").split((CharSequence)localObject2, 0);
          if (!((List)localObject2).isEmpty())
          {
            localListIterator = ((List)localObject2).listIterator(((List)localObject2).size());
            while (localListIterator.hasPrevious())
            {
              if (((CharSequence)localListIterator.previous()).length() == 0) {
                k = 1;
              } else {
                k = 0;
              }
              if (k == 0)
              {
                localObject2 = d.a.b.a((Iterable)localObject2, localListIterator.nextIndex() + 1);
                break label973;
              }
            }
          }
          localObject2 = d.a.b.a();
          label973:
          localObject2 = ((Collection)localObject2).toArray(new String[0]);
          if (localObject2 == null) {
            break;
          }
          localObject2 = (String[])localObject2;
          d5 = d4;
          if (Double.parseDouble(localObject2[1]) > d4) {
            d5 = Double.parseDouble(localObject2[1]);
          }
          d4 = d1;
          if (Double.parseDouble(localObject2[1]) < d1) {
            d4 = Double.parseDouble(localObject2[1]);
          }
          d6 = d3;
          if (Double.parseDouble(localObject2[0]) > d3) {
            d6 = Double.parseDouble(localObject2[0]);
          }
          d3 = d2;
          if (Double.parseDouble(localObject2[0]) < d2) {
            d3 = Double.parseDouble(localObject2[0]);
          }
          j += 1;
          d1 = d4;
          d2 = d3;
          d3 = d6;
          d4 = d5;
        }
        throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
      }
    }
    label1135:
    localObject1 = new LatLngBounds.Builder().include(new LatLng(d5, d6)).include(new LatLng(d8, d7)).build();
    Object localObject2 = this.b;
    if (localObject2 != null) {
      ((AMap)localObject2).moveCamera(CameraUpdateFactory.newLatLngBounds((LatLngBounds)localObject1, 20));
    }
  }
  
  public View a(int paramInt)
  {
    if (this.i == null) {
      this.i = new HashMap();
    }
    View localView2 = (View)this.i.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.i.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    h.b(paramString, "path");
    h.b(paramObject, "o");
    this.h = false;
    if (paramString.hashCode() != 1550345440) {
      return;
    }
    if (paramString.equals("run_reg"))
    {
      paramString = (RunRegReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, RunRegReturnModel.class);
      if (paramString != null)
      {
        Object localObject = paramString.getCode();
        if (localObject != null)
        {
          int j = ((String)localObject).hashCode();
          paramObject = null;
          RunRegRequestModel localRunRegRequestModel = null;
          paramString = null;
          if (j != 1686169)
          {
            if (j != 1715960)
            {
              if ((j == 1715968) && (((String)localObject).equals("8008")))
              {
                paramObject = this.e;
                if (paramObject != null) {
                  ((RunRegRequestModel)paramObject).setAlreadyAppeal(true);
                }
                paramObject = this.e;
                if (paramObject != null)
                {
                  localRunRegRequestModel = this.e;
                  if (localRunRegRequestModel != null) {
                    paramString = localRunRegRequestModel.getUuid();
                  }
                  ((RunRegRequestModel)paramObject).saveOrUpdate(new String[] { "uuid = ?", paramString });
                }
                this.g = true;
                c("申诉已登记，等待后台人工处理！");
              }
            }
            else if (((String)localObject).equals("8000"))
            {
              paramString = this.e;
              if (paramString != null) {
                paramString.setAlreadyAppeal(true);
              }
              localRunRegRequestModel = this.e;
              if (localRunRegRequestModel != null)
              {
                localObject = this.e;
                paramString = (String)paramObject;
                if (localObject != null) {
                  paramString = ((RunRegRequestModel)localObject).getUuid();
                }
                localRunRegRequestModel.saveOrUpdate(new String[] { "uuid = ?", paramString });
              }
              this.g = true;
              paramString = getString(2131689526);
              h.a(paramString, "getString(R.string.appeal_success)");
              c(paramString);
            }
          }
          else if (((String)localObject).equals("7000"))
          {
            paramString = this.e;
            if (paramString != null) {
              paramString.setAlreadyAppeal(true);
            }
            paramObject = this.e;
            if (paramObject != null)
            {
              localObject = this.e;
              paramString = localRunRegRequestModel;
              if (localObject != null) {
                paramString = ((RunRegRequestModel)localObject).getUuid();
              }
              ((RunRegRequestModel)paramObject).saveOrUpdate(new String[] { "uuid = ?", paramString });
            }
            this.g = true;
            c("今天已成功提交走跑数据，无法再次提交！");
            return;
          }
        }
        c("服务器异常！");
      }
    }
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    h.b(paramString, "path");
    h.b(paramThrowable, "e");
    this.h = false;
    if (paramString.hashCode() != 1550345440) {
      return;
    }
    if (paramString.equals("run_reg")) {
      c("申诉失败，请重新申诉！");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492905);
    this.a = new f((c)this);
    f();
    this.d = i.a();
    b();
    e();
    ((MapView)a(R.id.map)).onCreate(paramBundle);
    h();
  }
  
  protected void onDestroy()
  {
    if (this.c != null)
    {
      AMapLocationClient localAMapLocationClient = this.c;
      if (localAMapLocationClient != null) {
        localAMapLocationClient.stopLocation();
      }
      localAMapLocationClient = this.c;
      if (localAMapLocationClient != null) {
        localAMapLocationClient.onDestroy();
      }
      this.c = ((AMapLocationClient)null);
    }
    ((MapView)a(R.id.map)).onDestroy();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    ((MapView)a(R.id.map)).onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    ((MapView)a(R.id.map)).onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    h.b(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    ((MapView)a(R.id.map)).onSaveInstanceState(paramBundle);
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(LocalSportRecordActivity paramLocalSportRecordActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(LocalSportRecordActivity paramLocalSportRecordActivity) {}
    
    public final void onClick(View paramView)
    {
      if (LocalSportRecordActivity.a(this.a)) {
        return;
      }
      paramView = LocalSportRecordActivity.b(this.a);
      Object localObject = null;
      if (paramView != null) {
        paramView = Boolean.valueOf(paramView.isCanAppeal());
      } else {
        paramView = null;
      }
      if (paramView == null) {
        h.a();
      }
      if (paramView.booleanValue())
      {
        if (LocalSportRecordActivity.c(this.a)) {
          return;
        }
        paramView = LocalSportRecordActivity.b(this.a);
        if (paramView != null) {
          paramView.setFlag("N");
        }
        RunRegRequestModel localRunRegRequestModel = LocalSportRecordActivity.b(this.a);
        if (localRunRegRequestModel != null)
        {
          LoginReturnModel localLoginReturnModel = LocalSportRecordActivity.d(this.a);
          paramView = (View)localObject;
          if (localLoginReturnModel != null) {
            paramView = localLoginReturnModel.getSchoolID();
          }
          localRunRegRequestModel.setSchoolName(paramView);
        }
        paramView = LocalSportRecordActivity.e(this.a);
        if (paramView != null) {
          paramView.a(LocalSportRecordActivity.b(this.a), this.a.getBaseContext());
        }
        LocalSportRecordActivity.a(this.a, true);
      }
    }
  }
  
  static final class c
    implements OneButtonDialog.a
  {
    c(LocalSportRecordActivity paramLocalSportRecordActivity) {}
    
    public final void a(String paramString)
    {
      if ((h.a("confirm_btn", paramString)) && (LocalSportRecordActivity.a(this.a))) {
        this.a.finish();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\run\LocalSportRecordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */