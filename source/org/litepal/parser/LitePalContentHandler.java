package org.litepal.parser;

import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LitePalContentHandler
  extends DefaultHandler
{
  private LitePalAttr litePalAttr;
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {}
  
  public void endDocument()
    throws SAXException
  {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {}
  
  public void startDocument()
    throws SAXException
  {
    this.litePalAttr = LitePalAttr.getInstance();
    this.litePalAttr.getClassNames().clear();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    boolean bool = "dbname".equalsIgnoreCase(paramString2);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    if (bool) {
      while (i < paramAttributes.getLength())
      {
        if ("value".equalsIgnoreCase(paramAttributes.getLocalName(i))) {
          this.litePalAttr.setDbName(paramAttributes.getValue(i).trim());
        }
        i += 1;
      }
    }
    if ("version".equalsIgnoreCase(paramString2))
    {
      i = j;
      while (i < paramAttributes.getLength())
      {
        if ("value".equalsIgnoreCase(paramAttributes.getLocalName(i))) {
          this.litePalAttr.setVersion(Integer.parseInt(paramAttributes.getValue(i).trim()));
        }
        i += 1;
      }
    }
    if ("mapping".equalsIgnoreCase(paramString2))
    {
      i = k;
      while (i < paramAttributes.getLength())
      {
        if ("class".equalsIgnoreCase(paramAttributes.getLocalName(i))) {
          this.litePalAttr.addClassName(paramAttributes.getValue(i).trim());
        }
        i += 1;
      }
    }
    if ("cases".equalsIgnoreCase(paramString2))
    {
      i = m;
      while (i < paramAttributes.getLength())
      {
        if ("value".equalsIgnoreCase(paramAttributes.getLocalName(i))) {
          this.litePalAttr.setCases(paramAttributes.getValue(i).trim());
        }
        i += 1;
      }
    }
    if ("storage".equalsIgnoreCase(paramString2))
    {
      i = n;
      while (i < paramAttributes.getLength())
      {
        if ("value".equalsIgnoreCase(paramAttributes.getLocalName(i))) {
          this.litePalAttr.setStorage(paramAttributes.getValue(i).trim());
        }
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\parser\LitePalContentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */