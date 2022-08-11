public class myClass {
    private int a;
    private int b;

    public myClass(int a, int b){
        this.a=a;
        this.b=b;
    }

    public void sayHello(){
        System.out.println("Hello");
    }
    public String returnHello(String name){
        return "Hello" + name;
    }
}
