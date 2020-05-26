import java.util.concurrent.TimeUnit;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack[] stacks = new Stack[3]; //3 �����
        for (int i = 0; i < 3; i++) {
            stacks[i] = new Stack();
        }
        Queue Free = new Queue(); //5 ��������� �������
        for (int i = 1; i <= 5; i++) {
            Free.enqueue(1);
        }
        Queue Busy = new Queue(); //5 ������� �������

        Deque dec = new Deque<>();
        try {
            for (int i = 1; ; i++) {
                TimeUnit.SECONDS.sleep(1);
                switch ((int) (Math.random() * 4)) {
                    case 0: //���������� � �����
                        System.out.println(
                                 i + ". �������� ��������� � ����������... (box1:" + stacks[0].getSize()+
                                                                                     " box2:" + stacks[1].getSize()+
                                                                                     " box3:" + stacks[2].getSize()+
                                                                                     "; FR: " + Free.getSize()+
                                                                                     "; BR: " + Busy.getSize()+
                                                                                     "; �onv:"+ dec.getSize() + ")");
                        for (int j = 0; j < 3; j++) {
                            stacks[j].push(1);//��������� ���� ������� � ����� ���������
                        }
                        System.out.println("   �������� � ��������� ����������.");
                        break;
                    case 1: //���� � ������ � ���� ������
                        System.out.println( i + ". ���� ��������� �� �����������... (box1:" + stacks[0].getSize()+
                                                                                              " box2:" + stacks[1].getSize()+
                                                                                              " box3:" + stacks[2].getSize()+
                                                                                              "; FR: " + Free.getSize()+
                                                                                              "; BR: " + Busy.getSize()+
                                                                                              "; �onv:"+ dec.getSize() + ")");
                        if (stacks[0].getSize() == 0 || stacks[1].getSize() == 0 || stacks[2].getSize() == 0) {
                            System.out.println("   �� ������� ����� ��������(��� ���������).");
                        }
                        else
                        if (Free.dequeue() != null) {
                            for (int j = 0; j < 3; j++) {//���� ���� � ������ ����� ���� 1 �������, �� ����� ��� ��������
                                stacks[j].pop();
                            }
                            Busy.enqueue(1);
                            System.out.println( "   ����� ���� ��������.");
                        }
                        else System.out.println("   �� ������� ����� ��������(��� �������).");
                        break;
                    case 2: //������ � ������������� ��� � ����������� ������� � �������
                        System.out.println(i + ". ����������� ������� �� �����...  (box1:" + stacks[0].getSize()+
                                                                                                " box2:" + stacks[1].getSize()+
                                                                                                " box3:" + stacks[2].getSize()+
                                                                                                "; FR: " + Free.getSize()+
                                                                                                "; BR: " + Busy.getSize()+
                                                                                                "; �onv:"+ dec.getSize() + ")");
                        if (Busy.getSize() == 0) {
                            System.out.println("   �� ������� �������� ������(��� �������).");
                        } else {
                            if(((int) (Math.random() * 4)) <2){
                            dec.enqueueFirst(1);
                                System.out.println("������ � ������");}
                            else {dec.enqueueLast(1);System.out.println("������ � �����");}
                            Free.enqueue(1);
                            System.out.println("   ������ �������� �� �������.");
                        }
                        break;
                    case 3: //�������� � ������
                        System.out.println( i + ". �������� ������� � ������...  (box1:" + stacks[0].getSize()+
                                                                                             " box2:" + stacks[1].getSize()+
                                                                                             " box3:" + stacks[2].getSize()+
                                                                                             "; FR: " + Free.getSize()+
                                                                                             "; BR: " + Busy.getSize()+
                                                                                             "; �onv:"+ dec.getSize() + ")");
                        if (dec.getSize() == 0) {
                            System.out.println("   �� ������� ��������� ������ � ������(��� �������).");
                        } else {
                            if (dec.getSize() == 1) {
                                dec.dequeueFirst();
                                System.out.println("   1 ����� �������� � ������.");
                            } else {
                                dec.dequeueFirst();
                                dec.dequeueLast();
                                System.out.println("   2 ������ ��������� � ������.");
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
