public class Visitor extends Person {

    // 游客的门票类型，用于区分不同类型的门票（例如普通票、学生票、优惠票等）
    private String ticketType;

    // 默认构造函数，创建一个空的Visitor对象，会调用父类（Person）的默认构造函数，此时门票类型未初始化
    public Visitor() {
        super();
    }

    // 带参数的构造函数，用于创建一个具有特定姓名、年龄和门票类型的Visitor对象，并调用父类（Person）的带参数构造函数初始化姓名和年龄
    // 添加对门票类型参数的验证逻辑，若为空则给出提示信息并可考虑设置默认值（当前示例简单打印提示，可按需调整）
    public Visitor(String name, int age, String ticketType) {
        super(name, age);
        if (ticketType == null || ticketType.isEmpty()) {
            System.out.println("门票类型不能为空，请提供有效的门票类型。");
            // 这里可设置默认门票类型，比如 "普通票"，当前示例暂未设置
        } else {
            this.ticketType = ticketType;
        }
    }

    // 获取门票类型的方法
    public String getTicketType() {
        return ticketType;
    }

    // 设置门票类型的方法，添加验证逻辑，确保新设置的门票类型不为空
    public void setTicketType(String ticketType) {
        if (ticketType == null || ticketType.isEmpty()) {
            System.out.println("设置的门票类型不能为空，请重新输入。");
        } else {
            this.ticketType = ticketType;
        }
    }

    // 重写toString方法，方便在打印游客对象信息时展示更详细、友好的格式，包含姓名、年龄、性别和门票类型信息
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}
