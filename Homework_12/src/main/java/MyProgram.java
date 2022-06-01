@Test public class MyProgram {

    @Test
    public void m1(String a, int b) {
    }

    public static void m2() {
    }

    @Test
    public static void m3(int a, int b, boolean c) {
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @Test
    public static void m5(int a, int b, String c, boolean d) {
    }

    public static void m6() {
    }

    @Test
    public void m7(String a, boolean b, String c) {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }
}