package com.totoro.school.adapter.score;

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
import com.totoro.school.activity.score.ScoreRunListActivity;
import com.totoro.school.entity.score.run.ScoreRunModel;
import java.util.List;

public class ScoreRunAdapter
  extends RecyclerView.Adapter<a>
{
  public static String a = "";
  private List<ScoreRunModel> b;
  private Activity c;
  
  @NonNull
  public a a(@NonNull final ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492963, paramViewGroup, false));
    paramViewGroup.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramViewGroup.getAdapterPosition();
        paramAnonymousView = (ScoreRunModel)ScoreRunAdapter.a(ScoreRunAdapter.this).get(i);
        Intent localIntent = new Intent(ScoreRunAdapter.b(ScoreRunAdapter.this), ScoreRunListActivity.class);
        localIntent.putExtra("academicYear", ScoreRunAdapter.a);
        localIntent.putExtra("academicMonth", paramAnonymousView.getMonthid());
        ScoreRunAdapter.b(ScoreRunAdapter.this).startActivity(localIntent);
      }
    });
    return paramViewGroup;
  }
  
  public void a(@NonNull a parama, int paramInt)
  {
    ScoreRunModel localScoreRunModel = (ScoreRunModel)this.b.get(paramInt);
    parama.b.setText(localScoreRunModel.getMonthid());
    parama.c.setText(localScoreRunModel.getMonthSuccess());
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    View a;
    TextView b;
    TextView c;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131296477));
      this.c = ((TextView)paramView.findViewById(2131296657));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\score\ScoreRunAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */