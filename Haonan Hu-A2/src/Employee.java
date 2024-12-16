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
    // 同时添加对员工ID和职位的非空验证，若为空则给出提示信息并使用默认值（可根据实际需求调整默认值逻辑）
    public Employee(String name, int age, String employeeId, String jobTitle) {
        super(name, age);
        if (employeeId == null || employeeId.isEmpty()) {
            System.out.println("员工ID不能为空，将设置为默认值（例如：E000）。");
            this.employeeId = "E000";
        } else {
            this.employeeId = employeeId;
        }

        if (jobTitle == null || jobTitle.isEmpty()) {
            System.out.println("员工职位不能为空，将设置为默认值（例如：普通员工）。");
            this.jobTitle = "普通员工";
        } else {
            this.jobTitle = jobTitle;
        }
    }

    // 获取员工ID的方法
    public String getEmployeeId() {
        return employeeId;
    }

    // 设置员工ID的方法，添加非空验证，若为空则给出提示信息并保持原有ID不变
    public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.isEmpty()) {
            System.out.println("设置的员工ID不能为空，保持原有ID不变。");
        } else {
            this.employeeId = employeeId;
        }
    }

    // 获取员工职位的方法
    public String getJobTitle() {
        return jobTitle;
    }

    // 设置员工职位的方法，添加非空验证，若为空则给出提示信息并保持原有职位不变
    public void setJobTitle(String jobTitle) {
        if (jobTitle == null || jobTitle.isEmpty()) {
            System.out.println("设置的员工职位不能为空，保持原有职位不变。");
        } else {
            this.jobTitle = jobTitle;
        }
    }

    // 重写toString方法，方便打印员工信息时展示更友好的格式
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", employeeId='" + employeeId + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
