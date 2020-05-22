#include <iostream>
#include <fstream>
#include <time.h>
#include <Windows.h>
using namespace std;

typedef int T;
typedef int hashTableIndex;
int hashTableSize;
T* hashTable;//массив - хеш-таблица
bool* used;//массив - занято или нет
int c = 2;//константы для квадратичного опробования
int d = 3;
//переменные для подсчета времени
clock_t  startedFirstHundred;
clock_t  endedFirstHundred; 
clock_t  start;            
clock_t  max = -2;       
clock_t  startFind;     
clock_t  timeOfFind;       
//хеш-функция размещения величины - остаток от деления
hashTableIndex myhash(T data) {
    return (data % hashTableSize);
}
//функция поиска местоположения и вставки величины в таблицу
void insertData(T data) {
    hashTableIndex bucket;
    int j = 0;
metka:
    bucket = myhash(data) + c * j + d * j * j;
point:
    if (used[bucket] == 0) {
        hashTable[bucket] = data;
        used[bucket] = 1;
    }
    else {
        j++;
        if (myhash(data) + c * j + d * j * j > hashTableSize) {
            bucket = (myhash(data) + c * j + d * j * j) % hashTableSize;
            j = 0;
            goto point;
        }
        goto metka;
    }
}
//функция поиска величины, равной указанному числу
int findData(T data) {
    hashTableIndex bucket;
    int k = 0;
metka:
    bucket = myhash(data) + c * k + d * k * k;
point:
    if(hashTable[bucket] == data){
        return bucket;
    } 
    else if (used[bucket] == false) {
        return -5;
    }
    else if (hashTable[bucket] != data) {
        k++;
        if (myhash(data) + c * k + d * k * k > hashTableSize) {
            bucket = (myhash(data) + c * k + d * k * k) % hashTableSize;
            k = 0;
            goto point;
        }
        goto metka;
    }
}

int main() {
    setlocale(LC_ALL, "rus");
  
    int i, * arr, maxnum;
    cout << "Введите количество элементов : ";
    cin >> maxnum;
    cout << "Введите размер хеш-таблицы : ";
    cin >> hashTableSize;
    arr = new int[maxnum];//массив с рандомными числами
    hashTable = new T[hashTableSize];
    used = new bool[hashTableSize];
    for (i = 0; i < hashTableSize; i++) {
        hashTable[i] = 0;
        used[i] = false;
    }

    for (i = 0; i < maxnum; i++)    arr[i] = rand()*rand();
    //заполнение хеш-таблицы элементами массива
    for (i = 0; i < maxnum; i++) {
        start = clock();
        if (i == 100) { 
            startedFirstHundred = clock();
            cout << "Время заполнения первой сотни = " << (((float)(startedFirstHundred - start))/CLOCKS_PER_SEC) << endl;
        }
        if (maxnum - 100 == i) endedFirstHundred = clock();
        insertData(arr[i]);
    }
    
    cout << "Время заполнения последней сотни = " << (((float)(clock() -endedFirstHundred))/ CLOCKS_PER_SEC) << endl;


    //поиск элементов массива по хеш-таблице
    for (i = maxnum - 1; i >= 0; i--) {
        startFind = clock();
        bool x = findData(arr[i]);
        timeOfFind = clock() - startFind;
        if (timeOfFind > max)   max = timeOfFind;
    }
    cout << "Поиск(max) - время - " << (max)  << endl;
   
	/*
    cout << "Вывод в txt файлы" << endl;
    ofstream out("List.txt");
    for (i = 0; i < maxnum; i++) {
        out << arr[i];
        if (i < maxnum - 1) out << "\t";
    }
    out.close();
    //сохранение хеш-таблицы в файл HashTable.txt
    out.open("HashTable.txt");
    for (i = 0; i < hashTableSize; i++) {
        out << i << "  :  " << hashTable[i] << endl;
    }
    out.close();
    cout << endl;
	*/
    while (true) {
        cout << "Хотите осуществить поиск определенного элемента? 1 - да 2 - нет" << endl;
        int variable;
        cin >> variable;
        if (variable != 1) break;
        cout << "Введите число для поиска его в хеш-таблице" << endl;
        long long int findNumber; cin >> findNumber;
        if (findData(findNumber)!= -5) {
            cout << "findData("<<findNumber<<") нашло на позиции [" << findData(findNumber) << "]" << endl;
        }
        else cout << "findData("<<findNumber<<") не нашло" << endl;
        cout << endl;
    }

  

    return 0;
}
