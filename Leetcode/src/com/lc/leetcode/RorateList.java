package com.lc.leetcode;

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public void add(int val){
        ListNode newNode = new ListNode(val);
        if(this.next == null){
            this.next = newNode;
        }else{
            this.next.add(val);
        }
    }
    public static ListNode createListNode(int[] array){
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int j : array) {
            head.next = new ListNode(j);
            head = head.next;
        }
        return pre.next;
    }

    public void print(){
        if(this.next==null){
            System.out.println(this.val);
            return;
        }
        System.out.print(this.val);
        System.out.print("->");
        if(this.next!=null){
            this.next.print();
        }
    }

}


public class RorateList {
    @SuppressWarnings("UnusedReturnValue")
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while(node!=null){
            len++;
            node = node.next;
        }
        return rotateRight2(head, k%len);
    }
    public ListNode rotateRight2(ListNode head, int k){
        ListNode kNode = head;
        int i=0;
        while(i!=k){
            kNode = kNode.next;
            i++;
        }
        kNode.print();
        ListNode curNode = head;
        while(kNode.next!=null){
            curNode = curNode.next;
            kNode = kNode.next;
        }
        kNode.next = head;
        ListNode resNode = curNode.next;
        curNode.next = null;
        resNode.print();
        return resNode;
    }

    public static void main(String[] args) {
        ListNode testList = ListNode.createListNode(new int[]{0});
        testList.print();
        new RorateList().rotateRight(testList, 1);
    }
}
