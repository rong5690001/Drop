package com.rong.drop.database;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * 类别表
 */

//@DatabaseTable(tableName = "account_type")
public class AccountTypeNode extends RealmObject {
    /**
     * 使用联合约束时 一定要命名uniqueIndexName 约束名称一致 否则为唯一约束
     */
//    @DatabaseField(columnName = "typeName")
    public String typeName = "";//类别名称

    @Ignore
    public static String TYPENAME = "typeName";
    //    @Deprecated
//    @DatabaseField(columnName = "i" +"dentifier")
    private String identifier = "";//UUID

    @Ignore
    public static String IDENTIFIER = "identifier";

    //    @DatabaseField(columnName = "moneyType")
    public int moneyType;//支出0 收入1
    @Ignore
    public static String MONEYTYPE = "moneyType";

    //    @DatabaseField(columnName = "typeIcon")
    public int typeIcon;//对应icon下标
    @Ignore
    public static String TYPEICON = "typeIcon";

    //    @DatabaseField(columnName = "hide")
    public int hide = 0;//没有删除0  删除1
    @Ignore
    public static String HIDE = "hide";

    //    @DatabaseField(columnName = "sort")
    public int sort;
    //
//    //db.version = 2
//    @DatabaseField(columnName = "systemId")
    public String systemId;
    @Ignore
    public static String SYSTEMID = "systemId";

    @Ignore
    public boolean isSelected = false;

    @Override
    public String toString() {
        return "AccountTypeNode{" +
                "typeName='" + typeName + '\'' +
                ", identifier='" + identifier + '\'' +
                ", moneyType=" + moneyType +
                ", typeIcon=" + typeIcon +
                ", hide=" + hide +
                ", sort=" + sort +
                ", systemId='" + systemId + '\'' +
                '}';
    }
}
