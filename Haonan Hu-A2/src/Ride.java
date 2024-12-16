import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ride implements RideInterface {

    // 游乐设施的名称，用于唯一标识该游乐设施
    private String rideName;
    // 一次循环中游乐设施可承载的最大游客数量
    private int maxRider;
    // 记录游乐设施已经运行的次数，方便统计设施的使用频率等信息
    private int numOfCycles;
    // 负责操作该游乐设施的员工
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

    // 设置一次循环可承载的最大游客数量的方法
    public void setMaxRider(int maxRider) {
        if (maxRider > 0) {
            this.maxRider = maxRider;
        } else {
            System.out.println("The maximum number of riders must be greater than 0. Please reset it.");
        }
    }

    // 获取游乐设施运行次数的方法
    public int getNumOfCycles() {
        return numOfCycles;
    }

    // 设置游乐设施运行次数的方法
    public void setNumOfCycles(int numOfCycles) {
        if (numOfCycles >= 0) {
            this.numOfCycles = numOfCycles;
        } else {
            System.out.println("The number of operation cycles cannot be negative. Please reset it.");
        }
    }

    // 获取游乐设施操作员的方法
    public Employee getRideOperator() {
        return rideOperator;
    }

    // 设置游乐设施操作员的方法，确保操作员不为空，输出设置成功的提示信息
    public void setRideOperator(Employee rideOperator) {
        if (rideOperator!= null) {
            this.rideOperator = rideOperator;
            System.out.println(rideOperator.getName() + " has been successfully set as the operator of " + rideName + ".");
        } else {
            System.out.println("The operator cannot be null. Please set a valid employee object.");
        }
    }

    // 将游客添加到等待队列的方法，同时输出符合规范的提示信息，体现游客入队情况，并设置参观日期为当前日期
    // 这里针对儿童票游客添加了额外提示，提醒工作人员关注儿童相关情况
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor!= null) {
            visitor.setVisitDate(new Date());
            waitingQueue.add(visitor);
            System.out.println(visitor.getName() + " has been successfully added to the waiting queue of " + rideName + ".");
            if (visitor.isChildTicket()) {
                System.out.println(visitor.getName() + " is a child ticket visitor. Please ask the staff to pay more attention.");
            }
        } else {
            System.out.println("Cannot add a null visitor to the waiting queue. Please ensure that the visitor object is not null.");
        }
    }

    // 从等待队列中移除游客的方法，根据队列状态输出相应提示信息
    // 针对儿童票游客移除时给出更合适的提示信息
    @Override
    public void removeVisitorFromQueue(Visitor targetVisitor) {
        if (targetVisitor!= null && waitingQueue.contains(targetVisitor)) {
            waitingQueue.remove(targetVisitor);
            if (targetVisitor.isChildTicket()) {
                System.out.println(targetVisitor.getName() + " (child ticket visitor) has been successfully removed from the queue. Please ensure that the child has left the waiting area safely.");
            } else {
                System.out.println(targetVisitor.getName() + " has been successfully removed from the queue.");
            }
        } else {
            System.out.println("The visitor " + targetVisitor.getName() + " is not in the waiting queue of " + rideName + " and cannot be removed.");
        }
    }

    // 打印等待队列中的游客信息的方法，包括游客姓名、年龄、性别、门票类型和参观日期等关键信息，格式优化
    // 在输出时对儿童票游客做特殊标识，方便查看区分
    @Override
    public void printQueue() {
        System.out.println("The waiting queue information of " + rideName + " is as follows:");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Visitor visitor : waitingQueue) {
            if (visitor!= null) {
                System.out.println("Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Gender: " + visitor.getGender() + ", Ticket Type: " + visitor.getTicketType() + ", Visit Date: " + sdf.format(visitor.getVisitDate()));
            }
        }
    }

    // 运行一次游乐设施循环的方法，根据操作员和等待队列状态执行操作，增加更多详细的运行状态输出
    // 针对儿童票游客在乘坐过程中给出不同提示，提醒注意儿童安全等事项
    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println(rideName + " has no operator assigned and cannot run this cycle. Please set an operator first.");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue of " + rideName + " is empty. There are no visitors available for this run, so the cycle cannot be started.");
            return;
        }
        int numToRemove = Math.min(maxRider, waitingQueue.size());
        System.out.println("For this run of " + rideName + ", " + numToRemove + " visitors will be removed from the queue and added to the ride history.");
        for (int i = 0; i < numToRemove; i++) {
            Visitor visitor = waitingQueue.poll();
            if (visitor!= null) {
                rideHistory.add(visitor);
                if (visitor.isChildTicket()) {
                    System.out.println(visitor.getName() + " (child ticket visitor) has been successfully removed from the queue and added to the ride history. Please assist the child in getting ready for the ride and ensure safety.");
                } else {
                    System.out.println(visitor.getName() + " has been successfully removed from the queue and added to the ride history.");
                }
            }
        }
        numOfCycles++;
        System.out.println(rideName + " has been successfully run once. The current number of runs: " + numOfCycles);

        // 打印运行后的队列信息
        System.out.println("After running once, the waiting queue information of " + rideName + " is as follows:");
        printQueue();

        // 打印当前乘坐历史记录信息
        System.out.println("The current ride history information of " + rideName + " is as follows:");
        printRideHistory();
    }

    // 将游客添加到乘坐历史记录的方法，同时输出提示信息，明确添加操作情况
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor!= null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " has been successfully added to the ride history of " + rideName + ".");
        } else {
            System.out.println("Cannot add a null visitor to the ride history. Please ensure that the visitor object is not null.");
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

    // 打印乘坐历史记录中的游客信息的方法，包括游客姓名、年龄、性别、门票类型和参观日期等，格式调整使其更易读
    // 在输出时对儿童票游客做特殊标识，方便查看区分
    @Override
    public void printRideHistory() {
        System.out.println("The ride history information of " + rideName + " is as follows:");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Visitor visitor : rideHistory) {
            if (visitor!= null) {
                System.out.println("Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Gender: " + visitor.getGender() + ", Ticket Type: " + visitor.getTicketType() + ", Visit Date: " + sdf.format(visitor.getVisitDate()));
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

    // 将乘坐历史记录导出到文件的方法，处理文件写入操作和异常，提供更详细的成功/失败提示，包含参观日期的导出
    public void exportRideHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rideName + ".csv"))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (Visitor visitor : rideHistory) {
                if (visitor!= null) {
                    writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," + visitor.getTicketType() + "," + sdf.format(visitor.getVisitDate()) + "\n");
                }
            }
            System.out.println("The ride history of " + rideName + " has been successfully exported to a file.");
        } catch (IOException e) {
            System.out.println("An error occurred while exporting the ride history file of " + rideName + ": " + e.getMessage());
        }
    }

    // 从文件中导入乘坐历史记录的方法，处理文件读取操作和异常，完善导入相关提示信息，包含参观日期的导入
    public void importRideHistory() {
        try (Scanner scanner = new Scanner(new File(rideName + ".csv"))) {
            rideHistory.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String gender = parts[2];
                    String ticketType = parts[3];
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date visitDate = sdf.parse(parts[4]);
                    Visitor visitor = new Visitor(name, age, gender, ticketType);
                    visitor.setVisitDate(visitDate);
                    rideHistory.add(visitor);
                }
            }
            System.out.println("The ride history of " + rideName + " has been successfully imported from the file.");
            System.out.println("There are currently " + numberOfVisitors() + " visitors in the ride history of " + rideName + ". The specific information is as follows:");
            printRideHistory();
        } catch (IOException | java.text.ParseException e) {
            System.out.println("An error occurred while importing the ride history file of " + rideName + ": " + e.getMessage());
        }
    }
}