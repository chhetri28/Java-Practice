public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static void message(){
        System.out.println("Hello World");
    }
    static int pop=0;
    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.pop+=1;
    }
} 
