package com.totoro.school.adapter.common;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.totoro.school.entity.common.campus.CampusListModel;
import java.util.List;

public class SelectCampusAdapter
  extends BaseAdapter
{
  private List<CampusListModel> a;
  private Context b;
  private int c;
  private boolean d;
  private String e;
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2131492958, null);
      paramViewGroup = new ViewHolder(paramView);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
    paramViewGroup.tvConent.setText(((CampusListModel)this.a.get(paramInt)).getName());
    paramViewGroup = paramViewGroup.tvConent.getPaint();
    if (this.d)
    {
      if (this.c == paramInt)
      {
        paramViewGroup.setTypeface(Typeface.DEFAULT_BOLD);
        paramViewGroup.setFakeBoldText(true);
        return paramView;
      }
      paramViewGroup.setTypeface(Typeface.DEFAULT);
      paramViewGroup.setFakeBoldText(false);
      return paramView;
    }
    if (((CampusListModel)this.a.get(paramInt)).getName().equals(this.e))
    {
      paramViewGroup.setTypeface(Typeface.DEFAULT_BOLD);
      paramViewGroup.setFakeBoldText(true);
      return paramView;
    }
    paramViewGroup.setTypeface(Typeface.DEFAULT);
    paramViewGroup.setFakeBoldText(false);
    return paramView;
  }
  
  static class ViewHolder
  {
    @BindView(2131296682)
    TextView tvConent;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\common\SelectCampusAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */