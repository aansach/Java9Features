interface Java9Interf {
    default void m1() {
        m3();
    }
    
    default void m2() {
        m3();
    }
    
    private void m3() {
        System.out.println("common functionality of methods m1 & m2");
    }
}