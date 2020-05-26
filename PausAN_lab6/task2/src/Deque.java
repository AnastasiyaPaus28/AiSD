public class Deque<T> {
    Integer top = -1; 
    DoubleLinkedList<T> doubleLinkedList;
    Deque() {
        doubleLinkedList = new DoubleLinkedList<>();
       }
    //добавляет в начало
    void enqueueFirst(T data) {
        top++;
        doubleLinkedList.addFirst(data);
    }
    //добавляет в конец
    void enqueueLast(T data) {
        top++;
        doubleLinkedList.addLast(data);
    }

    //удаляет из начала
    void  dequeueFirst() {
        top--;
        doubleLinkedList.deleteFirst();
        System.out.println("удалил с начала");
    }
    //удаляет из конца
    void  dequeueLast() {
        top--;
        doubleLinkedList.deleteLast();
        System.out.println("удалил с конца");
    }
    public Integer getSize(){
        return top+1;
    }
    //возвращает элемент в начала
    T peekFirst() {
        return doubleLinkedList.first.data;
    }
    //возвращает последний элемент
    T peekLast() {
        return doubleLinkedList.last.data;
    }
    //проверка на пустоту
    boolean isEmpty() {
        return doubleLinkedList.isEmpty();
    }
    @Override
    public String toString() {
        return doubleLinkedList.toString();
    }
}



