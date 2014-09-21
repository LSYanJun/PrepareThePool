//Yanjun Wu-SSW567-Assignment_1
package edu.stevens.ssw567.ywu;

public class Pool {
	
	int length, width, depth_shallow, depth_deep,area,volume;
	double paintTime,fillTime,amountOfTime;
	String CID;
	
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
		+ Math.sqrt(length*length + depth_deep*depth_deep) * width + depth_deep * width + depth_shallow * width);
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
