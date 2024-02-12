package org.example;

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node cur = head;
        HashMap<Node, Node> copyMap = new HashMap<>();
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            copyMap.put(cur, copyNode);
            cur = cur.next;
        }

        cur = head;
        Node prevCopy, curCopy;


        if (cur.random != null) {
            copyMap.get(cur).random = copyMap.get(cur.random);
        }

        while (cur.next != null) {
            prevCopy = copyMap.get(cur);
            cur = cur.next;
            curCopy = copyMap.get(cur);
            prevCopy.next = curCopy;

            if (cur.random != null) {
                curCopy.random = copyMap.get(cur.random);
            }
        }
        return copyMap.get(head);
    }
}