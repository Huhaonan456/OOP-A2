import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ride implements RideInterface {

    // 游乐设施的名称
    private String rideName;
    // 一次循环中游乐设施可承载的最大游客数量
    private int maxRider;
    // 记录游乐设施已经运行的次数
    private int numOfCycles;
    // 负责操作该游乐设施的员工
    private Employee rideOperator;
    // 用于存储等待乘坐该游乐设施的游客队列
    private Queue<Visitor> waitingQueue;
    // 用于存储已经乘坐过该游乐设施的游客历史记录
    private LinkedList<Visitor> rideHistory;

    // 默认构造函数，初始化等待队列和乘坐历史记录列表
    public Ride() {
        waitingQueue = new LinkedList<>();
        rideHistory = new LinkedList<>();
    }

    // 带参数的构造函数，用于创建一个具有特定名称和最大承载量的游乐设施对象，并初始化相关属性
    public Ride(String rideName, int maxRider) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.rideOperator = null;
        waitingQueue = new LinkedList<>();
        rideHistory = new LinkedList<>();
    }

    // 获取游乐设施名称的方法
    public String getRideName() {
        return rideName;
    }

    // 设置游乐设施名称的方法
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    // 获取一次循环可承载的最大游客数量的方法
    public int getMaxRider() {
        return maxRider;
    }

    // 设置一次循环可承载的最大游客数量的方法
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    // 获取游乐设施运行次数的方法
    public int getNumOfCycles() {
        return numOfCycles;
    }

    // 设置游乐设施运行次数的方法
    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    // 获取游乐设施操作员的方法
    public Employee getRideOperator() {
        return rideOperator;
    }

    // 设置游乐设施操作员的方法，确保操作员不为空
    public void setRideOperator(Employee rideOperator) {
        if (rideOperator!= null) {
            this.rideOperator = rideOperator;
        } else {
            System.out.println("操作员不能为空，请设置有效的员工对象。");
        }
    }

    // 将游客添加到等待队列的方法，同时输出提示信息
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor!= null) {
            waitingQueue.add(visitor);
            System.out.println(visitor.getName() + " 已加入 " + rideName + " 的等待队列。");
        } else {
            System.out.println("无法添加空游客到等待队列。");
        }
    }

    // 从等待队列中移除游客的方法，根据队列状态输出相应提示信息
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor visitor = waitingQueue.poll();
            if (visitor!= null) {
                System.out.println(visitor.getName() + " 已从 " + rideName + " 的等待队列中移除。");
            }
        } else {
            System.out.println(rideName + " 的等待队列为空。");
        }
    }

    // 打印等待队列中的游客信息的方法，包括游客姓名和年龄
    @Override
    public void printQueue() {
        System.out.println(rideName + " 的等待队列:");
        for (Visitor visitor : waitingQueue) {
            if (visitor!= null) {
                System.out.println(visitor.getName() + " - " + visitor.getAge());
            }
        }
    }

    // 运行一次游乐设施循环的方法，根据操作员和等待队列状态执行操作
    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println(rideName + " 没有分配操作员，无法运行。");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println(rideName + " 的等待队列为空，无法运行。");
            return;
        }
        int numToRemove = Math.min(maxRider, waitingQueue.size());
        System.out.println("本次将从队列中移除 " + numToRemove + " 名游客并添加到乘坐历史记录中。");
        for (int i = 0; i < numToRemove; i++) {
            Visitor visitor = waitingQueue.poll();
            if (visitor!= null) {
                rideHistory.add(visitor);
                System.out.println(visitor.getName() + " 已从队列中移除并添加到乘坐历史记录。");
            }
        }
        numOfCycles++;
        System.out.println(rideName + " 运行了一次，当前运行次数: " + numOfCycles);
    }

    // 将游客添加到乘坐历史记录的方法，同时输出提示信息
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor!= null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " 已添加到 " + rideName + " 的乘坐历史记录。");
        } else {
            System.out.println("无法添加空游客到乘坐历史记录。");
        }
    }

    // 检查游客是否在乘坐历史记录中的方法，返回布尔值
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // 获取乘坐历史记录中的游客数量的方法
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // 打印乘坐历史记录中的游客信息的方法，包括游客姓名和年龄
    @Override
    public void printRideHistory() {
        System.out.println(rideName + " 的乘坐历史记录:");
        for (Visitor visitor : rideHistory) {
            if (visitor!= null) {
                System.out.println(visitor.getName() + " - " + visitor.getAge());
            }
        }
    }

    // 对乘坐历史记录进行排序的方法，根据游客年龄和姓名排序
    public void sortRideHistory() {
        rideHistory.sort((v1, v2) -> {
            // 根据年龄和姓名进行排序
            int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
            if (ageComparison == 0) {
                return v1.getName().compareTo(v2.getName());
            }
            return ageComparison;
        });
    }

    // 将乘坐历史记录导出到文件的方法，处理文件写入操作和异常
    public void exportRideHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rideName + ".csv"))) {
            for (Visitor visitor : rideHistory) {
                if (visitor!= null) {
                    writer.write(visitor.getName() + "," + visitor.getAge() + "\n");
                }
            }
            System.out.println(rideName + " 的乘坐历史记录已导出到文件。");
        } catch (IOException e) {
            System.out.println("导出文件时出错: " + e.getMessage());
        }
    }

    // 从文件中导入乘坐历史记录的方法，处理文件读取操作和异常
    public void importRideHistory() {
        try (Scanner scanner = new Scanner(new File(rideName + ".csv"))) {
            rideHistory.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    Visitor visitor = new Visitor(name, age, "普通票");
                    rideHistory.add(visitor);
                }
            }
            System.out.println(rideName + " 的乘坐历史记录已从文件导入。");
        } catch (IOException e) {
            System.out.println("导入文件时出错: " + e.getMessage());
        }
    }
}