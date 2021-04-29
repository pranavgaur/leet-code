public class Solution {

    public static void getMissingNumbers(int[] arr, int length) {

        BitSet bitSet = new BitSet(length - arr.length);
        System.out.println(bitSet);

        for(int i: arr)
            bitSet.set(i);

        System.out.println(bitSet);
        System.out.println("Missing numbers :: ");

        int idx = 1;
        for(int i = 0; i < length - arr.length; i++){
            idx = bitSet.nextClearBit(idx);
            System.out.println(idx++);
        }

    }
}