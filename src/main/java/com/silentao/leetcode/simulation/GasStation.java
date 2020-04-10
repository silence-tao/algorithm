package com.silentao.leetcode.simulation;

/**
 * @Description
 * 134. 加油站
 * https://leetcode-cn.com/problems/gas-station/
 * @Author Silence
 * @Date 2020/4/10 22:18
 **/
public class GasStation {

    /**
     * 出发时要判断首站的油是否能到达下一站
     * 不能直接跳到从下一个加油站出发
     * 每到一站要先把加油站的油全加到车里
     * 然后减去到下一站需要消耗的油
     * 如果剩余的油大于等于0就继续前行
     * 否则跳出循环，选择下一个出发的加油站
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null && cost == null) {
            return -1;
        }

        if (cost == null) {
            return 0;
        }

        int len = gas.length;
        for (int i = 0; i < len; i++) {
            // 首站是否足够到下一站
            if (gas[i] < cost[i]) {
                // 不够就跳到下一站出发
                continue ;
            }

            // 油箱剩余的油
            int t = gas[i] - cost[i];
            // 当前所在的加油站
            int j = i;
            // 因为要循环一圈所以这里取余
            // 当回到i加油站时说明循环了一圈
            // 所以结束循环
            while ((j = (j + 1) % len) != i) {
                // 先把加油站的油全加到车里
                // 然后减去到下一站需要的油
                t = t + gas[j] - cost[j];

                // 剩余的油小0说明不足以到达下一站
                // 就直接跳出循环
                if (t < 0) {
                    break ;
                }
            }

            // 跑完全程如果剩余的油大于等于0
            // 表示符合条件就返回结果
            // 当然这里包括了未跑完全程的情况
            // 不过未跑完全程油肯定小于0
            // 所以不必担心
            if (t >= 0) {
                return i;
            }
        }

        // 不符合条件就返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] gas  = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
