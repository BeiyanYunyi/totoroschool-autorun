package com.google.gson.b.a;

import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public final class c
  extends t<Date>
{
  public static final u a = new u()
  {
    public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
    {
      if (paramAnonymousa.a() == Date.class) {
        return new c();
      }
      return null;
    }
  };
  private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
  
  /* Error */
  private Date a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/google/gson/b/a/c:c	Ljava/text/DateFormat;
    //   6: aload_1
    //   7: invokevirtual 46	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_1
    //   16: goto +44 -> 60
    //   19: aload_0
    //   20: getfield 35	com/google/gson/b/a/c:b	Ljava/text/DateFormat;
    //   23: aload_1
    //   24: invokevirtual 46	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: areturn
    //   32: aload_1
    //   33: new 48	java/text/ParsePosition
    //   36: dup
    //   37: iconst_0
    //   38: invokespecial 51	java/text/ParsePosition:<init>	(I)V
    //   41: invokestatic 56	com/google/gson/b/a/a/a:a	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: areturn
    //   49: astore_2
    //   50: new 58	com/google/gson/r
    //   53: dup
    //   54: aload_1
    //   55: aload_2
    //   56: invokespecial 61	com/google/gson/r:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_2
    //   65: goto -46 -> 19
    //   68: astore_2
    //   69: goto -37 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	c
    //   0	72	1	paramString	String
    //   10	38	2	localDate	Date
    //   49	7	2	localParseException1	java.text.ParseException
    //   64	1	2	localParseException2	java.text.ParseException
    //   68	1	2	localParseException3	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
    //   19	28	15	finally
    //   32	45	15	finally
    //   50	60	15	finally
    //   32	45	49	java/text/ParseException
    //   2	11	64	java/text/ParseException
    //   19	28	68	java/text/ParseException
  }
  
  public Date a(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return a(paramJsonReader.nextString());
  }
  
  public void a(JsonWriter paramJsonWriter, Date paramDate)
    throws IOException
  {
    if (paramDate == null) {
      try
      {
        paramJsonWriter.nullValue();
        return;
      }
      finally
      {
        break label34;
      }
    }
    paramJsonWriter.value(this.b.format(paramDate));
    return;
    label34:
    throw paramJsonWriter;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */