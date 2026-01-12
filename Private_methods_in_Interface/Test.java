class Test implements Java9Interf {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1();
        t.m2();
        // t.m3(); // CE: m3() has private access in Java9Interf
    }
}