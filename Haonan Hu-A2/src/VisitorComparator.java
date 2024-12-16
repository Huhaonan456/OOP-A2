import java.util.Comparator;

// 游客比较器类，用于实现对Visitor对象的比较逻辑
public class VisitorComparator implements Comparator<Visitor> {

    // 重写compare方法，定义Visitor对象的比较规则
    @Override
    public int compare(Visitor v1, Visitor v2) {
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