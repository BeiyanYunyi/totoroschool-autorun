package com.totoro.school.adapter.score;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.totoro.school.activity.score.SportRecordActivity;
import com.totoro.school.entity.score.run.ScoreRunDetailModel;
import java.util.List;

public class ScoreRunDetailAdapter
  extends RecyclerView.Adapter<a>
{
  private List<ScoreRunDetailModel> a;
  private Activity b;
  
  public ScoreRunDetailAdapter(List<ScoreRunDetailModel> paramList, Activity paramActivity)
  {
    this.a = paramList;
    this.b = paramActivity;
  }
  
  @NonNull
  public a a(@NonNull final ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492964, paramViewGroup, false));
    paramViewGroup.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramViewGroup.getAdapterPosition();
        paramAnonymousView = (ScoreRunDetailModel)ScoreRunDetailAdapter.a(ScoreRunDetailAdapter.this).get(i);
        Intent localIntent = new Intent(ScoreRunDetailAdapter.b(ScoreRunDetailAdapter.this), SportRecordActivity.class);
        localIntent.putExtra("scoreRunDetailModel", paramAnonymousView);
        ScoreRunDetailAdapter.b(ScoreRunDetailAdapter.this).startActivity(localIntent);
      }
    });
    return paramViewGroup;
  }
  
  public void a(@NonNull a parama, int paramInt)
  {
    ScoreRunDetailModel localScoreRunDetailModel = (ScoreRunDetailModel)this.a.get(paramInt);
    parama.b.setText(localScoreRunDetailModel.getBegdate());
    double d = localScoreRunDetailModel.getTotalKm();
    parama.c.setText(String.valueOf(d));
    parama.d.setText(localScoreRunDetailModel.getDurationTime());
    if ("Y".equals(localScoreRunDetailModel.getFlag()))
    {
      parama.e.setText(this.b.getString(2131689682));
      parama.e.setTextColor(this.b.getResources().getColor(2131099678));
      return;
    }
    parama.e.setText(this.b.getString(2131689674));
    parama.e.setTextColor(this.b.getResources().getColor(2131099700));
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
      this.d = ((TextView)paramView.findViewById(2131296368));
      this.e = ((TextView)paramView.findViewById(2131296546));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\score\ScoreRunDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */