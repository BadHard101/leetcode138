package org.example;

import java.util.HashMap;

class Solution1 {
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
        Node curCopy, nextCopy;

        while (cur != null) {
            curCopy = copyMap.get(cur);
            nextCopy = copyMap.get(cur.next);
            curCopy.next = nextCopy;
            curCopy.random = copyMap.get(cur.random);
            cur = cur.next;
        }
        return copyMap.get(head);
    }
}