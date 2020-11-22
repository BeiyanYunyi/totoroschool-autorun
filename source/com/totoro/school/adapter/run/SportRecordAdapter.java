package com.totoro.school.adapter.run;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.totoro.school.activity.run.LocalSportRecordActivity;
import com.totoro.school.entity.run.reg.RunRegRequestModel;
import com.totoro.school.entity.run.routePoint.RoutePointModel;
import java.util.List;
import org.litepal.FluentQuery;
import org.litepal.LitePal;

public class SportRecordAdapter
  extends RecyclerView.Adapter<a>
{
  private List<RunRegRequestModel> a;
  private Activity b;
  
  public SportRecordAdapter(List<RunRegRequestModel> paramList, Activity paramActivity)
  {
    this.a = paramList;
    this.b = paramActivity;
  }
  
  @NonNull
  public a a(@NonNull final ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492969, paramViewGroup, false));
    paramViewGroup.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramViewGroup.getAdapterPosition();
        paramAnonymousView = (RunRegRequestModel)SportRecordAdapter.a(SportRecordAdapter.this).get(i);
        RoutePointModel localRoutePointModel = (RoutePointModel)LitePal.where(new String[] { "uuid = ?", paramAnonymousView.getUuid() }).findFirst(RoutePointModel.class);
        Intent localIntent = new Intent(SportRecordAdapter.b(SportRecordAdapter.this), LocalSportRecordActivity.class);
        localIntent.putExtra("runRegRequestModel", paramAnonymousView);
        localIntent.putExtra("routePointModel", localRoutePointModel);
        SportRecordAdapter.b(SportRecordAdapter.this).startActivity(localIntent);
      }
    });
    return paramViewGroup;
  }
  
  public void a(@NonNull a parama, int paramInt)
  {
    RunRegRequestModel localRunRegRequestModel = (RunRegRequestModel)this.a.get(paramInt);
    parama.b.setText(localRunRegRequestModel.getBegdate());
    TextView localTextView = parama.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localRunRegRequestModel.getUserbegtime());
    localStringBuilder.append("-");
    localStringBuilder.append(localRunRegRequestModel.getUserendtime());
    localTextView.setText(localStringBuilder.toString());
    parama.c.setText(localRunRegRequestModel.getUserkm());
    parama.e.setText(localRunRegRequestModel.getUsertime());
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    View a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131296544));
      this.c = ((TextView)paramView.findViewById(2131296545));
      this.d = ((TextView)paramView.findViewById(2131296547));
      this.e = ((TextView)paramView.findViewById(2131296368));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\run\SportRecordAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */