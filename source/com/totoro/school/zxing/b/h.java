package com.totoro.school.zxing.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.totoro.school.activity.morning.MorningExercisesActivity;
import java.util.Hashtable;

final class h
  extends Handler
{
  private static final String a = "h";
  private final MorningExercisesActivity b;
  private final MultiFormatReader c = new MultiFormatReader();
  
  h(MorningExercisesActivity paramMorningExercisesActivity, Hashtable<DecodeHintType, Object> paramHashtable)
  {
    this.c.setHints(paramHashtable);
    this.b = paramMorningExercisesActivity;
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_1
    //   6: arraylength
    //   7: newarray <illegal type>
    //   9: astore 10
    //   11: iconst_0
    //   12: istore 4
    //   14: iload 4
    //   16: iload_3
    //   17: if_icmpge +53 -> 70
    //   20: iconst_0
    //   21: istore 5
    //   23: iload 5
    //   25: iload_2
    //   26: if_icmpge +35 -> 61
    //   29: aload 10
    //   31: iload 5
    //   33: iload_3
    //   34: imul
    //   35: iload_3
    //   36: iadd
    //   37: iload 4
    //   39: isub
    //   40: iconst_1
    //   41: isub
    //   42: aload_1
    //   43: iload 4
    //   45: iload_2
    //   46: imul
    //   47: iload 5
    //   49: iadd
    //   50: baload
    //   51: bastore
    //   52: iload 5
    //   54: iconst_1
    //   55: iadd
    //   56: istore 5
    //   58: goto -35 -> 23
    //   61: iload 4
    //   63: iconst_1
    //   64: iadd
    //   65: istore 4
    //   67: goto -53 -> 14
    //   70: invokestatic 46	com/totoro/school/zxing/a/c:a	()Lcom/totoro/school/zxing/a/c;
    //   73: aload 10
    //   75: iload_3
    //   76: iload_2
    //   77: invokevirtual 49	com/totoro/school/zxing/a/c:a	([BII)Lcom/totoro/school/zxing/a/e;
    //   80: astore 10
    //   82: new 51	com/google/zxing/BinaryBitmap
    //   85: dup
    //   86: new 53	com/google/zxing/common/HybridBinarizer
    //   89: dup
    //   90: aload 10
    //   92: invokespecial 56	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   95: invokespecial 59	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 24	com/totoro/school/zxing/b/h:c	Lcom/google/zxing/MultiFormatReader;
    //   103: aload_1
    //   104: invokevirtual 63	com/google/zxing/MultiFormatReader:decodeWithState	(Lcom/google/zxing/BinaryBitmap;)Lcom/google/zxing/Result;
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 24	com/totoro/school/zxing/b/h:c	Lcom/google/zxing/MultiFormatReader;
    //   112: invokevirtual 66	com/google/zxing/MultiFormatReader:reset	()V
    //   115: goto +22 -> 137
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 24	com/totoro/school/zxing/b/h:c	Lcom/google/zxing/MultiFormatReader;
    //   123: invokevirtual 66	com/google/zxing/MultiFormatReader:reset	()V
    //   126: aload_1
    //   127: athrow
    //   128: aload_0
    //   129: getfield 24	com/totoro/school/zxing/b/h:c	Lcom/google/zxing/MultiFormatReader;
    //   132: invokevirtual 66	com/google/zxing/MultiFormatReader:reset	()V
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +116 -> 254
    //   141: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   144: lstore 8
    //   146: getstatic 68	com/totoro/school/zxing/b/h:a	Ljava/lang/String;
    //   149: astore 11
    //   151: new 70	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   158: astore 12
    //   160: aload 12
    //   162: ldc 73
    //   164: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 12
    //   170: lload 8
    //   172: lload 6
    //   174: lsub
    //   175: invokevirtual 80	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 12
    //   181: ldc 82
    //   183: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 12
    //   189: aload_1
    //   190: invokevirtual 88	com/google/zxing/Result:toString	()Ljava/lang/String;
    //   193: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 11
    //   199: aload 12
    //   201: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: aload_0
    //   209: getfield 30	com/totoro/school/zxing/b/h:b	Lcom/totoro/school/activity/morning/MorningExercisesActivity;
    //   212: invokevirtual 100	com/totoro/school/activity/morning/MorningExercisesActivity:b	()Landroid/os/Handler;
    //   215: ldc 101
    //   217: aload_1
    //   218: invokestatic 107	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   221: astore_1
    //   222: new 109	android/os/Bundle
    //   225: dup
    //   226: invokespecial 110	android/os/Bundle:<init>	()V
    //   229: astore 11
    //   231: aload 11
    //   233: ldc 112
    //   235: aload 10
    //   237: invokevirtual 117	com/totoro/school/zxing/a/e:a	()Landroid/graphics/Bitmap;
    //   240: invokevirtual 121	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   243: aload_1
    //   244: aload 11
    //   246: invokevirtual 125	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   249: aload_1
    //   250: invokevirtual 128	android/os/Message:sendToTarget	()V
    //   253: return
    //   254: aload_0
    //   255: getfield 30	com/totoro/school/zxing/b/h:b	Lcom/totoro/school/activity/morning/MorningExercisesActivity;
    //   258: invokevirtual 100	com/totoro/school/activity/morning/MorningExercisesActivity:b	()Landroid/os/Handler;
    //   261: ldc -127
    //   263: invokestatic 132	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   266: invokevirtual 128	android/os/Message:sendToTarget	()V
    //   269: return
    //   270: astore_1
    //   271: goto -143 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	h
    //   0	274	1	paramArrayOfByte	byte[]
    //   0	274	2	paramInt1	int
    //   0	274	3	paramInt2	int
    //   12	54	4	i	int
    //   21	36	5	j	int
    //   3	170	6	l1	long
    //   144	27	8	l2	long
    //   9	227	10	localObject1	Object
    //   149	96	11	localObject2	Object
    //   158	42	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   99	108	118	finally
    //   99	108	270	com/google/zxing/ReaderException
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2131296345)
    {
      if (i != 2131296525) {
        return;
      }
      Looper.myLooper().quit();
      return;
    }
    a((byte[])paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */