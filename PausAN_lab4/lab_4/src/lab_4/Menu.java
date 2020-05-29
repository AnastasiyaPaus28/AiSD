package lab_4;
//import java.util.Locale;
import java.util.Scanner;

public class Menu {//класс меню
  Sorts sorty;//содержит обьект по класу Array

  void printMenu() {Scanner in = new Scanner(System.in);

	System.out.println("Введите количество элементов массива:");
	int size = in.nextInt();

	int[] mas = sorty.random(size);
	System.out.println("Массив задается рандомно:");
	sorty.Sorts(mas,mas.length);

	System.out.println("----------------------------");
	System.out.println("Массив упорядочен по возврастанию:");
	sorty.Sorts(mas,mas.length);

	System.out.println("----------------------------");
	System.out.println("Массив упорядочен по убыванию:");
	sorty.reverse(mas);

	sorty.Sorts(mas,mas.length);
     
  }

  
  


  void consoleMenu() {//забирает из консоли пункт меню
      printMenu();
      Scanner scanner = new Scanner(System.in);
            
  }


}

