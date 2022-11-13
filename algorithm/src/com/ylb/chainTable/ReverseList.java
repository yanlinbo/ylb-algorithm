package com.ylb.chainTable;

public class ReverseList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 迭代的算法
     * @param head
     * @return
     */
    public static ListNode iterate(ListNode head){

        ListNode pre = null,next;
        ListNode cur = head;
        while(cur != null){
            //第一步：先保存指针
            next =  cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return  pre;
    }


    /**
     * 递归的算法
     * @param head
     * @return
     */
    public static ListNode recursion(ListNode head){

        if(head == null || head.next == null){
            return  head;
        }
        ListNode new_head = recursion(head.next);

        head.next.next = head;
        head.next = null;
        return new_head;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);

//        ListNode pre = iterate(listNode1);
//        System.out.println(pre);

        ListNode new_head = recursion(listNode1);
        System.out.println(new_head);
    }
}
