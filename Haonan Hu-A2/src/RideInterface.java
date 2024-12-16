import java.util.Queue;

// 游乐设施接口，定义了游乐设施应具备的操作方法
public interface RideInterface {

    // 将游客添加到等待队列的方法，接受一个Visitor对象作为参数，表示要添加到队列的游客
    void addVisitorToQueue(Visitor visitor);

    // 从等待队列中移除游客的方法，无参数，用于从等待队列中移除一个游客（通常是队首的游客）
    void removeVisitorFromQueue();

    // 打印等待队列中的游客信息的方法，无参数，用于输出当前等待队列中所有游客的信息
    void printQueue();

    // 运行一次游乐设施循环的方法，无参数，用于执行一次游乐设施的运行操作，包括从等待队列中选取游客、运行游乐设施、更新相关状态等
    void runOneCycle();

    // 将游客添加到乘坐历史记录的方法，接受一个Visitor对象作为参数，表示要添加到乘坐历史记录的游客
    void addVisitorToHistory(Visitor visitor);

    // 检查游客是否在乘坐历史记录中的方法，接受一个Visitor对象作为参数，返回一个布尔值，表示该游客是否在乘坐历史记录中
    boolean checkVisitorFromHistory(Visitor visitor);

    // 获取乘坐历史记录中的游客数量的方法，无参数，返回一个整数，表示乘坐历史记录中游客的数量
    int numberOfVisitors();

    // 打印乘坐历史记录中的游客信息的方法，无参数，用于输出乘坐历史记录中所有游客的信息
    void printRideHistory();
}