import java.util.Arrays;

public class Main {

    static int searchCount;
    static int linearSearchCount;
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};


        int searchValue = 9;
        int index = linearSearch(nums, searchValue);

        int searchValue2 = 9;
        int index2 = IoPSearch(nums, searchValue);

        System.out.println(Arrays.toString(nums));
        System.out.println("linear Search: " + searchValue + " is in index " + index + " || Search Count: " + linearSearchCount);
        System.out.println(Arrays.toString(nums));
        System.out.println("Twin Linear Search: " + searchValue2 + " is in index " + index2 + " || Search Count: " + searchCount);
    }
    private static int linearSearch(int[] nums, int value){
        linearSearchCount = 0;
        for (int i = 0; i < nums.length; i++){
            linearSearchCount++;
            if(value == nums[i]){
                return i;
            }

        }
        return -1;
    }

    private static int IoPSearch(int[] nums, int value){
        int start = 0;
        int end = nums.length - 1;
        searchCount = 0;
        while (start <= end) {
            searchCount++;
            if(nums[start] == value){
                return start;
            }
            if(nums[end] == value){
               return end;
            }

            start++;
            end--;
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int value){
         int start = 0;
         int end = nums.length - 1;

         while (start <= end){
             int middle = (start + end) / 2;

             if (value == nums[middle]){
                 return middle;
             }
             else if (value < nums[middle]) {
                 end = middle - 1;

             }
             else if (value > nums[middle]){
                start = middle + 1;
             }

         }
         return -1;
    }
}
