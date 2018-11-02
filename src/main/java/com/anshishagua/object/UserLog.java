package com.anshishagua.object;

import java.util.Date;
import java.util.Random;

public class UserLog {
    private long id;
    private long timestamp;
    private String ip;
    private double money;

    public UserLog(long id, long timestamp, String ip, double money) {
        this.id = id;
        this.timestamp = timestamp;
        this.ip = ip;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", ip='" + ip + '\'' +
                ", money=" + money +
                '}';
    }

    public static UserLog random() {
        Random random = new Random();

        long id = 1;//random.nextInt(10);
        double money = random.nextDouble() * 100;
        long timestamp = new Date().getTime();

        String ip = String.format("%d.%d.%d.%d", random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));

        return new UserLog(id, timestamp, ip, money);
    }
}