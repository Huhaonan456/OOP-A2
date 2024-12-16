public abstract class Person {
    // 姓名，用于标识个人，不能为空
    private String name;
    // 年龄，记录个人的年龄信息，年龄应大于等于0
    private int age;
    // 性别，描述个人的性别
    private String gender;

    // 默认构造函数，创建一个空的Person对象
    public Person() {
    }

    // 带参数的构造函数，用于创建一个具有姓名和年龄的Person对象
    // 添加对姓名和年龄参数的验证
    public Person(String name, int age) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty. Please provide a valid name.");
        } else {
            this.name = name;
        }

        if (age < 0) {
            System.out.println("Age cannot be negative. Please provide a valid age.");
        } else {
            this.age = age;
        }
    }

    // 获取姓名的方法
    public String getName() {
        return name;
    }

    // 设置姓名的方法，添加验证逻辑，确保新设置的姓名不为空
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("The set name cannot be empty. Please re-enter.");
        } else {
            this.name = name;
        }
    }

    // 获取年龄的方法
    public int getAge() {
        return age;
    }

    // 设置年龄的方法，添加验证逻辑，确保新设置的年龄不小于0
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("The set age cannot be negative. Please re-enter.");
        } else {
            this.age = age;
        }
    }

    // 获取性别的方法
    public String getGender() {
        return gender;
    }

    // 设置性别的方法
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}