package lab_4;
import java.util.Scanner;
public class Sorts {	
		static private long time = 0;
		static private int compare = 0;
		static private int swap = 0;

		/*public static void main(String[] args) {

			Scanner in = new Scanner(System.in);

			System.out.println("Введите количество элементов массива:");
			int size = in.nextInt();

			int[] mas = random(size);
			System.out.println("Массив задается рандомно:");
			Sorts(mas);

			System.out.println("----------------------------");
			System.out.println("Массив упорядочен по возврастанию:");
			Sorts(mas);

			System.out.println("----------------------------");
			System.out.println("Массив упорядочен по убыванию:");
			reverse(mas);

			Sorts(mas);
			in.close();
		}
*/
		static void Sorts(int[] mas, int n) {
			System.out.println("Сортировка выбором:");
			long start1 = System.currentTimeMillis();
			SVibor(mas);
			time = System.currentTimeMillis() - start1;
			vivod();

			System.out.println();
			
            System.out.println("Сортировка вставкой:");
            long start2 = System.currentTimeMillis();
			SVstavka(mas);
			time = System.currentTimeMillis() - start2;
			vivod();

			System.out.println();
			
			System.out.println("Сортировка обменом:");
			long start3 = System.currentTimeMillis();
			SObmen(mas);
			time = System.currentTimeMillis() - start3;
			vivod();
			

			System.out.println();

			System.out.println("Быстрая сортировка:");
			long start4 = System.currentTimeMillis();
			SFast(mas);
			time = System.currentTimeMillis() - start4;
			vivod();

			System.out.println();

			System.out.println("Поразрядная сортировка:");
			long start5 = System.currentTimeMillis();
			PSSort(mas, mas.length);
			time = System.currentTimeMillis() - start5;
			vivod();

			System.out.println();

			
		}

		static void reverse(int[] mas) {
			for (int i = 0; i <= (mas.length - 1) / 2; i++) {
				int temp = mas[mas.length - 1 - i];
				mas[mas.length - 1 - i] = mas[i];
				mas[i] = temp;
			}
		}

		static private void vivod() {
			System.out.println("Время работы в миллисекундах: " + time);
			System.out.println("Количество сравнений: " + compare);
			System.out.println("Количество обменов: " + swap);
		}

		static int[] random(int size) {
			int[] mas = new int[size];

			for (int i = 0; i < mas.length; i++)
				mas[i] = (int) (Math.random() * 1000);
			return mas;
		}
		
		static private void SObmen(int[] mas) {
			int[] masn = mas.clone();
			compare = 0;
			swap = 0;
			for (int i = masn.length - 1; i >= 1; i--)
				for (int j = 0; j < i; j++) {
					compare++;
					if (masn[j] > masn[j + 1]) {
						int temp = masn[j];
						masn[j] = masn[j + 1];
						masn[j + 1] = temp;
						swap++;
					}
				}
		}

		static private void SVstavka(int[] mas) {
			int[] masn = mas.clone();
			compare = 0;
			swap = 0;
			int k;
	        int i, j;

	        for (i = 0; i < masn.length; i++) {
	            k = masn[i];
	            compare++;
	            for (j = i - 1; j >= 0 && masn[j] > k; j--) {
	            	compare++;
	                masn[j + 1] = masn[j];
	                }
	            masn[j + 1] = k;
	            swap++;
	        }
	    }         
			

		static private void SVibor(int[] mas) {
			int[] masn = mas.clone();
			int k;
			int element;
			compare = 0;
			swap = 0;
			for (int i = 0; i < masn.length; i++) {
				k = i;
				element = masn[i];
				for (int j = i + 1; j < masn.length; j++) {
					compare++;
					if (masn[j] < element) {
						k = j;
						element = masn[j];
					}
				}
				swap++;
				masn[k] = masn[i];
				masn[i] = element;
			}
		}

		static private void SFast(int[] mas) {
			compare = 0;
			swap = 0;
			fast(mas, 0, mas.length - 1);
		}

		static private void fast(int[] mas, int b, int e) {
			int l = b, r = e;
			int piv = mas[(l + r) / 2];
			while (l <= r) {
				compare++;
				while (mas[l] < piv) {
					compare++;
					l++;
				}
				compare++;
				while (mas[r] > piv) {
					compare++;
					r--;
				}
				if (l <= r) {
					int temp = mas[l];
					mas[l] = mas[r];
					mas[r] = temp;
					swap++;
					l++;
					r--;
				}
			}
			if (b < r)
				fast(mas, b, r);
			if (e > l)
				fast(mas, l, e);
		}
		
		static int POW(int l) {
		    int ans = 1;
		    for (int i = 0; i < l; ++i) {
		        ans *= 10;
		    }
		    return ans;
		}
		static private void PSSort(int[] mas, int n) {
			swap = 0;
			compare = 0;
			    int max = Math.abs(mas[0]);

			    for (int i = 1; i < n; ++i) { // Ищем количество разрядов
			    	compare++;
			        if (mas[i] > max)
			            max = mas[i];
			    }
			    int k = 0;
			    while (max != 0) {
			        max = max / 10;
			        ++k;
			       
			    }

			    int [][] dopmas = new int [n+1][n+1]; //Создаем двумерный массив для хранения разрядов
			    for (int i = 0; i < n+1; ++i)
			        dopmas[i] = new int[10];


			    int kol = 1; //Количество итераций
			    int num;
			    int buf;
			    while (kol <= k) {
			        num = 0;
			        while (num < n) { // Заполнение дополнитеьного массива
			        	compare++;
			            if (mas[num] < POW(kol-1)) {
			                buf = 0;
			                
			            }
			            else {
			                buf = (mas[num] % POW(kol)) / POW(kol - 1);
			            }
			                dopmas[dopmas[n][buf]][buf] = mas[num];
			                dopmas[n][buf]++;
			                num++;
			        }
			        num = 0;
			        int j = 0;

			        while  (num < n) { // Перезапись массива
			   
			            int i = 0;
			            if (dopmas[n][j] == 0) {
			                ++j;
			            }
			            else {
			                while (dopmas[n][j] > 0) {
			                	swap++;
			                    mas[num] = dopmas[i][j];
			                    ++i;
			                    --dopmas[n][j];
			                    ++num;
			                }
			            }
			        }
			        ++kol;
			    }
			    
			
			
		}
	}


