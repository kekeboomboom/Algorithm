import java.util.*;

/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {5,4,-1,7,8};



    }

    public boolean canJump(int[] nums) {
        int maxJump = 0;
        int curIndex = 0;
        while (curIndex < nums.length && curIndex <= maxJump) {
            maxJump = Math.max(maxJump, curIndex + nums[curIndex]);
            if (maxJump >= nums.length - 1) {
                return true;
            }
            curIndex++;
        }
        return false;
    }

}
