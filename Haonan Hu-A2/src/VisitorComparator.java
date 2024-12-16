import java.util.Comparator;

/**
 * VisitorComparator 类实现了 Comparator 接口，用于定义 Visitor 对象之间的比较
 * 先按照游客的年龄进行比较，如果年龄相同，则按照游客的姓名进行比较
 * 以此来确定两个 Visitor 对象在排序等操作中的先后顺序
 */
public class VisitorComparator implements Comparator<Visitor> {

    /**
     * 方法定义 Visitor 对象之间的具体比较。
     * 先比较年龄，若年龄相等再比较姓名，最终确定两个 Visitor 对象的顺序关系
     * @param v1 要进行比较的第一个 Visitor 对象，不能为空
     * @param v2 要进行比较的第二个 Visitor 对象，不能为空
     * @return 一个整数，若返回值小于 0，则表示 v1 小于 v2；若返回值等于 0，则表示 v1 等于 v2；若返回值大于 0，则表示 v1 大于 v2
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        return compareByAgeAndName(v1, v2);
    }

    /**
     * 私有方法，用于按照年龄和姓名的顺序比较两个 Visitor 对象。
     * 先比较年龄，如果年龄相同再比较姓名，确定两者的顺序关系。
     *
     * @param v1 第一个要比较的 Visitor 对象，要求不为空。
     * @param v2 第二个要比较的 Visitor 对象，要求不为空。
     * @return 比较结果，返回值的含义同 Comparator 接口中 compare 方法
     */
    private int compareByAgeAndName(Visitor v1, Visitor v2) {
        // 首先比较两个游客的年龄
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        // 如果年龄相同，则进一步比较姓名
        if (ageComparison == 0) {
            return v1.getName().compareTo(v2.getName());
        }
        // 返回年龄比较的结果，用于确定两个游客的顺序
        return ageComparison;
    }
}
