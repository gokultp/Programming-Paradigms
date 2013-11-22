//with semaphores

import java.util.*;
import java.lang.*;

public class Rdr
	{
		public static void main(String args[])
			{
			Reader r=new Reader();
			Writer w=new Writer();
			Writer w1=new Writer();
			w1.start();
			r.start();
			w.start();
			}
	}
	
class Semaphore
	{
	int val;
	
	Semaphore(int n)
		{val=n;}
	
	void signal()
		{
		val++;
		}
	void waits()
		{
		while(val<=0);
		val--;
		}
	}
	
class RoW extends Thread
	{
	static int data=0;
	static int rdcnt=0;
	static Semaphore mutex=new Semaphore(1);
	static Semaphore wrt=new Semaphore(1);
	public 	void run()
		{
		
		}
	}
	
class Reader extends RoW
	{
	public void run()
		{
		do
			{
			mutex.waits();
			rdcnt++;
			if(rdcnt==1){
				wrt.waits();
				}
			mutex.signal();
			System.out.println(Thread.currentThread().getId()+"Reading"+data);
			mutex.waits();
			rdcnt--;
			if(rdcnt ==0)
				{
				wrt.signal();
				}
			mutex.signal();
			try
				{
				Thread.sleep(500);
				}
			catch(InterruptedException e){}
			}while(true);
		}
		
	
	}
	
class Writer extends RoW
	{
	public void run()
		{
		do
			{
			wrt.waits();
			data++;
			System.out.println(Thread.currentThread().getId()+"Writing"+data);
			
			wrt.signal();
			try
				{
				Thread.sleep(500);
				}
			catch(InterruptedException e){}
			}
			while(true);
		}		
	
	}
	
	
