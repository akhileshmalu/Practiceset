package Sorting;


import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 7/22/20.
 */
public class Sort2 {


//    // {5,4,3,2,1}
//    // {4,3,2,1,5}
//    private void bubbleSort(int[] nums) {
//        for(int i = 0; i < nums.length-1; i++) {
//            for (int j = 0; j < (nums.length -i - 1) ; j++) {
//                if(nums[j] > nums[j+1]) {
//                    swap(nums, j+1, j);
//                }
//            }
//            Arrays.stream(nums).forEach(System.out::print);
//            System.out.println();
//        }
//    }
//
//    private void selectionSort(int[] nums) {
//        for(int i = 0; i < nums.length-1; i++) {
//            int j = i;
//            int minVal = nums[i];
//            int minIndex = -1;
//            while (j < nums.length) {
//                if(nums[j] < minVal) {
//                    minIndex = j;
//                    minVal = nums[j];
//                }
//                j++;
//            }
//            swap(nums, minIndex, i);
//            Arrays.stream(nums).forEach(System.out::print);
//            System.out.println();
//        }
//    }
//
//    private void insertionSort(int[] num) {
//        for (int i = 1; i < num.length; i++) {
//            int temp = num[i];
//            int j = i-1;
//            while (j >= 0) {
//                if(num[j] > temp) {
//                    num[j+1] = num[j];
//                } else {
//                    break;
//                }
//                j--;
//            }
//            num[j+1] = temp;
//
//            Arrays.stream(num).forEach(System.out::print);
//            System.out.println();
//        }
//    }
//
//    private void mergeSort(int[] nums, int start, int end) {
//        if(start < end) {
//            int mid = (start + end)/2;
//            mergeSort(nums, start, mid);
//            mergeSort(nums, mid+1, end);
//            merge(nums, start, mid, end);
//        }
//    }
//
//    private void merge(int[] nums, int start, int mid, int end) {
//        // CopyOfRange Param: start is inclusive & end is exclusive;
//        int[] left = Arrays.copyOfRange(nums, start, mid + 1);
//        int[] right = Arrays.copyOfRange(nums, mid+1, end+1);
//        int i = 0, j = 0, k = start;
//        while (i < left.length && j < right.length) {
//            if(left[i] < right[j]) {
//                nums[k++] = left[i++];
//            } else {
//                nums[k++] = right[j++];
//            }
//        }
//        if(i < left.length) {
//            while(i < left.length) {
//                nums[k++] = left[i++];
//            }
//        } else if(j < right.length) {
//            while(j < right.length) {
//                nums[k++] = left[j++];
//            }
//        }
//    }
//
//    private void quickSort(int[] nums, int start, int end) {
//        if(start < end) {
//            int partition = findPartition(nums, start, end);
//            quickSort(nums, start, partition-1);
//            quickSort(nums, partition+1, end);
//            Arrays.stream(nums).forEach(System.out::print);
//            System.out.println();
//        }
//    }
//
//    private int findPartition(int[] nums, int start, int end) {
//        int pivot = nums[end];
//        int index = start;
//        for (int i = start; i < end; i++) {
//            if(nums[i] < pivot) {
//                swap(nums, index, i);
//                index++;
//            }
//        }
//        swap(nums, index, end);
//        return index;
//    }
//
//    public void swap(int[] nums, int firstIndex, int secIndex) {
//        int temp = nums[firstIndex];
//        nums[firstIndex] = nums[secIndex];
//        nums[secIndex] = temp;
//    }
    void selectionSort(int[] nums) {
        for(int i = 0; i< nums.length; i++) {
            int minInd = searchMin(nums, i, nums.length - 1);
            swap(nums, i, minInd);
        }
    }


    int searchMin(int[] nums, int start, int end) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = start; i <= end; i++) {
            if(nums[i] < minVal) {
                minVal = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    void insertionSort(int[] nums) {
        for(int i = 1; i<nums.length; i++) {
            for(int j = i; j > 0; j--) {
                if(nums[j] < nums[j-1]) {
                    swap(nums, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    void merSort(int[] nums, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            merSort(nums, start, mid);
            merSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    // end the last element index
    void merge(int[] nums, int start, int mid, int end) {
        // (]
        int[] left = Arrays.copyOfRange(nums, start, mid+1);
        int[] right = Arrays.copyOfRange(nums, mid+1, end+1);

        int l = 0, r = 0, k = start;
        while(k <= end) {
            if(l >= left.length) nums[k++] = right[r++];
            else if(r >= right.length) nums[k++] = left[l++];
            else if(left[l] < right[r]) nums[k++] = left[l++];
            else nums[k++] = right[r++];
        }
    }

    void quickSort(int[] nums, int start, int end) {
        if(start < end) {
           int ind = findPartition(nums, start, end);
           quickSort(nums, start, ind-1);
           quickSort(nums,  ind+1, end);
        }
    }

    private int findPartition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int ind = start;
        for(int i = start; i < end; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, ind);
                ind++;
            }
        }
        swap(nums, ind, end);
        return ind;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
//        Sort2 sort = new Sort2();
//        int[] nums = {5,4,3,2,1};
//        Arrays.stream(nums).forEach(System.out::print);
//        System.out.println();
//
//        long start = System.nanoTime();
//        sort.quickSort(nums, 0, nums.length-1);
////        sort.insertionSort(nums);
//        System.out.println("Time taken for sorting in ms: " + (System.nanoTime() - start));
//        Arrays.stream(nums).forEach(System.out::print);
        Person p1 = new Person(10);
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        p1.age = 20;
        System.out.println(set.contains(p1));
    }


}
class Person {
    int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
