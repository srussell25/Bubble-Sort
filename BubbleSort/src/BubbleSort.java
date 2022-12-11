import java.util.*;

public class BubbleSort 
{ int [] nums;
  public BubbleSort (int numItems, int maxItemValue, int randomSeed)
  { nums = new int[numItems];
    Random rand = new Random(randomSeed);
    for (int i = 0; i < nums.length; i++)
         nums[i] = rand.nextInt(maxItemValue + 1);
         System.out.println("\nConstructor: nums = " +
          Arrays.toString(nums) + " (using random-seed = " + randomSeed + ")");
  }
  
 public void bubbleSort()
 { int numComparisonsInThisPass = nums.length - 1,
       numExchangesInThisPass;
   do
   { numExchangesInThisPass = 0;
     String exchangesInThisPass = "";
     for (int i = 1; i <= numComparisonsInThisPass; i++)
         if (nums[i - 1] > nums[i])
         { numExchangesInThisPass++;
           exchangesInThisPass += "(" + nums[i - 1] + "," + nums[i] + ") ";
           int temp = nums[i];
           nums[i] = nums[i - 1];
           nums[i - 1] = temp;
         }
     System.out.println(numExchangesInThisPass + " exchanges in pass #" +
       (nums.length - numComparisonsInThisPass) + ": " + exchangesInThisPass);
     numComparisonsInThisPass--;
     System.out.println("nums: " + Arrays.toString(nums));
   }
   while ((numExchangesInThisPass > 0) && (numComparisonsInThisPass > 0));  
  }
  
 public static void testBubbleSort (int numTests, int numItems)
 { int maxItemValue = 5 * (Math.min(numItems, Integer.MAX_VALUE / 5)) - 1;
   System.out.println("\nShown below are successive phases of the simple " 
                      + "Bubble-sort for \n" + numTests + " random arrays of "
                      + "size " + numItems + ", with items in the range "
                      + "[0, " + maxItemValue + "]. ");
   for (int i = 0; i <= numTests - 1; i++)
   { (new BubbleSort(numItems, maxItemValue, i)).bubbleSort();
   }
 }
 
 public static void main(String[] args)
 { Scanner scan = new Scanner(System.in);
   System.out.print("\nEnter number of random items to sort (>= 1 and < 10)" +
            " :");
   int numItems = scan.nextInt();
   testBubbleSort(2, numItems);
 }
}

/*
Enter number of random items to sort (>= 1 and < 10) : 5

Shown below are successive phases of the simple Bubble-sort for 
2 random arrays of size 5, with items in the range [0, 24]. 

Constructor: nums = [10, 23, 4, 22, 15] (using random-seed = 0)
3 exchanges in pass #1: (23,4) (23,22) (23,15) 
nums: [10, 4, 22, 15, 23]
2 exchanges in pass #2: (10,4) (22,15) 
nums: [4, 10, 15, 22, 23]
0 exchanges in pass #3: 
nums: [4, 10, 15, 22, 23]

Constructor: nums = [10, 13, 22, 13, 4] (using random-seed = 1)
2 exchanges in pass #1: (22,13) (22,4) 
nums: [10, 13, 13, 4, 22]
1 exchanges in pass #2: (13,4) 
nums: [10, 13, 4, 13, 22]
1 exchanges in pass #3: (13,4) 
nums: [10, 4, 13, 13, 22]
1 exchanges in pass #4: (10,4) 
nums: [4, 10, 13, 13, 22]
*/