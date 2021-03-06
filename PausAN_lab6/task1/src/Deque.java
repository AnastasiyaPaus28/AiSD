public class Deque<T> {
    Integer top = -1; 
    DoubleLinkedList<T> doubleLinkedList;
   
    Deque() {
        doubleLinkedList = new DoubleLinkedList<>();
          }
    //��������� � ������
    void enqueueFirst(T data) {
        top++;
        doubleLinkedList.addFirst(data);
    }
    //��������� � �����
    void enqueueLast(T data) {
        top++;
        doubleLinkedList.addLast(data);
    }

    //������� �� ������
    void  dequeueFirst() {
        doubleLinkedList.deleteFirst();
        System.out.println("remove from the beginning");
    }
    //������� �� �����
    void  dequeueLast() {
        doubleLinkedList.deleteLast();
        System.out.println("remove from end");
    }
    //���������� ��������� ����� ���������� �������� + 1 - ������ �����
    public Integer getSize(){
        return top+1;
    }
    //���������� ������� � ������
    T peekFirst() {
        return doubleLinkedList.first.data;
    }
    //���������� ��������� �������
    T peekLast() {
        return doubleLinkedList.last.data;
    }
    //�������� �� �������
    boolean isEmpty() {
        return doubleLinkedList.isEmpty();
    }
    @Override
    public String toString() {
        return doubleLinkedList.toString();
    }
}



