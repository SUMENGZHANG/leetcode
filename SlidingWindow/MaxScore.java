public class MaxScore {
    public static int maxScore(int[] cardPoints, int k) {
        // 左右指针 如果相同，则比较固定窗口带来的收益率
        int len = cardPoints.length;
        int left = 0;
        int right = len - 1;
        int maxVal = 0;
        int num = k;

        int leftWindow = 0;
        int rightWindow = 0;
        for (int i = left; i < left + num; i++) {
            leftWindow += cardPoints[i];
        }
        for (int j = right; j > right - num; j--) {
            rightWindow += cardPoints[j];
        }
        while (num > 0) {
            if (leftWindow > rightWindow) {
                maxVal += cardPoints[left];
                leftWindow = leftWindow - cardPoints[left];
                left++;
                num--;
                rightWindow = rightWindow - cardPoints[right - num];
            } else {
                maxVal += cardPoints[right];
                rightWindow = rightWindow - cardPoints[right];
                right--;
                num--;
                leftWindow = leftWindow - cardPoints[left + num];
            }

        }

        return maxVal;

    }

    public static void main(String[] args) {
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(maxScore(cardPoints, k));

    }

}
