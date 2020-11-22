package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;

class TransitionValuesMaps
{
  final SparseArray<View> mIdValues = new SparseArray();
  final LongSparseArray<View> mItemIdValues = new LongSparseArray();
  final ArrayMap<String, View> mNameValues = new ArrayMap();
  final ArrayMap<View, TransitionValues> mViewValues = new ArrayMap();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\TransitionValuesMaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */