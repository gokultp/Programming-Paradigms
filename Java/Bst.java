import java.util.*;

class Node
	{
	int Data;
	Node Left,Right;
	
	Node(int n)
		{
		Data=n;
		Left=null;
		Right=null;
		}
	}
class Tree
	{
	Node Root;
	Tree()
		{
		Root=null;
		}

	public Node insertItem(Node Ptr,int n)
		{
		if(Ptr==null)
			{
			Ptr=new Node(n);
			return Ptr;
			}
		else if(n<Ptr.Data)
			{
			Ptr.Left=insertItem(Ptr.Left,n);
			return Ptr;
			}
		else if(n>Ptr.Data)
			{
			Ptr.Right=insertItem(Ptr.Right,n);
			return Ptr;
			}
		return Ptr;
		}

	public Node deleteItem(Node Ptr,int n)
		{	
		if(n<Ptr.Data)
			{
			Ptr.Left=deleteItem(Ptr.Left,n);
			}
		else if(n>Ptr.Data)
			{
			Ptr.Right=deleteItem(Ptr.Right,n);
			}
		else
			{
			if(Ptr.Left==null)
				{
				Ptr=Ptr.Right;
				}
			else if(Ptr.Right==null)
				{
				Ptr=Ptr.Left;
				}
			else
				{
				int a=min(Ptr.Right);
				Ptr.Data=a;
				Ptr.Right=deleteItem(Ptr.Right,a);
				}
			}
		return Ptr;
		}
	public int min(Node Ptr)
		{
		int val;
		if(Ptr.Left==null)
			{
			return Ptr.Data;
			}
		else
			{
			val=min(Ptr.Left);
			}
		return val;
		}
	public void inorder(Node Ptr)
		{
		if(Ptr!=null)
			{
			inorder(Ptr.Left);
			System.out.println(Ptr.Data);
			inorder(Ptr.Right);
			}
		}
	}
public class Bst
	{
	public static void main(String args[])
		{
		String nl = System.getProperty("line.separator");
		Scanner in=new Scanner(System.in);
		Tree B=new Tree();
		int i,n;
		do
			{
			System.out.println("Enter your Choice"+nl+"1. Insert"+nl+"2. Delete"+nl+"3. Inorder"+nl+"4. Exit"+nl);
			i=in.nextInt();
			switch(i)
				{
				case 1:
					n=in.nextInt();
					B.Root=B.insertItem(B.Root,n);
					break;
				case 2:
					n=in.nextInt();
                                        B.Root=B.deleteItem(B.Root,n);
                                        break;
				case 3:
					B.inorder(B.Root);
					break;
				
				}	
			}
		while(i<4);
		}
	}
