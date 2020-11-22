package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.tencent.smtt.sdk.a.d;

class ba
  implements TbsReaderView.ReaderCallback
{
  ba(TbsReaderView paramTbsReaderView) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    int i = paramInteger.intValue();
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    int j = 1;
    Object localObject1;
    if (i != 5026) {
      if (i != 5030)
      {
        switch (i)
        {
        }
        for (;;)
        {
          i = 0;
          localObject1 = paramInteger;
          localObject2 = paramObject1;
          break label717;
          if (!d.c(this.a.a))
          {
            paramObject1 = Integer.valueOf(5011);
            localObject1 = TbsReaderView.getResString(this.a.a, 5022);
            paramInteger = new Bundle();
            paramInteger.putString("tip", (String)localObject1);
            paramInteger.putString("statistics", "AHNG816");
            paramInteger.putInt("channel_id", 10835);
            localObject2 = this.a;
            localObject1 = "AHNG815";
          }
          else
          {
            localObject1 = "";
            if (paramObject1 != null)
            {
              localObject2 = (Bundle)paramObject1;
              localObject1 = ((Bundle)localObject2).getString("docpath");
            }
            QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "txt", (Bundle)localObject2);
            i = j;
            localObject1 = paramInteger;
            localObject2 = paramObject1;
            break label717;
            if (!d.c(this.a.a))
            {
              paramObject1 = Integer.valueOf(5011);
              localObject1 = TbsReaderView.getResString(this.a.a, 5021);
              paramInteger = new Bundle();
              paramInteger.putString("tip", (String)localObject1);
              paramInteger.putString("statistics", "AHNG808");
              paramInteger.putInt("channel_id", 10833);
              localObject2 = this.a;
              localObject1 = "AHNG807";
            }
            else
            {
              localObject1 = "";
              localObject2 = localObject3;
              if (paramObject1 != null)
              {
                localObject2 = (Bundle)paramObject1;
                localObject1 = ((Bundle)localObject2).getString("docpath");
              }
              QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "", (Bundle)localObject2);
              localObject1 = this.a;
              localObject2 = "AHNG809";
              break label504;
              if (d.c(this.a.a)) {
                break;
              }
              paramObject1 = Integer.valueOf(5011);
              localObject1 = TbsReaderView.getResString(this.a.a, 5023);
              paramInteger = new Bundle();
              paramInteger.putString("tip", (String)localObject1);
              paramInteger.putString("statistics", "AHNG812");
              paramInteger.putInt("channel_id", 10834);
              localObject2 = this.a;
              localObject1 = "AHNG811";
            }
          }
          ((TbsReaderView)localObject2).userStatistics((String)localObject1);
          localObject1 = paramInteger;
          paramInteger = (Integer)paramObject1;
          paramObject1 = localObject1;
        }
        localObject1 = "";
        localObject2 = localObject4;
        if (paramObject1 != null)
        {
          localObject2 = (Bundle)paramObject1;
          localObject1 = ((Bundle)localObject2).getString("docpath");
        }
        QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "pdf", (Bundle)localObject2);
        localObject1 = this.a;
      }
    }
    for (localObject2 = "AHNG813";; localObject2 = "AHNG829")
    {
      label504:
      ((TbsReaderView)localObject1).userStatistics((String)localObject2);
      i = j;
      localObject1 = paramInteger;
      localObject2 = paramObject1;
      break label717;
      i = j;
      localObject1 = paramInteger;
      localObject2 = paramObject1;
      if (paramObject1 == null) {
        break label717;
      }
      localObject1 = (Bundle)paramObject1;
      TbsReaderView.gReaderPackName = ((Bundle)localObject1).getString("name");
      TbsReaderView.gReaderPackVersion = ((Bundle)localObject1).getString("version");
      i = j;
      localObject1 = paramInteger;
      localObject2 = paramObject1;
      break label717;
      if (!d.c(this.a.a))
      {
        paramObject1 = Integer.valueOf(5011);
        localObject1 = TbsReaderView.getResString(this.a.a, 5029);
        paramInteger = new Bundle();
        paramInteger.putString("tip", (String)localObject1);
        paramInteger.putString("statistics", "AHNG828");
        paramInteger.putInt("channel_id", 10965);
        localObject2 = this.a;
        localObject1 = "AHNG827";
        break;
      }
      localObject1 = "";
      localObject2 = localObject5;
      if (paramObject1 != null)
      {
        localObject2 = (Bundle)paramObject1;
        localObject1 = ((Bundle)localObject2).getString("docpath");
      }
      QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "doc", (Bundle)localObject2);
      localObject1 = this.a;
    }
    label717:
    if ((this.a.d != null) && (i == 0)) {
      this.a.d.onCallBackAction((Integer)localObject1, localObject2, paramObject2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */