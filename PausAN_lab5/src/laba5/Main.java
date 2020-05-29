package laba5;


public class Main {

    private static int[] Fibonachi(int length) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 2;
        System.out.print(n0 + " " + n1 + " ");
        for (int i = 3; i <= length; i++) {
            n2 = n0 + n1;
            System.out.print(n2 + " ");
            if (n2 - length < 0) {
                n0 = n1;
                n1 = n2;
            } else {
                break;
            }
        }
        System.out.println();
        return new int[]{n0, n1, n2};
    }

    private static void output(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + i + "] = " + arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int length = 70;//меняем количество элементов

        int[] arr = new int[length];   // исходный массив

        for (int i = 0; i < length; i++)
            arr[i] = (int) (Math.random() * 50 + 1); //заполнили рандомными целыми числами
        output(arr);

        int[] n = Fibonachi(arr.length);

        System.out.println(n[2] + " = " + n[1] + " + " + n[0]);
        int empty = n[2] - arr.length;
        System.out.println("пустых" + " = " + empty);
        file[] obj = new file[3];
        obj[0] = new file(n[1]);
        obj[1] = new file(n[0]);
        obj[2] = new file(n[0]);

        int j = 0;
       // time
        for (int i = empty; i < obj[0].length(); i++, j++)
            obj[0].add(i, arr[i]);

        for (int i = 0; i < obj[1].length(); i++, j++)
            obj[1].add(i, arr[j]);


        System.out.println("start:");
        System.out.print("file1: ");
        obj[0].output();
        System.out.print("file2: ");
        obj[1].output();
        System.out.print("file3: ");
        obj[2].output();
        int notEmpty = 3;
        int step = 1;
        int x = 2;
        int y = 1;
        int z = 0;
        
        while (notEmpty != 1) {
            obj[x] = obj[x].drain(obj[z], obj[y], obj[x]);

            x--;
            if (x == -1)
                x = 2;

            z--;
            if (z == -1)
                z = 2;

            y--;
            if (y == -1)
                y = 2;

            System.out.println(step + " проход:");
            step++;
            System.out.print("file1: ");
            obj[0].output();
            System.out.print("file2: ");
            obj[1].output();
            System.out.print("file3: ");
            obj[2].output();

            notEmpty = 0;
            for (int i = 0; i < 3; i++)
                if (!obj[i].Empty())
                    notEmpty++;

        }
    }
}

