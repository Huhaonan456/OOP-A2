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
        // 创建一个名为"过山车"，最大承载量为2的Ride对象
        Ride rollerCoaster = new Ride("过山车", 2);

        // 创建一些Visitor对象并添加到队列中，添加门票类型参数
        Visitor visitor1 = new Visitor("Jack", 25, "普通票");
        Visitor visitor2 = new Visitor("Sharon", 22, "普通票");
        Visitor visitor3 = new Visitor("Benny", 18, "学生票");
        Visitor visitor4 = new Visitor("Leo", 30, "普通票");
        Visitor visitor5 = new Visitor("Nehemia", 28, "普通票");

        rollerCoaster.addVisitorToQueue(visitor1);
        System.out.println(visitor1.getName() + "已成功添加到过山车的等待队列！");
        rollerCoaster.addVisitorToQueue(visitor2);
        System.out.println(visitor2.getName() + "已成功添加到过山车的等待队列！");
        rollerCoaster.addVisitorToQueue(visitor3);
        System.out.println(visitor3.getName() + "已成功添加到过山车的等待队列！");
        rollerCoaster.addVisitorToQueue(visitor4);
        System.out.println(visitor4.getName() + "已成功添加到过山车的等待队列！");
        rollerCoaster.addVisitorToQueue(visitor5);
        System.out.println(visitor5.getName() + "已成功添加到过山车的等待队列！");

        // 从队列中移除一个Visitor
        rollerCoaster.removeVisitorFromQueue();
        System.out.println(visitor1.getName() + "已成功从过山车的等待队列中移除！");

        // 打印队列中的所有Visitor
        System.out.println("过山车的等待队列内容如下：");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // 创建一个名为"雷暴过山车"，最大承载量为4的Ride对象
        Ride thunderstorm = new Ride("雷暴过山车", 4);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型参数
        Visitor visitor6 = new Visitor("Tom", 35, "普通票");
        Visitor visitor7 = new Visitor("Sherly", 26, "普通票");
        Visitor visitor8 = new Visitor("Ben", 20, "学生票");
        Visitor visitor9 = new Visitor("David", 29, "普通票");
        Visitor visitor10 = new Visitor("Jack", 25, "普通票");

        thunderstorm.addVisitorToHistory(visitor6);
        System.out.println(visitor6.getName() + "已成功添加到雷暴过山车的乘坐历史记录！");
        thunderstorm.addVisitorToHistory(visitor7);
        System.out.println(visitor7.getName() + "已成功添加到雷暴过山车的乘坐历史记录！");
        thunderstorm.addVisitorToHistory(visitor8);
        System.out.println(visitor8.getName() + "已成功添加到雷暴过山车的乘坐历史记录！");
        thunderstorm.addVisitorToHistory(visitor9);
        System.out.println(visitor9.getName() + "已成功添加到雷暴过山车的乘坐历史记录！");
        thunderstorm.addVisitorToHistory(visitor10);
        System.out.println(visitor10.getName() + "已成功添加到雷暴过山车的乘坐历史记录！");

        // 检查一个Visitor是否在乘坐历史记录中
        boolean isInHistory = thunderstorm.checkVisitorFromHistory(visitor7);
        if (isInHistory) {
            System.out.println(visitor7.getName() + "在雷暴过山车当前游客参观历史中！");
        } else {
            System.out.println(visitor7.getName() + "不在雷暴过山车当前游客参观历史中。");
        }

        // 打印乘坐历史记录中的Visitor数量
        System.out.println("雷暴过山车的游客参观历史人数：" + thunderstorm.numberOfVisitors());

        // 打印乘坐历史记录中的所有Visitor
        System.out.println("雷暴过山车的游客参观历史记录数据如下：");
        thunderstorm.printRideHistory();
    }

    public void partFourB() {
        // 创建一个名为"水上过山车"，最大承载量为3的Ride对象
        Ride waterRide = new Ride("水上过山车", 3);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型参数
        Visitor visitor11 = new Visitor("Amy", 23, "普通票");
        Visitor visitor12 = new Visitor("Bob", 27, "普通票");
        Visitor visitor13 = new Visitor("Cathy", 19, "学生票");
        Visitor visitor14 = new Visitor("David", 32, "普通票");
        Visitor visitor15 = new Visitor("Emma", 24, "普通票");

        waterRide.addVisitorToHistory(visitor11);
        System.out.println(visitor11.getName() + "已成功添加到水上过山车的乘坐历史记录！");
        waterRide.addVisitorToHistory(visitor12);
        System.out.println(visitor12.getName() + "已成功添加到水上过山车的乘坐历史记录！");
        waterRide.addVisitorToHistory(visitor13);
        System.out.println(visitor13.getName() + "已成功添加到水上过山车的乘坐历史记录！");
        waterRide.addVisitorToHistory(visitor14);
        System.out.println(visitor14.getName() + "已成功添加到水上过山车的乘坐历史记录！");
        waterRide.addVisitorToHistory(visitor15);
        System.out.println(visitor15.getName() + "已成功添加到水上过山车的乘坐历史记录！");

        // 打印未排序前的乘坐历史记录中的所有Visitor
        System.out.println("水上过山车未排序前的游客参观历史记录数据如下：");
        waterRide.printRideHistory();

        // 对乘坐历史记录进行排序
        waterRide.sortRideHistory();
        System.out.println("水上过山车的乘坐历史记录已完成排序。");

        // 打印排序后的乘坐历史记录中的所有Visitor
        System.out.println("水上过山车排序后的游客参观历史记录数据如下：");
        waterRide.printRideHistory();
    }

    public void partFive() {
        // 创建一个名为"旋转过山车"，最大承载量为3的Ride对象
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
        System.out.println(visitor16.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor17);
        System.out.println(visitor17.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor18);
        System.out.println(visitor18.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor19);
        System.out.println(visitor19.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor20);
        System.out.println(visitor20.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor21);
        System.out.println(visitor21.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor22);
        System.out.println(visitor22.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor23);
        System.out.println(visitor23.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor24);
        System.out.println(visitor24.getName() + "已成功添加到旋转过山车的等待队列！");
        spinningRide.addVisitorToQueue(visitor25);
        System.out.println(visitor25.getName() + "已成功添加到旋转过山车的等待队列！");

        // 打印队列中的所有Visitor
        System.out.println("旋转过山车初始的等待队列内容如下：");
        spinningRide.printQueue();

        // 运行一次过山车
        spinningRide.runOneCycle();

        // 打印运行一次后的队列中的所有Visitor
        System.out.println("旋转过山车运行一次后的等待队列内容如下：");
        spinningRide.printQueue();

        // 打印乘坐历史记录中的所有Visitor
        System.out.println("旋转过山车的游客参观历史记录数据如下：");
        spinningRide.printRideHistory();
    }

    public void partSix() {
        // 创建一个名为"过山车"，最大承载量为2的Ride对象
        Ride rollerCoaster = new Ride("过山车", 2);

        // 创建一些Visitor对象并添加到乘坐历史记录中，添加门票类型参数
        Visitor visitor1 = new Visitor("Jack", 25, "普通票");
        Visitor visitor2 = new Visitor("Sharon", 22, "普通票");
        Visitor visitor3 = new Visitor("Benny", 18, "学生票");
        Visitor visitor4 = new Visitor("Leo", 30, "普通票");
        Visitor visitor5 = new Visitor("Nehemia", 28, "普通票");

        rollerCoaster.addVisitorToHistory(visitor1);
        System.out.println(visitor1.getName() + "已成功添加到过山车的乘坐历史记录！");
        rollerCoaster.addVisitorToHistory(visitor2);
        System.out.println(visitor2.getName() + "已成功添加到过山车的乘坐历史记录！");
        rollerCoaster.addVisitorToHistory(visitor3);
        System.out.println(visitor3.getName() + "已成功添加到过山车的乘坐历史记录！");
        rollerCoaster.addVisitorToHistory(visitor4);
        System.out.println(visitor4.getName() + "已成功添加到过山车的乘坐历史记录！");
        rollerCoaster.addVisitorToHistory(visitor5);
        System.out.println(visitor5.getName() + "已成功添加到过山车的乘坐历史记录！");

        // 将乘坐历史记录导出到文件
        rollerCoaster.exportRideHistory();
    }

    public void partSeven() {
        // 创建一个名为"过山车"，最大承载量为2的Ride对象
        Ride rollerCoaster = new Ride("过山车", 2);

        // 从文件中导入乘坐历史记录
        rollerCoaster.importRideHistory();

        // 打印导入后的乘坐历史记录中的Visitor数量
        System.out.println("过山车导入后的游客参观历史记录人数：" + rollerCoaster.numberOfVisitors());

        // 打印导入后的乘坐历史记录中的所有Visitor
        System.out.println("过山车导入后的游客参观历史记录数据如下：");
        rollerCoaster.printRideHistory();
    }
}