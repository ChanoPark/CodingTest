package Programmers;

import java.util.*;

public class MinimalRectangle {

    //최적화..
    public int solution2(int[][] sizes) {
        int maxWeight = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            maxWeight = Math.max(maxWeight, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }
        return maxWeight * maxHeight;
    }

    public int solution(int[][] sizes) {
        //긴 변을 한 쪽에 몰아넣기
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }

        int maxWeight = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            maxWeight = Math.max(maxWeight, size[0]);
            maxHeight = Math.max(maxHeight, size[1]);
        }
        return maxWeight * maxHeight;
    }

    //게속 사각형을 돌려보면서 확인했으나, 모든 케이스를 감당하지 못함
//    private static int maxWeight = Integer.MAX_VALUE;
//    private static int maxHeight = Integer.MAX_VALUE;
//    private static Queue<Integer> maxs = new LinkedList<>();
//
//    public int solution(int[][] sizes) {
//        getMax(sizes);
//
//        while (!maxs.isEmpty()) {
//            int i = maxs.poll();
//
//            if (sizes[i][0] == maxWeight) {
//                //가로가 큰 카드
//                if (sizes[i][0] < maxHeight && sizes[i][1] <= maxWeight) {
//                    swap(sizes, i);
//                    getMax(sizes);
//                }
//
//            } else if (sizes[i][1] == maxHeight) {
//                //세로가 큰 카드
//                if (sizes[i][1] < maxWeight && sizes[i][0] <= maxHeight) {
//                    swap(sizes, i);
//                    getMax(sizes);
//                }
//            }
//        }
//
//        return maxWeight * maxHeight;
//    }
//
//    private void getMax(int[][] sizes) {
//        int mw = -1;
//        int mh = -1;
//        int mwv = 0;
//        int mhv = 0;
//        for (int i = 0; i < sizes.length; i++) {
//            if (mwv < sizes[i][0]) {
//                mwv = sizes[i][0];
//                mw = i;
//            }
//            if (mhv < sizes[i][1]) {
//                mhv = sizes[i][1];
//                mh = i;
//            }
//        }
//
//        if (mw != -1 && maxWeight != mwv) maxs.offer(mw);
//        if (mh != -1 && maxHeight != mhv) maxs.offer(mh);
//        maxWeight = Math.min(maxWeight, mwv);
//        maxHeight = Math.min(maxHeight, mhv);
//    }
//
//    private void swap(int[][] sizes, int i) {
//        int temp = sizes[i][0];
//        sizes[i][0] = sizes[i][1];
//        sizes[i][1] = temp;
//    }
}
