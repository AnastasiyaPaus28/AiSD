package lab_4;
//import java.util.Locale;
import java.util.Scanner;

public class Menu {//����� ����
  Sorts sorty;//�������� ������ �� ����� Array

  void printMenu() {Scanner in = new Scanner(System.in);

	System.out.println("������� ���������� ��������� �������:");
	int size = in.nextInt();

	int[] mas = sorty.random(size);
	System.out.println("������ �������� ��������:");
	sorty.Sorts(mas,mas.length);

	System.out.println("----------------------------");
	System.out.println("������ ���������� �� ������������:");
	sorty.Sorts(mas,mas.length);

	System.out.println("----------------------------");
	System.out.println("������ ���������� �� ��������:");
	sorty.reverse(mas);

	sorty.Sorts(mas,mas.length);
     
  }

  
  


  void consoleMenu() {//�������� �� ������� ����� ����
      printMenu();
      Scanner scanner = new Scanner(System.in);
            
  }


}

