#include <iostream>
using namespace std;
class Heap {
    int* mas;//массив куча
    int d=3;
    int size;
    void swap(int i, int j) {
        int tmp = mas[i];
        mas[i] = mas[j];
        mas[j] = tmp;
    }
    //при добавлении элемента переделываем кучу
    void shiftUp(int i) {

        while (i > 0) {
            if (mas[i] < mas[(int)floor((i - 1) / d)]) {
                swap(i, (int)floor((i - 1) / d));     
            }
            i--;
        }
    }
    //при удалении элемента переделываем кучу
    void shiftDown(int i) {

        while (i * d + 1 < size - 1) {

            int minOfHeap = mas[i * d + 1];//минимальный элемент массива
            int j = i * d + 1;
            for (int r = 2; r <= d; r++) {
                if (mas[i * d + r] < minOfHeap) {
                    minOfHeap = mas[i * d + r];
                    j = i * d + r;
                }
            }
           
            if (mas[i] > mas[j] && j < size) {
				swap(i, j);
            }
            i = j;
           
        }
    }
    //заполнение кучи
    void setHeap(int* m) {
        for (int i = 0; i < size; i++) {
            mas[i] = m[i];
            shiftUp(i);
        }
    }
public:
    Heap(int* mas, int d, int s) {
        this->d = d;
        size = s;
        this->mas = new int[size];
        setHeap(mas);
    }
    ~Heap() {
    };
   
    void print(const string& str, int n, bool temp)//Вывод
    {
        if (n < size)
        {
            cout << str;        cout << "|_:" << mas[n] << std::endl;
            for (int i = 1; i < d; i++) {
                if (temp)      print(str + "|   ", d * n + i, true);
                else           print(str + "    ", d * n + i, true);
            }
            if (temp)      print(str + "|   ", d * n + d, false);
            else           print(str + "    ", d * n + d, false);
        }
    }
  
    //вставка произвольного нового элемента в кучу
    void insert(int element) {
        mas[size] = element;
        shiftUp(size);
        size++;
    }
    //удалить элемент с минимальным ключом из кучи
    void delete_min() {
        swap(0, size - 1);
        size--;
        shiftDown(0);
    }  

};
int main() {
    int sizeOfHeap;
    int insertElement;
    setlocale(LC_ALL, "ru");
    cout << "Введите размер кучи:" << endl;
    cin >> sizeOfHeap;
    cout << "Введите кучу:" << endl;
    int* mas = new int[sizeOfHeap];
    for (int i = 0; i < sizeOfHeap; i++) {
        cin >> mas[i];
    }
    
    Heap heap(mas, 3, sizeOfHeap);
    heap.print("", 0, false);
	cout << "Удалили минимальный элемент" << endl;
    heap.delete_min();
    cout << endl;
	heap.print("", 0, false);
    cout << endl;
    cout << "Введите элемент, который хотите вставить:" << endl;
    cin >> insertElement;
    heap.insert(insertElement);
    cout << endl;
	heap.print("", 0, false);
    cout << endl;
	cout << endl;
	system("pause");
    return 0;
}
