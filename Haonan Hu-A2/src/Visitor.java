public class Visitor extends Person {

    // 游客的门票类型，用于区分不同类型的门票（例如普通票、学生票、优惠票等）
    private String ticketType;

    // 默认构造函数，创建一个空的Visitor对象，会调用父类（Person）的默认构造函数，此时门票类型未初始化
    public Visitor() {
        super();
    }

    // 带参数的构造函数，用于创建一个具有特定姓名、年龄和门票类型的Visitor对象，并调用父类（Person）的带参数构造函数初始化姓名和年龄
    public Visitor(String name, int age, String ticketType) {
        super(name, age);
        this.ticketType = ticketType;
    }

    // 获取门票类型的方法
    public String getTicketType() {
        return ticketType;
    }

    // 设置门票类型的方法，用于更新游客的门票类型
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}