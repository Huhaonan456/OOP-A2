public abstract class Person {

    // 姓名，用于标识个人
    private String name;
    // 年龄，记录个人的年龄信息
    private int age;
    // 性别，描述个人的性别
    private String gender;

    // 默认构造函数，创建一个空的Person对象，此时对象的属性未初始化
    public Person() {
    }

    // 带参数的构造函数，用于创建一个具有姓名和年龄的Person对象，性别属性未在构造函数中初始化
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 获取姓名的方法
    public String getName() {
        return name;
    }

    // 设置姓名的方法
    public void setName(String name) {
        this.name = name;
    }

    // 获取年龄的方法
    public int getAge() {
        return age;
    }

    // 设置年龄的方法
    public void setAge(int age) {
        this.age = age;
    }

    // 获取性别的方法
    public String getGender() {
        return gender;
    }

    // 设置性别的方法
    public void setGender(String gender) {
        this.gender = gender;
    }
}