package laba5;


import java.util.ArrayList;
import java.util.Collections;

class file {
    public ArrayList<Integer>[] file;

    file(int series) {
        file = new ArrayList[series];
        for (int i = 0; i < series; i++){
            file[i] = new ArrayList<>();
        }
    }

    void add(int series, int value){
        file[series].add(value);
    }

    int length(){
        return file.length;
    }

    void output(){
        for(int i = 0; i < file.length; i++){
            for(Integer s : file[i]) {
                System.out.print(" " + s + " ");
            }
            System.out.print(" : ");
        }
        System.out.println();
    }

    file drain(file file1, file file2, file file3){
        int size = 0;
        int start = 0;
        for(int i = 0; i < file2.length(); i++){
            if(!file2.file[i].isEmpty()) size++;
            if(file2.file[i].isEmpty()) start++;
            if(i != file2.length() - 1)
            if(!file2.file[i].isEmpty() && file2.file[i+1].isEmpty()){
                break;
            }
        }

        for(int i = 0; i < size; i++) {   // исключая пустые
            for (int j = 0; j < file1.file[i].size(); j++) {
                file3.add(i, file1.file[i].get(j));
                file1.file[i].remove(j);
                j--;
            }
        }

        for(int i = start; i < file2.length(); i++) {
            for(int j = 0; j < file2.file[i].size(); j++) {
                file3.add(i - start, file2.file[i].get(j));
                file2.file[i].remove(j);
                j--;
            }
        }
        for (int i = 0; i < file3.length(); i++){
            Collections.sort(file3.file[i]);
        }

        return file3;
    }

    boolean Empty(){
        for(int i = 0; i < file.length; i++)
            if(!file[i].isEmpty())
                return false;
        return true;
    }
}

