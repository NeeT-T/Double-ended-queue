package deque;
public class Deque <dataType>{
    private Node front;
    private Node back;
    private class Node{
        private Node next;
        private dataType element;
        private Node(Node next, dataType element) {
            this.next = next;
            this.element = element;
        }
    }

    public Deque() {
        front = back = null;
    }
    
    public boolean isEmpty(){
        return front == null;
    }
    
    public void clearDeque(){
        front = back = null;
    }
    
    public void pushFront(dataType elem){
        if(isEmpty()){
            Node first = new Node(null, elem);
            front = back  = first;
        }
        else{
            Node first = new Node(front, elem);
            front = first;
        }
    }
    
    public void pushBack(dataType elem){
        Node last = new Node(null, elem);
        if(isEmpty()){
            back = front  = last;
        }
        else{
            back.next = last;
            back = last;
        }
    }
    
    public void popFront(){
        if(isEmpty()){
            return;
        }
        else if (front == back){
            front = back = null;
        }
        else{
            front = front.next;
        }
    }
    
    public void popBack(){
        if(isEmpty()){
            return;
        }
        else if (front == back){
            front = back = null;
        }
        else{
            Node aux = previousToBack();
            back = aux;
            back.next = null;
        }
    }
    
    private Node previousToBack(){
        Node aux = front;
        while(aux != back){
            if(aux.next.equals(back))
                break;
            aux = aux.next;
        }
        return aux;
    }
    
    public dataType front(){
        if(isEmpty())
            return null;
        return front.element;
    }
    
    public dataType back(){
        if(isEmpty())
            return null;
        return back.element;
    }
    
    /*public void printDeque() {
        if (isEmpty()){
            return;
        }
        Node aux = front;
        while (aux != null){
            System.out.println(aux.element);
            aux = aux.next;
        }
    }*/
    
}

