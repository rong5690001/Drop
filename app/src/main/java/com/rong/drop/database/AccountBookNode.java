package com.rong.drop.database;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * 账本
 * Created by Administrator on 2017/7/3.
 */

//@DatabaseTable(tableName = "account_book")
//@Parcel(implementations = {AccountBookNodeRealmProxy.class},
//        value = Parcel.Serialization.BEAN,
//        analyze = {AccountBookNode.class})
public class AccountBookNode extends RealmObject {

    @PrimaryKey
    public int bookId;
    /**
     * 账本名称
     */
//    @DatabaseField(columnName = "book_name")
    public String book_name;
    @Ignore
    public static String BOOK_NAME = "book_name";

    /**
     * 该账本的预算
     */
//    @DatabaseField(columnName = "account_budget")
    public String account_budget;
    @Ignore
    public static String ACCOUNT_BUDGET = "account_budget";
    /**
     * 账单结算日,每月的第几天开始结算
     */
//    @DatabaseField(columnName = "account_cycle")
    public int account_cycle;
    @Ignore
    public static String ACCOUNT_CYCLE = "account_cycle";
    /**
     * 每月最后一天
     */
    @Ignore
    public static int LAST_DAY_OF_MONTH = 35;
    /**
     * 是否打开滚存
     */
//    @DatabaseField(columnName = "balance_rolling")
    public int balance_rolling = 1; // "0"需要滚存 "1" 不需要滚存
    @Ignore
    public static String BALANCE_ROLLING = "balance_rolling";
    /**
     * 打开滚存
     */
    @Ignore
    public static int BALANCE_ROLLING_OPEN = 0;
    /**
     * 关闭滚存
     */
    @Ignore
    public static int BALANCE_ROLLING_CLOSE = 1;
    /**
     * 滚存修改时间
     */
//    @DatabaseField(columnName = "rb_update_time")
    public long rb_update_time = 0;
    @Ignore
    public static String RB_UPDATE_TIME = "rb_update_time";

    public AccountTypeNode mAccountTypeNode;

    /**
     * 排序 更新的时间
     */
//    @DatabaseField(columnName = "sort_time", defaultValue = "0")
    public long sort_time = 0l;
    @Ignore
    public static String SORT_TIME = "sort_time";
    @Ignore
    public String balance = "";

    /**
     * 0 当前账本不是正在使用的
     * 1 当前账本是正在使用
     */
    @Ignore
    public int currentBook = 0;

    /**
     * 当前账本
     */
    @Ignore
    public final static int CURRENT_ACCOUNT_BOOK = 0;
    /**
     * 常规账本
     */
    @Ignore
    public final static int COMMON_ACCOUNT_BOOK = 1;
    /**
     * 在账本列表界面，动画切换过程中，用来记录该账本上一次的状态
     * 例如：用户正在使用该账本（currentbook=1，lastStatus = 0），
     * 此时用户切换了账本 currentBook 与lastStatus 值改变
     * currentBook:1->0(当前账本切换到常规账本)
     * lastStatus:0->1（记录该账本上一次的状态）
     */
    @Ignore
    public int lastStatus = 0;

    @Ignore
    public int allBills = 0;


    /**
     * 获取预算金额 比较特殊。界面上的余额相关，
     * 使用工具类处理AccountNodeTool.getBudget
     *
     * @return
     */
    public String getAccount_budget() {
        return account_budget;
    }

    @Override
    public String toString() {
        return "AccountBookNode{" +
                "book_name='" + book_name + '\'' +
                ", account_budget=" + account_budget +
                ", account_cycle=" + account_cycle +
                ", balance_rolling=" + balance_rolling +
                ", rb_update_time=" + rb_update_time +
                ", sort_time=" + sort_time +
                ", bills='" + balance + '\'' +
                ", currentBook=" + currentBook +
                ", lastStatus=" + lastStatus +
                '}';
    }
}
