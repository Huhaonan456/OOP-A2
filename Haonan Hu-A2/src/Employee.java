public class Employee extends Person {
    // 员工ID，用于唯一标识员工
    private String employeeId;
    // 员工职位，描述员工的工作职责
    private String jobTitle;

    // 默认构造函数，用于创建一个空的Employee对象，会调用父类（Person）的默认构造函数
    public Employee() {
        super();
    }

    // 带参数的构造函数，用于创建Employee对象，并调用父类（Person）的带参数构造函数初始化姓名和年龄
    // 添加对员工ID和职位的验证，若为空则给出提示信息并使用默认值
    public Employee(String name, int age, String employeeId, String jobTitle) {
        super(name, age);
        if (employeeId == null || employeeId.isEmpty()) {
            System.out.println("Employee ID cannot be empty, and it will be set to the default value.");
            this.employeeId = "E000";
        } else {
            this.employeeId = employeeId;
        }

        if (jobTitle == null || jobTitle.isEmpty()) {
            System.out.println("Job title cannot be empty, and it will be set to the default value.");
            this.jobTitle = "General Staff";
        } else {
            this.jobTitle = jobTitle;
        }
    }

    // 获取员工ID的方法
    public String getEmployeeId() {
        return employeeId;
    }

    // 设置员工ID的方法，添加验证，若为空则给出提示信息并保持原有ID不变
    public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.isEmpty()) {
            System.out.println("The set Employee ID cannot be empty, and the original ID will remain unchanged.");
        } else {
            this.employeeId = employeeId;
        }
    }

    // 获取员工职位的方法
    public String getJobTitle() {
        return jobTitle;
    }

    // 设置员工职位的方法，添加验证，若为空则给出提示信息并保持原有职位不变
    public void setJobTitle(String jobTitle) {
        if (jobTitle == null || jobTitle.isEmpty()) {
            System.out.println("The set job title cannot be empty, and the original job title will remain unchanged.");
        } else {
            this.jobTitle = jobTitle;
        }
    }

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