interface Java8Interf {
    public void m1();
    public void m2();
    
    default void m3() {
        System.out.println("Default Implementation of m3()");
    }
}
