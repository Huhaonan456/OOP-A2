import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ride implements RideInterface {

    // 游乐设施的名称，用于唯一标识该游乐设施
    private String rideName;
    // 一次循环中游乐设施可承载的最大游客数量，限制每次运行可接待的游客上限
    private int maxRider;
    // 记录游乐设施已经运行的次数，方便统计设施的使用频率等信息
    private int numOfCycles;
    // 负责操作该游乐设施的员工，操作员对于游乐设施的正常运行起着关键作用
    private Employee rideOperator;
    // 用于存储等待乘坐该游乐设施的游客队列，遵循先进先出原则
    private Queue<Visitor> waitingQueue;
    // 用于存储已经乘坐过该游乐设施的游客历史记录，便于后续查询、统计和分析乘坐情况
    private LinkedList<Visitor> rideHistory;

    // 默认构造函数，初始化等待队列和乘坐历史记录列表，创建一个基本的游乐设施对象实例
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

    // 设置游乐设施名称的方法，更新游乐设施的名称
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    // 获取一次循环可承载的最大游客数量的方法
    public int getMaxRider() {
        return maxRider;
    }

    // 设置一次循环可承载的最大游客数量的方法，可根据实际运营情况调整承载量限制
    public void setMaxRider(int maxRider) {
        if (maxRider > 0) {
            this.maxRider = maxRider;
        } else {
            System.out.println("最大承载游客数量必须大于 0，请重新设置。");
        }
    }

    // 获取游乐设施运行次数的方法
    public int getNumOfCycles() {
        return numOfCycles;
    }

    // 设置游乐设施运行次数的方法，一般用于数据初始化或者特殊场景下的次数调整（需谨慎使用）
    public void setNumOfCycles(int numOfCycles) {
        if (numOfCycles >= 0) {
            this.numOfCycles = numOfCycles;
        } else {
            System.out.println("运行次数不能为负数，请重新设置。");
        }
    }

    // 获取游乐设施操作员的方法
    public Employee getRideOperator() {
        return rideOperator;
    }

    // 设置游乐设施操作员的方法，确保操作员不为空，同时输出设置成功的提示信息
    public void setRideOperator(Employee rideOperator) {
        if (rideOperator!= null) {
            this.rideOperator = rideOperator;
            System.out.println(rideOperator.getName() + " 已被成功设置为 " + rideName + " 的操作员。");
        } else {
            System.out.println("操作员不能为空，请设置有效的员工对象。");
        }
    }

    // 将游客添加到等待队列的方法，同时输出符合规范的提示信息，体现游客入队情况
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor!= null) {
            waitingQueue.add(visitor);
            System.out.println(visitor.getName() + " 已成功添加到 " + rideName + " 的等待队列。");
        } else {
            System.out.println("无法添加空游客到等待队列，请确保游客对象不为空。");
        }
    }

    // 从等待队列中移除游客的方法，根据队列状态输出相应提示信息，格式更清晰友好
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor visitor = waitingQueue.poll();
            if (visitor!= null) {
                System.out.println(visitor.getName() + " 已成功从 " + rideName + " 的等待队列中移除。");
            }
        } else {
            System.out.println(rideName + " 的等待队列为空，无游客可移除。");
        }
    }

    // 打印等待队列中的游客信息的方法，包括游客姓名、年龄等关键信息，格式优化
    @Override
    public void printQueue() {
        System.out.println(rideName + " 的等待队列信息如下：");
        for (Visitor visitor : waitingQueue) {
            if (visitor!= null) {
                System.out.println("姓名：" + visitor.getName() + "，年龄：" + visitor.getAge() + "，门票类型：" + visitor.getTicketType());
            }
        }
    }

    // 运行一次游乐设施循环的方法，根据操作员和等待队列状态执行操作，增加更多详细的运行状态输出
    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println(rideName + " 没有分配操作员，无法运行本次循环，请先设置操作员。");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println(rideName + " 的等待队列为空，没有游客可参与本次运行，无法启动循环。");
            return;
        }
        int numToRemove = Math.min(maxRider, waitingQueue.size());
        System.out.println("本次运行 " + rideName + "，将从队列中移除 " + numToRemove + " 名游客并添加到乘坐历史记录中。");
        for (int i = 0; i < numToRemove; i++) {
            Visitor visitor = waitingQueue.poll();
            if (visitor!= null) {
                rideHistory.add(visitor);
                System.out.println(visitor.getName() + " 游客已成功从等待队列移除，并添加到 " + rideName + " 的乘坐历史记录中。");
            }
        }
        numOfCycles++;
        System.out.println(rideName + " 已成功运行了一次，当前运行次数: " + numOfCycles);

        // 打印运行后的队列信息
        System.out.println("运行一次后，" + rideName + " 的等待队列信息如下：");
        printQueue();

        // 打印当前乘坐历史记录信息
        System.out.println("当前 " + rideName + " 的乘坐历史记录信息如下：");
        printRideHistory();
    }

    // 将游客添加到乘坐历史记录的方法，同时输出提示信息，明确添加操作情况
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor!= null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " 已成功添加到 " + rideName + " 的乘坐历史记录中。");
        } else {
            System.out.println("无法添加空游客到乘坐历史记录，请确保游客对象不为空。");
        }
    }

    // 检查游客是否在乘坐历史记录中的方法，返回布尔值，用于查询游客乘坐历史情况
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // 获取乘坐历史记录中的游客数量的方法，方便统计已乘坐过该游乐设施的游客总数
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // 打印乘坐历史记录中的游客信息的方法，包括游客姓名、年龄等，格式调整使其更易读
    @Override
    public void printRideHistory() {
        System.out.println(rideName + " 的乘坐历史记录信息如下：");
        for (Visitor visitor : rideHistory) {
            if (visitor!= null) {
                System.out.println("姓名：" + visitor.getName() + "，年龄：" + visitor.getAge() + "，门票类型：" + visitor.getTicketType());
            }
        }
    }

    // 对乘坐历史记录进行排序的方法，根据游客年龄和姓名排序，使记录呈现更有序的状态
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

    // 将乘坐历史记录导出到文件的方法，处理文件写入操作和异常，提供更详细的成功/失败提示
    public void exportRideHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rideName + ".csv"))) {
            for (Visitor visitor : rideHistory) {
                if (visitor!= null) {
                    writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getTicketType() + "\n");
                }
            }
            System.out.println(rideName + " 的乘坐历史记录已成功导出到文件。");
        } catch (IOException e) {
            System.out.println("导出 " + rideName + " 的乘坐历史记录文件时出错: " + e.getMessage());
        }
    }

    // 从文件中导入乘坐历史记录的方法，处理文件读取操作和异常，完善导入相关提示信息
    public void importRideHistory() {
        try (Scanner scanner = new Scanner(new File(rideName + ".csv"))) {
            rideHistory.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String ticketType = parts[2];
                    Visitor visitor = new Visitor(name, age, ticketType);
                    rideHistory.add(visitor);
                }
            }
            System.out.println(rideName + " 的乘坐历史记录已成功从文件导入。");
            System.out.println("当前 " + rideName + " 的乘坐历史记录中共有 " + numberOfVisitors() + " 名游客，具体信息如下：");
            printRideHistory();
        } catch (IOException e) {
            System.out.println("导入 " + rideName + " 的乘坐历史记录文件时出错: " + e.getMessage());
        }
    }
}