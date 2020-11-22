package org.litepal.crud;

import android.content.ContentValues;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.LitePalBase;
import org.litepal.Operator;
import org.litepal.annotation.Encrypt;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.util.cipher.CipherUtil;

abstract class DataHandler
  extends LitePalBase
{
  public static final String TAG = "DataHandler";
  private List<AssociationsInfo> fkInCurrentModel;
  private List<AssociationsInfo> fkInOtherModel;
  SQLiteDatabase mDatabase;
  private LitePalSupport tempEmptyModel;
  
  private void analyzeAssociations(String paramString)
  {
    Object localObject = getAssociationInfo(paramString);
    if (this.fkInCurrentModel == null) {
      this.fkInCurrentModel = new ArrayList();
    } else {
      this.fkInCurrentModel.clear();
    }
    if (this.fkInOtherModel == null) {
      this.fkInOtherModel = new ArrayList();
    } else {
      this.fkInOtherModel.clear();
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AssociationsInfo localAssociationsInfo = (AssociationsInfo)((Iterator)localObject).next();
      if ((localAssociationsInfo.getAssociationType() != 2) && (localAssociationsInfo.getAssociationType() != 1))
      {
        if (localAssociationsInfo.getAssociationType() == 3) {
          this.fkInOtherModel.add(localAssociationsInfo);
        }
      }
      else if (localAssociationsInfo.getClassHoldsForeignKey().equals(paramString)) {
        this.fkInCurrentModel.add(localAssociationsInfo);
      } else {
        this.fkInOtherModel.add(localAssociationsInfo);
      }
    }
  }
  
  private String genGetColumnMethod(Class<?> paramClass)
  {
    if (paramClass.isPrimitive()) {
      paramClass = BaseUtility.capitalize(paramClass.getName());
    } else {
      paramClass = paramClass.getSimpleName();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get");
    ((StringBuilder)localObject).append(paramClass);
    localObject = ((StringBuilder)localObject).toString();
    if ("getBoolean".equals(localObject)) {
      return "getInt";
    }
    if ((!"getChar".equals(localObject)) && (!"getCharacter".equals(localObject)))
    {
      if ("getDate".equals(localObject)) {
        return "getLong";
      }
      if ("getInteger".equals(localObject)) {
        return "getInt";
      }
      paramClass = (Class<?>)localObject;
      if ("getbyte[]".equalsIgnoreCase((String)localObject)) {
        return "getBlob";
      }
    }
    else
    {
      paramClass = "getString";
    }
    return paramClass;
  }
  
  private String genGetColumnMethod(Field paramField)
  {
    if (isCollection(paramField.getType())) {
      paramField = getGenericTypeClass(paramField);
    } else {
      paramField = paramField.getType();
    }
    return genGetColumnMethod(paramField);
  }
  
  private String[] getCustomizedColumns(String[] paramArrayOfString, List<Field> paramList, List<AssociationsInfo> paramList1)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      paramArrayOfString = new ArrayList(Arrays.asList(paramArrayOfString));
      Object localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3 = paramList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject1).add(((Field)((Iterator)localObject3).next()).getName());
      }
      int k = 0;
      int j = 0;
      int i = 0;
      while (j < paramArrayOfString.size())
      {
        localObject3 = (String)paramArrayOfString.get(j);
        if (BaseUtility.containsIgnoreCases((Collection)localObject1, (String)localObject3))
        {
          ((List)localObject2).add(Integer.valueOf(j));
        }
        else if (isIdColumn((String)localObject3))
        {
          if ("_id".equalsIgnoreCase((String)localObject3)) {
            paramArrayOfString.set(j, BaseUtility.changeCase("id"));
          }
          i = 1;
        }
        j += 1;
      }
      j = ((List)localObject2).size() - 1;
      while (j >= 0)
      {
        localArrayList1.add((String)paramArrayOfString.remove(((Integer)((List)localObject2).get(j)).intValue()));
        j -= 1;
      }
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Field)((Iterator)localObject1).next();
        if (BaseUtility.containsIgnoreCases(localArrayList1, ((Field)localObject2).getName())) {
          localArrayList2.add(localObject2);
        }
      }
      paramList.clear();
      paramList.addAll(localArrayList2);
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        j = k;
        while (j < paramList1.size())
        {
          paramArrayOfString.add(getForeignKeyColumnName(DBUtility.getTableNameByClassName(((AssociationsInfo)paramList1.get(j)).getAssociatedClassName())));
          j += 1;
        }
      }
      if (i == 0) {
        paramArrayOfString.add(BaseUtility.changeCase("id"));
      }
      return (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
    }
    return null;
  }
  
  private Object getInitParamValue(Class<?> paramClass1, Class<?> paramClass2)
  {
    String str = paramClass2.getName();
    if ((!"boolean".equals(str)) && (!"java.lang.Boolean".equals(str)))
    {
      if ((!"float".equals(str)) && (!"java.lang.Float".equals(str)))
      {
        if ((!"double".equals(str)) && (!"java.lang.Double".equals(str)))
        {
          if ((!"int".equals(str)) && (!"java.lang.Integer".equals(str)))
          {
            if ((!"long".equals(str)) && (!"java.lang.Long".equals(str)))
            {
              if ((!"short".equals(str)) && (!"java.lang.Short".equals(str)))
              {
                if ((!"char".equals(str)) && (!"java.lang.Character".equals(str)))
                {
                  if ((!"[B".equals(str)) && (!"[Ljava.lang.Byte;".equals(str)))
                  {
                    if ("java.lang.String".equals(str)) {
                      return "";
                    }
                    if (paramClass1 == paramClass2) {
                      return null;
                    }
                    return createInstanceFromClass(paramClass2);
                  }
                  return new byte[0];
                }
                return Character.valueOf(' ');
              }
              return Integer.valueOf(0);
            }
            return Long.valueOf(0L);
          }
          return Integer.valueOf(0);
        }
        return Double.valueOf(0.0D);
      }
      return Float.valueOf(0.0F);
    }
    return Boolean.valueOf(false);
  }
  
  private Class<?> getObjectType(Class<?> paramClass)
  {
    if ((paramClass != null) && (paramClass.isPrimitive()))
    {
      paramClass = paramClass.getName();
      if ("int".equals(paramClass)) {
        return Integer.class;
      }
      if ("short".equals(paramClass)) {
        return Short.class;
      }
      if ("long".equals(paramClass)) {
        return Long.class;
      }
      if ("float".equals(paramClass)) {
        return Float.class;
      }
      if ("double".equals(paramClass)) {
        return Double.class;
      }
      if ("boolean".equals(paramClass)) {
        return Boolean.class;
      }
      if ("char".equals(paramClass)) {
        return Character.class;
      }
    }
    return null;
  }
  
  private boolean isCharType(Field paramField)
  {
    paramField = paramField.getType().getName();
    return (paramField.equals("char")) || (paramField.endsWith("Character"));
  }
  
  private boolean isFieldWithDefaultValue(LitePalSupport paramLitePalSupport, Field paramField)
    throws IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException
  {
    LitePalSupport localLitePalSupport = getEmptyModel(paramLitePalSupport);
    paramLitePalSupport = getFieldValue(paramLitePalSupport, paramField);
    paramField = getFieldValue(localLitePalSupport, paramField);
    if ((paramLitePalSupport != null) && (paramField != null)) {
      return paramLitePalSupport.toString().equals(paramField.toString());
    }
    return paramLitePalSupport == paramField;
  }
  
  private boolean isPrimitiveBooleanType(Field paramField)
  {
    return "boolean".equals(paramField.getType().getName());
  }
  
  private boolean isSaving()
  {
    return SaveHandler.class.getName().equals(getClass().getName());
  }
  
  private boolean isUpdating()
  {
    return UpdateHandler.class.getName().equals(getClass().getName());
  }
  
  private String makeGetterMethodName(Field paramField)
  {
    Object localObject = paramField.getName();
    String str;
    if (isPrimitiveBooleanType(paramField))
    {
      paramField = (Field)localObject;
      if (((String)localObject).matches("^is[A-Z]{1}.*$")) {
        paramField = ((String)localObject).substring(2);
      }
      str = "is";
    }
    else
    {
      str = "get";
      paramField = (Field)localObject;
    }
    if (paramField.matches("^[a-z]{1}[A-Z]{1}.*"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramField);
      return ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(BaseUtility.capitalize(paramField));
    return ((StringBuilder)localObject).toString();
  }
  
  private String makeSetterMethodName(Field paramField)
  {
    if ((isPrimitiveBooleanType(paramField)) && (paramField.getName().matches("^is[A-Z]{1}.*$")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("set");
      localStringBuilder.append(paramField.getName().substring(2));
      return localStringBuilder.toString();
    }
    if (paramField.getName().matches("^[a-z]{1}[A-Z]{1}.*"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("set");
      localStringBuilder.append(paramField.getName());
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set");
    localStringBuilder.append(BaseUtility.capitalize(paramField.getName()));
    return localStringBuilder.toString();
  }
  
  private void putFieldsValueDependsOnSaveOrUpdate(LitePalSupport paramLitePalSupport, Field paramField, ContentValues paramContentValues)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (isUpdating())
    {
      if (!isFieldWithDefaultValue(paramLitePalSupport, paramField)) {
        putContentValuesForUpdate(paramLitePalSupport, paramField, paramContentValues);
      }
    }
    else if (isSaving()) {
      putContentValuesForSave(paramLitePalSupport, paramField, paramContentValues);
    }
  }
  
  /* Error */
  private void setAssociatedModel(LitePalSupport paramLitePalSupport)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	org/litepal/crud/DataHandler:fkInOtherModel	Ljava/util/List;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 42	org/litepal/crud/DataHandler:fkInOtherModel	Ljava/util/List;
    //   12: invokeinterface 163 1 0
    //   17: astore 7
    //   19: aload 7
    //   21: invokeinterface 54 1 0
    //   26: ifeq +685 -> 711
    //   29: aload 7
    //   31: invokeinterface 58 1 0
    //   36: checkcast 60	org/litepal/crud/model/AssociationsInfo
    //   39: astore 8
    //   41: aload 8
    //   43: invokevirtual 207	org/litepal/crud/model/AssociationsInfo:getAssociatedClassName	()Ljava/lang/String;
    //   46: astore 9
    //   48: aload 8
    //   50: invokevirtual 64	org/litepal/crud/model/AssociationsInfo:getAssociationType	()I
    //   53: iconst_3
    //   54: if_icmpne +8 -> 62
    //   57: iconst_1
    //   58: istore_2
    //   59: goto +5 -> 64
    //   62: iconst_0
    //   63: istore_2
    //   64: aload_0
    //   65: aload 9
    //   67: invokevirtual 376	org/litepal/crud/DataHandler:getSupportedFields	(Ljava/lang/String;)Ljava/util/List;
    //   70: astore 10
    //   72: aload_0
    //   73: aload 9
    //   75: invokevirtual 379	org/litepal/crud/DataHandler:getSupportedGenericFields	(Ljava/lang/String;)Ljava/util/List;
    //   78: astore 11
    //   80: iload_2
    //   81: ifeq +169 -> 250
    //   84: aload_1
    //   85: invokevirtual 384	org/litepal/crud/LitePalSupport:getTableName	()Ljava/lang/String;
    //   88: astore_3
    //   89: aload 9
    //   91: invokestatic 212	org/litepal/util/DBUtility:getTableNameByClassName	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 4
    //   96: aload_3
    //   97: aload 4
    //   99: invokestatic 388	org/litepal/util/DBUtility:getIntermediateTableName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 6
    //   104: new 98	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   111: astore 5
    //   113: aload 5
    //   115: ldc_w 390
    //   118: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 5
    //   124: aload 4
    //   126: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 5
    //   132: ldc_w 392
    //   135: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 5
    //   141: aload 6
    //   143: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 5
    //   149: ldc_w 394
    //   152: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: new 98	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   163: astore 6
    //   165: aload 6
    //   167: aload 4
    //   169: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 6
    //   175: ldc -71
    //   177: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 5
    //   183: aload 6
    //   185: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: ldc_w 396
    //   197: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 5
    //   203: aload_3
    //   204: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: ldc_w 398
    //   213: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: iconst_2
    //   218: anewarray 74	java/lang/String
    //   221: dup
    //   222: iconst_0
    //   223: aload 5
    //   225: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 190	org/litepal/util/BaseUtility:changeCase	(Ljava/lang/String;)Ljava/lang/String;
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: aload_1
    //   235: invokevirtual 402	org/litepal/crud/LitePalSupport:getBaseObjId	()J
    //   238: invokestatic 405	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 411	org/litepal/Operator:findBySQL	([Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   245: astore 4
    //   247: goto +94 -> 341
    //   250: aload_0
    //   251: aload 8
    //   253: invokevirtual 414	org/litepal/crud/model/AssociationsInfo:getSelfClassName	()Ljava/lang/String;
    //   256: invokestatic 212	org/litepal/util/DBUtility:getTableNameByClassName	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 215	org/litepal/crud/DataHandler:getForeignKeyColumnName	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore_3
    //   263: aload 9
    //   265: invokestatic 212	org/litepal/util/DBUtility:getTableNameByClassName	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore 5
    //   270: aload_0
    //   271: getfield 416	org/litepal/crud/DataHandler:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   274: astore 4
    //   276: aload 5
    //   278: invokestatic 190	org/litepal/util/BaseUtility:changeCase	(Ljava/lang/String;)Ljava/lang/String;
    //   281: astore 5
    //   283: new 98	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   290: astore 6
    //   292: aload 6
    //   294: aload_3
    //   295: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 6
    //   301: ldc_w 418
    //   304: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 4
    //   310: aload 5
    //   312: aconst_null
    //   313: aload 6
    //   315: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: iconst_1
    //   319: anewarray 74	java/lang/String
    //   322: dup
    //   323: iconst_0
    //   324: aload_1
    //   325: invokevirtual 402	org/litepal/crud/LitePalSupport:getBaseObjId	()J
    //   328: invokestatic 405	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   331: aastore
    //   332: aconst_null
    //   333: aconst_null
    //   334: aconst_null
    //   335: aconst_null
    //   336: invokevirtual 424	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   339: astore 4
    //   341: aload 4
    //   343: ifnull +308 -> 651
    //   346: aload 4
    //   348: astore_3
    //   349: aload 4
    //   351: astore 5
    //   353: aload 4
    //   355: invokeinterface 429 1 0
    //   360: ifeq +291 -> 651
    //   363: aload 4
    //   365: astore_3
    //   366: aload 4
    //   368: astore 5
    //   370: new 431	android/util/SparseArray
    //   373: dup
    //   374: invokespecial 432	android/util/SparseArray:<init>	()V
    //   377: astore 12
    //   379: aload 4
    //   381: astore_3
    //   382: aload 4
    //   384: astore 5
    //   386: new 434	java/util/HashMap
    //   389: dup
    //   390: invokespecial 435	java/util/HashMap:<init>	()V
    //   393: astore 6
    //   395: aload 4
    //   397: astore_3
    //   398: aload 4
    //   400: astore 5
    //   402: aload_0
    //   403: aload 9
    //   405: invokestatic 439	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   408: invokevirtual 264	org/litepal/crud/DataHandler:createInstanceFromClass	(Ljava/lang/Class;)Ljava/lang/Object;
    //   411: checkcast 381	org/litepal/crud/LitePalSupport
    //   414: astore 13
    //   416: aload 4
    //   418: astore_3
    //   419: aload 4
    //   421: astore 5
    //   423: aload_0
    //   424: aload 13
    //   426: aload 4
    //   428: aload 4
    //   430: ldc -69
    //   432: invokeinterface 443 2 0
    //   437: invokeinterface 446 2 0
    //   442: invokevirtual 450	org/litepal/crud/DataHandler:giveBaseObjIdValue	(Lorg/litepal/crud/LitePalSupport;J)V
    //   445: aload 4
    //   447: astore_3
    //   448: aload_0
    //   449: aload 13
    //   451: aload 10
    //   453: aconst_null
    //   454: aload 4
    //   456: aload 12
    //   458: invokevirtual 454	org/litepal/crud/DataHandler:setValueToModel	(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Lnet/sqlcipher/Cursor;Landroid/util/SparseArray;)V
    //   461: aload_0
    //   462: aload 13
    //   464: aload 11
    //   466: aload 6
    //   468: invokevirtual 458	org/litepal/crud/DataHandler:setGenericValueToModel	(Lorg/litepal/crud/LitePalSupport;Ljava/util/List;Ljava/util/Map;)V
    //   471: aload 8
    //   473: invokevirtual 64	org/litepal/crud/model/AssociationsInfo:getAssociationType	()I
    //   476: iconst_2
    //   477: if_icmpeq +34 -> 511
    //   480: iload_2
    //   481: ifeq +6 -> 487
    //   484: goto +27 -> 511
    //   487: aload 8
    //   489: invokevirtual 64	org/litepal/crud/model/AssociationsInfo:getAssociationType	()I
    //   492: iconst_1
    //   493: if_icmpne +104 -> 597
    //   496: aload_0
    //   497: aload_1
    //   498: aload 8
    //   500: invokevirtual 462	org/litepal/crud/model/AssociationsInfo:getAssociateOtherModelFromSelf	()Ljava/lang/reflect/Field;
    //   503: aload 13
    //   505: invokevirtual 466	org/litepal/crud/DataHandler:setFieldValue	(Lorg/litepal/crud/LitePalSupport;Ljava/lang/reflect/Field;Ljava/lang/Object;)V
    //   508: goto +89 -> 597
    //   511: aload 8
    //   513: invokevirtual 462	org/litepal/crud/model/AssociationsInfo:getAssociateOtherModelFromSelf	()Ljava/lang/reflect/Field;
    //   516: astore 14
    //   518: aload_0
    //   519: aload_1
    //   520: aload 14
    //   522: invokevirtual 322	org/litepal/crud/DataHandler:getFieldValue	(Lorg/litepal/crud/LitePalSupport;Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   525: checkcast 44	java/util/Collection
    //   528: astore 5
    //   530: aload 5
    //   532: astore 4
    //   534: aload 5
    //   536: ifnonnull +51 -> 587
    //   539: aload_0
    //   540: aload 14
    //   542: invokevirtual 141	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   545: invokevirtual 469	org/litepal/crud/DataHandler:isList	(Ljava/lang/Class;)Z
    //   548: ifeq +15 -> 563
    //   551: new 34	java/util/ArrayList
    //   554: dup
    //   555: invokespecial 35	java/util/ArrayList:<init>	()V
    //   558: astore 4
    //   560: goto +12 -> 572
    //   563: new 471	java/util/HashSet
    //   566: dup
    //   567: invokespecial 472	java/util/HashSet:<init>	()V
    //   570: astore 4
    //   572: aload_1
    //   573: aload 14
    //   575: invokevirtual 164	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   578: aload 4
    //   580: aload_1
    //   581: invokevirtual 333	java/lang/Object:getClass	()Ljava/lang/Class;
    //   584: invokestatic 478	org/litepal/crud/DynamicExecutor:setField	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V
    //   587: aload 4
    //   589: aload 13
    //   591: invokeinterface 479 2 0
    //   596: pop
    //   597: aload_3
    //   598: invokeinterface 482 1 0
    //   603: ifne +18 -> 621
    //   606: aload 12
    //   608: invokevirtual 483	android/util/SparseArray:clear	()V
    //   611: aload 6
    //   613: invokeinterface 486 1 0
    //   618: goto +36 -> 654
    //   621: aload_3
    //   622: astore 4
    //   624: goto -229 -> 395
    //   627: astore_1
    //   628: goto +8 -> 636
    //   631: astore_1
    //   632: goto +11 -> 643
    //   635: astore_1
    //   636: goto +63 -> 699
    //   639: astore_1
    //   640: aload 5
    //   642: astore_3
    //   643: aload_1
    //   644: astore 4
    //   646: aload_3
    //   647: astore_1
    //   648: goto +29 -> 677
    //   651: aload 4
    //   653: astore_3
    //   654: aload_3
    //   655: ifnull -636 -> 19
    //   658: aload_3
    //   659: invokeinterface 489 1 0
    //   664: goto -645 -> 19
    //   667: astore_1
    //   668: aconst_null
    //   669: astore_3
    //   670: goto +29 -> 699
    //   673: astore 4
    //   675: aconst_null
    //   676: astore_1
    //   677: new 491	org/litepal/exceptions/LitePalSupportException
    //   680: dup
    //   681: aload 4
    //   683: invokevirtual 494	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   686: aload 4
    //   688: invokespecial 497	org/litepal/exceptions/LitePalSupportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   691: athrow
    //   692: astore 4
    //   694: aload_1
    //   695: astore_3
    //   696: aload 4
    //   698: astore_1
    //   699: aload_3
    //   700: ifnull +9 -> 709
    //   703: aload_3
    //   704: invokeinterface 489 1 0
    //   709: aload_1
    //   710: athrow
    //   711: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	this	DataHandler
    //   0	712	1	paramLitePalSupport	LitePalSupport
    //   58	423	2	i	int
    //   88	616	3	localObject1	Object
    //   94	558	4	localObject2	Object
    //   673	14	4	localException	Exception
    //   692	5	4	localObject3	Object
    //   111	530	5	localObject4	Object
    //   102	510	6	localObject5	Object
    //   17	13	7	localIterator	Iterator
    //   39	473	8	localAssociationsInfo	AssociationsInfo
    //   46	358	9	str	String
    //   70	382	10	localList1	List
    //   78	387	11	localList2	List
    //   377	230	12	localSparseArray	SparseArray
    //   414	176	13	localLitePalSupport	LitePalSupport
    //   516	58	14	localField	Field
    // Exception table:
    //   from	to	target	type
    //   448	480	627	finally
    //   487	508	627	finally
    //   511	530	627	finally
    //   539	560	627	finally
    //   563	572	627	finally
    //   572	587	627	finally
    //   587	597	627	finally
    //   597	618	627	finally
    //   448	480	631	java/lang/Exception
    //   487	508	631	java/lang/Exception
    //   511	530	631	java/lang/Exception
    //   539	560	631	java/lang/Exception
    //   563	572	631	java/lang/Exception
    //   572	587	631	java/lang/Exception
    //   587	597	631	java/lang/Exception
    //   597	618	631	java/lang/Exception
    //   353	363	635	finally
    //   370	379	635	finally
    //   386	395	635	finally
    //   402	416	635	finally
    //   423	445	635	finally
    //   353	363	639	java/lang/Exception
    //   370	379	639	java/lang/Exception
    //   386	395	639	java/lang/Exception
    //   402	416	639	java/lang/Exception
    //   423	445	639	java/lang/Exception
    //   64	80	667	finally
    //   84	247	667	finally
    //   250	341	667	finally
    //   64	80	673	java/lang/Exception
    //   84	247	673	java/lang/Exception
    //   250	341	673	java/lang/Exception
    //   677	692	692	finally
  }
  
  private void setToModelByReflection(Object paramObject, Field paramField, int paramInt, String paramString, Cursor paramCursor)
    throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
  {
    paramCursor = paramCursor.getClass().getMethod(paramString, new Class[] { Integer.TYPE }).invoke(paramCursor, new Object[] { Integer.valueOf(paramInt) });
    if ((paramField.getType() != Boolean.TYPE) && (paramField.getType() != Boolean.class))
    {
      if ((paramField.getType() != Character.TYPE) && (paramField.getType() != Character.class))
      {
        paramString = paramCursor;
        if (paramField.getType() == Date.class)
        {
          long l = ((Long)paramCursor).longValue();
          if (l <= 0L) {
            paramString = null;
          } else {
            paramString = new Date(l);
          }
        }
      }
      else
      {
        paramString = Character.valueOf(((String)paramCursor).charAt(0));
      }
    }
    else if ("0".equals(String.valueOf(paramCursor)))
    {
      paramString = Boolean.valueOf(false);
    }
    else
    {
      paramString = paramCursor;
      if ("1".equals(String.valueOf(paramCursor))) {
        paramString = Boolean.valueOf(true);
      }
    }
    if (isCollection(paramField.getType()))
    {
      localObject = (Collection)DynamicExecutor.getField(paramObject, paramField.getName(), paramObject.getClass());
      paramCursor = (Cursor)localObject;
      if (localObject == null)
      {
        if (isList(paramField.getType())) {
          paramCursor = new ArrayList();
        } else {
          paramCursor = new HashSet();
        }
        DynamicExecutor.setField(paramObject, paramField.getName(), paramCursor, paramObject.getClass());
      }
      localObject = getGenericTypeName(paramField);
      if ("java.lang.String".equals(localObject))
      {
        paramObject = (Encrypt)paramField.getAnnotation(Encrypt.class);
        paramField = paramString;
        if (paramObject != null) {
          paramField = decryptValue(((Encrypt)paramObject).algorithm(), paramString);
        }
      }
      else
      {
        paramField = paramString;
        if (paramObject.getClass().getName().equals(localObject)) {
          if (!(paramString instanceof Long))
          {
            paramField = paramString;
            if (!(paramString instanceof Integer)) {}
          }
          else
          {
            paramField = Operator.find(paramObject.getClass(), ((Long)paramString).longValue());
          }
        }
      }
      paramCursor.add(paramField);
      return;
    }
    Object localObject = (Encrypt)paramField.getAnnotation(Encrypt.class);
    paramCursor = paramString;
    if (localObject != null)
    {
      paramCursor = paramString;
      if ("java.lang.String".equals(paramField.getType().getName())) {
        paramCursor = decryptValue(((Encrypt)localObject).algorithm(), paramString);
      }
    }
    DynamicExecutor.setField(paramObject, paramField.getName(), paramCursor, paramObject.getClass());
  }
  
  protected void analyzeAssociatedModels(LitePalSupport paramLitePalSupport, Collection<AssociationsInfo> paramCollection)
  {
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        AssociationsInfo localAssociationsInfo = (AssociationsInfo)paramCollection.next();
        if (localAssociationsInfo.getAssociationType() == 2) {
          new Many2OneAnalyzer().analyze(paramLitePalSupport, localAssociationsInfo);
        } else if (localAssociationsInfo.getAssociationType() == 1) {
          new One2OneAnalyzer().analyze(paramLitePalSupport, localAssociationsInfo);
        } else if (localAssociationsInfo.getAssociationType() == 3) {
          new Many2ManyAnalyzer().analyze(paramLitePalSupport, localAssociationsInfo);
        }
      }
      return;
    }
    catch (Exception paramLitePalSupport)
    {
      throw new LitePalSupportException(paramLitePalSupport.getMessage(), paramLitePalSupport);
    }
  }
  
  protected Object createInstanceFromClass(Class<?> paramClass)
  {
    try
    {
      Constructor localConstructor = findBestSuitConstructor(paramClass);
      paramClass = localConstructor.newInstance(getConstructorParams(paramClass, localConstructor));
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new LitePalSupportException(paramClass.getMessage(), paramClass);
    }
  }
  
  protected Object decryptValue(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if (paramString != null)
    {
      localObject = paramObject;
      if (paramObject != null)
      {
        localObject = paramObject;
        if ("AES".equalsIgnoreCase(paramString)) {
          localObject = CipherUtil.aesDecrypt((String)paramObject);
        }
      }
    }
    return localObject;
  }
  
  protected Object encryptValue(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if (paramString != null)
    {
      localObject = paramObject;
      if (paramObject != null)
      {
        if ("AES".equalsIgnoreCase(paramString)) {
          return CipherUtil.aesEncrypt((String)paramObject);
        }
        localObject = paramObject;
        if ("MD5".equalsIgnoreCase(paramString)) {
          localObject = CipherUtil.md5Encrypt((String)paramObject);
        }
      }
    }
    return localObject;
  }
  
  protected Constructor<?> findBestSuitConstructor(Class<?> paramClass)
  {
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    SparseArray localSparseArray = new SparseArray();
    int i1 = arrayOfConstructor.length;
    int k = 0;
    int j;
    for (int m = Integer.MAX_VALUE; k < i1; m = j)
    {
      Constructor localConstructor = arrayOfConstructor[k];
      int i = localConstructor.getParameterTypes().length;
      Class[] arrayOfClass = localConstructor.getParameterTypes();
      int i2 = arrayOfClass.length;
      int n = 0;
      while (n < i2)
      {
        Class localClass = arrayOfClass[n];
        if (localClass == paramClass)
        {
          j = i + 10000;
        }
        else
        {
          j = i;
          if (localClass.getName().startsWith("com.android"))
          {
            j = i;
            if (localClass.getName().endsWith("InstantReloadException")) {
              j = i + 10000;
            }
          }
        }
        n += 1;
        i = j;
      }
      if (localSparseArray.get(i) == null) {
        localSparseArray.put(i, localConstructor);
      }
      j = m;
      if (i < m) {
        j = i;
      }
      k += 1;
    }
    paramClass = (Constructor)localSparseArray.get(m);
    if (paramClass != null) {
      paramClass.setAccessible(true);
    }
    return paramClass;
  }
  
  protected LitePalSupport getAssociatedModel(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    return (LitePalSupport)getFieldValue(paramLitePalSupport, paramAssociationsInfo.getAssociateOtherModelFromSelf());
  }
  
  protected Collection<LitePalSupport> getAssociatedModels(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    return (Collection)getFieldValue(paramLitePalSupport, paramAssociationsInfo.getAssociateOtherModelFromSelf());
  }
  
  protected Object[] getConstructorParams(Class<?> paramClass, Constructor<?> paramConstructor)
  {
    paramConstructor = paramConstructor.getParameterTypes();
    Object[] arrayOfObject = new Object[paramConstructor.length];
    int i = 0;
    while (i < paramConstructor.length)
    {
      arrayOfObject[i] = getInitParamValue(paramClass, paramConstructor[i]);
      i += 1;
    }
    return arrayOfObject;
  }
  
  /* Error */
  protected LitePalSupport getEmptyModel(LitePalSupport paramLitePalSupport)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 647	org/litepal/crud/DataHandler:tempEmptyModel	Lorg/litepal/crud/LitePalSupport;
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: getfield 647	org/litepal/crud/DataHandler:tempEmptyModel	Lorg/litepal/crud/LitePalSupport;
    //   11: areturn
    //   12: aload_1
    //   13: invokevirtual 650	org/litepal/crud/LitePalSupport:getClassName	()Ljava/lang/String;
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 439	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: invokevirtual 652	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   25: checkcast 381	org/litepal/crud/LitePalSupport
    //   28: putfield 647	org/litepal/crud/DataHandler:tempEmptyModel	Lorg/litepal/crud/LitePalSupport;
    //   31: aload_0
    //   32: getfield 647	org/litepal/crud/DataHandler:tempEmptyModel	Lorg/litepal/crud/LitePalSupport;
    //   35: astore_2
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: goto +20 -> 59
    //   42: astore_1
    //   43: new 491	org/litepal/exceptions/LitePalSupportException
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 494	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokespecial 497	org/litepal/exceptions/LitePalSupportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: new 98	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   66: astore_3
    //   67: aload_3
    //   68: aload_1
    //   69: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: ldc_w 654
    //   77: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: new 491	org/litepal/exceptions/LitePalSupportException
    //   84: dup
    //   85: aload_3
    //   86: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: aload_2
    //   90: invokespecial 497	org/litepal/exceptions/LitePalSupportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: athrow
    //   94: aconst_null
    //   95: astore_1
    //   96: new 98	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   103: astore_2
    //   104: aload_2
    //   105: ldc_w 656
    //   108: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_2
    //   113: aload_1
    //   114: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: new 658	org/litepal/exceptions/DatabaseGenerateException
    //   121: dup
    //   122: aload_2
    //   123: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokespecial 660	org/litepal/exceptions/DatabaseGenerateException:<init>	(Ljava/lang/String;)V
    //   129: athrow
    //   130: astore_1
    //   131: goto -37 -> 94
    //   134: astore_2
    //   135: goto -39 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	DataHandler
    //   0	138	1	paramLitePalSupport	LitePalSupport
    //   35	2	2	localLitePalSupport	LitePalSupport
    //   38	1	2	localInstantiationException1	InstantiationException
    //   56	34	2	localInstantiationException2	InstantiationException
    //   103	20	2	localStringBuilder1	StringBuilder
    //   134	1	2	localClassNotFoundException	ClassNotFoundException
    //   66	20	3	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	36	38	java/lang/InstantiationException
    //   12	17	42	java/lang/Exception
    //   17	36	42	java/lang/Exception
    //   12	17	56	java/lang/InstantiationException
    //   12	17	130	java/lang/ClassNotFoundException
    //   17	36	134	java/lang/ClassNotFoundException
  }
  
  protected Object getFieldValue(LitePalSupport paramLitePalSupport, Field paramField)
    throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    if (shouldGetOrSet(paramLitePalSupport, paramField)) {
      return DynamicExecutor.getField(paramLitePalSupport, paramField.getName(), paramLitePalSupport.getClass());
    }
    return null;
  }
  
  protected List<AssociationsInfo> getForeignKeyAssociations(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      analyzeAssociations(paramString);
      return this.fkInCurrentModel;
    }
    return null;
  }
  
  protected String getIntermediateTableName(LitePalSupport paramLitePalSupport, String paramString)
  {
    return BaseUtility.changeCase(DBUtility.getIntermediateTableName(paramLitePalSupport.getTableName(), paramString));
  }
  
  protected Class<?>[] getParameterTypes(Field paramField, Object paramObject, Object[] paramArrayOfObject)
  {
    if (isCharType(paramField))
    {
      paramArrayOfObject[1] = String.valueOf(paramObject);
      return new Class[] { String.class, String.class };
    }
    if (paramField.getType().isPrimitive())
    {
      paramObject = new Class[2];
      paramObject[0] = String.class;
      paramObject[1] = getObjectType(paramField.getType());
    }
    for (paramField = (Field)paramObject;; paramField = (Field)paramObject)
    {
      return paramField;
      if ("java.util.Date".equals(paramField.getType().getName())) {
        return new Class[] { String.class, Long.class };
      }
      paramObject = new Class[2];
      paramObject[0] = String.class;
      paramObject[1] = paramField.getType();
    }
  }
  
  protected String getTableName(Class<?> paramClass)
  {
    return BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName()));
  }
  
  protected String[] getWhereArgs(String... paramVarArgs)
  {
    if (isAffectAllLines(new Object[] { paramVarArgs })) {
      return null;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 1))
    {
      String[] arrayOfString = new String[paramVarArgs.length - 1];
      System.arraycopy(paramVarArgs, 1, arrayOfString, 0, paramVarArgs.length - 1);
      return arrayOfString;
    }
    return null;
  }
  
  protected String getWhereClause(String... paramVarArgs)
  {
    if (isAffectAllLines(new Object[] { paramVarArgs })) {
      return null;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      return paramVarArgs[0];
    }
    return null;
  }
  
  protected String getWhereOfIdsWithOr(Collection<Long> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      long l = ((Long)paramCollection.next()).longValue();
      if (i != 0) {
        localStringBuilder.append(" or ");
      }
      i = 1;
      localStringBuilder.append("id = ");
      localStringBuilder.append(l);
    }
    return BaseUtility.changeCase(localStringBuilder.toString());
  }
  
  protected String getWhereOfIdsWithOr(long... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramVarArgs.length;
    int i = 0;
    for (int j = 0; i < k; j = 1)
    {
      long l = paramVarArgs[i];
      if (j != 0) {
        localStringBuilder.append(" or ");
      }
      localStringBuilder.append("id = ");
      localStringBuilder.append(l);
      i += 1;
    }
    return BaseUtility.changeCase(localStringBuilder.toString());
  }
  
  protected void giveBaseObjIdValue(LitePalSupport paramLitePalSupport, long paramLong)
    throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    if (paramLong > 0L) {
      DynamicExecutor.set(paramLitePalSupport, "baseObjId", Long.valueOf(paramLong), LitePalSupport.class);
    }
  }
  
  protected boolean isAffectAllLines(Object... paramVarArgs)
  {
    return (paramVarArgs != null) && (paramVarArgs.length == 0);
  }
  
  /* Error */
  protected <T> T mathQuery(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 714	org/litepal/util/BaseUtility:checkConditionsCorrect	([Ljava/lang/String;)V
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 7
    //   13: aload_0
    //   14: getfield 416	org/litepal/crud/DataHandler:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   17: aload_1
    //   18: aload_2
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 716	org/litepal/crud/DataHandler:getWhereClause	([Ljava/lang/String;)Ljava/lang/String;
    //   24: aload_0
    //   25: aload_3
    //   26: invokevirtual 718	org/litepal/crud/DataHandler:getWhereArgs	([Ljava/lang/String;)[Ljava/lang/String;
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokevirtual 721	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   35: astore_1
    //   36: aload 7
    //   38: astore_2
    //   39: aload_1
    //   40: invokeinterface 429 1 0
    //   45: ifeq +42 -> 87
    //   48: aload_1
    //   49: invokevirtual 333	java/lang/Object:getClass	()Ljava/lang/Class;
    //   52: aload_0
    //   53: aload 4
    //   55: invokespecial 151	org/litepal/crud/DataHandler:genGetColumnMethod	(Ljava/lang/Class;)Ljava/lang/String;
    //   58: iconst_1
    //   59: anewarray 81	java/lang/Class
    //   62: dup
    //   63: iconst_0
    //   64: getstatic 503	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   67: aastore
    //   68: invokevirtual 507	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   71: aload_1
    //   72: iconst_1
    //   73: anewarray 324	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: iconst_0
    //   79: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: invokevirtual 513	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   86: astore_2
    //   87: aload_1
    //   88: ifnull +9 -> 97
    //   91: aload_1
    //   92: invokeinterface 489 1 0
    //   97: aload_2
    //   98: areturn
    //   99: astore_2
    //   100: goto +37 -> 137
    //   103: astore_2
    //   104: aload_1
    //   105: astore 5
    //   107: aload_2
    //   108: astore_1
    //   109: goto +15 -> 124
    //   112: astore_2
    //   113: aload 5
    //   115: astore_1
    //   116: goto +21 -> 137
    //   119: astore_1
    //   120: aload 6
    //   122: astore 5
    //   124: new 491	org/litepal/exceptions/LitePalSupportException
    //   127: dup
    //   128: aload_1
    //   129: invokevirtual 494	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: aload_1
    //   133: invokespecial 497	org/litepal/exceptions/LitePalSupportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: athrow
    //   137: aload_1
    //   138: ifnull +9 -> 147
    //   141: aload_1
    //   142: invokeinterface 489 1 0
    //   147: aload_2
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	DataHandler
    //   0	149	1	paramString	String
    //   0	149	2	paramArrayOfString1	String[]
    //   0	149	3	paramArrayOfString2	String[]
    //   0	149	4	paramClass	Class<T>
    //   5	118	5	localObject1	Object
    //   8	113	6	localObject2	Object
    //   11	26	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	87	99	finally
    //   39	87	103	java/lang/Exception
    //   13	36	112	finally
    //   124	137	112	finally
    //   13	36	119	java/lang/Exception
  }
  
  protected void putContentValuesForSave(LitePalSupport paramLitePalSupport, Field paramField, ContentValues paramContentValues)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    Object localObject = DynamicExecutor.getField(paramLitePalSupport, paramField.getName(), paramLitePalSupport.getClass());
    if (localObject != null)
    {
      paramLitePalSupport = (LitePalSupport)localObject;
      if ("java.util.Date".equals(paramField.getType().getName())) {
        paramLitePalSupport = Long.valueOf(((Date)localObject).getTime());
      }
      Encrypt localEncrypt = (Encrypt)paramField.getAnnotation(Encrypt.class);
      localObject = paramLitePalSupport;
      if (localEncrypt != null)
      {
        localObject = paramLitePalSupport;
        if ("java.lang.String".equals(paramField.getType().getName())) {
          localObject = encryptValue(localEncrypt.algorithm(), paramLitePalSupport);
        }
      }
      paramLitePalSupport = new Object[2];
      paramLitePalSupport[0] = BaseUtility.changeCase(DBUtility.convertToValidColumnName(paramField.getName()));
      paramLitePalSupport[1] = localObject;
      paramField = getParameterTypes(paramField, localObject, paramLitePalSupport);
      DynamicExecutor.send(paramContentValues, "put", paramLitePalSupport, paramContentValues.getClass(), paramField);
    }
  }
  
  protected void putContentValuesForUpdate(LitePalSupport paramLitePalSupport, Field paramField, ContentValues paramContentValues)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    Object localObject = getFieldValue(paramLitePalSupport, paramField);
    paramLitePalSupport = (LitePalSupport)localObject;
    if ("java.util.Date".equals(paramField.getType().getName()))
    {
      paramLitePalSupport = (LitePalSupport)localObject;
      if (localObject != null) {
        paramLitePalSupport = Long.valueOf(((Date)localObject).getTime());
      }
    }
    Encrypt localEncrypt = (Encrypt)paramField.getAnnotation(Encrypt.class);
    localObject = paramLitePalSupport;
    if (localEncrypt != null)
    {
      localObject = paramLitePalSupport;
      if ("java.lang.String".equals(paramField.getType().getName())) {
        localObject = encryptValue(localEncrypt.algorithm(), paramLitePalSupport);
      }
    }
    paramLitePalSupport = new Object[2];
    paramLitePalSupport[0] = BaseUtility.changeCase(DBUtility.convertToValidColumnName(paramField.getName()));
    paramLitePalSupport[1] = localObject;
    paramField = getParameterTypes(paramField, localObject, paramLitePalSupport);
    DynamicExecutor.send(paramContentValues, "put", paramLitePalSupport, paramContentValues.getClass(), paramField);
  }
  
  protected void putFieldsValue(LitePalSupport paramLitePalSupport, List<Field> paramList, ContentValues paramContentValues)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Field localField = (Field)paramList.next();
      if (!isIdColumn(localField.getName())) {
        putFieldsValueDependsOnSaveOrUpdate(paramLitePalSupport, localField, paramContentValues);
      }
    }
  }
  
  /* Error */
  protected <T> List<T> query(Class<T> paramClass, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5, List<AssociationsInfo> paramList)
  {
    // Byte code:
    //   0: new 34	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 35	java/util/ArrayList:<init>	()V
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 12
    //   15: aload 12
    //   17: astore 10
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 87	java/lang/Class:getName	()Ljava/lang/String;
    //   24: invokevirtual 376	org/litepal/crud/DataHandler:getSupportedFields	(Ljava/lang/String;)Ljava/util/List;
    //   27: astore 14
    //   29: aload 12
    //   31: astore 10
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 87	java/lang/Class:getName	()Ljava/lang/String;
    //   38: invokevirtual 379	org/litepal/crud/DataHandler:getSupportedGenericFields	(Ljava/lang/String;)Ljava/util/List;
    //   41: astore 15
    //   43: aload 12
    //   45: astore 10
    //   47: aload_0
    //   48: aload_2
    //   49: aload 15
    //   51: aload 9
    //   53: invokespecial 745	org/litepal/crud/DataHandler:getCustomizedColumns	([Ljava/lang/String;Ljava/util/List;Ljava/util/List;)[Ljava/lang/String;
    //   56: invokestatic 748	org/litepal/util/DBUtility:convertSelectClauseToValidNames	([Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore_2
    //   60: aload 12
    //   62: astore 10
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 750	org/litepal/crud/DataHandler:getTableName	(Ljava/lang/Class;)Ljava/lang/String;
    //   69: astore 16
    //   71: aload 12
    //   73: astore 10
    //   75: aload_0
    //   76: getfield 416	org/litepal/crud/DataHandler:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   79: aload 16
    //   81: aload_2
    //   82: aload_3
    //   83: aload 4
    //   85: aload 5
    //   87: aload 6
    //   89: aload 7
    //   91: aload 8
    //   93: invokevirtual 424	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   96: astore_2
    //   97: aload_2
    //   98: invokeinterface 429 1 0
    //   103: ifeq +119 -> 222
    //   106: new 431	android/util/SparseArray
    //   109: dup
    //   110: invokespecial 432	android/util/SparseArray:<init>	()V
    //   113: astore_3
    //   114: new 434	java/util/HashMap
    //   117: dup
    //   118: invokespecial 435	java/util/HashMap:<init>	()V
    //   121: astore 4
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 264	org/litepal/crud/DataHandler:createInstanceFromClass	(Ljava/lang/Class;)Ljava/lang/Object;
    //   128: astore 5
    //   130: aload_0
    //   131: aload 5
    //   133: checkcast 381	org/litepal/crud/LitePalSupport
    //   136: aload_2
    //   137: aload_2
    //   138: ldc -69
    //   140: invokeinterface 443 2 0
    //   145: invokeinterface 446 2 0
    //   150: invokevirtual 450	org/litepal/crud/DataHandler:giveBaseObjIdValue	(Lorg/litepal/crud/LitePalSupport;J)V
    //   153: aload_0
    //   154: aload 5
    //   156: aload 14
    //   158: aload 9
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 454	org/litepal/crud/DataHandler:setValueToModel	(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Lnet/sqlcipher/Cursor;Landroid/util/SparseArray;)V
    //   165: aload_0
    //   166: aload 5
    //   168: checkcast 381	org/litepal/crud/LitePalSupport
    //   171: aload 15
    //   173: aload 4
    //   175: invokevirtual 458	org/litepal/crud/DataHandler:setGenericValueToModel	(Lorg/litepal/crud/LitePalSupport;Ljava/util/List;Ljava/util/Map;)V
    //   178: aload 9
    //   180: ifnull +12 -> 192
    //   183: aload_0
    //   184: aload 5
    //   186: checkcast 381	org/litepal/crud/LitePalSupport
    //   189: invokespecial 752	org/litepal/crud/DataHandler:setAssociatedModel	(Lorg/litepal/crud/LitePalSupport;)V
    //   192: aload 13
    //   194: aload 5
    //   196: invokeinterface 68 2 0
    //   201: pop
    //   202: aload_2
    //   203: invokeinterface 482 1 0
    //   208: ifne -85 -> 123
    //   211: aload_3
    //   212: invokevirtual 483	android/util/SparseArray:clear	()V
    //   215: aload 4
    //   217: invokeinterface 486 1 0
    //   222: aload_2
    //   223: ifnull +9 -> 232
    //   226: aload_2
    //   227: invokeinterface 489 1 0
    //   232: aload 13
    //   234: areturn
    //   235: astore_1
    //   236: goto +35 -> 271
    //   239: astore_1
    //   240: aload_2
    //   241: astore 10
    //   243: goto +15 -> 258
    //   246: astore_1
    //   247: aload 10
    //   249: astore_2
    //   250: goto +21 -> 271
    //   253: astore_1
    //   254: aload 11
    //   256: astore 10
    //   258: new 491	org/litepal/exceptions/LitePalSupportException
    //   261: dup
    //   262: aload_1
    //   263: invokevirtual 494	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   266: aload_1
    //   267: invokespecial 497	org/litepal/exceptions/LitePalSupportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: athrow
    //   271: aload_2
    //   272: ifnull +9 -> 281
    //   275: aload_2
    //   276: invokeinterface 489 1 0
    //   281: aload_1
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	DataHandler
    //   0	283	1	paramClass	Class<T>
    //   0	283	2	paramArrayOfString1	String[]
    //   0	283	3	paramString1	String
    //   0	283	4	paramArrayOfString2	String[]
    //   0	283	5	paramString2	String
    //   0	283	6	paramString3	String
    //   0	283	7	paramString4	String
    //   0	283	8	paramString5	String
    //   0	283	9	paramList	List<AssociationsInfo>
    //   17	240	10	localObject1	Object
    //   10	245	11	localObject2	Object
    //   13	59	12	localObject3	Object
    //   7	226	13	localArrayList	ArrayList
    //   27	130	14	localList1	List
    //   41	131	15	localList2	List
    //   69	11	16	str	String
    // Exception table:
    //   from	to	target	type
    //   97	123	235	finally
    //   123	178	235	finally
    //   183	192	235	finally
    //   192	222	235	finally
    //   97	123	239	java/lang/Exception
    //   123	178	239	java/lang/Exception
    //   183	192	239	java/lang/Exception
    //   192	222	239	java/lang/Exception
    //   19	29	246	finally
    //   33	43	246	finally
    //   47	60	246	finally
    //   64	71	246	finally
    //   75	97	246	finally
    //   258	271	246	finally
    //   19	29	253	java/lang/Exception
    //   33	43	253	java/lang/Exception
    //   47	60	253	java/lang/Exception
    //   64	71	253	java/lang/Exception
    //   75	97	253	java/lang/Exception
  }
  
  protected void setFieldValue(LitePalSupport paramLitePalSupport, Field paramField, Object paramObject)
    throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    if (shouldGetOrSet(paramLitePalSupport, paramField)) {
      DynamicExecutor.setField(paramLitePalSupport, paramField.getName(), paramObject, paramLitePalSupport.getClass());
    }
  }
  
  /* Error */
  protected void setGenericValueToModel(LitePalSupport paramLitePalSupport, List<Field> paramList, java.util.Map<Field, org.litepal.tablemanager.model.GenericModel> paramMap)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 163 1 0
    //   6: astore 11
    //   8: aload 11
    //   10: invokeinterface 54 1 0
    //   15: ifeq +352 -> 367
    //   18: aload 11
    //   20: invokeinterface 58 1 0
    //   25: checkcast 137	java/lang/reflect/Field
    //   28: astore 12
    //   30: aconst_null
    //   31: astore 10
    //   33: aload_3
    //   34: aload 12
    //   36: invokeinterface 756 2 0
    //   41: checkcast 758	org/litepal/tablemanager/model/GenericModel
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +134 -> 182
    //   51: aload_0
    //   52: aload 12
    //   54: invokevirtual 541	org/litepal/crud/DataHandler:getGenericTypeName	(Ljava/lang/reflect/Field;)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_1
    //   59: invokevirtual 650	org/litepal/crud/LitePalSupport:getClassName	()Ljava/lang/String;
    //   62: aload_2
    //   63: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifeq +16 -> 82
    //   69: aload 12
    //   71: invokestatic 761	org/litepal/util/DBUtility:getM2MSelfRefColumnName	(Ljava/lang/reflect/Field;)Ljava/lang/String;
    //   74: astore 6
    //   76: ldc 120
    //   78: astore_2
    //   79: goto +20 -> 99
    //   82: aload 12
    //   84: invokevirtual 164	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   87: invokestatic 730	org/litepal/util/DBUtility:convertToValidColumnName	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 6
    //   92: aload_0
    //   93: aload 12
    //   95: invokespecial 763	org/litepal/crud/DataHandler:genGetColumnMethod	(Ljava/lang/reflect/Field;)Ljava/lang/String;
    //   98: astore_2
    //   99: aload_1
    //   100: invokevirtual 650	org/litepal/crud/LitePalSupport:getClassName	()Ljava/lang/String;
    //   103: aload 12
    //   105: invokevirtual 164	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   108: invokestatic 766	org/litepal/util/DBUtility:getGenericTableName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 7
    //   113: aload_1
    //   114: invokevirtual 650	org/litepal/crud/LitePalSupport:getClassName	()Ljava/lang/String;
    //   117: invokestatic 769	org/litepal/util/DBUtility:getGenericValueIdColumnName	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 8
    //   122: new 758	org/litepal/tablemanager/model/GenericModel
    //   125: dup
    //   126: invokespecial 770	org/litepal/tablemanager/model/GenericModel:<init>	()V
    //   129: astore 9
    //   131: aload 9
    //   133: aload 7
    //   135: invokevirtual 773	org/litepal/tablemanager/model/GenericModel:setTableName	(Ljava/lang/String;)V
    //   138: aload 9
    //   140: aload 6
    //   142: invokevirtual 776	org/litepal/tablemanager/model/GenericModel:setValueColumnName	(Ljava/lang/String;)V
    //   145: aload 9
    //   147: aload 8
    //   149: invokevirtual 779	org/litepal/tablemanager/model/GenericModel:setValueIdColumnName	(Ljava/lang/String;)V
    //   152: aload 9
    //   154: aload_2
    //   155: invokevirtual 782	org/litepal/tablemanager/model/GenericModel:setGetMethodName	(Ljava/lang/String;)V
    //   158: aload_3
    //   159: aload 12
    //   161: aload 9
    //   163: invokeinterface 785 3 0
    //   168: pop
    //   169: aload_2
    //   170: astore 9
    //   172: aload 6
    //   174: astore_2
    //   175: aload 9
    //   177: astore 6
    //   179: goto +30 -> 209
    //   182: aload 6
    //   184: invokevirtual 786	org/litepal/tablemanager/model/GenericModel:getTableName	()Ljava/lang/String;
    //   187: astore 7
    //   189: aload 6
    //   191: invokevirtual 789	org/litepal/tablemanager/model/GenericModel:getValueColumnName	()Ljava/lang/String;
    //   194: astore_2
    //   195: aload 6
    //   197: invokevirtual 792	org/litepal/tablemanager/model/GenericModel:getValueIdColumnName	()Ljava/lang/String;
    //   200: astore 8
    //   202: aload 6
    //   204: invokevirtual 795	org/litepal/tablemanager/model/GenericModel:getGetMethodName	()Ljava/lang/String;
    //   207: astore 6
    //   209: aload_0
    //   210: getfield 416	org/litepal/crud/DataHandler:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   213: astore 9
    //   215: new 98	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   222: astore 13
    //   224: aload 13
    //   226: aload 8
    //   228: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 13
    //   234: ldc_w 797
    //   237: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 9
    //   243: aload 7
    //   245: aconst_null
    //   246: aload 13
    //   248: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: iconst_1
    //   252: anewarray 74	java/lang/String
    //   255: dup
    //   256: iconst_0
    //   257: aload_1
    //   258: invokevirtual 402	org/litepal/crud/LitePalSupport:getBaseObjId	()J
    //   261: invokestatic 405	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   264: aastore
    //   265: aconst_null
    //   266: aconst_null
    //   267: aconst_null
    //   268: invokevirtual 721	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   271: astore 7
    //   273: aload 7
    //   275: invokeinterface 429 1 0
    //   280: ifeq +49 -> 329
    //   283: aload 7
    //   285: aload_2
    //   286: invokestatic 190	org/litepal/util/BaseUtility:changeCase	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokeinterface 800 2 0
    //   294: istore 4
    //   296: iload 4
    //   298: iconst_m1
    //   299: if_icmpeq +16 -> 315
    //   302: aload_0
    //   303: aload_1
    //   304: aload 12
    //   306: iload 4
    //   308: aload 6
    //   310: aload 7
    //   312: invokespecial 802	org/litepal/crud/DataHandler:setToModelByReflection	(Ljava/lang/Object;Ljava/lang/reflect/Field;ILjava/lang/String;Lnet/sqlcipher/Cursor;)V
    //   315: aload 7
    //   317: invokeinterface 482 1 0
    //   322: istore 5
    //   324: iload 5
    //   326: ifne -43 -> 283
    //   329: aload 7
    //   331: ifnull -323 -> 8
    //   334: aload 7
    //   336: invokeinterface 489 1 0
    //   341: goto -333 -> 8
    //   344: astore_2
    //   345: aload 7
    //   347: astore_1
    //   348: goto +7 -> 355
    //   351: astore_2
    //   352: aload 10
    //   354: astore_1
    //   355: aload_1
    //   356: ifnull +9 -> 365
    //   359: aload_1
    //   360: invokeinterface 489 1 0
    //   365: aload_2
    //   366: athrow
    //   367: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	DataHandler
    //   0	368	1	paramLitePalSupport	LitePalSupport
    //   0	368	2	paramList	List<Field>
    //   0	368	3	paramMap	java.util.Map<Field, org.litepal.tablemanager.model.GenericModel>
    //   294	13	4	i	int
    //   322	3	5	bool	boolean
    //   44	265	6	localObject1	Object
    //   111	235	7	localObject2	Object
    //   120	107	8	str	String
    //   129	113	9	localObject3	Object
    //   31	322	10	localObject4	Object
    //   6	13	11	localIterator	Iterator
    //   28	277	12	localField	Field
    //   222	25	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   273	283	344	finally
    //   283	296	344	finally
    //   302	315	344	finally
    //   315	324	344	finally
    //   209	273	351	finally
  }
  
  protected void setValueToModel(Object paramObject, List<Field> paramList, List<AssociationsInfo> paramList1, Cursor paramCursor, SparseArray<QueryInfoCache> paramSparseArray)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    int j = paramSparseArray.size();
    int i;
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        int k = paramSparseArray.keyAt(i);
        paramList = (QueryInfoCache)paramSparseArray.get(k);
        setToModelByReflection(paramObject, paramList.field, k, paramList.getMethodName, paramCursor);
        i += 1;
      }
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      String str = genGetColumnMethod(localField);
      if (isIdColumn(localField.getName())) {
        paramList = "id";
      } else {
        paramList = DBUtility.convertToValidColumnName(localField.getName());
      }
      i = paramCursor.getColumnIndex(BaseUtility.changeCase(paramList));
      if (i != -1)
      {
        setToModelByReflection(paramObject, localField, i, str, paramCursor);
        paramList = new QueryInfoCache();
        paramList.getMethodName = str;
        paramList.field = localField;
        paramSparseArray.put(i, paramList);
      }
    }
    if (paramList1 != null)
    {
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (AssociationsInfo)paramList.next();
        i = paramCursor.getColumnIndex(getForeignKeyColumnName(DBUtility.getTableNameByClassName(paramList1.getAssociatedClassName())));
        if (i != -1)
        {
          long l = paramCursor.getLong(i);
          try
          {
            paramSparseArray = (LitePalSupport)Operator.find(Class.forName(paramList1.getAssociatedClassName()), l);
            if (paramSparseArray != null) {
              setFieldValue((LitePalSupport)paramObject, paramList1.getAssociateOtherModelFromSelf(), paramSparseArray);
            }
          }
          catch (ClassNotFoundException paramList1)
          {
            paramList1.printStackTrace();
          }
        }
      }
    }
  }
  
  protected boolean shouldGetOrSet(LitePalSupport paramLitePalSupport, Field paramField)
  {
    return (paramLitePalSupport != null) && (paramField != null);
  }
  
  class QueryInfoCache
  {
    Field field;
    String getMethodName;
    
    QueryInfoCache() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\DataHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */