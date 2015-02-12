//SSW-567 group 1, Assignment #5
//Developed by Yanjun Wu, Han Wang, Slavik, Xingsheng Shi

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;

public class Pool {
	private static int intData[] = new int[100];
	static Formatter ff = null;

	public static void main(String[] args) {
		Pool d = new Pool();
		BufferedReader reader = null;
		File f = new File("output.txt");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else {
			FileWriter fw;
			try {
				fw = new FileWriter(f);
				fw.flush();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			ff = new Formatter(new PrintStream("output.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<PoolClass> list = new ArrayList<PoolClass>();
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("testfile.txt")));
			String str = null;
			int count = 1;
			System.out.println("Input...");
			ff.format("%s\r\n", "Input...");
			System.out
					.println("Input sequence: length, width, depth of shallow end, depth of deep end, customer.");
			ff.format(
					"%s\r\n",
					"Input sequence: length, width, depth of shallow end, depth of deep end, customer.");
			while ((str = reader.readLine()) != null) {

				PoolClass pool = new PoolClass();
				boolean flag = d.Check(str, count);
				if (flag == true) {
					String[] strT = str.split(" ");
					pool.setLength(Integer.parseInt(strT[0]));
					pool.setWidth(Integer.parseInt(strT[1]));
					pool.setDepth_shallow(Integer.parseInt(strT[2]));
					pool.setDepth_deep(Integer.parseInt(strT[3]));
					pool.setCID(strT[4]);
					pool.calcArea();
					pool.calcVolume();
					pool.calcGw();
					pool.setDay();
					pool.setHour();
					pool.setMinute();
					pool.calcD();
					pool.calcH();
					pool.calcM();
					pool.setTotalDays();
					pool.calcDate();
					list.add(pool);
				}
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("Output...");
		ff.format("\r\n%s\r\n", "output:");
		ff.format("%-15s%15s%7s%7s%10s%15s%7s%7s%10s%-14s\r\n", "customer",
				"area", "day", "hour", "minute", "water(gal)", "day", "hour",
				"minute", "  Date(MM/DD/YYYY)");
		ff.format("%-15s%15s%7s%7s%10s%15s%7s%7s%10s%-14s\r\n", "========",
				"==========", "===", "====", "======", "==========", "===",

				"====", "======", "  ===================");

		for (int i = 0; i < list.size(); i++) {
			PoolClass pool = (PoolClass) list.get(i);
			ff.format(
					"%-15s%15.2f%7d%7d%10d%15.2f%7d%7d%10d%s%02d/%02d/%04d%4s%02d:%02d\r\n",
					pool.getCID(), pool.getArea(), pool.getDay(),
					pool.getHour(), pool.getMinute(), pool.getGw(),
					pool.getD(), pool.getH(), pool.getM(), "  ", pool.getMm(),
					pool.getDd(), pool.getYyyy(), "at ", pool.getTime(),
					pool.getM());
		}
		System.out.printf("%-15s%15s%7s%7s%10s%15s%7s%7s%10s%-14s\r\n",
				"customer", "area", "day", "hour", "minute", "water(gal)",
				"day", "hour",

				"minute", "  Date(MM/DD/YYYY)");
		System.out.printf("%-15s%15s%7s%7s%10s%15s%7s%7s%10s%-14s\r\n",
				"==========", "==========", "===", "====", "======",
				"==========",

				"===", "====", "======", "  ===================");
		for (int i = 0; i < list.size(); i++) {
			PoolClass pool = (PoolClass) list.get(i);
			System.out
					.printf("%-15s%15.2f%7d%7d%10d%15.2f%7d%7d%10d%s%02d/%02d/%04d%4s%02d:%02d\r\n",
							pool.getCID(), pool.getArea(), pool.getDay(),
							pool.getHour(), pool.getMinute(), pool.getGw(),
							pool.getD(), pool.getH(), pool.getM(), "  ",
							pool.getMm(), pool.getDd(), pool.getYyyy(), "at ",
							pool.getTime(), pool.getM());
		}
	}

	public boolean Check(String str, int count) {
		System.out.println(str);
		ff.format("%s\r\n", str);
		String[] strT = str.split(" ");
		int l = strT.length;
		boolean flag = true;
		if (l != 5) {
			System.out.println("Line " + count
					+ " error! only 5 inputs of each line is acceptable!");
			ff.format("%s%d%s\r\n", "Input line ", count,
					" error! only 5 inputs of each line is acceptable!");
			flag = false;
		}
		else {
			//Code modified
			//Checking customer ID
			if(!strT[4].matches("[0-9A-Za-z]*")){
				System.out.println(strT[4] + " Customer Id contains invalid character! Only a name with or without number(s) allowed.");
				ff.format("%-15s%s%s\r\n", strT[4], " ",
						"Customer Id contains invalid character! Only a name with or without number(s) allowed.");
				flag = false;
			}
			for (int i = 0; i < l - 1; i++) {
				try {
					Pool.intData[i] = Integer.parseInt(strT[i]);
					if (intData[i] <= 0) {
						System.out.println("invalid data! " + strT[i]
								+ " is not a positive number!");
						ff.format("%-15s%s%s%s\r\n", strT[4], " ", strT[i],
								" is not a positive number!");
						flag = false;
					}
				} catch (Exception e) {
					System.out.println("invalid data! " + strT[i]
							+ " is not a positive integer!");
					ff.format("%-15s%s%s%s\r\n", strT[4], " ", strT[i],
							" is not a positive integer!");
					flag = false;
				}
			}
			// 10 < length < 500
			if (intData[0] > 500 || intData[0] < 10) {
				System.out.println("length out of range(10~500).");
				ff.format("%-15s%s%s\r\n", strT[4], " ",
						"length out of range(10~500)!");
				flag = false;
			}
			// 3 < width < 300
			if (intData[1] > 300 || intData[1] < 3) {
				System.out.println("width out of range(3~300).");
				ff.format("%-15s%s%s\r\n", strT[4], " ",
						"width out of range(3~300)!");
				flag = false;
			}
			// 3 < ds < 10
			if (intData[2] > 10 || intData[2] < 3) {
				System.out.println("Depth of shallow end out of range(3~10).");
				ff.format("%-15s%s%s\r\n", strT[4], " ",
						"Depth of shallow end out of range(3~10)!");
				flag = false;
			}
			// 5 < dd < 30
			if (intData[3] > 30 || intData[3] < 5) {
				System.out.println("Depth of deep end out of range(5~30).");
				ff.format("%-15s%s%s\r\n", strT[4], " ",
						"Depth of deep end out of range(5~30)!");
				flag = false;
			}
			if (intData[0] <= intData[1]) {
				System.out.println("length should be greater than width!");
				ff.format("%-15s%s%s\r\n", strT[4], " ",
						"length should be greater than width!");
				flag = false;
			}
			if (intData[2] >= intData[3]) {
				System.out
						.println("Depth of deep end should be greater than Depth of shallow end!");
				ff.format("%-15s%s%s\r\n", strT[4], " ",
						"Depth of deep end should be greater than Depth of shallow end!");
				flag = false;
			}
		}
		return flag;
	}
}

class PoolClass {
	private int length, width, depth_shallow, depth_deep, volume;
	private double paintTime, fillTime, amountOfTime;
	private double area, gw;
	private int day, hour, minute, d, h, m;
	private int totalDays, time;
	private int mm, dd, yyyy;
	private String CID;
	private int d1, d2;
	
	public boolean isLeapYear(int y) {
		boolean flag = false;
		if (y % 100 == 0 && y % 400 == 0)
			flag = true;
		else if (y % 100 != 0 && y % 4 == 0)
			flag = true;
		else
			flag = false;
		return flag;
	}

	public void setTotalDays(){
		if(hour != 0 || minute != 0)
			this.d1 = day + 1;
		else
			this.d1 = day;
		if(h != 0 || m != 0)
			this.d2 = d + 1;
		else
			this.d2 = d;
		this.totalDays = d1 + d2 - 1;
		System.out.println(totalDays);
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void calcDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 3, 1);
		calendar.add(Calendar.DATE, totalDays);
		this.yyyy = calendar.get(Calendar.YEAR);
		this.mm = calendar.get(Calendar.MONTH) + 1;
		this.dd = calendar.get(Calendar.DAY_OF_MONTH);
		if (h > 4)
			this.time = 8 + h + 1;
		else if (h == 4 && m > 0)
			this.time = 8 + h + 1;
		else if (h == 4 && m == 0)
			this.time = 8 + h;
		else
			this.time = 8 + h;
	}
	public int getTime() {
		return time;
	}

	public int getMm() {
		return mm;
	}

	public int getDd() {
		return dd;
	}

	public int getYyyy() {
		return yyyy;
	}

	public void calcGw() {
		this.gw = (volume - width * length * 0.5) * 7.48;

	}

	public double getGw() {
		return gw;
	}

	public void calcD() {
		this.d = (int) (gw / 12000);
	}

	public int getD() {
		return d;
	}

	public void calcH() {
		double left = gw - d * 12000;
		if (left <= 8000)
			this.h = (int) (left / 2000);
		else
			this.h = (int) ((left - 8000) / 1000) + 4;

	}

	public int getH() {
		return h;
	}

	public void calcM() {
		double left;
		if (h <= 4) {
			left = gw - 12000 * d - h * 2000;
			m = (int) (left * 60 / 2000);
		} else {
			left = gw - 12000 * d - 4 * 2000 - (h - 4) * 1000;
			m = (int) (left * 60 / 1000);
		}
	}

	public int getM() {
		return m;
	}

	public int getDay() {
		return day;
	}

	public void setDay() {
		this.day = (int) (area / 1200);
	}

	public int getHour() {
		return hour;
	}

	public void setHour() {
		double left;
		if (day == 0) {
			left = area;
		} else {
			left = area - 1200 * day;
		}
		if (left >= 1100) {
			this.hour = 7;
		} else if (left >= 1000 && left < 1100) {
			this.hour = 6;
		} else if (left >= 900 && left < 1000) {
			this.hour = 5;
		} else if (left >= 800 && left < 900) {
			this.hour = 4;
		} else {
			this.hour = (int) (left / 200);
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute() {
		double left;
		if (day == 0 && hour == 0) {
			left = area;
			this.minute = (int) (left * 60 / 200);
		} else if (hour > 4) {
			left = area - 1200 * day - 800 - (hour - 4) * 100;
			this.minute = (int) (left * 60 / 100);
		} else if (hour < 4) {
			left = area - 1200 * day - hour * 200;
			this.minute = (int) (left * 60 / 200);
		} else {
			left = 0;
			this.minute = 0;
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth_shallow() {
		return depth_shallow;
	}

	public void setDepth_shallow(int depthShallow) {
		depth_shallow = depthShallow;
	}

	public int getDepth_deep() {
		return depth_deep;
	}

	public void setDepth_deep(int depthDeep) {
		depth_deep = depthDeep;
	}

	public String getCID() {
		return CID;
	}

	public void setCID(String cid) {
		this.CID = cid;
	}

	public double getArea() {
		return area;
	}

	public void calcArea() {
		this.area = (int) ((depth_deep + depth_shallow)
				* length
				+ (Math.sqrt(length * length + (depth_deep - depth_shallow)
						* (depth_deep - depth_shallow))) * width + depth_deep
				* width + depth_shallow *

		width);
	}

	public int getVolume() {
		return volume;
	}

	public void calcVolume() {
		this.volume = (depth_deep + depth_shallow) * length * width / 2;
	}

	public double getPaintTime() {
		return paintTime;
	}

	public void setPaintTime() {
	}

	public double getFillTime() {
		return fillTime;
	}

	public void setFillTime() {
	}

	public double getAmountOfTime() {
		return amountOfTime;
	}

	public void setAmountOfTime() {
		this.amountOfTime = this.getPaintTime() + this.getFillTime() + 8;
	}

}