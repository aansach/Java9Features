interface Java9InterfStatic {
    public static void m1() {
        m3();
    }
    
    public static void m2() {
        m3();
    }
    
    private static void m3() {
        System.out.println("common functionality of methods m1 & m2");
    }
}