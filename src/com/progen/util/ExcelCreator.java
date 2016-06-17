package com.progen.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.cache.impl.PrimaryCache;

public class ExcelCreator {

	private List<UserStatusBean> statusList=null;
	private static PrimaryCache cache=null;
	private Map<Integer, UserBean> userMap=null;


	public  void setStatusList(List<UserStatusBean> statusList){
		this.statusList=statusList;
	}
	public  List<UserStatusBean>  getStatusList(){
		return statusList;
	}



	public  void cretaeExcel(){
		 cache=Singleton.getInstance();
		 userMap=cache.getUserBeanMap();
		if(statusList==null){
			statusList=cache.getUserstList();
		}

		File file = new File("/usr/local/cache/status/ProgenStatus"+ExcelCreator.getCurrentDateAndMonth()+".xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook();
	    //Create a blank sheet
		   XSSFSheet spreadsheet = workbook.createSheet("Daily Status Task List");


	    //Create row object
		 XSSFRow row;


		 row = spreadsheet.createRow(0);
	      Cell cell = row.createCell(0);
	      Cell cell1 = row.createCell(1);
	      Cell cell2 = row.createCell(2);
	      Cell cell3 = row.createCell(3);
	      Cell cell4 = row.createCell(4);
	      Cell cell5 = row.createCell(5);
//	      row=null;
	      cell.setCellValue("UserName");
	      cell1.setCellValue("TaskId");
	      cell2.setCellValue("Task Detail");
	      cell3.setCellValue("Time");
	      cell5.setCellValue("Status");

	      cell4.setCellValue("DownTime");
	      row = spreadsheet.createRow(2);

	      String uname="";
	      int count=2;
	      try{
	      for(UserStatusBean st:statusList){
				 row = spreadsheet.createRow(count++);
				 Cell  cell0 = row.createCell(0);
				 Cell  cell11 = row.createCell(1);
				 Cell  cell22 = row.createCell(2);
				 Cell cell33 = row.createCell(3);
				 Cell  cell44 = row.createCell(4);
				 Cell cell55 = row.createCell(5);

			      if(uname.equalsIgnoreCase(userMap.get(st.getUserid()).getFirstname())){
			    	  cell0.setCellValue("");
			      }else{
			    	  uname=userMap.get(st.getUserid()).getFirstname();
			    	  cell0.setCellValue(userMap.get(st.getUserid()).getFirstname());
			      }
			      cell11.setCellValue(st.getDailyTaskId());
			      cell22.setCellValue(st.getTaskDetail());
			      cell33.setCellValue(st.getTotalTime());
			      cell44.setCellValue(st.getStatus());
			      cell55.setCellValue(st.getDownTime());
			      System.out.println("@@@@@"+st.getTaskDetail());
			}
		}catch(Exception e){

		}
	      //Write the workbook in file system
	      FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      System.out.println("Writesheet.xlsx written successfully" );
	      EmailSender.setAddress() ;

//
	      if (file.exists()) {
		    	System.out.println("file deleted");
		    	file.delete();
		    }

//	      return out;
	   }


public static  void main(String[] a) {
	Calendar cal=new GregorianCalendar();
	int x=cal.DATE;
	System.out.println(x);
	cal = Calendar.getInstance();
	String month = x+"-"+cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
System.out.println( x+"-"+month);
	// TODO Auto-generated method stub
//ExcelCreator c=new ExcelCreator();
//c.cretaeExcel();
DateFormat dateFormat = new SimpleDateFormat("dd");
//get current date time with Date()
Date date = new Date();
System.out.println(dateFormat.format(date));

//get current date time with Calendar()
System.out.println(dateFormat.format(cal.getTime())+"-"+cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
}

public static String getCurrentDateAndMonth(){
	Calendar cal=new GregorianCalendar();
	cal = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd");
	//get current date time with Date()
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	System.out.println(dateFormat.format(date));

	//get current date time with Calendar()
	System.out.println(dateFormat.format(cal.getTime())+"-"+cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
	return ""+dateFormat.format(cal.getTime())+"-"+cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
}


}
