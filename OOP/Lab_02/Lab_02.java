import java.util.Scanner;
import java.math.BigDecimal;

public class NguyenHuynhAnhKhoa_522H0046_B2 {

	public static void menu() {
		System.out.println("0. exit program");
		System.out.println("1. find the maximum value of an array");
		System.out.println("2. find the minimum value of an array");
		System.out.println("3. sum all even numbers of an array");
		System.out.println("4. count how many specific elements are in an array");
		System.out.println("5. count how many prime numbers are in an array");
		System.out.println("6. to find the index of an element k in an array");
		System.out.println("7. square all elements of an array");
		System.out.println("8. maximum value of a BigDecimal object array");
		System.out.println("9. find the elements divisible by k in an array");
		System.out.println("10. find the third largest element in an array");
	}
	
	public static int findMax(int a[], int n) {
		
		int max_num = a[0];
		
		for (int i = 0; i < n; i++) {
			if (a[i] > max_num) {
				max_num = a[i];
			} 
		}
		return max_num; 
	}

	public static int findMin(int a[],int n)
	{
		int temp = a[0];
		for(int i =1;i<n;i++)
		{	
			temp = a[0];
			if(a[i] < temp)
			{
				temp = a[i];
			}	
		}
		return temp;
	}
	
	public static int sumEven(int a[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] % 2 == 0) {
				sum += a[i];
			}
		}
		return sum;
	}

	public static int specificElements(int a[], int n, int k)
	{
		int count=0;
		for(int i =0;i<n;i++)
		{
			if(a[i]==k)
			{
				count++;
			}
		}
		return count;
	}

	public static int find ( int a[], int n, int k)
	{
		for(int i =0;i<n;i++)
		{
			if(a[i] ==k)
			{
				return i;
			}
		}
		return -1;
	}

	public static int isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if ( n % i == 0) {
				return 0;
			}
		}
		return 1;
	}
	
	public static int countPrime(int a[], int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(a[i]) == 1) {
				count ++;
			}
		}
		return count;
	}
	
	public static void squareNum (int a[], int n) {
		for (int i = 0; i < n; i++) {
			a[i] = (int)Math.pow(a[i],2);
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
	}



	public static void divisibleNumbers(int a[],int n, int k)
	{
		Scanner sc = new Scanner(System.in);
		int count=1;
		for(int i = 0;i<n;i++)
		{
			if(a[i]%k==0)
			{
				count++; 
			}
		}
		int [] b = new int[count];
		for (int i =0;i<n;i++)
		{
			if(a[i]%k==0)
			{
				for(int j =0;j<count;j++)
				{
					b[j] = sc.nextInt(); 
				}
			}
		}
		for(int i =0;i<count;i++)
		{
		System.out.print(b[i]+" ");
		}
	}
	
	public static int thirdLargestNumber(int a[],int n)
	{
		for(int i =0;i<n;i++)
		{
			for(int j= i+1;j<n;j++)
			{
				if(a[i]<a[j])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a[2];
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Nhap so phan tu cua mang: ");
			n = sc.nextInt();
		} while (n < 0);
		
		int [] arr = new int[n];
		System.out.println("Nhap vao cac phan tu cho mang:");
		for (int i = 0; i < n; i++) {
			System.out.print("Nhap vao phan tu thu " + (i + 1) + ": ");
			arr[i] = sc.nextInt();
		}

		System.out.println("Nhap vao phan tu k:");
		int k = sc.nextInt();

		
		do {
			menu();
		
			System.out.println("Nhap vao lua chon: ");
			int userChoice = sc.nextInt();

			switch (userChoice) {
				case 0:
					return;
				case 1:
					System.out.println("the maximum value of an array: " + findMax(arr, n));
					break;
				case 2:
					System.out.println("the minimum value of an array: " + findMin(arr, n));
					break;
				case 3:
					System.out.println("sum all even numbers of an array: " + sumEven(arr, n));
					break;
				case 4:
					System.out.println(" number of specific elements are in an array: " + specificElements(arr, n, k));
					break;
				case 5:
					System.out.println("number of prime numbers are in an array: " + countPrime(arr, n));
					break;
				case 6:
					System.out.println("index of an element " + k + ": " + find(arr, n, k));
					break;
				case 7:
					System.out.println("square all elements of an array: ");
					squareNum(arr, n);
					break;
				case 8:
					
					break;
				case 9:
					System.out.println("the elements divisible by" + k + ": ");
					divisibleNumbers(arr, n, k);
					break;
				case 10:
					System.out.println("square all elements of an array: " + thirdLargestNumber(arr, n));
					break;
			}	
		} while (true);
	}
}









