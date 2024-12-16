import java.util.Date;

public class Visitor extends Person {
    // 游客的门票类型，用于区分不同类型的门票（例如普通票、学生票、儿童票等）
    private String ticketType;
    // 游客的参观日期
    private Date visitDate;

    // 定义儿童票的年龄界限
    private static final int CHILD_AGE_LIMIT = 12;

    // 默认构造函数，创建一个空的Visitor对象，调用父类（Person）的默认构造函数
    public Visitor() {
        super();
    }

    // 带参数的构造函数，用于创建一个具有特定姓名、年龄、性别和门票类型的Visitor对象，并调用父类（Person）的带参数构造函数初始化姓名、年龄和性别
    // 添加对门票类型参数的验证逻辑，若为空则给出提示信息
    // 同时初始化参观日期为当前日期
    public Visitor(String name, int age, String gender, String ticketType) {
        super(name, age);
        // 初始化性别属性
        setGender(gender);
        if (ticketType == null || ticketType.isEmpty()) {
            System.out.println("Ticket type cannot be empty. It will be set to the default ticket type (Regular Ticket).");
            this.ticketType = "Regular Ticket";
        } else {
            this.ticketType = ticketType;
        }
        this.visitDate = new Date();
    }

    // 获取门票类型的方法
    public String getTicketType() {
        return ticketType;
    }

    // 设置门票类型的方法，添加验证逻辑，确保新设置的门票类型不为空
    public void setTicketType(String ticketType) {
        if (ticketType == null || ticketType.isEmpty()) {
            System.out.println("The set ticket type cannot be empty. Please re-enter.");
        } else {
            this.ticketType = ticketType;
        }
    }

    // 获取参观日期的方法
    public Date getVisitDate() {
        return visitDate;
    }

    // 设置参观日期的方法
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    // 判断是否为儿童票的方法，通过门票类型判断以及年龄是否在儿童票对应的年龄范围内来确定
    public boolean isChildTicket() {
        return "Child Ticket".equals(ticketType) || getAge() <= CHILD_AGE_LIMIT &&!("Regular Ticket".equals(ticketType) || "Student Ticket".equals(ticketType));
    }

    @Override
    public String toString() {
        StringBuilder ticketDisplay = new StringBuilder(ticketType);
        if (isChildTicket()) {
            ticketDisplay.append(" (Child Ticket)");
        }
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", ticketType='" + ticketDisplay.toString() + '\'' +
                ", visitDate=" + visitDate +
                '}';
    }
}