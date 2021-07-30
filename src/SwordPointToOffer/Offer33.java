package SwordPointToOffer;

/**
 * @author keboom
 * @date 2021/7/22
 */
public class Offer33 {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int m = -1;
        for (int k = j - 1; k >= 0; k--) {
            if (postorder[k] < postorder[j]) {
                m = k;
                break;
            }
        }
        for (int k = m-1; k >= 0; k--) {
            if (postorder[k] > postorder[j]) {
                return false;
            }
        }
        return recur(postorder, i, m) && recur(postorder, m + 1, j - 1);
    }

}
