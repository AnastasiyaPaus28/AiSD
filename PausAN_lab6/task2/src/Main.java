import java.util.concurrent.TimeUnit;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack[] stacks = new Stack[3]; //3 ящика
        for (int i = 0; i < 3; i++) {
            stacks[i] = new Stack();
        }
        Queue Free = new Queue(); //5 свободных роботов
        for (int i = 1; i <= 5; i++) {
            Free.enqueue(1);
        }
        Queue Busy = new Queue(); //5 занятых роботов

        Deque dec = new Deque<>();
        try {
            for (int i = 1; ; i++) {
                TimeUnit.SECONDS.sleep(1);
                switch ((int) (Math.random() * 4)) {
                    case 0: //добавление в ящики
                        System.out.println(
                                 i + ". Доставка продуктов в контейнеры... (box1:" + stacks[0].getSize()+
                                                                                     " box2:" + stacks[1].getSize()+
                                                                                     " box3:" + stacks[2].getSize()+
                                                                                     "; FR: " + Free.getSize()+
                                                                                     "; BR: " + Busy.getSize()+
                                                                                     "; Сonv:"+ dec.getSize() + ")");
                        for (int j = 0; j < 3; j++) {
                            stacks[j].push(1);//добавляет один продукт в любой контейнер
                        }
                        System.out.println("   Продукты в контейнер доставлены.");
                        break;
                    case 1: //сбор с ящиков и уход робота
                        System.out.println( i + ". Сбор продуктов из контейнеров... (box1:" + stacks[0].getSize()+
                                                                                              " box2:" + stacks[1].getSize()+
                                                                                              " box3:" + stacks[2].getSize()+
                                                                                              "; FR: " + Free.getSize()+
                                                                                              "; BR: " + Busy.getSize()+
                                                                                              "; Сonv:"+ dec.getSize() + ")");
                        if (stacks[0].getSize() == 0 || stacks[1].getSize() == 0 || stacks[2].getSize() == 0) {
                            System.out.println("   Не удалось взять продукты(нет продуктов).");
                        }
                        else
                        if (Free.dequeue() != null) {
                            for (int j = 0; j < 3; j++) {//если есть в каждом ящике хоть 1 элемент, то робот его забирает
                                stacks[j].pop();
                            }
                            Busy.enqueue(1);
                            System.out.println( "   Робот взял продукты.");
                        }
                        else System.out.println("   Не удалось взять продукты(нет роботов).");
                        break;
                    case 2: //приход в сортировочный цех и становление обратно в очередь
                        System.out.println(i + ". Складывание салатов на ленту...  (box1:" + stacks[0].getSize()+
                                                                                                " box2:" + stacks[1].getSize()+
                                                                                                " box3:" + stacks[2].getSize()+
                                                                                                "; FR: " + Free.getSize()+
                                                                                                "; BR: " + Busy.getSize()+
                                                                                                "; Сonv:"+ dec.getSize() + ")");
                        if (Busy.getSize() == 0) {
                            System.out.println("   Не удалось положить салаты(нет роботов).");
                        } else {
                            if(((int) (Math.random() * 4)) <2){
                            dec.enqueueFirst(1);
                                System.out.println("Сейчас в начало");}
                            else {dec.enqueueLast(1);System.out.println("Сейчас в конец");}
                            Free.enqueue(1);
                            System.out.println("   Салаты положены на конвеер.");
                        }
                        break;
                    case 3: //погрузка в машину
                        System.out.println( i + ". Погрузка салатов в машину...  (box1:" + stacks[0].getSize()+
                                                                                             " box2:" + stacks[1].getSize()+
                                                                                             " box3:" + stacks[2].getSize()+
                                                                                             "; FR: " + Free.getSize()+
                                                                                             "; BR: " + Busy.getSize()+
                                                                                             "; Сonv:"+ dec.getSize() + ")");
                        if (dec.getSize() == 0) {
                            System.out.println("   Не удалось погрузить салаты в машину(нет салатов).");
                        } else {
                            if (dec.getSize() == 1) {
                                dec.dequeueFirst();
                                System.out.println("   1 салат загружен в машину.");
                            } else {
                                dec.dequeueFirst();
                                dec.dequeueLast();
                                System.out.println("   2 салата загружено в машину.");
                            }
                        }
                        break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
