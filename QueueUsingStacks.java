import java.util.*;
public class QueueUsingStacks {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public QueueUsingStacks(){
        stackEnqueue=new Stack<>();
        stackDequeue=new Stack<>();
    }

    public void enqueue(int value){
        stackEnqueue.push(value);
    }

    public int dequeue(){
        if(stackDequeue.isEmpty()){
            if(stackEnqueue.isEmpty()){
                return -1;
            }
            while(!stackEnqueue.isEmpty()){
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.pop();
    }

    public boolean isEmpty(){
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }
    public int peak(){
        if(stackDequeue.isEmpty()){
            while(!stackEnqueue.isEmpty()){
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if(stackDequeue.isEmpty()){
            return -1;
        }
        return stackDequeue.peek();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue=new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.peak());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }
}