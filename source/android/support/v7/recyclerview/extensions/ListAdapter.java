package android.support.v7.recyclerview.extensions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.AdapterListUpdateCallback;
import android.support.v7.util.DiffUtil.ItemCallback;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<VH>
{
  private final AsyncListDiffer<T> mHelper;
  
  protected ListAdapter(@NonNull AsyncDifferConfig<T> paramAsyncDifferConfig)
  {
    this.mHelper = new AsyncListDiffer(new AdapterListUpdateCallback(this), paramAsyncDifferConfig);
  }
  
  protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this.mHelper = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(paramItemCallback).build());
  }
  
  protected T getItem(int paramInt)
  {
    return (T)this.mHelper.getCurrentList().get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mHelper.getCurrentList().size();
  }
  
  public void submitList(@Nullable List<T> paramList)
  {
    this.mHelper.submitList(paramList);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\recyclerview\extensions\ListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */