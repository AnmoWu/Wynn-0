import java.util.*;
public class Color{
    private int value;                           //颜色值
    public Color(int red, int green, int blue)   //构造方法
    {
        value = 0xff000000 | ((red & 0xFF)<<16) | ((green & 0xFF)<<8) | blue & 0xFF;
    }
    public Color(int rgb)
    {
        value = 0xff000000 | rgb;
    }
    public int getRGB()
    {
        return value;
    }
    public int getRed()
    {
        return (getRGB()>>16) & 0xFF;
    }
    public int getGreen()
    {
        return (getRGB()>> 8) & 0xFF;
    }
    public int getBlue()
    {
        return  getRGB() & 0xFF;
    }
    public String toString()
    {
        return getClass().getName()+",RGB("+getRed()+","+getGreen()+","+getBlue()+"),0x"
                +Integer.toHexString(value);
    }

    public static void main(String args[])
    {
        System.out.println(new Color(255,0,0).toString());      //红
        System.out.println(new Color(0,255,0).toString());      //绿
        System.out.println(new Color(0,0,255).toString());      //蓝
    }
}