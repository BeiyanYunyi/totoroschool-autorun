package org.angmarch.views;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public abstract class c<T>
  extends BaseAdapter
{
  int a;
  private final e b;
  private int c;
  private int d;
  
  c(Context paramContext, int paramInt1, int paramInt2, e parame)
  {
    this.b = parame;
    this.d = paramInt2;
    this.c = paramInt1;
  }
  
  public abstract T a(int paramInt);
  
  void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public abstract int getCount();
  
  public abstract T getItem(int paramInt);
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, @Nullable View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = View.inflate((Context)localObject, R.layout.spinner_list_item, null);
      paramView = (TextView)paramViewGroup.findViewById(R.id.text_view_spinner);
      if (Build.VERSION.SDK_INT >= 16) {
        paramView.setBackground(ContextCompat.getDrawable((Context)localObject, this.d));
      }
      paramViewGroup.setTag(new a(paramView));
    }
    else
    {
      localObject = ((a)paramView.getTag()).a;
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    paramView.setText(this.b.a(getItem(paramInt).toString()));
    paramView.setTextColor(this.c);
    return paramViewGroup;
  }
  
  static class a
  {
    TextView a;
    
    a(TextView paramTextView)
    {
      this.a = paramTextView;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\angmarch\views\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */