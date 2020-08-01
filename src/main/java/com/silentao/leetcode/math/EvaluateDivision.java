package com.silentao.leetcode.math;

import com.google.common.collect.Lists;
import javafx.util.Pair;

import java.util.*;

/**
 * @Description
 * 399. 除法求值
 * https://leetcode-cn.com/problems/evaluate-division/
 * @Author Silence
 * @Date 2020/7/28 7:40
 **/
public class EvaluateDivision {

    /**
     * [["x1","x2"],["x2","x3"],["x1","x4"],["x2","x5"]]
     * [3.0,0.5,3.4,5.6]
     * [["x2","x4"],["x1","x5"],["x1","x3"],["x5","x5"],["x5","x1"],["x3","x4"],["x4","x3"],["x6","x6"],["x0","x0"]]
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> map = new HashMap<>();
        Set<String> letters = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);

            String str = e.get(0);
            List<Pair<String, Double>> list = map.get(str);
            if (list == null) {
                list = new ArrayList<>();

                map.put(str, list);
            }

            list.add(new Pair<>(e.get(1), values[i]));

            letters.add(e.get(0));
            letters.add(e.get(1));
        }

        System.out.println(map);

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);

            if (!letters.contains(a) || !letters.contains(b)) {
                res[i] = -1D;
            } else {
                res[i] = calcEquation(a, b, map, 1D, 1D);
            }
        }

        return res;
    }

    private static double calcEquation(String a, String b, Map<String, List<Pair<String, Double>>> map, double x, double y) {
        double res = -1D;

        if (a.equals(b)) {
            return x / y;
        }

        List<Pair<String, Double>> pairs = map.get(a);
        if (pairs != null) {
            for (Pair<String, Double> pair : pairs) {
                res = calcEquation(pair.getKey(), b, map, x * pair.getValue(), y);

                if (res != -1) {
                    return res;
                }
            }
        }

        pairs = map.get(b);
        if (pairs != null) {
            for (Pair<String, Double> pair : pairs) {
                res = calcEquation(a, pair.getKey(), map, x, y * pair.getValue());

                if (res != -1) {
                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<String>> equations = Lists.newArrayList(
                Lists.newArrayList("x1","x2"),
                Lists.newArrayList("x2","x3"),
                Lists.newArrayList("x1","x4"),
                Lists.newArrayList("x2","x5"));

        double[] values = new double[] {3.0,0.5,3.4,5.6};

        List<List<String>> queries = Lists.newArrayList(
                Lists.newArrayList("x2","x4"),
                Lists.newArrayList("x1","x5"),
                Lists.newArrayList("x1","x3"),
                Lists.newArrayList("x5","x5"),
                Lists.newArrayList("x5","x1"),
                Lists.newArrayList("x3","x4"),
                Lists.newArrayList("x4","x3"),
                Lists.newArrayList("x6","x6"),
                Lists.newArrayList("x0","x0"));

        double[] res = calcEquation(equations, values, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
