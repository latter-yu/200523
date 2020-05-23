public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode oddEvenList(ListNode head) {
        //奇偶链表
        //应当保持奇数节点和偶数节点的相对顺序.
        //链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推.
        if(head == null || head.next == null) {
            return head;
        }
        //head 为奇链表头节点, tail 为奇链表尾节点
        ListNode tail = head;
        //h 为偶链表头节点, t 为偶链表尾结点
        ListNode h = head.next;
        ListNode t = h;
        while(tail.next != null && t.next != null) {
            tail.next = t.next;
            tail = tail.next;
            t.next = tail.next;
            t = t.next;
        }
        tail.next = h;
        return head;
    }

    public ListNode detectCycle(ListNode head) {
        //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
        //整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）.
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                ListNode cur = head;
                while(slow != cur) {
                    slow = slow.next;
                    cur = cur.next;
                }
                return slow;
            }
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        //判断链表是否有环.
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //输入两个链表，找出它们的第一个公共结点
        ListNode p = headA;
        ListNode q = headB;

        if(headA == null || headB == null) {
            return null;
        }
        while(p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    public boolean chkPalindrome(ListNode A) {
        //判断链表是否为回文结构
        ListNode fast = A;
        ListNode slow = A;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode nextMid = slow.next;
        //逆置
        while(nextMid != null){
            ListNode next = nextMid.next;
            nextMid.next = slow;
            slow = nextMid;
            nextMid = next;
        }
        while(slow != A) {
            if(slow.val != A.val) {
                return false;
            }
            if(A.next == slow) {
                return true;
            }
            A = A.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        ListNode cur = pHead;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return node.next;
    }

}