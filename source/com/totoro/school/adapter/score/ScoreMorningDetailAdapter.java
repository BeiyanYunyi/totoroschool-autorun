package com.totoro.school.adapter.score;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.totoro.school.entity.score.morning.ScoreMorningDetailModel;
import java.util.List;

public class ScoreMorningDetailAdapter
  extends RecyclerView.Adapter<a>
{
  private List<ScoreMorningDetailModel> a;
  private Activity b;
  
  public ScoreMorningDetailAdapter(List<ScoreMorningDetailModel> paramList, Activity paramActivity)
  {
    this.a = paramList;
    this.b = paramActivity;
  }
  
  @NonNull
  public a a(@NonNull final ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492961, paramViewGroup, false));
    paramViewGroup.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramViewGroup.getAdapterPosition();
        paramAnonymousView = (ScoreMorningDetailModel)ScoreMorningDetailAdapter.a(ScoreMorningDetailAdapter.this).get(i);
      }
    });
    return paramViewGroup;
  }
  
  public void a(@NonNull a parama, int paramInt)
  {
    ScoreMorningDetailModel localScoreMorningDetailModel = (ScoreMorningDetailModel)this.a.get(paramInt);
    parama.b.setText(localScoreMorningDetailModel.getCheckdate());
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
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131296597));
      this.c = ((TextView)paramView.findViewById(2131296598));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\score\ScoreMorningDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */