package com.lzhlyle.contest.weekly182;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    private Map<String, long[]> map; // int[2]: {total, n}
    private Map<Integer, Tour> tourMap;

    public UndergroundSystem() {
        map = new HashMap<>();
        tourMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        tourMap.put(id, new Tour(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        if (tourMap.containsKey(id)) {
            Tour tour = tourMap.get(id);
            String key = tour.from.compareTo(stationName) < 0 ? tour.from + "-" + stationName : stationName + "-" + tour.from;
            if (!map.containsKey(key)) map.put(key, new long[2]);
            long[] arr = map.get(key);
            arr[0] += t - tour.t; // total time
            arr[1] += 1; // how many
            map.put(key, arr);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation.compareTo(endStation) < 0 ? startStation+ "-" + endStation : endStation+ "-" + startStation;
        if (!map.containsKey(key)) return 0;
        long[] arr = map.get(key);
        double res = arr[0] * 1.0 / arr[1];
        System.out.println(res);
        return res;
    }

    class Tour {
        String from;
        int t;

        public Tour(String from, int t) {
            this.from = from;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge");       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0
    }
}
