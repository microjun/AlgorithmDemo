package com.lkjun.section2;

/**
 * Created by IntelliJ IDEA.
 * Author: Micro Jun
 * Date: 2020/3/8
 * File: Demo2_1_5.java
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索
 *
 * 迷宫的最短路径问题
 *
 * 给定一个大小为N*M的迷宫，迷宫由通道和墙壁构成，每一步可以向相邻的上下左右四个的通道移动，请求出从起点到终点所需的最小步数。
 *
 * 输入：
 * N=10,M=10
 *
 * S: 起点
 * G：终点
 * #: 墙壁
 *
 */

public class Demo2_1_5 {

    static int M,N;
    static char[][] maze;
    static int[][] d;
    Point beginPoint;
    Point endPoint;

    int[] dx={1,0,-1,0};
    int[] dy = {0,1,0,1};

    public void solve() {
        beginPoint = new Point();
        endPoint = new Point();

        System.out.println(bfs()-1);
    }

    public int bfs() {

        boolean flag = false;
        for(int i = 0 ;i< M ;i++) {
            if(flag)
                break;
            for(int j = 0 ;j< N ;j++) {
                if(maze[i][j] == 'S') {
                    beginPoint = new Point(i,j);
                    d[i][j] = 1;
                    flag = true;
                    break;
                }
            }
        }

        Queue<Point> pointQueue = new LinkedList<Point>();
        pointQueue.add(beginPoint);

        while (!pointQueue.isEmpty()) {
            Point tempPoint = pointQueue.poll();
            if(maze[tempPoint.x][tempPoint.y] == 'G' ) {
                return d[tempPoint.x][tempPoint.y];
            }

            for(int i = 0 ;i< dx.length ;i++) {
                int tempX = tempPoint.x + dx[i];
                int tempY = tempPoint.y + dy[i];

                if(tempX >=0 && tempX<= N && tempY>=0 && tempY<= M && maze[tempX][tempY] != '#' && d[tempX][tempY] == 0) {
                    pointQueue.add(new Point(tempX,tempY));
                    d[tempX][tempY] = d[tempPoint.x][tempPoint.y] + 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        maze = new char[M][N];
        d = new int[M][N];

        new Demo2_1_5().solve();

    }

    static class Point {
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
