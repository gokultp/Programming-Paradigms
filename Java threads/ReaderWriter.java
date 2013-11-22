//without semaphore

import java.util.*;
import java.lang.*;

public class ReaderWriter
	{
	static boolean lock=false;
	static int no_reader=0;
	static int waiting_writer=0;
	static int data=0;
	static Random rand = new Random();
	
	public synchronized static void  start_read()
		{
		
				
		no_reader++;
		
		
		} 
		
		
		
		
	public synchronized static void  end_read()
	{
	no_reader--;
	}
	
	
		
	public synchronized static void  start_write()
		{	
		
		lock=true;
		waiting_writer--;
		data++;
		
		}
		
	public synchronized static void  end_write()
	
	{
	lock=false;
	}		
	
		
		
	
	
	public static void main(String arg[])
		{
		Thread reader=new Thread(new Runnable(){
		public void run()
			{
			for(int i=0;i<10;i++)
				{
				try
					{
					while(lock)
						{
						Thread.sleep(5);
						}
			
			
					while(waiting_writer>0)
						{
						Thread.sleep(5);
						}
						
					start_read();
					System.out.println("Reader1 reads "+data);
					Thread.sleep( 1000);
					end_read();
					
					}
				catch(InterruptedException e)
					{
				}
			}
			}});
			
			
			Thread reader1=new Thread(new Runnable(){
		public void run()
			{
			for(int i=0;i<10;i++)
				{
				try
					{
					while(lock)
						{
						Thread.sleep(5);
						}
			
			
					while(waiting_writer>0)
						{
						Thread.sleep(5);
						}
					start_read();
					System.out.println("Reader2 reads "+data);
					Thread.sleep( 1000);
					end_read();
					}
				catch(InterruptedException e)
					{
				}
			}
			}});
			
			
			
			Thread writer=new Thread(new Runnable(){
		public void run()
			{
			for(int i=0;i<10;i++)
				{
				try
					{
					waiting_writer++;
					while(lock)
						{
						Thread.sleep(5);
						}
					while(no_reader>0)
						{
						Thread.sleep(5);
						}
					
					start_write();
					System.out.println("Writer1 writes " +data);
					Thread.sleep(1000);
					end_write();
					}
				catch(InterruptedException e)
					{
				}
			}
			}});
			
			
			Thread writer1=new Thread(new Runnable(){
		public void run()
			{
			for(int i=0;i<10;i++)
				{
				try
					{
					waiting_writer++;
					while(lock)
						{
						Thread.sleep(5);
						}
					while(no_reader>0)
						{
						Thread.sleep(5);
						}
					
					start_write();
					System.out.println("Writer2 writes " +data);
					Thread.sleep(1000);
					end_write();
					}
				catch(InterruptedException e)
					{
				}
			}
			}});
			
			
			reader.start();
			 writer1.start();
			reader1.start();
			writer.start();
			 
				
	}
}
