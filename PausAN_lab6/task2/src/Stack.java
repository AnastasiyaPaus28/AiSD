public class Stack<T> {
    Integer top = -1;
    private LinkedList<T> li = new LinkedList<>();

    //добавление в вершину
    public void push(T data) {
        top++;
        li.addFirst(data);
    }
    //удаление последнего
    public T pop() {
        if (li.first == null) return null;
        else{
            top--;
            return li.deleteFirst();
        }
    }
    //извлечение первого элемента
    public T peek() {
        if (li.first == null) return null;
        return li.first.data;
    }

    public Integer getSize(){

        return top + 1;
    }
    //проверка на пустоту
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