//Yanjun Wu-SSW567-Assignment_2
package edu.stevens.ssw567.ywu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class DataCheck {
	private int intData[] = new int[100];
	
	public static void main(String [] args) throws IOException{
		DataCheck d = new DataCheck();
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
			String str = null;
			while ((str = reader.readLine()) != null) {
				System.out.println(d.Check(str));
				}
			}catch (FileNotFoundException e){
				e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			try{
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean Check(String str){
		System.out.println(str);
		String[] strT = str.split(" ");
		int l = strT.length;
		
		if(l != 5){
			System.out.println("only 5 inputs of each line is acceptable!");
			return false;
		}
		else{
		for(int i = 0;i < l-1;i++){
				
				try{
					this.intData[i] = Integer.parseInt(strT[i]);
					if(intData[i] <= 0){
						System.out.println("invalid data! " + strT[i] + " is not a positive number!");
						return false;
					}
				}catch(Exception e){
					System.out.println("invalid data! " + strT[i] + " is not a positive integer!");
					return false;
			    }
						
		}
		
		if(intData[0]>800){
			System.out.println("length beyond limit");
			return false;
		}
		if(intData[1]>500){
			System.out.println("width beyond limit");
			return false;
		}
		if(intData[2]>100){
			System.out.println("Depth_shallow beyond limit");
			return false;
		}
		if(intData[3]>200){
			System.out.println("Depth_deep beyond limit");
			return false;
		}
		if(intData[0]<=intData[1]){
			System.out.println("length should be greater than width!");
			return false;
		}
		if(intData[2]>=intData[3]){
			System.out.println("Depth_deep should be greater than Depth_shallow!");
			return false;
		}
		return true;
		}
	}
	
}
