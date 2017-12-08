package com.rong.drop.database;


import android.content.Context;

//import net.ffrj.dolphinwallet.common.FApplication;
//import net.ffrj.dolphinwallet.constant.Constant;
//import net.ffrj.dolphinwallet.db.storage.AccountStorage;
//import net.ffrj.dolphinwallet.node.common.PieNode;
//import net.ffrj.dolphinwallet.node.dbmodel.AccountBookNode;
//import net.ffrj.dolphinwallet.node.dbmodel.AccountNode;
//import net.ffrj.dolphinwallet.node.dbmodel.AccountTypeNode;
//import net.ffrj.dolphinwallet.node.dbmodel.BaseNode;
//import net.ffrj.dolphinwallet.ui.main.adapter.ShowAllAccountAdapter;
//import net.ffrj.dolphinwallet.ui.main.adapter.ShowAllAccountAdapter;
//import net.ffrj.dolphinwallet.util.ArithUtil;
//import net.ffrj.dolphinwallet.util.CalendarUtil;
//import net.ffrj.dolphinwallet.util.LogUtil;
//import net.ffrj.dolphinwallet.util.rxbus.RxBus;
//import net.ffrj.dolphinwallet.util.rxbus.RxBusEvent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * accountNode数据转换
 * Created by Administrator on 2017/7/5.
 */
public class AccountNodeTool {

    private Context mContext = null;

    public static int MONEY_ALL = 0;
    public static int MONEY_IN = MONEY_ALL + 1;
    public static int MONEY_SPEND = MONEY_IN + 1;

    public AccountNodeTool(Context mContext) {
        this.mContext = mContext;
    }

    public int getCountByAccountBookId(int id) {
//        AccountStorage accountStorage = new AccountStorage(mContext);
//
//        return accountStorage.queryByBookId(id);
        return 0;
    }

    /**
     * 获取输入数据的 收入/支出
     *
     * @param accountNodes 待计算的数据 postition : 0 支出 1 收入
     * @return
     */
    public String[] getPayAndIn(List<AccountNode> accountNodes) {
        String[] temp = new String[2];
        String pay = "0";
        String in = "0";
        for (AccountNode accountNode : accountNodes) {
//            if (accountNode.getMoney_type() == AccountNode.MONEY_TYPE_IN) {
////                in = ArithUtil.add(in, accountNode.getMoney());
//            } else if (accountNode.getMoney_type() == AccountNode.MONEY_TYPE_PAY) {
////                pay = ArithUtil.add(pay, accountNode.getMoney());
//            }
        }
        temp[0] = pay;
        temp[1] = in;
        return temp;
    }


    /**
     * 可用金额= 每月预算*(x-y)+所有收入-所有支出
     * x-y: 当前所处的月份x- 上一次打开滚存所处的月份y
     *
     * @param accountBookNode
     * @return
     */
    public String getCurrentMonthBalance(AccountBookNode accountBookNode) {

        // 查看滚存是否打开
        String currentMonthBalance = "";

//        // 滚存为关，直接使用当前的余额
//        if (accountBookNode.getBalance_rolling() == AccountBookNode.BALANCE_ROLLING_CLOSE
//                || accountBookNode.getRb_update_time() == 0) {
//            return accountBookNode.getAccount_budget() + "";
//        }
//        long cycleTime = getLastCycleTime(accountBookNode);
//        //-----------------最后一个预算结算日距离当前时间点相距多少月----------------------
//        int monthDistance = CalendarUtil.getDistanceMonth(cycleTime, CalendarUtil.getNowTimeMillis());
//        // ---------------最后一个结算日距离当天时间段内查所有的记录------------------
//        List<AccountNode> accountNodes = getDistanceDayAccounts(accountBookNode.get_id(), cycleTime, CalendarUtil.getNowTimeMillis());
//        String[] temp = getPayAndIn(accountNodes);
//        String pay = temp[0];
//        String in = temp[1];
//        String allBudget = "";
//        // 所有月*每月的balance
//        if (monthDistance > 0) {
//            allBudget = ArithUtil.mul(monthDistance, Double.valueOf(accountBookNode.getAccount_budget()));
//        } else {
//            allBudget = String.valueOf(accountBookNode.getAccount_budget());
//        }
//        // 加上所有的收入
//        currentMonthBalance = ArithUtil.add(allBudget, in);
//        // 减去所有的指支出
//        currentMonthBalance = ArithUtil.sub(currentMonthBalance, pay, 2);
//        LogUtil.d("tempBalance->=" + currentMonthBalance);
        return currentMonthBalance;
    }

    /**
     * 根据账本ID查询一段时间内的所有数据
     *
     * @param accountId
     * @param startDate
     * @param endDate
     * @return
     */
    public List<AccountNode> getDistanceDayAccounts(int accountId, long startDate, long endDate) {
//        AccountStorage accountStorage = new AccountStorage(mContext);
//        LogUtil.d("AccountNodeTool", "getDistanceDayAccounts");
//        return accountStorage.queryDistanceDatas(accountId, startDate, endDate);
        return null;
    }

    /**
     * 获取最后一个结算日的时间点
     *
     * @param accountBookNode
     * @return
     */
    public long getLastCycleTime(AccountBookNode accountBookNode) {
        // 一天秒数
        int ONE_DAY_MINLLINS = 86400;
        long lastRollingDate = accountBookNode.rb_update_time;
        int distanceDay = 0;
        long cycleTime = 0l;
        //-----------------最后一个预算结算日所处的时间点-----------------------------
        // 根绝cycle与滚存更新的时间算出时间点，
        // 特殊处理，如果预算结算日选择是最后一天
//        if (accountBookNode.getAccount_cycle() == AccountBookNode.LAST_DAY_OF_MONTH) {
//            if (CalendarUtil.getDay(lastRollingDate)
//                    == CalendarUtil.getLastDayOfMonth(lastRollingDate)) {
//                // 如果滚存更新的时间与结算日在一天，
//                cycleTime = lastRollingDate + ONE_DAY_MINLLINS;
//            } else if (CalendarUtil.getDay(lastRollingDate)
//                    < CalendarUtil.getLastDayOfMonth(lastRollingDate)) {
//                // 如果小于预算结算日，直接获取当前月的第一天
//                cycleTime = CalendarUtil.getFirstDayOfMonth(lastRollingDate);
//            }
//        } else {
//            // 如果更新滚存开关的时间day小于预算结算日，则月份要减1
//            if (accountBookNode.getAccount_cycle() >= CalendarUtil.getDay(lastRollingDate)) {
//                // 滚存更新的时间小于下一次的结算日，
//                // 更新的时间距离下一次结算日的distance，得到下一次结算日的时间戳
//                // getDistanceMonth获取上一个月的时间戳
//                distanceDay = accountBookNode.getAccount_cycle() - CalendarUtil.getDay(lastRollingDate);
//                cycleTime = CalendarUtil.getDistanceMonth(
//                        CalendarUtil.getDayBeginTime((distanceDay + 1) * ONE_DAY_MINLLINS + lastRollingDate), -1);
//            } else if (accountBookNode.getAccount_cycle() < CalendarUtil.getDay(lastRollingDate)) {
//                // 如果时间大于结算日时间，则滚存更新的时间减去结算日
//                distanceDay = CalendarUtil.getDay(lastRollingDate) - accountBookNode.getAccount_cycle();
//                cycleTime = lastRollingDate - (distanceDay + 1) * ONE_DAY_MINLLINS;
//            } else {
//                // 如果滚存更新的时间与结算日在一天，
//                cycleTime = lastRollingDate + ONE_DAY_MINLLINS;
//            }
//        }
        return cycleTime;
    }


    /**
     * 根据首页的显示规则,按照月份将数据分割
     *
     * @param datas
     * @return
     */
    public List<AccountNode> splitDataByMonth(List<AccountNode> datas) {
        List<AccountNode> tempNodes = new ArrayList<>();
//        if (null == datas || datas.size() == 0) {
//            AccountNode baseNode1 = new AccountNode();
//            baseNode1.setType(ShowAllAccountAdapter.TYPE_MONTH_EMPTY);
//            tempNodes.add(0, baseNode1);
//            AccountNode baseNode2 = new AccountNode();
//            baseNode2.setType(ShowAllAccountAdapter.TYPE_DATE);
//            baseNode2.setYmd_hms(CalendarUtil.getNowTimeMillis());
//            tempNodes.add(0, baseNode2);
//        } else {
//            int size = datas.size();
//            tempNodes.addAll(datas);
//            // 对temoNodes进行添加的时候，要注意tempNodes.datas.size 不一样,注意偏移
//            int offsetPosition = 0;
//            //
//            for (int i = 0; i < size && size > 0; i++) {
//                AccountNode mainNode = new AccountNode();
//                if (i == 0) {
//                    mainNode.setYmd_hms(datas.get(0).getYmd_hms());
//                    mainNode.setType(ShowAllAccountAdapter.TYPE_DATE);
//                    tempNodes.add(0, mainNode);
//                    offsetPosition++; // 偏移量
//                }
//                if (i >= 1 && tempNodes.get(i - 1).getType() == ShowAllAccountAdapter.TYPE_DATE) {
//                    tempNodes.get(i).setLineStatus(AccountNode.LINE_STATUS_BOTTOM);
//                }
//                if (i + 1 < size) {
//                    if (CalendarUtil.timeMilis2Month(datas.get(i).getYmd_hms())
//                            > CalendarUtil.timeMilis2Month(datas.get(i + 1).getYmd_hms())) {
//                        mainNode.setYmd_hms(datas.get(i + 1).getYmd_hms());
//                        mainNode.setType(ShowAllAccountAdapter.TYPE_DATE);
//                        tempNodes.get(i + offsetPosition).setLineStatus(AccountNode.LINE_STATUS_UP);
//                        tempNodes.add(i + 1 + offsetPosition, mainNode);
//                        offsetPosition++;  // 偏移量
//                    }
//                }
//                //最后一个位置上，只显示上边的线
//                if (i == size - 1) {
//                    tempNodes.get(i + offsetPosition).setLineStatus(AccountNode.LINE_STATUS_UP);
//                }
//            }
//
//            // 判断第一条数据的时间是不是当月的数据，不是则构造提示模块数据对象
//            BaseNode baseNode = tempNodes.get(0);
//            if (CalendarUtil.timeMilis2Month(CalendarUtil.getNowTimeMillis())
//                    > CalendarUtil.timeMilis2Month(baseNode.getYmd_hms())) {
//                AccountNode baseNode1 = new AccountNode();
//                baseNode1.setType(ShowAllAccountAdapter.TYPE_MONTH_EMPTY);
//                tempNodes.add(0, baseNode1);
//                AccountNode baseNode2 = new AccountNode();
//                baseNode2.setType(ShowAllAccountAdapter.TYPE_DATE);
//                baseNode2.setYmd_hms(CalendarUtil.getNowTimeMillis());
//                tempNodes.add(0, baseNode2);
//            }
//        }

        datas = new ArrayList<>();
        datas.addAll(tempNodes);
        return datas;
    }


    /**
     * 获取一段时间的所有的数据，按照类别进行获取
     *
     * @param moneyType 收入/支出
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
//    public List<AccountNode> getAccountNodes(int moneyType, long startTime, long endTime) {
//        AccountStorage accountStorage = new AccountStorage(mContext);
//        return accountStorage.getDistanceByTypeDatas(FApplication.accountId, moneyType, startTime, endTime);
//    }

    /**
     * 根据typeIcon 和 typeName 区分
     *
     * @param accountNodes
     * @return
     */
//    public List<PieNode> getPieNodes(List<AccountNode> accountNodes) {
//        if (accountNodes == null) {
//            return null;
//        }
//        HashMap<String, PieNode> pieNodeHashMap = new HashMap<>();
//        for (AccountNode bookNode : accountNodes) {
//            AccountTypeNode typeNode = bookNode.getAccount_type_id();
//            if (typeNode == null) {
//                continue;
//            }
//            String key = typeNode.getTypeIcon() + "," + typeNode.getTypeName();
//            PieNode pieNode = null;
//            if (pieNodeHashMap.size() != 0) {
//                pieNode = pieNodeHashMap.get(key);
//            }
//            if (pieNode == null) {
//                pieNode = new PieNode();
//                pieNode.moneyType = typeNode.getMoneyType();
//                pieNode.typeIcon = typeNode.getTypeIcon();
//                pieNode.typeName = typeNode.getTypeName();
//                pieNode.number = 1;
//                pieNode.total = bookNode.getMoney();
//                pieNodeHashMap.put(key, pieNode);
//            } else {
//                pieNode.number += 1;
//                pieNode.total = ArithUtil.add(pieNode.total, bookNode.getMoney(), 2) + "";
//            }
//        }
//        List<PieNode> pieNodes = new ArrayList<>();
//        Iterator iterator = pieNodeHashMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            pieNodes.add((PieNode) entry.getValue());
//        }
//        //按照金额排序 冒泡
//        if (pieNodes.size() > 1) {
//            for (int i = 0; i < pieNodes.size() - 1; i++) {
//                for (int j = 0; j < pieNodes.size() - i - 1; j++) {
//                    BigDecimal b1 = new BigDecimal(pieNodes.get(j).total);
//                    BigDecimal b2 = new BigDecimal(pieNodes.get(j + 1).total);
//                    if (b1.compareTo(b2) == -1) {
//                        PieNode node = pieNodes.get(j);
//                        pieNodes.set(j, pieNodes.get(j + 1));
//                        pieNodes.set(j + 1, node);
//                    }
//                }
//            }
//        }
//        return pieNodes;
//    }

    /**
     * 删除一条数据
     *
     * @param accountNode
     * @return
     */
//    public boolean deleteAccountNode(AccountNode accountNode) {
//        if (null == accountNode) {
//            return false;
//        }
//        AccountStorage accountStorage = new AccountStorage(mContext);
//        if (accountStorage.delete(accountNode)) {
//            RxBus.getDefault().send(new RxBusEvent(Constant.REFRESH.HOME_LIST));
//            return true;
//        } else {
//            return false;
//        }
//    }
}
