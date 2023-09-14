import java.util.Scanner;

class QuickSort {

    public static void main(String[] args) {
        Scanner ip= new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = ip.nextInt();

        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arr["+i+"] :" );
            arr[i] = ip.nextInt();
        }

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); //sub-array left to the pivot
            quickSort(arr, pivotIndex + 1, high); //sub-array right to the pivot
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choose the leftmost element as the pivot
        int left = low + 1;
        int right = high;

        while (true) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left < right) { // execute left and right are in order
                // Swap arr[left] and arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else { // execute left and right are crosses each other (i.e going outside of the outer while)
            
                break; 
            }
        }

        // Swap pivot (arr[low]) with arr[right] (i.e placing pivot element in correct position)
        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;

        return right;
    }
}
