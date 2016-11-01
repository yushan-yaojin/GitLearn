package base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private final static SimpleDateFormat sdfTime0 = new SimpleDateFormat("HH:mm");
	
	private final static SimpleDateFormat sdfTime1 = new SimpleDateFormat("yyyy-MM-dd HH");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD hh:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	 * @Title: compareDate
	 * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws @author
	 *             luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() >= fomatDate(e).getTime();
	}

	/**
	 * 格式化日期---yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 格式化日期---yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Date fomatDate2(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 将Date类型时间转换为任意格式的String类型字符串
	* @Title: fomateDate2StrByType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param str
	* @param @param fomattype
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String fomateDate2StrByType(Date str,String fomattype){
		try{
			if(str==null){
				return "";
			}
			SimpleDateFormat sdf=new SimpleDateFormat(fomattype);
			return sdf.format(str);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}

	
	/**
	 * @Title: fomatDateToStr
	 * @Description: 日期格式化   "yyyy-MM-dd HH:mm:ss"
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String fomatDateToStr(Date str){
		try {
			return sdfTime.format(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Title: fomatDateToStr
	 * @Description: 日期格式化   yyyy-MM-dd  
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String fomatDateToStr2(Date str){
		try {
			return sdfDay.format(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String fomatDateToStr3(Date str){
		try {
			return sdfTime1.format(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param formatter
	 *            目标格式 xxxx-xx-xx xx:xx:xx:xxxx 或xxxx-xx-xx
	 * @return
	 */
	public static Date fomatDate1(String date, String formatter) {
		DateFormat fmt = new SimpleDateFormat(formatter);
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String fomatDate2(String date, String formatter) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatter);
			Date dat = sdf.parse(date);
			return sdf.format(dat);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa = 0;
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
					/ 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}
	
	/**
	 * <li>功能描述：模仿微信的消息列表中的日期格式
	 * @param date 
	 * @return
	 */
	public static String formatChatDateAsWeiXin(Date date){
		//格式化当前日期  年 -月 -日 ：小时
		String cur_time = getTime("yyyy-MM-dd HH");
		//将参数日期 转换成字符串
		String for_time = fomatDateToStr3(date);
		//得到两个时间差的小时数
		long  hours = getHourSub(for_time, cur_time);
		if(hours >= 0 && hours <= 24){
			//比较是否在同一天
			SimpleDateFormat sdf0 =new SimpleDateFormat("HH:mm");
			String str = sdf0.format(date);
			
			if(isSameDate(date, new Date())){
				return str;
			}else{
				return "昨天" + str;
			}
			
		}
		if(hours > 24 && hours <= 48){
			//两天之内		
			return getWeekOfDate(date);		
		}
		if(hours > 48){
		   //超过两天
		   SimpleDateFormat sdf0 =new SimpleDateFormat("HH:dd");
		   Calendar cal = Calendar.getInstance();
		   cal.setTime(date);
		   //得到月份
		   int Month = cal.get(Calendar.MONTH) + 1 ;
		   //得到具体的那一天
		   int Day = cal.get(Calendar.DAY_OF_MONTH);
		   
		   return  Month +"月"+ Day +"日";
		  
		}
		return null;
		
	}
	
	
	public static String formatChatDateAsWeiXin_FriendCircle(Date date){
		//格式化当前日期  年 -月 -日 ：小时
		String cur_time = getTime("yyyy-MM-dd HH");
		//将参数日期 转换成字符串
		String for_time = fomatDateToStr3(date);
		//得到两个时间差的小时数
		long  hours = getHourSub(for_time, cur_time);
		if(hours >= 0 && hours <= 24){
			//比较是否在同一天
			SimpleDateFormat sdf0 =new SimpleDateFormat("HH:mm");
			String str = sdf0.format(date);
			
			if(isSameDate(date, new Date())){
				long s = getMinuteSub(fomatDateToStr(date),getTime("yyyy-MM-dd HH:mm:ss"));
				if(s>60){
					return hours+"小时前";
				}else{
					if(s==0){
						s=1;
					}
					return s+"分钟前";
				}
				//一天之内
				//return str;
			}else{
				return "昨天";
			}
			
		}
		if(hours > 24 && hours <= 48){
			//两天之内		
			return "两天前";		
		}
		if(hours > 48){
		   //超过两天
		   SimpleDateFormat sdf0 =new SimpleDateFormat("HH:dd");
		   Calendar cal = Calendar.getInstance();
		   cal.setTime(date);
		   //得到月份
		   int Month = cal.get(Calendar.MONTH) + 1 ;
		   //得到具体的那一天
		   int Day = cal.get(Calendar.DAY_OF_MONTH);
		   
		   return  Month +"月"+ Day +"日";
		  
		}
		return null;
		
	}
	
	/**
	 * 比较两个日期是否在同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                        .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }
	/**
	 * 得到当前日期是星期几
	 * @param dt
	 * @return
	 */
	public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

	/**
	 * 得到两个时间差的小时数
	 * 
	 * @param beginDateStr--被减数
	 * @param endDateStr--减数
	 * @return
	 */
	public static long getHourSub(String beginDateStr, String endDateStr) {
		long hour = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		hour = (endDate.getTime() - beginDate.getTime()) / (60 * 60 * 1000);
		return hour;
	}

	/**
	 * 得到两个时间差的分钟数
	 * 
	 * @param beginDateStr--被减数
	 * @param endDateStr--减数
	 * @return
	 */
	public static long getMinuteSub(String beginDateStr, String endDateStr) {
		long minute = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		minute = (endDate.getTime() - beginDate.getTime()) / (60 * 1000);
		return minute;
	}
	
	/**
     * 得到两个时间差的秒数
     * @param beginDateStr--被减数
     * @param endDateStr--减数
     * @return
     */
    public static long getSecondeSub(String beginDateStr,String endDateStr){
        long second=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        try {
			beginDate = format.parse(beginDateStr);
			endDate= format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        second=(endDate.getTime()-beginDate.getTime())/(1000);      
        return second;
    }
    

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}
	
	/**
	 * 得到n年之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterYearDate(String time,int years){
		Calendar canlendar = Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		canlendar.setTime(date);
		canlendar.add(Calendar.YEAR, years);
		date=canlendar.getTime();
		return sdf.format(date);
	}

	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 根据指定的时间字符串计算前半小时的时间点
	 * 
	 * @param end_time
	 * @return
	 * @throws Exception
	 */
	public static String getBeforeTime(String end_time) throws Exception {

		long Time = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endDate = format.parse(end_time);
		Time = (endDate.getTime() - 10 * 60 * 1000);

		Date date = new Date(Time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.format(date);

	}

	/**
	 * 通过生日达到年龄
	 * 
	 * @param birth_date
	 * @return
	 */
	public static int getAge(Date birth_date) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birth_date)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);

		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birth_date);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				monthNow = monthBirth;
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}

	/**
	 * 获取当前时间
	 * 
	 * @param formatter
	 * @return
	 */
	public static String getTime(String formatter) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(date);
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
    /**
     * 获得指定日期的后一天 
     * @param start_time
     * @param days
     * @return
     */
	public static String getSpecifiedDayAfter(String start_time,int days){ 
		Calendar c = Calendar.getInstance(); 
		Date date=null;
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try { 
		
		date = format.parse(start_time); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+days); 

		String dayAfter=format.format(c.getTime()); 
		return dayAfter; 
	} 
	
	/**
     * 获得指定日期的前一天 
     * @param start_time
     * @param days
     * @return
     */
	public static String getSpecifiedDayBefore(String start_time,int days){ 
		Calendar c = Calendar.getInstance(); 
		Date date=null;
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try { 
		
		date = format.parse(start_time); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day-days); 

		String dayAfter=format.format(c.getTime()); 
		return dayAfter; 
	} 
	
	/**
	 * 获取时间差
	* @Title: getDiffDate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param formate--求和、差的条件（按分钟、小时或其他）
	* @param dateFormateStr--"yyyy-MM-dd HH:mm:ss"
	* @param diff--差值
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getDiffDate(String formate,String dateFormateStr,int diff){
		SimpleDateFormat df=new SimpleDateFormat(dateFormateStr);
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		if(formate.equals("dd")){
			cal.add(Calendar.DAY_OF_YEAR, diff);
		}else if(formate.equals("hh")){
			cal.add(Calendar.HOUR_OF_DAY, diff);
		}else if(formate.equals("mm")){
			cal.add(Calendar.MINUTE, diff);
		}else if(formate.equals("ss")){
			cal.add(Calendar.MILLISECOND, diff);
		}else if(formate.equals("yyyy")){
			cal.add(Calendar.YEAR, diff);
		}else if(formate.equals("MM")){
			cal.add(Calendar.MONTH, diff);
		}
		date=cal.getTime();
		return df.format(date);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getSpecifiedDayBefore("2016-08-01 20:12:42", 3));
	}
}
