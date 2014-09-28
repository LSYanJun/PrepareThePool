//SSW-567 group 1, Assignment #4
//Developed by Yanjun Wu, Han Wang, Slavik, Xingsheng Shi

package edu.stevens.ssw567.ywu;

public class Pool {
	
	int length, width, depth_shallow, depth_deep,area,volume;
	double paintTime,fillTime,amountOfTime;
	int day,hour,minute;
	String CID;
	
	
	public int getDay() {
		return day;
	}
	public void setDay() {
		this.day = area/1200;
	}
	public int getHour() {
		return hour;
	}
	public void setHour() {
		int left;
		if(day == 0){
			left = area;
		}
		else{
			left = area - 1200 * day;
		}
		if(left >= 1100){
			this.hour = 7;
		}
		else if(left >= 1000 && left < 1100){
			this.hour = 6;
		}
		else if(left >= 900&& left < 1000){
			this.hour = 5;
		}
		else if ( left >= 800 && left < 900){
			this.hour = 4;
		}
		else{
			this.hour = left / 200;
		}
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute() {
		int left;
		if(day == 0 && hour == 0){
			left = area;
			this.minute = left * 60 / 200;
		}
		else if(hour > 4){
			left = area - 1200 * day - 800 - (hour - 4) * 100;
			this.minute = left * 60 / 100 ;
		}
		else if(hour < 4){
			left = area - 1200 * day - hour * 200;
			this.minute = left * 60 / 200;
		}
		else{
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
	public int getArea() {
		return area;
	}
	public void calcArea() {
		this.area = (int) ((depth_deep + depth_shallow) * length 
		+ (Math.sqrt(length*length + (depth_deep-depth_shallow)*(depth_deep-depth_shallow))) * width + depth_deep * width + depth_shallow * width);
	}
	public int getVolume() {
		return volume;
	}
	public void calcVolume() {
		this.volume = (depth_deep + depth_shallow) * length * width / 2;
	}
	public double getPaintTime(){
		return paintTime;
	}
	public void setPaintTime() {
		this.paintTime = this.getArea() * 0.02;
	}
	public double getFillTime() {
		return fillTime;
	}
	public void setFillTime() {
		this.fillTime = this.getVolume() * 0.03;
	}
	public double getAmountOfTime() {
		return amountOfTime;
	}
	public void setAmountOfTime() {
		this.amountOfTime = this.getPaintTime() + this.getFillTime() + 8;
	}
	
	
}
