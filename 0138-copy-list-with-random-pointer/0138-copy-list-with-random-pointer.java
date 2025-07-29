/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head,newHead);

        Node node = head;
        Node newNode = newHead;
        while(node.next!=null){
            node = node.next;

            Node temp = new Node(node.val);

            newNode.next = temp;
            newNode = newNode.next;

            map.put(node,temp);
        }

        node = head;

        while(node!=null){
            if(node.random!=null){
                map.get(node).random = map.get(node.random);
            }
            node = node.next;
        }

        return newHead;
    }
}