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
import com.totoro.school.entity.score.test.ScoreTestModel;
import java.util.List;

public class ScoreTestAdapter
  extends RecyclerView.Adapter<a>
{
  private List<ScoreTestModel> a;
  private Activity b;
  
  public ScoreTestAdapter(List<ScoreTestModel> paramList, Activity paramActivity)
  {
    this.a = paramList;
    this.b = paramActivity;
  }
  
  @NonNull
  public a a(@NonNull final ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492967, paramViewGroup, false));
    paramViewGroup.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramViewGroup.getAdapterPosition();
        paramAnonymousView = (ScoreTestModel)ScoreTestAdapter.a(ScoreTestAdapter.this).get(i);
      }
    });
    return paramViewGroup;
  }
  
  public void a(@NonNull a parama, int paramInt)
  {
    ScoreTestModel localScoreTestModel = (ScoreTestModel)this.a.get(paramInt);
    parama.b.setText(localScoreTestModel.getTc_item());
    parama.c.setText(localScoreTestModel.getScore());
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
      this.b = ((TextView)paramView.findViewById(2131296630));
      this.c = ((TextView)paramView.findViewById(2131296567));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\score\ScoreTestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */