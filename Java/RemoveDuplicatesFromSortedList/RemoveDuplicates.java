/**
 * (1ms)
 * ��������ɾ���ظ���Ԫ�أ�ʹ�õݹ�ķ�������һ�ж��Ƿ�Ϊ�ظ��ģ���ԭ·���ء�
 * @author Phoenix-Z
 *
 */
public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		//������
		if(head == null)
			return head;
		//������������ľ�ͷ
		if(head.next == null)
			return head;
		//�����ǰ�ڵ��ֵ������һ���ڵ��ֵ���ͽ��ýڵ�ɾ��
		if(head.next.val == head.val)
		{
			//ɾ���ظ��ڵ�
			head.next = head.next.next;
			//ע�����ﻹ�ǶԵ�ǰ�ڵ�������Է��������������ϵ��ظ�
			return deleteDuplicates(head);
		}
		//�����ǰ�ڵ�������ڵ㲻��ͬ������ǰ����
		head.next = deleteDuplicates(head.next);
		return head;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}