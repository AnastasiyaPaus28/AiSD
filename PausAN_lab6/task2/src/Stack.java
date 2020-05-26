public class Stack<T> {
    Integer top = -1;
    private LinkedList<T> li = new LinkedList<>();

    //���������� � �������
    public void push(T data) {
        top++;
        li.addFirst(data);
    }
    //�������� ����������
    public T pop() {
        if (li.first == null) return null;
        else{
            top--;
            return li.deleteFirst();
        }
    }
    //���������� ������� ��������
    public T peek() {
        if (li.first == null) return null;
        return li.first.data;
    }

    public Integer getSize(){

        return top + 1;
    }
    //�������� �� �������
    public boolean isEmpty() {
        return li.first == null;
    }
    @Override
    public String toString() {
        if (li.isEmpty()){
            return "empty";
        }
        return li.toString();
    }
}