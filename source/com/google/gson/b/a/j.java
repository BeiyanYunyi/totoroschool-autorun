package com.google.gson.b.a;

import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class j
  extends t<Date>
{
  public static final u a = new u()
  {
    public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
    {
      if (paramAnonymousa.a() == Date.class) {
        return new j();
      }
      return null;
    }
  };
  private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");
  
  /* Error */
  public Date a(com.google.gson.stream.JsonReader paramJsonReader)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 40	com/google/gson/stream/JsonReader:peek	()Lcom/google/gson/stream/JsonToken;
    //   6: getstatic 46	com/google/gson/stream/JsonToken:NULL	Lcom/google/gson/stream/JsonToken;
    //   9: if_acmpne +11 -> 20
    //   12: aload_1
    //   13: invokevirtual 49	com/google/gson/stream/JsonReader:nextNull	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: new 51	java/sql/Date
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	com/google/gson/b/a/j:b	Ljava/text/DateFormat;
    //   28: aload_1
    //   29: invokevirtual 55	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
    //   32: invokevirtual 61	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   35: invokevirtual 67	java/util/Date:getTime	()J
    //   38: invokespecial 70	java/sql/Date:<init>	(J)V
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: new 72	com/google/gson/r
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 75	com/google/gson/r:<init>	(Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	j
    //   0	61	1	paramJsonReader	com.google.gson.stream.JsonReader
    // Exception table:
    //   from	to	target	type
    //   20	42	46	java/text/ParseException
    //   2	16	56	finally
    //   20	42	56	finally
    //   47	56	56	finally
  }
  
  public void a(JsonWriter paramJsonWriter, Date paramDate)
    throws IOException
  {
    if (paramDate == null) {
      paramDate = null;
    }
    try
    {
      paramDate = this.b.format(paramDate);
      paramJsonWriter.value(paramDate);
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */