import java.util.Scanner;
public class DoubleLinkedList {
class Node {
int data;
Node previous;
Node next;
public Node(int data) {
this.data = data;
}
}
Node head, tail = null;
public void addNode(int data) {
Node newNode = new Node(data);
if (head == null) {
head = tail = newNode;
head.previous = null;
tail.next = null;
} else {
tail.next = newNode;
newNode.previous = tail;
tail = newNode;
tail.next = null;
}
}
public void removeNode(int node) 
{ 
Node temp1 = head;
Node temp2=null; 
    if (head == null) {
	System.out.println("the List is Empty!!!"); 
        return; 
    } 
  while(temp1.data!=node)
{
	if(temp1.next==null)
	{
	System.out.println("given node not found to delete");
	return;
	}
	else
	{
	temp2=temp1;
	temp1=temp1.next;
	}
}
if(temp1==head)
{
head=head.next;
head.previous=null;
temp1=null;
System.out.println("Node removed SUCCESSFULLY!!!");
}
else if(temp1.previous==null&&temp1.next==null)
{
head=null;
System.out.println("Node removed SUCCESSFULLY!!!");
}
else
{
temp2.next=temp1.next;
temp1.next=temp1.previous=null;
temp1=null;
System.out.println("Node removed SUCCESSFULLY!!!");
}
}
public void display() {
Node current = head;
if (head == null) {
System.out.println("List is empty");
return;
}
System.out.println("Nodes of doubly linked list: ");
while (current != null) {
System.out.print(current.data + " ");
current = current.next;
}
}
public static void main(String[] args) {
DoubleLinkedList dList = new DoubleLinkedList();
Scanner sc=new Scanner(System.in);
int ch;
boolean flag=true;
while(flag)
{
System.out.println("\n1.InsertNode\t2.DeleteNode\t3.DisplayList\t4.Stop");
System.out.println("Enter Your Choice");
ch=sc.nextInt();
switch(ch)
{
case 1:System.out.println("Enter the value to insert");
	int value=sc.nextInt();
	dList.addNode(value);
	System.out.println("NODE Inserted Successfully!!!");
	break;
case 2: System.out.println("enter node to be deleted!!!");
	int node=sc.nextInt();
	dList.removeNode(node);
	break;
case 3:System.out.println("the Nodes in the list are");
	dList.display();
	break;
case 4:flag=false;
	System.out.println("You have Stopped Execution!!!");
	break;
default:System.out.println("Invalid choice!!! Enter correct choice");
}
}
}
}
