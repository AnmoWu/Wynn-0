import java.util.Scanner;
public class Complex {  //z=a+bi;
    private double real;
    private double image;

    public Complex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public Complex(String s) {
        s = s.trim();
        int op = -1;
        int i_index = -1;
        int len = s.length();
        String a = "";
        String b = "";
        if (s != null && !"".equals(s)) {
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') op = i;
                if (s.charAt(i) == 'i') i_index = i;
            }
            if (i_index == -1) {
                a = s;
                b = "0";
            } else if (op == -1 && i_index != -1) {
                if (i_index == 0) {
                    a = "0";
                    b = "1";
                } else {
                    a = "0";
                    b = s.substring(0, i_index);
                }
            } else if (op == 0 && i_index != 1) {
                if (i_index == 1) {
                    a = "0";
                    b = "-1";
                } else {
                    a = "0";
                    b = s.substring(0, i_index);
                }
            } else if (i_index - op == 1) {
                a = s.substring(0, op);
                b = s.charAt(op) + "1";
                if ("".equals(a)) a = "0";
            } else if (i_index != -1 && op != -1) {
                a = s.substring(0, op);
                b = s.substring(op, i_index);
                if ("".equals(a)) a = "0";
                if ("".equals(b)) b = "0";
            }
            Set(Double.valueOf(a), Double.valueOf(b));
        }
    }

    public void Set(double a, double b) {
        //构造复数
        this.real = a;
        this.image = b;
    }

    public String Add(Complex another) {
        //加法
        double add_x = this.real + another.real;
        double add_y = this.image + another.image;
        return new Complex(add_x, add_y).toString();
    }

    public String Sub(Complex another) {
        //减法
        double sub_x = this.real - another.real;
        double sub_y = this.image - another.image;
        return new Complex(sub_x, sub_y).toString();
    }

    public void Model(Complex another) {
        //模
        double x = this.real - another.real;
        double y = this.image - another.image;
        System.out.println("复数的模长为：" + String.format("%.2f", Math.sqrt(x * x + y * y)));
    }

    public String toString() {
        //字符串描述
        if (this.getReal() == 0 && this.getImage() == 0) {
            return "z = 0.0";
        }
        if (this.getReal() == 0) {
            return "z = " + this.getImage() + "i";
        }
        if (this.getImage() == 0) {
            return "z = " + String.valueOf(this.getReal());
        }
        if (this.getImage() < 0) {
            return "z = " + this.getReal() + "+(" + this.getImage() + "i)";
        }
        if (this.getImage() > 0) {
            return "z = " + this.getReal() + "+" + this.getImage() + "i";
        }
        return null;
    }

    public boolean equals(Complex another) {
        //是否相等
        return this == another || another != null && this.real == another.real && this.image == another.image;
    }

    public double getReal() {
        return real;
    }

    public double getImage() {
        return image;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个复数：");
        String s1 = sc.next();
        System.out.println("请输入第二个复数：");
        String s2 = sc.next();
        Complex z1 = new Complex(s1);
        Complex z2 = new Complex(s2);
        while (true) {
            System.out.println("1.计算加法\t2.计算减法\t3.计算模长\t4.比较是否相等\t5.exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(z1.Add(z2));
                    break;
                case 2:
                    System.out.println(z1.Sub(z2));
                    break;
                case 3:
                    z1.Model(z2);
                    break;
                case 4: {
                    if (z1.equals(z2)) System.out.println("Yes");
                    else System.out.println("No");
                    break;
                }
                case 5:
                    return;
            }
        }
    }
}

