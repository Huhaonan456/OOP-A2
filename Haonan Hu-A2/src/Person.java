public abstract class Person {

    // 姓名，用于标识个人，不能为空，添加相应验证逻辑保证数据有效性
    private String name;
    // 年龄，记录个人的年龄信息，年龄应大于等于0，添加验证逻辑
    private int age;
    // 性别，描述个人的性别，可根据实际情况对取值做限定（当前示例暂未严格限定）
    private String gender;

    // 默认构造函数，创建一个空的Person对象，此时对象的属性未初始化，可按需添加默认值设定逻辑
    public Person() {
    }

    // 带参数的构造函数，用于创建一个具有姓名和年龄的Person对象，性别属性未在构造函数中初始化
    // 添加对姓名和年龄参数的验证，若不符合要求给出提示信息并可考虑设置默认值（当前示例简单打印提示，可按需调整）
    public Person(String name, int age) {
        if (name == null || name.isEmpty()) {
            System.out.println("姓名不能为空，请提供有效的姓名。");
            // 这里可设置默认姓名，比如 "未知姓名"，当前示例暂未设置
        } else {
            this.name = name;
        }

        if (age < 0) {
            System.out.println("年龄不能为负数，请提供有效的年龄。");
            // 可设置默认年龄，比如 0，当前示例暂未设置
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
            System.out.println("设置的姓名不能为空，请重新输入。");
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
            System.out.println("设置的年龄不能为负数，请重新输入。");
        } else {
            this.age = age;
        }
    }

    // 获取性别的方法
    public String getGender() {
        return gender;
    }

    // 设置性别的方法，可根据实际需求添加更严格的取值验证（比如限定只能是"男"或"女"等）
    public void setGender(String gender) {
        this.gender = gender;
    }

    // 重写toString方法，方便在打印对象时展示更详细、友好的信息格式，包含姓名、年龄和性别信息
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}