package com.dds.learn.java;

public class EnergyPacketDistribution {


    public long solution(long[] packets, long agents) {
        if (packets == null || packets.length == 0 || agents <= 0) {
            return 0;
        }

        long left = 1;
        long right = 0;

        for (long packet : packets) {
            right = Math.max(right, packet);
        }

        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canDistribute(packets, agents, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canDistribute(long[] packets, long agents, long target) {
        long count = 0;

        for (long packet : packets) {
            count += packet / target;

            if (count >= agents) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        EnergyPacketDistribution distribution = new EnergyPacketDistribution();
        long[] packets = {10, 20, 30};
        long agents = 5;
        long result = distribution.solution(packets, agents);
        System.out.println("Maximum energy per agent: " + result);
    }
}