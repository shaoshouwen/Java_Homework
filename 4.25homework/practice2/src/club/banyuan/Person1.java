  
package club.banyuan;

public class Person1{
    private String name;
    private int age;
    
    public Person1(){

    }
    public Person1(String name){
        this.name = name;
    }
    public Person1(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void speak(){
        System.out.println("名字："+this.name+"，年龄："+this.age);
    }

}