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
import com.totoro.school.activity.score.ScoreMorningListActivity;
import com.totoro.school.entity.score.morning.ScoreMorningModel;
import java.util.List;

public class ScoreMorningNewAdapter
  extends RecyclerView.Adapter<a>
{
  public static String a = "";
  private List<ScoreMorningModel> b;
  private Activity c;
  
  public ScoreMorningNewAdapter(List<ScoreMorningModel> paramList, Activity paramActivity)
  {
    this.b = paramList;
    this.c = paramActivity;
  }
  
  @NonNull
  public a a(@NonNull final ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492962, paramViewGroup, false));
    paramViewGroup.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = paramViewGroup.getAdapterPosition();
        paramAnonymousView = (ScoreMorningModel)ScoreMorningNewAdapter.a(ScoreMorningNewAdapter.this).get(i);
        Intent localIntent = new Intent(ScoreMorningNewAdapter.b(ScoreMorningNewAdapter.this), ScoreMorningListActivity.class);
        localIntent.putExtra("academicYear", ScoreMorningNewAdapter.a);
        localIntent.putExtra("academicMonth", paramAnonymousView.getMonthid());
        ScoreMorningNewAdapter.b(ScoreMorningNewAdapter.this).startActivity(localIntent);
      }
    });
    return paramViewGroup;
  }
  
  public void a(@NonNull a parama, int paramInt)
  {
    Object localObject = (ScoreMorningModel)this.b.get(paramInt);
    parama.b.setText(((ScoreMorningModel)localObject).getMonthid());
    parama.c.setText(((ScoreMorningModel)localObject).getMonthid());
    parama.f.setText(((ScoreMorningModel)localObject).getNmonthSuccess());
    parama.e.setText(((ScoreMorningModel)localObject).getMonthSuccess());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Integer.parseInt(((ScoreMorningModel)localObject).getNmonthSuccess()) + Integer.parseInt(((ScoreMorningModel)localObject).getMonthSuccess()));
    localObject = localStringBuilder.toString();
    parama.d.setText((CharSequence)localObject);
    if (paramInt == 0) {
      parama.g.setVisibility(4);
    } else {
      parama.g.setVisibility(0);
    }
    if (paramInt == this.b.size() - 1)
    {
      parama.h.setVisibility(4);
      return;
    }
    parama.h.setVisibility(0);
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
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131296393));
      this.c = ((TextView)paramView.findViewById(2131296585));
      this.d = ((TextView)paramView.findViewById(2131296667));
      this.e = ((TextView)paramView.findViewById(2131296506));
      this.f = ((TextView)paramView.findViewById(2131296292));
      this.g = ((TextView)paramView.findViewById(2131296678));
      this.h = ((TextView)paramView.findViewById(2131296675));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\score\ScoreMorningNewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */