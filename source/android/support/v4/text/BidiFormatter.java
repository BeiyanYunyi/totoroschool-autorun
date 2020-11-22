package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter
{
  private static final int DEFAULT_FLAGS = 2;
  static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  private static final int DIR_LTR = -1;
  private static final int DIR_RTL = 1;
  private static final int DIR_UNKNOWN = 0;
  private static final String EMPTY_STRING = "";
  private static final int FLAG_STEREO_RESET = 2;
  private static final char LRE = '‪';
  private static final char LRM = '‎';
  private static final String LRM_STRING = Character.toString('‎');
  private static final char PDF = '‬';
  private static final char RLE = '‫';
  private static final char RLM = '‏';
  private static final String RLM_STRING = Character.toString('‏');
  private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
  private final int mFlags;
  private final boolean mIsRtlContext;
  
  BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.mIsRtlContext = paramBoolean;
    this.mFlags = paramInt;
    this.mDefaultTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
  }
  
  private static int getEntryDir(CharSequence paramCharSequence)
  {
    return new DirectionalityEstimator(paramCharSequence, false).getEntryDir();
  }
  
  private static int getExitDir(CharSequence paramCharSequence)
  {
    return new DirectionalityEstimator(paramCharSequence, false).getExitDir();
  }
  
  public static BidiFormatter getInstance()
  {
    return new Builder().build();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale)
  {
    return new Builder(paramLocale).build();
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean)
  {
    return new Builder(paramBoolean).build();
  }
  
  static boolean isRtlLocale(Locale paramLocale)
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) == 1;
  }
  
  private String markAfter(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    if ((!this.mIsRtlContext) && ((bool) || (getExitDir(paramCharSequence) == 1))) {
      return LRM_STRING;
    }
    if ((this.mIsRtlContext) && ((!bool) || (getExitDir(paramCharSequence) == -1))) {
      return RLM_STRING;
    }
    return "";
  }
  
  private String markBefore(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    if ((!this.mIsRtlContext) && ((bool) || (getEntryDir(paramCharSequence) == 1))) {
      return LRM_STRING;
    }
    if ((this.mIsRtlContext) && ((!bool) || (getEntryDir(paramCharSequence) == -1))) {
      return RLM_STRING;
    }
    return "";
  }
  
  public boolean getStereoReset()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  public boolean isRtl(CharSequence paramCharSequence)
  {
    return this.mDefaultTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public boolean isRtl(String paramString)
  {
    return isRtl(paramString);
  }
  
  public boolean isRtlContext()
  {
    return this.mIsRtlContext;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence)
  {
    return unicodeWrap(paramCharSequence, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramCharSequence, paramTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return null;
    }
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((getStereoReset()) && (paramBoolean))
    {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      }
      localSpannableStringBuilder.append(markBefore(paramCharSequence, paramTextDirectionHeuristicCompat));
    }
    if (bool != this.mIsRtlContext)
    {
      char c;
      if (bool) {
        c = '‫';
      } else {
        c = '‪';
      }
      localSpannableStringBuilder.append(c);
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.append('‬');
    }
    else
    {
      localSpannableStringBuilder.append(paramCharSequence);
    }
    if (paramBoolean)
    {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      }
      localSpannableStringBuilder.append(markAfter(paramCharSequence, paramTextDirectionHeuristicCompat));
    }
    return localSpannableStringBuilder;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return unicodeWrap(paramCharSequence, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public String unicodeWrap(String paramString)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, paramBoolean).toString();
  }
  
  public String unicodeWrap(String paramString, boolean paramBoolean)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  public static final class Builder
  {
    private int mFlags;
    private boolean mIsRtlContext;
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
    
    public Builder()
    {
      initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
    }
    
    public Builder(Locale paramLocale)
    {
      initialize(BidiFormatter.isRtlLocale(paramLocale));
    }
    
    public Builder(boolean paramBoolean)
    {
      initialize(paramBoolean);
    }
    
    private static BidiFormatter getDefaultInstanceFromContext(boolean paramBoolean)
    {
      if (paramBoolean) {
        return BidiFormatter.DEFAULT_RTL_INSTANCE;
      }
      return BidiFormatter.DEFAULT_LTR_INSTANCE;
    }
    
    private void initialize(boolean paramBoolean)
    {
      this.mIsRtlContext = paramBoolean;
      this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
      this.mFlags = 2;
    }
    
    public BidiFormatter build()
    {
      if ((this.mFlags == 2) && (this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC)) {
        return getDefaultInstanceFromContext(this.mIsRtlContext);
      }
      return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
    }
    
    public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
    {
      this.mTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
      return this;
    }
    
    public Builder stereoReset(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.mFlags |= 0x2;
        return this;
      }
      this.mFlags &= 0xFFFFFFFD;
      return this;
    }
  }
  
  private static class DirectionalityEstimator
  {
    private static final byte[] DIR_TYPE_CACHE = new byte['܀'];
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final CharSequence text;
    
    static
    {
      int i = 0;
      while (i < 1792)
      {
        DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
        i += 1;
      }
    }
    
    DirectionalityEstimator(CharSequence paramCharSequence, boolean paramBoolean)
    {
      this.text = paramCharSequence;
      this.isHtml = paramBoolean;
      this.length = paramCharSequence.length();
    }
    
    private static byte getCachedDirectionality(char paramChar)
    {
      if (paramChar < '܀') {
        return DIR_TYPE_CACHE[paramChar];
      }
      return Character.getDirectionality(paramChar);
    }
    
    private byte skipEntityBackward()
    {
      int i = this.charIndex;
      do
      {
        if (this.charIndex <= 0) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int j = this.charIndex - 1;
        this.charIndex = j;
        this.lastChar = localCharSequence.charAt(j);
        if (this.lastChar == '&') {
          return 12;
        }
      } while (this.lastChar != ';');
      this.charIndex = i;
      this.lastChar = ';';
      return 13;
    }
    
    private byte skipEntityForward()
    {
      char c;
      do
      {
        if (this.charIndex >= this.length) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int i = this.charIndex;
        this.charIndex = (i + 1);
        c = localCharSequence.charAt(i);
        this.lastChar = c;
      } while (c != ';');
      return 12;
    }
    
    private byte skipTagBackward()
    {
      int j = this.charIndex;
      label137:
      while (this.charIndex > 0)
      {
        CharSequence localCharSequence = this.text;
        int k = this.charIndex - 1;
        this.charIndex = k;
        this.lastChar = localCharSequence.charAt(k);
        if (this.lastChar == '<') {
          return 12;
        }
        if (this.lastChar == '>') {
          break;
        }
        if ((this.lastChar == '"') || (this.lastChar == '\''))
        {
          k = this.lastChar;
          for (;;)
          {
            if (this.charIndex <= 0) {
              break label137;
            }
            localCharSequence = this.text;
            int m = this.charIndex - 1;
            this.charIndex = m;
            int i = localCharSequence.charAt(m);
            this.lastChar = i;
            if (i == k) {
              break;
            }
          }
        }
      }
      this.charIndex = j;
      this.lastChar = '>';
      return 13;
    }
    
    private byte skipTagForward()
    {
      int j = this.charIndex;
      label133:
      while (this.charIndex < this.length)
      {
        CharSequence localCharSequence = this.text;
        int k = this.charIndex;
        this.charIndex = (k + 1);
        this.lastChar = localCharSequence.charAt(k);
        if (this.lastChar == '>') {
          return 12;
        }
        if ((this.lastChar == '"') || (this.lastChar == '\''))
        {
          k = this.lastChar;
          for (;;)
          {
            if (this.charIndex >= this.length) {
              break label133;
            }
            localCharSequence = this.text;
            int m = this.charIndex;
            this.charIndex = (m + 1);
            int i = localCharSequence.charAt(m);
            this.lastChar = i;
            if (i == k) {
              break;
            }
          }
        }
      }
      this.charIndex = j;
      this.lastChar = '<';
      return 13;
    }
    
    byte dirTypeBackward()
    {
      this.lastChar = this.text.charAt(this.charIndex - 1);
      if (Character.isLowSurrogate(this.lastChar))
      {
        int i = Character.codePointBefore(this.text, this.charIndex);
        this.charIndex -= Character.charCount(i);
        return Character.getDirectionality(i);
      }
      this.charIndex -= 1;
      byte b2 = getCachedDirectionality(this.lastChar);
      byte b1 = b2;
      if (this.isHtml)
      {
        if (this.lastChar == '>') {
          return skipTagBackward();
        }
        b1 = b2;
        if (this.lastChar == ';') {
          b1 = skipEntityBackward();
        }
      }
      return b1;
    }
    
    byte dirTypeForward()
    {
      this.lastChar = this.text.charAt(this.charIndex);
      if (Character.isHighSurrogate(this.lastChar))
      {
        int i = Character.codePointAt(this.text, this.charIndex);
        this.charIndex += Character.charCount(i);
        return Character.getDirectionality(i);
      }
      this.charIndex += 1;
      byte b2 = getCachedDirectionality(this.lastChar);
      byte b1 = b2;
      if (this.isHtml)
      {
        if (this.lastChar == '<') {
          return skipTagForward();
        }
        b1 = b2;
        if (this.lastChar == '&') {
          b1 = skipEntityForward();
        }
      }
      return b1;
    }
    
    int getEntryDir()
    {
      this.charIndex = 0;
      int k = 0;
      int j = 0;
      int i = 0;
      while ((this.charIndex < this.length) && (k == 0))
      {
        int m = dirTypeForward();
        if (m != 9) {
          switch (m)
          {
          default: 
            switch (m)
            {
            default: 
              break;
            case 18: 
              i -= 1;
              j = 0;
              break;
            case 16: 
            case 17: 
              i += 1;
              j = 1;
              break;
            case 14: 
            case 15: 
              i += 1;
              j = -1;
            }
            break;
          case 1: 
          case 2: 
            if (i == 0) {
              return 1;
            }
          case 0: 
            if (i == 0) {
              return -1;
            }
            k = i;
          }
        }
      }
      if (k == 0) {
        return 0;
      }
      if (j != 0) {
        return j;
      }
      while (this.charIndex > 0) {
        switch (dirTypeBackward())
        {
        default: 
          break;
        case 18: 
          i += 1;
          break;
        case 16: 
        case 17: 
          if (k == i) {
            return 1;
          }
          i -= 1;
          break;
        case 14: 
        case 15: 
          if (k == i) {
            return -1;
          }
          i -= 1;
        }
      }
      return 0;
    }
    
    int getExitDir()
    {
      this.charIndex = this.length;
      int j = 0;
      int i = 0;
      while (this.charIndex > 0)
      {
        int k = dirTypeBackward();
        if (k != 9) {
          switch (k)
          {
          default: 
            switch (k)
            {
            default: 
              if (j != 0) {}
              break;
            case 18: 
              i += 1;
              break;
            case 16: 
            case 17: 
              if (j == i) {
                return 1;
              }
              i -= 1;
              break;
            case 14: 
            case 15: 
              if (j == i) {
                return -1;
              }
              i -= 1;
            }
            break;
          case 1: 
          case 2: 
            if (i == 0) {
              return 1;
            }
            if (j != 0) {}
            break;
          case 0: 
            if (i == 0) {
              return -1;
            }
            if (j == 0) {
              j = i;
            }
            break;
          }
        }
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\text\BidiFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */