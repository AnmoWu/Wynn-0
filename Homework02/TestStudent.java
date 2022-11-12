public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",20);
        // s1.name = "zhangsan";
        // s1.age = 20;

        Student s2 = new Student("lisi",18);
        // s2.name = "lisi";
        // s2.age = 18;

        System.out.println(s1.name);
        s1.study();
        s1.setName("wangwu");

        s2.setName("chenliu");
    }
}
