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
        doubleLinkedList.deleteFirst();
        System.out.println("remove from the beginning");
    }
    //удаляет из конца
    void  dequeueLast() {
        doubleLinkedList.deleteLast();
        System.out.println("remove from end");
    }
    //возвращаем последний номер последнего элемента + 1 - размер стека
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



