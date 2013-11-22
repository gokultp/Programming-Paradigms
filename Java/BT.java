import java.lang.*;
class Node
	{
	int data;
	Node left,right,next;
	
	Node(int n)
		{
		data=n;
		left=null;
		right=null;
		next=null;
		}
	}
class Tree
	{
	Node root;
		Tree()
			{
			root=null;
			}
	public void insert(int n) throws NullPointerException
		{
		Node ri,rd;
			if(root==null)
				{
				root=new Node(n);
				}
			else
				{
				ri=root;
				while(ri.next!=null)
					{
					ri=ri.next;
					}
				ri.next=new Node(n);
				ri=ri.next;
				rd=root;
				while((rd.next!=null))
					{
					if((rd.left!=null)&&(rd.right!=null)){
					rd=rd.next;}
					else
						{break;}
					}
				if(rd.left==null)
					{
					rd.left=ri;
					}
				else if(rd.right==null)
					{
					rd.right=ri;
					}
				}
		}

	public void inorder(Node p)
		{
		if(p!=null)
			{
			
		inorder(p.left);
		System.out.print(p.data+"  ");
		inorder(p.right);
			}
		}
	public Node delete(Node ptr,int n) 
		{
		Node rd,ri;
		if(ptr!=null)
			{
			if(ptr.data==n)
				{
				if((ptr.left==null)&&(ptr.right==null))
					{
				
					rd=root;
					ri=rd;
					while((rd.next!=null)&&(rd.data!=ptr.data))
						{
						ri=rd;
						rd=rd.next;
					
						}
					ri.next=ptr.next;
					ptr=null;
					return ptr;
					}
				else
					System.out.println("Cannot delete "+ptr.data);
			
				}
			ptr.left=delete(ptr.left,n);
			ptr.right=delete(ptr.right,n);
			}
		return ptr;
		}
	}
public class BT 
	{
	public static void main(String args[]) throws NullPointerException
		{
		int i;
		Tree t=new Tree();
		for(i=1;i<=10;i++)
			t.insert(i);
		
		t.inorder(t.root);
		System.out.println("");
		System.out.println("");
		t.delete(t.root,8);
		t.delete(t.root,1);
		t.inorder(t.root);
		}	
	}
