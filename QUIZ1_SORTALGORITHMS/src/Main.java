public class Main {
    public static void main(String[] args) {
        int[] numbers1 = {25, -3, 5, 10, 38, 62, 20, -8, 173, 65};
        int[] numbers2 = numbers1.clone(); // Cloned the array numbers2 is just numbers1 in its entirety

        // Before sorting
        System.out.print("OG Array: ");
        printArrayElements(numbers1);

        // Bubble Sort (Descending Edition)
        bubbleSort(numbers1);
        System.out.print("\nAfter Bubble Sort (Descending):  ");
        printArrayElements(numbers1);

        // Selection Sort (Finding smallest and placing at the end)
        selectionSort(numbers2);
        System.out.print("\nAfter Selection Sort (Smallest to End): ");
        printArrayElements(numbers2);
    }

    private static void bubbleSort(int[] nums) {
        for (int unsortedPartitionIndex = nums.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            for (int i = 0; i < unsortedPartitionIndex; i++) {
                if (nums[i] < nums[i + 1]) { // literally just changed the direction of the "sideways v" (inequality sign)
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] nums) {
        for (int lastUnsortedIndex = nums.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int smallest = 0;

            // Find the smallest element
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (nums[i] < nums[smallest]) { // change sign and a couple of variable & statement name changes to make sense
                    smallest = i;
                }
            }

            // Swap smallest element with last unsorted index
            if (smallest != lastUnsortedIndex) {
                int temp = nums[smallest];
                nums[smallest] = nums[lastUnsortedIndex];
                nums[lastUnsortedIndex] = temp;
            }
        }
    }

    private static void printArrayElements(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}