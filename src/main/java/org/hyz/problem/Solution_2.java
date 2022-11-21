package org.hyz.problem;


import org.hyz.common.ListNode;

import java.util.ArrayList;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author huyz
 */

public class Solution_2 {

    public static void main(String[] args) {
//        ListNode<Integer> l1 = new ListNode<>(2, new ListNode<>(4, new ListNode<>(3,  null)));
//        ListNode<Integer> l2 = new ListNode<>(5, new ListNode<>(6, new ListNode<>(4,  null)));

        ListNode<Integer> l1 = new ListNode<>(0, null);
        ListNode<Integer> l2 = new ListNode<>(0, null);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> result = new ListNode<>();
        ListNode<Integer> resultSum = result;

        // 当前值
        int currentVal;

        // 进位
        int incVal = 0;

        while (l1 != null || l2 != null) {
            currentVal = 0;
            if (l1 == null) {
                currentVal += (l2.getVal() + incVal) % 10;
                incVal = (l2.getVal() + incVal) / 10;
                l2 = l2.getNext();
            } else if (l2 == null) {
                currentVal += (l1.getVal() + incVal) % 10;
                incVal = (l1.getVal() + incVal) / 10;
                l1 = l1.getNext();
            } else {
                currentVal += (l1.getVal() + l2.getVal() + incVal) % 10;
                incVal = (l1.getVal() + l2.getVal() + incVal) / 10;
                l2 = l2.getNext();
                l1 = l1.getNext();
            }
            resultSum.setNext(new ListNode<>(currentVal, new ListNode<>()));
            resultSum = resultSum.getNext();
        }
        if (incVal > 0) {
            resultSum.setNext(new ListNode<>(incVal, new ListNode<>()));
        }
        return result.getNext();
    }

}
