public class Queue<T> {
    Integer top = -1; 
    LinkedLiist<T> li = new LinkedLiist<>();
    public Queue() {
        li.first = li.last = null;
    }
    //добавление
    void enqueue(T data) {
        top++;
        li.addLast(data);
    }
    //удаление с начала
    T dequeue() {
        if(!li.isEmpty()){
            T first = li.first.data;
            li.deleteFirst();
            top--;
            return first;
        }
        else return null;
    }
    public Integer getSize(){
        return top+1;
    }
    T peek() {
        if (li.isEmpty()) return null;
        return li.first.data;
    }
    //проверка на пустоту
    public boolean isEmpty() {
        return li.last == null;
    }
    @Override
    public String toString() {
        return li.toString();
    }
}
