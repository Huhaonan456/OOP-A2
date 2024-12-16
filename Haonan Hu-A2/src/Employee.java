public class Employee extends Person {

    // 员工ID，用于唯一标识员工
    private String employeeId;
    // 员工职位，描述员工的工作职责
    private String jobTitle;

    // 默认构造函数，用于创建一个空的Employee对象，会调用父类（Person）的默认构造函数
    public Employee() {
        super();
    }

    // 带参数的构造函数，用于创建一个具有特定属性的Employee对象，并调用父类（Person）的带参数构造函数初始化姓名和年龄
    public Employee(String name, int age, String employeeId, String jobTitle) {
        super(name, age);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    // 获取员工ID的方法
    public String getEmployeeId() {
        return employeeId;
    }

    // 设置员工ID的方法
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // 获取员工职位的方法
    public String getJobTitle() {
        return jobTitle;
    }

    // 设置员工职位的方法
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}