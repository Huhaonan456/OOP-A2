import java.util.Scanner;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        System.out.println("-------------------------");
        assignment.partFourA();
        System.out.println("-------------------------");
        assignment.partFourB();
        System.out.println("-------------------------");
        assignment.partFive();
        System.out.println("-------------------------");
        assignment.partSix();
        System.out.println("-------------------------");
        assignment.partSeven();
    }

    public void partThree() {
        // 创建一个Ride对象
        Ride rollerCoaster = new Ride("过山车", 2);

        // 创建一些Visitor对象并添加到队列中，添加门票类型参数
        Visitor visitor1 = new Visitor("Jack", 25, "普通票");
        Visitor visitor2 = new Visitor("Sharon", 22, "普通票");
        Visitor visitor3 = new Visitor("Benny", 18, "学生票");
        Visitor visitor4 = new Visitor("Leo", 30, "普通票");
        Visitor visitor5 = new Visitor("Nehemia", 28, "普通票");

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 从队列中移除一个Visitor
        rollerCoaster.removeVisitorFromQueue();

        // 打印队列中的所有Visitor
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // 创建一个Ride对象
        Ride thunderstorm = new Ride("雷暴过山车", 4);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型参数
        Visitor visitor6 = new Visitor("Tom", 35, "普通票");
        Visitor visitor7 = new Visitor("Sherly", 26, "普通票");
        Visitor visitor8 = new Visitor("Ben", 20, "学生票");
        Visitor visitor9 = new Visitor("David", 29, "普通票");
        Visitor visitor10 = new Visitor("Jack", 25, "普通票");

        thunderstorm.addVisitorToHistory(visitor6);
        thunderstorm.addVisitorToHistory(visitor7);
        thunderstorm.addVisitorToHistory(visitor8);
        thunderstorm.addVisitorToHistory(visitor9);
        thunderstorm.addVisitorToHistory(visitor10);

        // 检查一个Visitor是否在乘坐历史记录中
        boolean isInHistory = thunderstorm.checkVisitorFromHistory(visitor7);
        if (isInHistory) {
            System.out.println(visitor7.getName() + " 在乘坐历史记录中。");
        } else {
            System.out.println(visitor7.getName() + " 不在乘坐历史记录中。");
        }

        // 打印乘坐历史记录中的Visitor数量
        System.out.println("乘坐历史记录中的Visitor数量: " + thunderstorm.numberOfVisitors());

        // 打印乘坐历史记录中的所有Visitor
        thunderstorm.printRideHistory();
    }

    public void partFourB() {
        // 创建一个Ride对象
        Ride waterRide = new Ride("水上过山车", 3);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型参数
        Visitor visitor11 = new Visitor("Amy", 23, "普通票");
        Visitor visitor12 = new Visitor("Bob", 27, "普通票");
        Visitor visitor13 = new Visitor("Cathy", 19, "学生票");
        Visitor visitor14 = new Visitor("David", 32, "普通票");
        Visitor visitor15 = new Visitor("Emma", 24, "普通票");

        waterRide.addVisitorToHistory(visitor11);
        waterRide.addVisitorToHistory(visitor12);
        waterRide.addVisitorToHistory(visitor13);
        waterRide.addVisitorToHistory(visitor14);
        waterRide.addVisitorToHistory(visitor15);

        // 打印未排序前的乘坐历史记录中的所有Visitor
        System.out.println("未排序前的乘坐历史记录:");
        waterRide.printRideHistory();

        // 对乘坐历史记录进行排序
        waterRide.sortRideHistory();

        // 打印排序后的乘坐历史记录中的所有Visitor
        System.out.println("排序后的乘坐历史记录:");
        waterRide.printRideHistory();
    }

    public void partFive() {
        // 创建一个Ride对象
        Ride spinningRide = new Ride("旋转过山车", 3);

        // 创建一些Visitor对象并添加到队列中，添加门票类型参数
        Visitor visitor16 = new Visitor("Frank", 30, "普通票");
        Visitor visitor17 = new Visitor("Grace", 25, "普通票");
        Visitor visitor18 = new Visitor("Henry", 28, "普通票");
        Visitor visitor19 = new Visitor("Ivy", 22, "学生票");
        Visitor visitor20 = new Visitor("Jack", 26, "普通票");
        Visitor visitor21 = new Visitor("Kate", 24, "普通票");
        Visitor visitor22 = new Visitor("Leo", 33, "普通票");
        Visitor visitor23 = new Visitor("Mary", 21, "学生票");
        Visitor visitor24 = new Visitor("Nick", 29, "普通票");
        Visitor visitor25 = new Visitor("Olivia", 27, "普通票");

        spinningRide.addVisitorToQueue(visitor16);
        spinningRide.addVisitorToQueue(visitor17);
        spinningRide.addVisitorToQueue(visitor18);
        spinningRide.addVisitorToQueue(visitor19);
        spinningRide.addVisitorToQueue(visitor20);
        spinningRide.addVisitorToQueue(visitor21);
        spinningRide.addVisitorToQueue(visitor22);
        spinningRide.addVisitorToQueue(visitor23);
        spinningRide.addVisitorToQueue(visitor24);
        spinningRide.addVisitorToQueue(visitor25);

        // 打印队列中的所有Visitor
        System.out.println("初始队列:");
        spinningRide.printQueue();

        // 运行一次过山车
        spinningRide.runOneCycle();

        // 打印运行一次后的队列中的所有Visitor
        System.out.println("运行一次后的队列:");
        spinningRide.printQueue();

        // 打印乘坐历史记录中的所有Visitor
        System.out.println("乘坐历史记录:");
        spinningRide.printRideHistory();
    }

    public void partSix() {
        // 创建一个Ride对象
        Ride rollerCoaster = new Ride("过山车", 2);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型参数
        Visitor visitor1 = new Visitor("Jack", 25, "普通票");
        Visitor visitor2 = new Visitor("Sharon", 22, "普通票");
        Visitor visitor3 = new Visitor("Benny", 18, "学生票");
        Visitor visitor4 = new Visitor("Leo", 30, "普通票");
        Visitor visitor5 = new Visitor("Nehemia", 28, "普通票");

        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // 将乘坐历史记录导出到文件
        rollerCoaster.exportRideHistory();
    }

    public void partSeven() {
        // 创建一个Ride对象
        Ride rollerCoaster = new Ride("过山车", 2);

        // 从文件中导入乘坐历史记录
        rollerCoaster.importRideHistory();

        // 打印导入后的乘坐历史记录中的Visitor数量
        System.out.println("导入后的乘坐历史记录中的Visitor数量: " + rollerCoaster.numberOfVisitors());

        // 打印导入后的乘坐历史记录中的所有Visitor
        rollerCoaster.printRideHistory();
    }
}