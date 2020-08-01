/**
 * Exercise for learning how the debug, breakpoint, and step-into
 * feature work.
 */
public class DebugExercise1 {
    public static long divideThenRound(int top, int bottom) {
        double quotient = top *1.0/ bottom;   // 整数和float做运算默认是float,和double运算结果就是double，但是*1.0出来的是double
        long result = Math.round(quotient); //传float返回int, 传double返回long
        return result;
    }

    public static String getType(Object o) {
        return o.getClass().getName();
    }

    public static void main(String[] args) {
        int t = 10;
        int b = 2;
        long result = divideThenRound(t, b);
        System.out.println("round(" + t + "/" + b + ")=" + result);

        int t2 = 9;
        int b2 = 4;
        long result2 = divideThenRound(t2, b2);
        System.out.println("round(" + t2 + "/" + b2 + ")=" + result2);

        int t3 = 1;
        int b3 = 3;
        long result3 = divideThenRound(t3, b3);
        System.out.println("round(" + t3 + "/" + b3 + ")=" + result3);


    }
}
