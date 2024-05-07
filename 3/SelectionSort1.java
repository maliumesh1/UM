Here's the provided selection sort code with detailed comments explaining each part:

```java
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort { 
    // Method to perform selection sort on an array
    public static int[] sort(int[] arr) {
        int n = arr.length; // Get the length of the array
        for (int i = 0; i < n; i++) { // Iterate through each element of the array
            int minIdx = i; // Assume the current index as the minimum index
            // Iterate through the remaining unsorted elements to find the minimum element
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) { // If a smaller element is found
                    minIdx = j; // Update the minimum index
                }
            }
            // Swap the current element with the minimum element found
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            // Print the array after each pass (optional, for visualization)
            System.out.println("Pass " + (i+1) + ": " + Arrays.toString(arr));
        }
        return arr; // Return the sorted array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt(); // Read the size of the array
        int[] arr = new int[size]; // Create an array of given size

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt(); // Read the elements of the array
        }      
        scanner.close(); // Close the scanner

        int[] sortedArr = SelectionSort.sort(arr); // Perform selection sort on the array
        // Print the sorted array
        System.out.println("Sorted array is: " + Arrays.toString(sortedArr));
    }
}
