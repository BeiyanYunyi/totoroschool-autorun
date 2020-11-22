package org.litepal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.tablemanager.typechange.BlobOrm;
import org.litepal.tablemanager.typechange.BooleanOrm;
import org.litepal.tablemanager.typechange.DateOrm;
import org.litepal.tablemanager.typechange.DecimalOrm;
import org.litepal.tablemanager.typechange.NumericOrm;
import org.litepal.tablemanager.typechange.OrmChange;
import org.litepal.tablemanager.typechange.TextOrm;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public abstract class LitePalBase
{
  private static final int GET_ASSOCIATIONS_ACTION = 1;
  private static final int GET_ASSOCIATION_INFO_ACTION = 2;
  public static final String TAG = "LitePalBase";
  private Map<String, List<Field>> classFieldsMap = new HashMap();
  private Map<String, List<Field>> classGenericFieldsMap = new HashMap();
  private Collection<AssociationsInfo> mAssociationInfos;
  private Collection<AssociationsModel> mAssociationModels;
  private Collection<GenericModel> mGenericModels;
  private OrmChange[] typeChangeRules = { new NumericOrm(), new TextOrm(), new BooleanOrm(), new DecimalOrm(), new DateOrm(), new BlobOrm() };
  
  private void addIntoAssociationInfoCollection(String paramString1, String paramString2, String paramString3, Field paramField1, Field paramField2, int paramInt)
  {
    AssociationsInfo localAssociationsInfo = new AssociationsInfo();
    localAssociationsInfo.setSelfClassName(paramString1);
    localAssociationsInfo.setAssociatedClassName(paramString2);
    localAssociationsInfo.setClassHoldsForeignKey(paramString3);
    localAssociationsInfo.setAssociateOtherModelFromSelf(paramField1);
    localAssociationsInfo.setAssociateSelfFromOtherModel(paramField2);
    localAssociationsInfo.setAssociationType(paramInt);
    this.mAssociationInfos.add(localAssociationsInfo);
  }
  
  private void addIntoAssociationModelCollection(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AssociationsModel localAssociationsModel = new AssociationsModel();
    localAssociationsModel.setTableName(DBUtility.getTableNameByClassName(paramString1));
    localAssociationsModel.setAssociatedTableName(DBUtility.getTableNameByClassName(paramString2));
    localAssociationsModel.setTableHoldsForeignKey(DBUtility.getTableNameByClassName(paramString3));
    localAssociationsModel.setAssociationType(paramInt);
    this.mAssociationModels.add(localAssociationsModel);
  }
  
  private void analyzeClassFields(String paramString, int paramInt)
  {
    try
    {
      Field[] arrayOfField = Class.forName(paramString).getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if (isNonPrimitive(localField))
        {
          Column localColumn = (Column)localField.getAnnotation(Column.class);
          if ((localColumn == null) || (!localColumn.ignore()))
          {
            oneToAnyConditions(paramString, localField, paramInt);
            manyToAnyConditions(paramString, localField, paramInt);
          }
        }
        i += 1;
      }
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can not find a class named ");
      localStringBuilder.append(paramString);
      throw new DatabaseGenerateException(localStringBuilder.toString());
    }
  }
  
  private ColumnModel convertFieldToColumnModel(Field paramField)
  {
    String str = getColumnType(paramField.getType().getName());
    Object localObject = (Column)paramField.getAnnotation(Column.class);
    boolean bool1;
    boolean bool2;
    if (localObject != null)
    {
      bool1 = ((Column)localObject).nullable();
      bool2 = ((Column)localObject).unique();
      localObject = ((Column)localObject).defaultValue();
    }
    else
    {
      bool2 = false;
      localObject = "";
      bool1 = true;
    }
    ColumnModel localColumnModel = new ColumnModel();
    localColumnModel.setColumnName(DBUtility.convertToValidColumnName(paramField.getName()));
    localColumnModel.setColumnType(str);
    localColumnModel.setNullable(bool1);
    localColumnModel.setUnique(bool2);
    localColumnModel.setDefaultValue((String)localObject);
    return localColumnModel;
  }
  
  private boolean isNonPrimitive(Field paramField)
  {
    return paramField.getType().isPrimitive() ^ true;
  }
  
  private boolean isPrivate(Field paramField)
  {
    return Modifier.isPrivate(paramField.getModifiers());
  }
  
  private void manyToAnyConditions(String paramString, Field paramField, int paramInt)
    throws ClassNotFoundException
  {
    if (isCollection(paramField.getType()))
    {
      String str = getGenericTypeName(paramField);
      Object localObject1;
      if (LitePalAttr.getInstance().getClassNames().contains(str))
      {
        localObject1 = Class.forName(str).getDeclaredFields();
        int m = localObject1.length;
        int j = 0;
        int i = 0;
        while (i < m)
        {
          Object localObject2 = localObject1[i];
          int k = j;
          if (!Modifier.isStatic(((Field)localObject2).getModifiers()))
          {
            Class localClass = ((Field)localObject2).getType();
            if (paramString.equals(localClass.getName())) {
              if (paramInt == 1) {
                addIntoAssociationModelCollection(paramString, str, str, 2);
              } else if (paramInt == 2) {
                addIntoAssociationInfoCollection(paramString, str, str, paramField, (Field)localObject2, 2);
              }
            }
            for (;;)
            {
              k = 1;
              break;
              k = j;
              if (!isCollection(localClass)) {
                break;
              }
              k = j;
              if (!paramString.equals(getGenericTypeName((Field)localObject2))) {
                break;
              }
              if (paramInt == 1)
              {
                if (paramString.equalsIgnoreCase(str))
                {
                  localObject2 = new GenericModel();
                  ((GenericModel)localObject2).setTableName(DBUtility.getGenericTableName(paramString, paramField.getName()));
                  ((GenericModel)localObject2).setValueColumnName(DBUtility.getM2MSelfRefColumnName(paramField));
                  ((GenericModel)localObject2).setValueColumnType("integer");
                  ((GenericModel)localObject2).setValueIdColumnName(DBUtility.getGenericValueIdColumnName(paramString));
                  this.mGenericModels.add(localObject2);
                }
                else
                {
                  addIntoAssociationModelCollection(paramString, str, null, 3);
                }
              }
              else if ((paramInt == 2) && (!paramString.equalsIgnoreCase(str))) {
                addIntoAssociationInfoCollection(paramString, str, null, paramField, (Field)localObject2, 3);
              }
            }
          }
          i += 1;
          j = k;
        }
        if (j == 0)
        {
          if (paramInt == 1)
          {
            addIntoAssociationModelCollection(paramString, str, str, 2);
            return;
          }
          if (paramInt == 2) {
            addIntoAssociationInfoCollection(paramString, str, str, paramField, null, 2);
          }
        }
      }
      else if ((BaseUtility.isGenericTypeSupported(str)) && (paramInt == 1))
      {
        localObject1 = new GenericModel();
        ((GenericModel)localObject1).setTableName(DBUtility.getGenericTableName(paramString, paramField.getName()));
        ((GenericModel)localObject1).setValueColumnName(DBUtility.convertToValidColumnName(paramField.getName()));
        ((GenericModel)localObject1).setValueColumnType(getColumnType(str));
        ((GenericModel)localObject1).setValueIdColumnName(DBUtility.getGenericValueIdColumnName(paramString));
        this.mGenericModels.add(localObject1);
      }
    }
  }
  
  private void oneToAnyConditions(String paramString, Field paramField, int paramInt)
    throws ClassNotFoundException
  {
    Class localClass1 = paramField.getType();
    if (LitePalAttr.getInstance().getClassNames().contains(localClass1.getName()))
    {
      Field[] arrayOfField = Class.forName(localClass1.getName()).getDeclaredFields();
      int m = arrayOfField.length;
      int j = 0;
      int i = 0;
      while (i < m)
      {
        Field localField = arrayOfField[i];
        int k = j;
        if (!Modifier.isStatic(localField.getModifiers()))
        {
          Class localClass2 = localField.getType();
          if (paramString.equals(localClass2.getName())) {
            if (paramInt == 1) {
              addIntoAssociationModelCollection(paramString, localClass1.getName(), localClass1.getName(), 1);
            } else if (paramInt == 2) {
              addIntoAssociationInfoCollection(paramString, localClass1.getName(), localClass1.getName(), paramField, localField, 1);
            }
          }
          for (;;)
          {
            k = 1;
            break;
            k = j;
            if (!isCollection(localClass2)) {
              break;
            }
            k = j;
            if (!paramString.equals(getGenericTypeName(localField))) {
              break;
            }
            if (paramInt == 1) {
              addIntoAssociationModelCollection(paramString, localClass1.getName(), paramString, 2);
            } else if (paramInt == 2) {
              addIntoAssociationInfoCollection(paramString, localClass1.getName(), paramString, paramField, localField, 2);
            }
          }
        }
        i += 1;
        j = k;
      }
      if (j == 0)
      {
        if (paramInt == 1)
        {
          addIntoAssociationModelCollection(paramString, localClass1.getName(), localClass1.getName(), 1);
          return;
        }
        if (paramInt == 2) {
          addIntoAssociationInfoCollection(paramString, localClass1.getName(), localClass1.getName(), paramField, null, 1);
        }
      }
    }
  }
  
  private void recursiveSupportedFields(Class<?> paramClass, List<Field> paramList)
  {
    if (paramClass != LitePalSupport.class)
    {
      if (paramClass == Object.class) {
        return;
      }
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if ((arrayOfField != null) && (arrayOfField.length > 0))
      {
        int j = arrayOfField.length;
        int i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          Column localColumn = (Column)localField.getAnnotation(Column.class);
          if (((localColumn == null) || (!localColumn.ignore())) && (!Modifier.isStatic(localField.getModifiers())) && (BaseUtility.isFieldTypeSupported(localField.getType().getName()))) {
            paramList.add(localField);
          }
          i += 1;
        }
      }
      recursiveSupportedFields(paramClass.getSuperclass(), paramList);
      return;
    }
  }
  
  private void recursiveSupportedGenericFields(Class<?> paramClass, List<Field> paramList)
  {
    if (paramClass != LitePalSupport.class)
    {
      if (paramClass == Object.class) {
        return;
      }
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if ((arrayOfField != null) && (arrayOfField.length > 0))
      {
        int j = arrayOfField.length;
        int i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          Object localObject = (Column)localField.getAnnotation(Column.class);
          if (((localObject == null) || (!((Column)localObject).ignore())) && (!Modifier.isStatic(localField.getModifiers())) && (isCollection(localField.getType())))
          {
            localObject = getGenericTypeName(localField);
            if ((BaseUtility.isGenericTypeSupported((String)localObject)) || (paramClass.getName().equalsIgnoreCase((String)localObject))) {
              paramList.add(localField);
            }
          }
          i += 1;
        }
      }
      recursiveSupportedGenericFields(paramClass.getSuperclass(), paramList);
      return;
    }
  }
  
  protected Collection<AssociationsInfo> getAssociationInfo(String paramString)
  {
    if (this.mAssociationInfos == null) {
      this.mAssociationInfos = new HashSet();
    }
    this.mAssociationInfos.clear();
    analyzeClassFields(paramString, 2);
    return this.mAssociationInfos;
  }
  
  protected Collection<AssociationsModel> getAssociations(List<String> paramList)
  {
    if (this.mAssociationModels == null) {
      this.mAssociationModels = new HashSet();
    }
    if (this.mGenericModels == null) {
      this.mGenericModels = new HashSet();
    }
    this.mAssociationModels.clear();
    this.mGenericModels.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      analyzeClassFields((String)paramList.next(), 1);
    }
    return this.mAssociationModels;
  }
  
  protected String getColumnType(String paramString)
  {
    OrmChange[] arrayOfOrmChange = this.typeChangeRules;
    int j = arrayOfOrmChange.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfOrmChange[i].object2Relation(paramString);
      if (str != null) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  protected String getForeignKeyColumnName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_id");
    return BaseUtility.changeCase(localStringBuilder.toString());
  }
  
  protected Collection<GenericModel> getGenericModels()
  {
    return this.mGenericModels;
  }
  
  protected Class<?> getGenericTypeClass(Field paramField)
  {
    paramField = paramField.getGenericType();
    if ((paramField != null) && ((paramField instanceof ParameterizedType))) {
      return (Class)((ParameterizedType)paramField).getActualTypeArguments()[0];
    }
    return null;
  }
  
  protected String getGenericTypeName(Field paramField)
  {
    paramField = getGenericTypeClass(paramField);
    if (paramField != null) {
      return paramField.getName();
    }
    return null;
  }
  
  protected List<Field> getSupportedFields(String paramString)
  {
    Object localObject = (List)this.classFieldsMap.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    try
    {
      Class localClass = Class.forName(paramString);
      recursiveSupportedFields(localClass, (List)localObject);
      this.classFieldsMap.put(paramString, localObject);
      return (List<Field>)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not find a class named ");
    ((StringBuilder)localObject).append(paramString);
    throw new DatabaseGenerateException(((StringBuilder)localObject).toString());
    return (List<Field>)localObject;
  }
  
  protected List<Field> getSupportedGenericFields(String paramString)
  {
    Object localObject = (List)this.classGenericFieldsMap.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    try
    {
      Class localClass = Class.forName(paramString);
      recursiveSupportedGenericFields(localClass, (List)localObject);
      this.classGenericFieldsMap.put(paramString, localObject);
      return (List<Field>)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not find a class named ");
    ((StringBuilder)localObject).append(paramString);
    throw new DatabaseGenerateException(((StringBuilder)localObject).toString());
    return (List<Field>)localObject;
  }
  
  protected TableModel getTableModel(String paramString)
  {
    String str = DBUtility.getTableNameByClassName(paramString);
    TableModel localTableModel = new TableModel();
    localTableModel.setTableName(str);
    localTableModel.setClassName(paramString);
    paramString = getSupportedFields(paramString).iterator();
    while (paramString.hasNext()) {
      localTableModel.addColumnModel(convertFieldToColumnModel((Field)paramString.next()));
    }
    return localTableModel;
  }
  
  protected boolean isCollection(Class<?> paramClass)
  {
    return (isList(paramClass)) || (isSet(paramClass));
  }
  
  protected boolean isIdColumn(String paramString)
  {
    return ("_id".equalsIgnoreCase(paramString)) || ("id".equalsIgnoreCase(paramString));
  }
  
  protected boolean isList(Class<?> paramClass)
  {
    return List.class.isAssignableFrom(paramClass);
  }
  
  protected boolean isSet(Class<?> paramClass)
  {
    return Set.class.isAssignableFrom(paramClass);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\LitePalBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */