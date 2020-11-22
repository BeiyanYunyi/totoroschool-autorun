package com.google.zxing.client.result;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CalendarParsedResult
  extends ParsedResult
{
  private static final Pattern DATE_TIME = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
  private static final Pattern RFC2445_DURATION = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
  private static final long[] RFC2445_DURATION_FIELD_UNITS = { 604800000L, 86400000L, 3600000L, 60000L, 1000L };
  private final String[] attendees;
  private final String description;
  private final Date end;
  private final boolean endAllDay;
  private final double latitude;
  private final String location;
  private final double longitude;
  private final String organizer;
  private final Date start;
  private final boolean startAllDay;
  private final String summary;
  
  /* Error */
  public CalendarParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, String paramString7, double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 64	com/google/zxing/client/result/ParsedResultType:CALENDAR	Lcom/google/zxing/client/result/ParsedResultType;
    //   4: invokespecial 67	com/google/zxing/client/result/ParsedResult:<init>	(Lcom/google/zxing/client/result/ParsedResultType;)V
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 69	com/google/zxing/client/result/CalendarParsedResult:summary	Ljava/lang/String;
    //   12: aload_0
    //   13: aload_2
    //   14: invokestatic 73	com/google/zxing/client/result/CalendarParsedResult:parseDate	(Ljava/lang/String;)Ljava/util/Date;
    //   17: putfield 75	com/google/zxing/client/result/CalendarParsedResult:start	Ljava/util/Date;
    //   20: aload_3
    //   21: ifnonnull +48 -> 69
    //   24: aload 4
    //   26: invokestatic 79	com/google/zxing/client/result/CalendarParsedResult:parseDurationMS	(Ljava/lang/CharSequence;)J
    //   29: lstore 14
    //   31: lload 14
    //   33: lconst_0
    //   34: lcmp
    //   35: ifge +8 -> 43
    //   38: aconst_null
    //   39: astore_1
    //   40: goto +21 -> 61
    //   43: new 81	java/util/Date
    //   46: dup
    //   47: aload_0
    //   48: getfield 75	com/google/zxing/client/result/CalendarParsedResult:start	Ljava/util/Date;
    //   51: invokevirtual 85	java/util/Date:getTime	()J
    //   54: lload 14
    //   56: ladd
    //   57: invokespecial 88	java/util/Date:<init>	(J)V
    //   60: astore_1
    //   61: aload_0
    //   62: aload_1
    //   63: putfield 90	com/google/zxing/client/result/CalendarParsedResult:end	Ljava/util/Date;
    //   66: goto +11 -> 77
    //   69: aload_0
    //   70: aload_3
    //   71: invokestatic 73	com/google/zxing/client/result/CalendarParsedResult:parseDate	(Ljava/lang/String;)Ljava/util/Date;
    //   74: putfield 90	com/google/zxing/client/result/CalendarParsedResult:end	Ljava/util/Date;
    //   77: aload_2
    //   78: invokevirtual 96	java/lang/String:length	()I
    //   81: istore 13
    //   83: iconst_0
    //   84: istore 17
    //   86: iload 13
    //   88: bipush 8
    //   90: if_icmpne +9 -> 99
    //   93: iconst_1
    //   94: istore 16
    //   96: goto +6 -> 102
    //   99: iconst_0
    //   100: istore 16
    //   102: aload_0
    //   103: iload 16
    //   105: putfield 98	com/google/zxing/client/result/CalendarParsedResult:startAllDay	Z
    //   108: iload 17
    //   110: istore 16
    //   112: aload_3
    //   113: ifnull +19 -> 132
    //   116: iload 17
    //   118: istore 16
    //   120: aload_3
    //   121: invokevirtual 96	java/lang/String:length	()I
    //   124: bipush 8
    //   126: if_icmpne +6 -> 132
    //   129: iconst_1
    //   130: istore 16
    //   132: aload_0
    //   133: iload 16
    //   135: putfield 100	com/google/zxing/client/result/CalendarParsedResult:endAllDay	Z
    //   138: aload_0
    //   139: aload 5
    //   141: putfield 102	com/google/zxing/client/result/CalendarParsedResult:location	Ljava/lang/String;
    //   144: aload_0
    //   145: aload 6
    //   147: putfield 104	com/google/zxing/client/result/CalendarParsedResult:organizer	Ljava/lang/String;
    //   150: aload_0
    //   151: aload 7
    //   153: putfield 106	com/google/zxing/client/result/CalendarParsedResult:attendees	[Ljava/lang/String;
    //   156: aload_0
    //   157: aload 8
    //   159: putfield 108	com/google/zxing/client/result/CalendarParsedResult:description	Ljava/lang/String;
    //   162: aload_0
    //   163: dload 9
    //   165: putfield 110	com/google/zxing/client/result/CalendarParsedResult:latitude	D
    //   168: aload_0
    //   169: dload 11
    //   171: putfield 112	com/google/zxing/client/result/CalendarParsedResult:longitude	D
    //   174: return
    //   175: astore_1
    //   176: new 114	java/lang/IllegalArgumentException
    //   179: dup
    //   180: aload_1
    //   181: invokevirtual 118	java/text/ParseException:toString	()Ljava/lang/String;
    //   184: invokespecial 121	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    //   188: astore_1
    //   189: new 114	java/lang/IllegalArgumentException
    //   192: dup
    //   193: aload_1
    //   194: invokevirtual 118	java/text/ParseException:toString	()Ljava/lang/String;
    //   197: invokespecial 121	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	CalendarParsedResult
    //   0	201	1	paramString1	String
    //   0	201	2	paramString2	String
    //   0	201	3	paramString3	String
    //   0	201	4	paramString4	String
    //   0	201	5	paramString5	String
    //   0	201	6	paramString6	String
    //   0	201	7	paramArrayOfString	String[]
    //   0	201	8	paramString7	String
    //   0	201	9	paramDouble1	double
    //   0	201	11	paramDouble2	double
    //   81	10	13	i	int
    //   29	26	14	l	long
    //   94	40	16	bool1	boolean
    //   84	33	17	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   69	77	175	java/text/ParseException
    //   12	20	188	java/text/ParseException
  }
  
  private static DateFormat buildDateFormat()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }
  
  private static DateFormat buildDateTimeFormat()
  {
    return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
  }
  
  private static String format(boolean paramBoolean, Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    DateFormat localDateFormat;
    if (paramBoolean) {
      localDateFormat = DateFormat.getDateInstance(2);
    } else {
      localDateFormat = DateFormat.getDateTimeInstance(2, 2);
    }
    return localDateFormat.format(paramDate);
  }
  
  private static Date parseDate(String paramString)
    throws ParseException
  {
    if (DATE_TIME.matcher(paramString).matches())
    {
      if (paramString.length() == 8) {
        return buildDateFormat().parse(paramString);
      }
      if ((paramString.length() == 16) && (paramString.charAt(15) == 'Z'))
      {
        paramString = buildDateTimeFormat().parse(paramString.substring(0, 15));
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        long l = paramString.getTime() + localGregorianCalendar.get(15);
        localGregorianCalendar.setTime(new Date(l));
        return new Date(l + localGregorianCalendar.get(16));
      }
      return buildDateTimeFormat().parse(paramString);
    }
    throw new ParseException(paramString, 0);
  }
  
  private static long parseDurationMS(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return -1L;
    }
    paramCharSequence = RFC2445_DURATION.matcher(paramCharSequence);
    if (!paramCharSequence.matches()) {
      return -1L;
    }
    long l1 = 0L;
    int i = 0;
    while (i < RFC2445_DURATION_FIELD_UNITS.length)
    {
      int j = i + 1;
      String str = paramCharSequence.group(j);
      long l2 = l1;
      if (str != null) {
        l2 = l1 + RFC2445_DURATION_FIELD_UNITS[i] * Integer.parseInt(str);
      }
      i = j;
      l1 = l2;
    }
    return l1;
  }
  
  public String[] getAttendees()
  {
    return this.attendees;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    maybeAppend(this.summary, localStringBuilder);
    maybeAppend(format(this.startAllDay, this.start), localStringBuilder);
    maybeAppend(format(this.endAllDay, this.end), localStringBuilder);
    maybeAppend(this.location, localStringBuilder);
    maybeAppend(this.organizer, localStringBuilder);
    maybeAppend(this.attendees, localStringBuilder);
    maybeAppend(this.description, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public Date getEnd()
  {
    return this.end;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public String getOrganizer()
  {
    return this.organizer;
  }
  
  public Date getStart()
  {
    return this.start;
  }
  
  public String getSummary()
  {
    return this.summary;
  }
  
  public boolean isEndAllDay()
  {
    return this.endAllDay;
  }
  
  public boolean isStartAllDay()
  {
    return this.startAllDay;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\CalendarParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */