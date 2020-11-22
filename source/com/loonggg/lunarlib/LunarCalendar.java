package com.loonggg.lunarlib;

import java.util.Date;
import java.util.GregorianCalendar;

public class LunarCalendar
{
  public static final int BASE_LAUNAR_YEAR = 1984;
  private static final int[] DAYS_BEFORE_MONTH = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
  public static final String[] LAUNAR_MONTH_DAY_INFO;
  public static final String[] LUNAR_ANIMAL = { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" };
  private static final int[] LUNAR_INFO = { 8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677 };
  public static final String[] LUNAR_MONTH_INFO;
  public static final String[] LUNAR_YEAR_INFO = { "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "已巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "已卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥", "戊子", "已丑", "庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "已亥", "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "已酉", "庚戌", "辛亥", "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "已未", "庚申", "辛酉", "壬戌", "癸亥" };
  public static final int MAX_YEAR = 2099;
  public static final int MIN_YEAR = 1900;
  
  static
  {
    LUNAR_MONTH_INFO = new String[] { "正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
    LAUNAR_MONTH_DAY_INFO = new String[] { "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十" };
  }
  
  private static int daysInLunarMonth(int paramInt1, int paramInt2)
  {
    if ((LUNAR_INFO[(paramInt1 - 1900)] & 1048576 >> paramInt2) == 0) {
      return 29;
    }
    return 30;
  }
  
  private static int daysInLunarYear(int paramInt)
  {
    int i;
    if (leapMonth(paramInt) != 0) {
      i = 377;
    } else {
      i = 348;
    }
    int k = LUNAR_INFO[(paramInt - 1900)];
    paramInt = 524288;
    while (paramInt > 7)
    {
      int j = i;
      if ((k & 0xFFF80 & paramInt) != 0) {
        j = i + 1;
      }
      paramInt >>= 1;
      i = j;
    }
    return i;
  }
  
  public static final int daysInMonth(int paramInt1, int paramInt2)
  {
    return daysInMonth(paramInt1, paramInt2, false);
  }
  
  public static final int daysInMonth(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = leapMonth(paramInt1);
    int i;
    if ((j != 0) && (paramInt2 > j)) {
      i = 1;
    } else {
      i = 0;
    }
    if (!paramBoolean) {
      return daysInLunarMonth(paramInt1, paramInt2 + i);
    }
    if ((j != 0) && (j == paramInt2)) {
      return daysInLunarMonth(paramInt1, paramInt2 + 1);
    }
    return 0;
  }
  
  public static String getLunarAnimal(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = solarToLunar(paramInt1, paramInt2, paramInt3);
    if (localObject[0] >= 1984)
    {
      paramInt1 = localObject[0];
      return LUNAR_ANIMAL[((paramInt1 - 1984) % 12)];
    }
    paramInt1 = localObject[0];
    localObject = LUNAR_ANIMAL;
    paramInt2 = (1984 - paramInt1) % 12;
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 12;
    }
    return localObject[(12 - paramInt1)];
  }
  
  public static String getLunarMonthDay(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = solarToLunar(paramInt1, paramInt2, paramInt3);
    String str = LUNAR_MONTH_INFO[(localObject[1] - 1)];
    localObject = LAUNAR_MONTH_DAY_INFO[(localObject[2] - 1)];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static String getLunarYear(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject = solarToLunar(paramInt1, paramInt2, paramInt3);
    if (!paramBoolean)
    {
      if (localObject[0] >= 1984)
      {
        paramInt1 = localObject[0];
        return LUNAR_YEAR_INFO[((paramInt1 - 1984) % 60)];
      }
      paramInt1 = localObject[0];
      localObject = LUNAR_YEAR_INFO;
      paramInt2 = (1984 - paramInt1) % 60;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 60;
      }
      return localObject[(60 - paramInt1)];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject[0]);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public static String getLunarYearMonthDay(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = solarToLunar(paramInt1, paramInt2, paramInt3);
    String str1;
    Object localObject1;
    if (localObject2[0] >= 1984)
    {
      paramInt1 = localObject2[0] - 1984;
      str1 = LUNAR_YEAR_INFO[(paramInt1 % 60)];
      localObject1 = LUNAR_ANIMAL[(paramInt1 % 12)];
    }
    else
    {
      paramInt3 = 1984 - localObject2[0];
      localObject1 = LUNAR_YEAR_INFO;
      paramInt2 = paramInt3 % 60;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 60;
      }
      str1 = localObject1[(60 - paramInt1)];
      localObject1 = LUNAR_ANIMAL;
      paramInt2 = paramInt3 % 12;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 12;
      }
      localObject1 = localObject1[(12 - paramInt1)];
    }
    String str2 = LUNAR_MONTH_INFO[(localObject2[1] - 1)];
    localObject2 = LAUNAR_MONTH_DAY_INFO[(localObject2[2] - 1)];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("年");
    localStringBuilder.append(str2);
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
  
  private static int leapMonth(int paramInt)
  {
    return (LUNAR_INFO[(paramInt - 1900)] & 0xF00000) >> 20;
  }
  
  public static final int[] lunarToSolar(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramInt1 >= 1900) && (paramInt1 <= 2099) && (paramInt2 >= 1) && (paramInt2 <= 12) && (paramInt3 >= 1) && (paramInt3 <= 30))
    {
      int[] arrayOfInt1 = LUNAR_INFO;
      int k = paramInt1 - 1900;
      int j = (arrayOfInt1[k] & 0x1F) - 1;
      int i = j;
      if ((LUNAR_INFO[k] & 0x60) >> 5 == 2) {
        i = j + 31;
      }
      j = 1;
      while (j < paramInt2)
      {
        if ((524288 >> j - 1 & LUNAR_INFO[k]) == 0) {
          i += 29;
        } else {
          i += 30;
        }
        j += 1;
      }
      i += paramInt3;
      j = (LUNAR_INFO[k] & 0xF00000) >> 20;
      paramInt3 = i;
      if (j != 0) {
        if (paramInt2 <= j)
        {
          paramInt3 = i;
          if (paramInt2 == j)
          {
            paramInt3 = i;
            if (!paramBoolean) {}
          }
        }
        else if ((524288 >> paramInt2 - 1 & LUNAR_INFO[k]) == 0)
        {
          paramInt3 = i + 29;
        }
        else
        {
          paramInt3 = i + 30;
        }
      }
      if (paramInt3 <= 366)
      {
        paramInt2 = paramInt3;
        i = paramInt1;
        if (paramInt1 % 4 != 0)
        {
          paramInt2 = paramInt3;
          i = paramInt1;
          if (paramInt3 <= 365) {}
        }
      }
      else
      {
        i = paramInt1 + 1;
        if (i % 4 == 1) {
          paramInt2 = paramInt3 - 366;
        } else {
          paramInt2 = paramInt3 - 365;
        }
      }
      arrayOfInt1 = new int[3];
      paramInt1 = 1;
      while (paramInt1 < 13)
      {
        j = DAYS_BEFORE_MONTH[paramInt1];
        k = i % 4;
        paramInt3 = j;
        if (k == 0)
        {
          paramInt3 = j;
          if (paramInt1 > 2) {
            paramInt3 = j + 1;
          }
        }
        if ((k == 0) && (paramInt1 == 2) && (paramInt3 + 1 == paramInt2))
        {
          arrayOfInt1[1] = paramInt1;
          arrayOfInt1[2] = (paramInt2 - 31);
          break;
        }
        if (paramInt3 >= paramInt2)
        {
          arrayOfInt1[1] = paramInt1;
          int[] arrayOfInt2 = DAYS_BEFORE_MONTH;
          int m = paramInt1 - 1;
          j = arrayOfInt2[m];
          paramInt3 = j;
          if (k == 0)
          {
            paramInt3 = j;
            if (paramInt1 > 2) {
              paramInt3 = j + 1;
            }
          }
          if (paramInt2 > paramInt3)
          {
            arrayOfInt1[2] = (paramInt2 - paramInt3);
            break;
          }
          if (paramInt2 == paramInt3)
          {
            if ((k == 0) && (paramInt1 == 2))
            {
              arrayOfInt1[2] = (DAYS_BEFORE_MONTH[paramInt1] - DAYS_BEFORE_MONTH[m] + 1);
              break;
            }
            arrayOfInt1[2] = (DAYS_BEFORE_MONTH[paramInt1] - DAYS_BEFORE_MONTH[m]);
            break;
          }
          arrayOfInt1[2] = paramInt2;
          break;
        }
        paramInt1 += 1;
      }
      arrayOfInt1[0] = i;
      return arrayOfInt1;
    }
    throw new IllegalArgumentException("Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30");
  }
  
  public static final int[] solarToLunar(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1900;
    int m = 0;
    Date localDate = new GregorianCalendar(1900, 0, 31).getTime();
    paramInt2 = (int)((new GregorianCalendar(paramInt1, paramInt2 - 1, paramInt3).getTime().getTime() - localDate.getTime()) / 86400000L);
    int j = 0;
    paramInt1 = i;
    while ((paramInt1 <= 2099) && (paramInt2 > 0))
    {
      j = daysInLunarYear(paramInt1);
      paramInt2 -= j;
      paramInt1 += 1;
    }
    i = paramInt1;
    paramInt3 = paramInt2;
    if (paramInt2 < 0)
    {
      paramInt3 = paramInt2 + j;
      i = paramInt1 - 1;
    }
    int n = leapMonth(i);
    paramInt1 = paramInt3;
    paramInt3 = 1;
    j = 0;
    while ((paramInt3 <= 13) && (paramInt1 > 0))
    {
      j = daysInLunarMonth(i, paramInt3);
      paramInt1 -= j;
      paramInt3 += 1;
    }
    int k = m;
    paramInt2 = paramInt3;
    if (n != 0)
    {
      k = m;
      paramInt2 = paramInt3;
      if (paramInt3 > n)
      {
        paramInt3 -= 1;
        k = m;
        paramInt2 = paramInt3;
        if (paramInt3 == n)
        {
          k = 1;
          paramInt2 = paramInt3;
        }
      }
    }
    m = paramInt2;
    paramInt3 = paramInt1;
    if (paramInt1 < 0)
    {
      paramInt3 = paramInt1 + j;
      m = paramInt2 - 1;
    }
    return new int[] { i, m, paramInt3 + 1, k };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loonggg\lunarlib\LunarCalendar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */