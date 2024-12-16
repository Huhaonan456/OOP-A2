import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        // 创建一个名为"过山车"，最大承载量为2的Ride对象
        Ride rollerCoaster = new Ride("Roller Coaster", 2);

        // 创建一些Visitor对象并添加到队列中，添加门票类型和性别参数
        Visitor visitor1 = new Visitor("Jack", 10, "Male", "Child Ticket");
        Visitor visitor2 = new Visitor("Sharon", 22, "Female", "Regular Ticket");
        Visitor visitor3 = new Visitor("Benny", 18, "Male", "Student Ticket");
        Visitor visitor4 = new Visitor("Leo", 30, "Male", "Regular Ticket");
        Visitor visitor5 = new Visitor("Nehemia", 28, "Female", "Regular Ticket");

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 从队列中移除一个Visitor2
        rollerCoaster.removeVisitorFromQueue(visitor2);

        // 打印队列中的所有Visitor
        System.out.println("The content of the waiting queue of the Roller Coaster is as follows:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // 创建一个名为"雷暴过山车"，最大承载量为4的Ride对象
        Ride thunderstorm = new Ride("Thunderstorm Roller Coaster", 4);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型和性别参数
        Visitor visitor6 = new Visitor("Tom", 35, "Male", "Regular Ticket");
        Visitor visitor7 = new Visitor("Sherly", 26, "Female", "Regular Ticket");
        Visitor visitor8 = new Visitor("Ben", 20, "Male", "Student Ticket");
        Visitor visitor9 = new Visitor("David", 29, "Male", "Regular Ticket");
        Visitor visitor10 = new Visitor("Jack", 10, "Male", "Child Ticket");

        thunderstorm.addVisitorToHistory(visitor6);
        thunderstorm.addVisitorToHistory(visitor7);
        thunderstorm.addVisitorToHistory(visitor8);
        thunderstorm.addVisitorToHistory(visitor9);
        thunderstorm.addVisitorToHistory(visitor10);

        // 检查一个Visitor是否在乘坐历史记录中
        boolean isInHistory = thunderstorm.checkVisitorFromHistory(visitor7);
        if (isInHistory) {
            System.out.println(visitor7.getName() + "In Thunderstorm roller coaster current visitor visit history!");
        } else {
            System.out.println(visitor7.getName() + "Not in Thunderstorm Roller coaster's current visitor history.");
        }

        // 打印乘坐历史记录中的Visitor数量
        System.out.println("The number of visitors in the ride history of the Thunderstorm Roller Coaster: " + thunderstorm.numberOfVisitors());

        // 打印乘坐历史记录中的所有Visitor
        System.out.println("The visitor ride history data of the Thunderstorm Roller Coaster is as follows:");
        thunderstorm.printRideHistory();
    }

    public void partFourB() {
        // 创建一个名为"水上过山车"，最大承载量为3的Ride对象
        Ride waterRide = new Ride("Water Roller Coaster", 3);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型和性别参数
        Visitor visitor11 = new Visitor("Amy", 23, "Female", "Regular Ticket");
        Visitor visitor12 = new Visitor("Bob", 27, "Male", "Regular Ticket");
        Visitor visitor13 = new Visitor("Cathy", 19, "Female", "Student Ticket");
        Visitor visitor14 = new Visitor("David", 32, "Male", "Regular Ticket");
        Visitor visitor15 = new Visitor("Emma", 24, "Female", "Regular Ticket");

        waterRide.addVisitorToHistory(visitor11);
        waterRide.addVisitorToHistory(visitor12);
        waterRide.addVisitorToHistory(visitor13);
        waterRide.addVisitorToHistory(visitor14);
        waterRide.addVisitorToHistory(visitor15);

        // 打印未排序前的乘坐历史记录中的所有Visitor
        System.out.println("水上过山车未排序前的游客参观历史记录数据如下：");
        waterRide.printRideHistory();

        // 对乘坐历史记录进行排序
        waterRide.sortRideHistory();
        System.out.println("The ride history of the Water Roller Coaster has been sorted.");

        // 打印排序后的乘坐历史记录中的所有Visitor
        System.out.println("The visitor ride history data of the Water Roller Coaster after sorting is as follows:");
        waterRide.printRideHistory();
    }

    public void partFive() {
        // 创建一个名为"旋转过山车"，最大承载量为3的Ride对象
        Ride spinningRide = new Ride("Spinning Roller Coaster", 3);

        // 创建一些Visitor对象并添加到队列中，添加门票类型和性别参数
        Visitor visitor16 = new Visitor("Frank", 30, "Male", "Regular Ticket");
        Visitor visitor17 = new Visitor("Grace", 25, "Female", "Regular Ticket");
        Visitor visitor18 = new Visitor("Henry", 28, "Male", "Regular Ticket");
        Visitor visitor19 = new Visitor("Ivy", 22, "Female", "Student Ticket");
        Visitor visitor20 = new Visitor("Jack", 10, "Male", "Child Ticket");
        Visitor visitor21 = new Visitor("Kate", 24, "Female", "Regular Ticket");
        Visitor visitor22 = new Visitor("Leo", 33, "Male", "Regular Ticket");
        Visitor visitor23 = new Visitor("Mary", 21, "Female", "Student Ticket");
        Visitor visitor24 = new Visitor("Nick", 29, "Male", "Regular Ticket");
        Visitor visitor25 = new Visitor("Olivia", 27, "Female", "Regular Ticket");

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
        System.out.println("The initial content of the waiting queue of the Spinning Roller Coaster is as follows:");
        spinningRide.printQueue();

        // 运行一次过山车
        spinningRide.runOneCycle();

        // 打印运行一次后的队列中的所有Visitor
        System.out.println("The content of the waiting queue of the Spinning Roller Coaster after running once is as follows:");
        spinningRide.printQueue();

        // 打印乘坐历史记录中的所有Visitor
        System.out.println("The visitor ride history data of the Spinning Roller Coaster is as follows:");
        spinningRide.printRideHistory();
    }

    public void partSix() {
        // 创建一个名为"过山车"，最大承载量为2的Ride对象
        Ride rollerCoaster = new Ride("Roller Coaster", 2);

        // 创建一些Visitor对象并添加到乘坐历史记录中，修改Jack年龄为10岁使其成为儿童票，添加性别参数
        Visitor visitor1 = new Visitor("Jack", 10, "Male", "Child Ticket");
        Visitor visitor2 = new Visitor("Sharon", 22, "Female", "Regular Ticket");
        Visitor visitor3 = new Visitor("Benny", 18, "Male", "Student Ticket");
        Visitor visitor4 = new Visitor("Leo", 30, "Male", "Regular Ticket");
        Visitor visitor5 = new Visitor("Nehemia", 28, "Female", "Regular Ticket");

        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // 将乘坐历史记录导出到文件
        rollerCoaster.exportRideHistory();
    }

    public void partSeven() {
        // 创建一个名为"过山车"，最大承载量为2的Ride对象
        Ride rollerCoaster = new Ride("Roller Coaster", 2);

        // 从文件中导入乘坐历史记录
        rollerCoaster.importRideHistory();

        // 打印导入后的乘坐历史记录中的Visitor数量
        System.out.println("The number of visitors in the ride history of the Roller Coaster after import: " + rollerCoaster.numberOfVisitors());

        // 打印导入后的乘坐历史记录中的所有Visitor
        System.out.println("The visitor ride history data of the Roller Coaster after import is as follows:");
        rollerCoaster.printRideHistory();
    }
}