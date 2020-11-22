package org.litepal.parser;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources.NotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.ParseConfigurationFileException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class LitePalParser
{
  static final String ATTR_CLASS = "class";
  static final String ATTR_VALUE = "value";
  static final String NODE_CASES = "cases";
  static final String NODE_DB_NAME = "dbname";
  static final String NODE_LIST = "list";
  static final String NODE_MAPPING = "mapping";
  static final String NODE_STORAGE = "storage";
  static final String NODE_VERSION = "version";
  private static LitePalParser parser;
  
  private InputStream getConfigInputStream()
    throws IOException
  {
    AssetManager localAssetManager = LitePalApplication.getContext().getAssets();
    String[] arrayOfString = localAssetManager.list("");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ("litepal.xml".equalsIgnoreCase(str)) {
          return localAssetManager.open(str, 3);
        }
        i += 1;
      }
    }
    throw new ParseConfigurationFileException("litepal.xml file is missing. Please ensure it under assets folder.");
  }
  
  public static LitePalConfig parseLitePalConfiguration()
  {
    if (parser == null) {
      parser = new LitePalParser();
    }
    return parser.usePullParse();
  }
  
  private LitePalConfig usePullParse()
  {
    try
    {
      LitePalConfig localLitePalConfig = new LitePalConfig();
      XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(getConfigInputStream(), "UTF-8");
      for (int i = localXmlPullParser.getEventType(); i != 1; i = localXmlPullParser.next())
      {
        String str = localXmlPullParser.getName();
        if (i == 2) {
          if ("dbname".equals(str)) {
            localLitePalConfig.setDbName(localXmlPullParser.getAttributeValue("", "value"));
          } else if ("version".equals(str)) {
            localLitePalConfig.setVersion(Integer.parseInt(localXmlPullParser.getAttributeValue("", "value")));
          } else if ("mapping".equals(str)) {
            localLitePalConfig.addClassName(localXmlPullParser.getAttributeValue("", "class"));
          } else if ("cases".equals(str)) {
            localLitePalConfig.setCases(localXmlPullParser.getAttributeValue("", "value"));
          } else if ("storage".equals(str)) {
            localLitePalConfig.setStorage(localXmlPullParser.getAttributeValue("", "value"));
          }
        }
      }
      return localLitePalConfig;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      for (;;) {}
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new ParseConfigurationFileException("IO exception happened");
    throw new ParseConfigurationFileException("can not parse the litepal.xml, check if it's in correct format");
  }
  
  private void useSAXParser()
  {
    try
    {
      XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
      localXMLReader.setContentHandler(new LitePalContentHandler());
      localXMLReader.parse(new InputSource(getConfigInputStream()));
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;) {}
    }
    catch (SAXException localSAXException)
    {
      for (;;) {}
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      for (;;) {}
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new ParseConfigurationFileException("IO exception happened");
    throw new ParseConfigurationFileException("parse configuration is failed");
    throw new ParseConfigurationFileException("can not parse the litepal.xml, check if it's in correct format");
    throw new ParseConfigurationFileException("litepal.xml file is missing. Please ensure it under assets folder.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\parser\LitePalParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */