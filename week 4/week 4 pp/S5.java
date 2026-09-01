import java.util.Arrays;

class S5 {
    public int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        S5 s = new S5();
        System.out.println(Arrays.toString(
                s.rotateArray(new int[]{1,2,3,4,5,6,7}, 3)
        ));
    }
}
