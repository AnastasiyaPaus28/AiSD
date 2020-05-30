//https://github.com/AnastasiyaPaus28/AiSD
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree tre = new Tree();
        tre.add(8);
        tre.add(3);
        tre.add(10);
        tre.add(1);
        tre.add(6);
        tre.add(14);
        tre.add(2);
        tre.add(4);
        tre.add(7);
        tre.add(13);
        tre.print();

        Scanner scan=new Scanner(System.in);
        while (true){
            System.out.println("    0. �����");
            System.out.println("������� ��������:");
            System.out.println("    1. ���������� ����");
            System.out.println("    2. ����� ����");
            System.out.println("    3. ��������(�����) ����");
            System.out.println("    4. ��������(������) ����");
            System.out.println("����� ������:");
            System.out.println("    5. ������");
            System.out.println("    6. ��������");
            System.out.println("    7. ������������");
            System.out.println("������ ��� �����������: ");
            System.out.println("    8. �������");
            System.out.println("    9. ������");
            System.out.println("    10. ������ ����");
            System.out.println("11. ����� ������");
            switch (scan.nextInt()){
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    System.out.println("������� �������:");
                    tre.add(scan.nextInt());
                    break;
                case 2:
                    System.out.println("������� ������� ��� ������:");
                    Tree.Node node= tre.search(scan.nextInt());
                    if(node==null)
                        System.out.println("���� �� ������!");
                    else
                    node.print("",node.getKey()+"",true);
                    break;
                case 3:
                    System.out.println("������� ������� ��� ��������:");
                    tre.LeftDelete(scan.nextInt());
                    break;
                case 4:
                    System.out.println("������� ������� ��� ��������:");
                    tre.RightDelete(scan.nextInt());
                    break;
                case 5:
                   System.out.println( tre.PrObhod(tre.getRoot()));
                    break;
                case 6:
                    System.out.println( tre.ObrObhod(tre.getRoot()));
                    break;
                case 7:
                    System.out.println( tre.SymObhod(tre.getRoot()));
                    break;
                case 8:
                    System.out.println("������� �������:");
                    int depth=tre.Glubina(scan.nextInt());
                    if(depth==-1)
                    System.out.println("���� �� ������!");
                    else System.out.println(depth);
                    break;
                case 9:
                    System.out.println("������� �������:");
                    int height= tre.height(scan.nextInt());
                    if(height==-1)
                        System.out.println("���� �� ������!");
                    else System.out.println(height);
                    break;
                case 10:
                    System.out.println("������� �������:");
                    int level=tre.level(scan.nextInt());
                    if(level==-1)
                        System.out.println("���� �� ������!");
                    else System.out.println(level);
                    break;
                case 11:
                    tre.print();
                    break;

            }

        }

    }

}
