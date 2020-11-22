package com.google.zxing.client.result;

public final class AddressBookParsedResult
  extends ParsedResult
{
  private final String[] addressTypes;
  private final String[] addresses;
  private final String birthday;
  private final String[] emailTypes;
  private final String[] emails;
  private final String[] geo;
  private final String instantMessenger;
  private final String[] names;
  private final String[] nicknames;
  private final String note;
  private final String org;
  private final String[] phoneNumbers;
  private final String[] phoneTypes;
  private final String pronunciation;
  private final String title;
  private final String[] urls;
  
  public AddressBookParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String[] paramArrayOfString3, String[] paramArrayOfString4, String[] paramArrayOfString5, String[] paramArrayOfString6, String paramString2, String paramString3, String[] paramArrayOfString7, String[] paramArrayOfString8, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString9, String[] paramArrayOfString10)
  {
    super(ParsedResultType.ADDRESSBOOK);
    this.names = paramArrayOfString1;
    this.nicknames = paramArrayOfString2;
    this.pronunciation = paramString1;
    this.phoneNumbers = paramArrayOfString3;
    this.phoneTypes = paramArrayOfString4;
    this.emails = paramArrayOfString5;
    this.emailTypes = paramArrayOfString6;
    this.instantMessenger = paramString2;
    this.note = paramString3;
    this.addresses = paramArrayOfString7;
    this.addressTypes = paramArrayOfString8;
    this.org = paramString4;
    this.birthday = paramString5;
    this.title = paramString6;
    this.urls = paramArrayOfString9;
    this.geo = paramArrayOfString10;
  }
  
  public AddressBookParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, String[] paramArrayOfString5, String[] paramArrayOfString6, String[] paramArrayOfString7)
  {
    this(paramArrayOfString1, null, null, paramArrayOfString2, paramArrayOfString3, paramArrayOfString4, paramArrayOfString5, null, null, paramArrayOfString6, paramArrayOfString7, null, null, null, null, null);
  }
  
  public String[] getAddressTypes()
  {
    return this.addressTypes;
  }
  
  public String[] getAddresses()
  {
    return this.addresses;
  }
  
  public String getBirthday()
  {
    return this.birthday;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    maybeAppend(this.names, localStringBuilder);
    maybeAppend(this.nicknames, localStringBuilder);
    maybeAppend(this.pronunciation, localStringBuilder);
    maybeAppend(this.title, localStringBuilder);
    maybeAppend(this.org, localStringBuilder);
    maybeAppend(this.addresses, localStringBuilder);
    maybeAppend(this.phoneNumbers, localStringBuilder);
    maybeAppend(this.emails, localStringBuilder);
    maybeAppend(this.instantMessenger, localStringBuilder);
    maybeAppend(this.urls, localStringBuilder);
    maybeAppend(this.birthday, localStringBuilder);
    maybeAppend(this.geo, localStringBuilder);
    maybeAppend(this.note, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String[] getEmailTypes()
  {
    return this.emailTypes;
  }
  
  public String[] getEmails()
  {
    return this.emails;
  }
  
  public String[] getGeo()
  {
    return this.geo;
  }
  
  public String getInstantMessenger()
  {
    return this.instantMessenger;
  }
  
  public String[] getNames()
  {
    return this.names;
  }
  
  public String[] getNicknames()
  {
    return this.nicknames;
  }
  
  public String getNote()
  {
    return this.note;
  }
  
  public String getOrg()
  {
    return this.org;
  }
  
  public String[] getPhoneNumbers()
  {
    return this.phoneNumbers;
  }
  
  public String[] getPhoneTypes()
  {
    return this.phoneTypes;
  }
  
  public String getPronunciation()
  {
    return this.pronunciation;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String[] getURLs()
  {
    return this.urls;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\AddressBookParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */