package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

class AppCompatHintHelper
{
  static InputConnection onCreateInputConnection(InputConnection paramInputConnection, EditorInfo paramEditorInfo, View paramView)
  {
    if ((paramInputConnection != null) && (paramEditorInfo.hintText == null)) {
      for (paramView = paramView.getParent(); (paramView instanceof View); paramView = paramView.getParent()) {
        if ((paramView instanceof WithHint))
        {
          paramEditorInfo.hintText = ((WithHint)paramView).getHint();
          return paramInputConnection;
        }
      }
    }
    return paramInputConnection;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\AppCompatHintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */