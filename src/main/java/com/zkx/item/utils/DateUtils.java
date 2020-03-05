package com.zkx.item.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xuhu
 * @Date 2019/4/28
 */
@Slf4j
public class DateUtils {

    /**
     * 获取昨天日期
     */
    public static String getYesTerday(String... pattern){
        return getLastDay(1,pattern);
    }

    /**
     * 获取N天前时间
     */
    public static String getLastDay(int n,String... pattern){
        String str = StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyyMMdd" : pattern[0];
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY,-24*n);
        Date time=cal.getTime();
        return new SimpleDateFormat(str).format(time);
    }

    /**
     * 获取N月前时间
     */
    public static String getLastMonthStr(int n,String... pattern){
        String str = StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyyMMdd" : pattern[0];
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH,-n);
        Date time=cal.getTime();
        return new SimpleDateFormat(str).format(time);
    }

    /**
     * 获取N月前时间
     */
    public static Date getLastMonth(Date time){
        Calendar cal=Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.MONTH,-1);
        return cal.getTime();
    }

    /**
     * 获取指定时间的N天前时间
     */
    public static String getLastDay(int n,Date date,String... pattern){
        String str = StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyyMMdd" : pattern[0];
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY,-24*n);
        Date time=cal.getTime();
        return new SimpleDateFormat(str).format(time);
    }

    /**
     * 获取指定时间的N分钟前时间
     */
    public static String getLastMinutes(int n,Date date,String... pattern){
        String str = StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyyMMdd" : pattern[0];
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE,-n);
        Date time=cal.getTime();
        return new SimpleDateFormat(str).format(time);
    }


    /**
     * 比较两个日期是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean sameDate(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(d1).equals(fmt.format(d2));
    }




    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<Date> getBetweenDates(Date beginDate, Date endDate) {
        List<Date> dates = new ArrayList<>();
        // 把开始时间加入集合
        dates.add(beginDate);
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                dates.add(cal.getTime());
            } else {
                break;
            }
        }
        // 把结束时间加入集合
        dates.add(endDate);
        return dates;
    }

    public static String getDateStr(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 字符串转换为对应日期
     *
     * @param source
     * @param pattern
     * @return
     */
    public static Date stringToDate(String source, String... pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyy/MM/dd HH:mm:ss" : pattern[0]);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * Date类型转为指定格式的String类型
     *
     * @param source
     * @param pattern
     * @return
     */
    public static String dateToString(Date source, String... pattern) {
        if(source == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyy/MM/dd HH:mm:ss" : pattern[0]);
        return simpleDateFormat.format(source);
    }

    /**
     * Unix时间戳（Unix timestamp）转换Date
     *
     * @param timestamp
     * @param type 1：毫秒  1000：秒
     * @param pattern   格式化
     */
    public static String LongToString(long timestamp,int type,String... pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyy/MM/dd HH:mm:ss" : pattern[0]);
        Date date = new Date(timestamp * type);
        return simpleDateFormat.format(date);
    }

    /**
     * 通过毫秒值，手动计算日期间的相关的值
     * <p>
     * 跨年不会出现问题
     * 使用此种方法的话需要注意
     * 如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
     *
     * @throws ParseException
     */
    public static int getBetweenDays(Date oDate, Date fDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fDate = sdf.parse(sdf.format(fDate));
            oDate = sdf.parse(sdf.format(oDate));
            long days = (oDate.getTime() - fDate.getTime()) / (1000 * 3600 * 24);
            return (int) days;
        } catch (ParseException e) {
            log.info("计算两时间相差天数时异常,{}",e.getMessage());
            return 0;
        }

    }

    /**
     * 比较两个时间大小
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * 美东时间转中国时间
     * @param dateTime
     */
    public static String longUsEastToChina(String dateTime,String... pattern){
        if(StringUtils.isEmpty(dateTime)){
            return null;
        }
        Date date = new Date(Long.parseLong(dateTime) * 1000);
        String formatStr = StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyy/MM/dd HH:mm:ss" : pattern[0];
        DateFormat ymd = new SimpleDateFormat(formatStr);
        return timeZoneTransfer(ymd.format(date), formatStr,"America/New_York","Asia/Shanghai" );
    }

    /**
     * 获取当前美东时间
     * @param pattern
     * @return
     */
    public static String getUsEastDate(String... pattern) {
        //转换为当时的美国时值
        TimeZone tz = TimeZone.getTimeZone("America/New_York");
        Calendar cl = Calendar.getInstance(tz, Locale.US);
        DateFormat df = new SimpleDateFormat(StringUtils.isEmpty(pattern) || pattern.length == 0 ? "yyyy/MM/dd HH:mm:ss" : pattern[0]);
        df.setTimeZone(tz);
        return df.format(cl.getTime());
    }

    /**
     * 时区转换
     * @param time 时间字符串
     * @param pattern 格式 "yyyy-MM-dd HH:mm"
     * @param nowTimeZone eg:+8，0，+9，-1 等等
     * @param targetTimeZone 同nowTimeZone
     * @return
     */
    public static String timeZoneTransfer(String time, String pattern, String nowTimeZone, String targetTimeZone) {
        if(StringUtils.isEmpty(time)){
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(nowTimeZone));
        Date date;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            log.error("时间转换出错。", e);
            return "";
        }
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(targetTimeZone));
        return simpleDateFormat.format(date);
    }

    /**
     * 比较两时间相差毫秒数
     * @param date1
     * @param date2
     * @return
     */
    public static long calLastedTime(Date date1,Date date2){
        long interval = Math.abs(date2.getTime() - date1.getTime());
        return interval;
    }

    /**
     * 获取指定某一天的开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getDailyStartTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定某一天的结束时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getDailyEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当月开始时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getMonthStartTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当月的结束时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Long getMonthEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取当前月最后一天
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    public static void main(String[] args){
        System.out.println(longUsEastToChina("1567545110"));
        System.out.println(getUsEastDate());
        System.out.println(timeZoneTransfer("2019-09-04 05:11:50","yyyy-MM-dd HH:mm:ss","America/New_York","Asia/Shanghai"));
    }
}
