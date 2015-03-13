public class MyLinkedList{

    private LNode head;
    private LNode current;
    private int size;

    public MyLinkedList(){
	head = new LNode(0);
	size = 0;
    }

    public String toString(){
	String ans = "[ ";
        current = head;
	for (int i = 0; i < size; i++){
	    ans += current.getValue() + ", ";
	    current = current.getNext();
	}
	//ans += "]";
	return (ans.substring(0,ans.length()-1) + " ]") ;
    }

    public boolean add(int val){
	LNode temp = new LNode(val);
	if (size == 0){
	    head = temp;
	    current = head;
	}else{
	    current = head;
	    for (int i = 0; i < size; i++){
		current = current.getNext();
	    }
	    current.setNext(temp);
	}
	size++;
	return true; //always returns true unless index sucks
    }

    public void set(int index, int val){
	if (index < 0 || index >= size){
	    //index sucks
	    throw new IndexOutOfBoundsException();
	}
	current = head;
	//keep goin til ya get there
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	current.setValue(val);
    }

    public int get(int index){
	if (index < 0 || index >= size){
	    //index sucks
	    throw new IndexOutOfBoundsException();
	}
	current = head;
	//keep goin til ya get there
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int indexOf(int val){
	current = head;
	for (int i = 0; i < size; i++){
	    if (current.getValue() == val){
		return i;
	    }else{
		current = current.getNext();
	    }
	}
	//nope
	return -1;
    }

    public int remove(int index){
	if (index < 0 || index >= size){
	    //index sucks
	    throw new IndexOutOfBoundsException();
	}
	current = head;
	for (int i = 0; i < index-1; i++){
	    current = current.getNext();
	}
	//System.out.println(current.getValue());
	LNode dead = current.getNext();

	//System.out.println(dead.getValue());

	current.setNext(dead.getNext());
	size--;
	return dead.getValue();
    }

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
    }


    public static void main(String[]arg){
	MyLinkedList l = new MyLinkedList();

	//empty list
	System.out.println(l);

	l.add(3);
	System.out.println(l);

	l.add(4);
	//l.add(7);
	//l.add(8);
	//l.add(1);
	//l.add(0);
	System.out.println(l);


    }

}
