public class Student {
    String name;
    int age;
    //构造函数
    public Student() {
        this("guest",10); //一定要写在构造函数的第一行
    }   

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("student construct!");
    }
    public void study() {
        int i =10;
        System.out.println(name+"正在学习");
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void g(Student s) {
        System.out.println(s.name);
    }

    public void printSelf(){
        g(this);
    }
}
