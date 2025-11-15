public class Main {
    public static void main (String[] args){
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.pop();
        System.out.println("middle:"+s.findMiddle());

    }
}
