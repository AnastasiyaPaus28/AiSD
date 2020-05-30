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
            System.out.println("    0. Выход");
            System.out.println("Базовые операции:");
            System.out.println("    1. Добавление узла");
            System.out.println("    2. Поиск узла");
            System.out.println("    3. Удаление(левое) узла");
            System.out.println("    4. Удаление(правое) узла");
            System.out.println("Обход дерева:");
            System.out.println("    5. Прямой");
            System.out.println("    6. Обратный");
            System.out.println("    7. Симметричный");
            System.out.println("Методы для определения: ");
            System.out.println("    8. Глубины");
            System.out.println("    9. Высоты");
            System.out.println("    10. Уровня узла");
            System.out.println("11. Вывод дерева");
            switch (scan.nextInt()){
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    System.out.println("Введите элемент:");
                    tre.add(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Введите элемент для поиска:");
                    Tree.Node node= tre.search(scan.nextInt());
                    if(node==null)
                        System.out.println("Узел не найден!");
                    else
                    node.print("",node.getKey()+"",true);
                    break;
                case 3:
                    System.out.println("Введите элемент для удаления:");
                    tre.LeftDelete(scan.nextInt());
                    break;
                case 4:
                    System.out.println("Введите элемент для удаления:");
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
                    System.out.println("Введите элемент:");
                    int depth=tre.Glubina(scan.nextInt());
                    if(depth==-1)
                    System.out.println("Узел не найден!");
                    else System.out.println(depth);
                    break;
                case 9:
                    System.out.println("Введите элемент:");
                    int height= tre.height(scan.nextInt());
                    if(height==-1)
                        System.out.println("Узел не найден!");
                    else System.out.println(height);
                    break;
                case 10:
                    System.out.println("Введите элемент:");
                    int level=tre.level(scan.nextInt());
                    if(level==-1)
                        System.out.println("Узел не найден!");
                    else System.out.println(level);
                    break;
                case 11:
                    tre.print();
                    break;

            }

        }

    }

}
