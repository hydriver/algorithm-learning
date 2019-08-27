package chapter_one;

import edu.princeton.cs.algs4.StdOut;

public class Date implements Comparable<Date> {
    /**
     * 实现日期
     */
    private final int month;
    private final int day;
    private final int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return year() + "/" + month() + "/" + day();
    }

    public boolean equals(Object x) {
        if (this == x) {
            return true;  // 判定是否是引用同一个对象
        }
        if (x == null) {
            return false;  // 如果比较的对象为空，直接返回错误
        }
        if (this.getClass() != x.getClass()) {
            return false;  // 不是同一个数据类型，返回错误
        }
        Date that = (Date)x;
        if (this.year != that.year || this.month != that.month() || this.day != that.day()) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Date that) {
        if (this.year > that.year) {
            return 1;
        }
        if (this.year < that.year) {
            return -1;
        }
        if (this.month > that.month) {
            return 1;
        }
        if (this.month < that.month) {
            return -1;
        }
        if (this.day > that.day) {
            return 1;
        }
        if (this.day < that.day) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Date one = new Date(8, 13, 2018);
        Date another = new Date(8, 13, 2019);
        StdOut.println(one == another);
        StdOut.println(one.equals(another));
        StdOut.println(another.year);
        StdOut.println(one.compareTo(another));
    }
}
