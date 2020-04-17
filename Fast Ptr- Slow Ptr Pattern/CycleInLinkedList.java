package coding_interview;


class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val=val;
		this.next=null;
	}
	@Override
	public String toString() {
		return "ListNode val=" + val;
	}
	
}
public class CycleInLinkedList {
	
	public static boolean isCyclic(ListNode head) {
		if(head==null)
			return false;
		ListNode fast=head;
		ListNode slow = head;
		while(true) {
			fast=fast.next;
			if(fast!=null)
				fast=fast.next;
			if(fast==null)
				return false;
			slow=slow.next;
			if(fast==slow) {
				slow=fast.next;
				int length=findLengthOfCycle(slow, fast);
				System.out.println("Length of cycle is: "+length);
				System.out.println("The start of cycle is: "+ findStartOfCycle(head, length));
				return true;
			}	
		}
	}
	
	private static int findLengthOfCycle(ListNode slow, ListNode fast) {
		int count=0;
		while(slow!=fast) {
			count++;
			slow=slow.next;
		}
		return count+1;
	}
	
	public static ListNode findStartOfCycle(ListNode head, int length) {
		if(head==null || length<=0)
			throw new IllegalArgumentException();
		ListNode start=head,end=head;
		for(int i=0;i<length;i++) {
			end=end.next;
		}
		while(start!=end) {
			start=start.next;
			end=end.next;
			if(start==end)
				return start;
		}
		return start;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode first = new ListNode(2);
		head.next=first;
		ListNode second = new ListNode(3);
		first.next = second;
		ListNode third = new ListNode(4);
		second.next=third;
		ListNode fourth = new ListNode(5);
		third.next=fourth;
		ListNode fifth = new ListNode(6);
		fourth.next=fifth;
		fifth.next=first;
		System.out.println(isCyclic(head));
	}

}
