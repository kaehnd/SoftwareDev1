package kaehnd;
import java.util.Scanner;

public class ClassMethods {

   private double percentGrowthRate;
   public int age;
   public double weight;
   public String name;
   public int grades;


   public  ClassMethods (int age, double weight){
        this.age = age;
        this.weight = weight;
    }
    public ClassMethods (String name, int age, int grades){
       this.name = name;
       this.age = age;
       this.grades = grades;
    }

   public void setPercentGrowthRate(double percentGrowthRate){
       this.percentGrowthRate = percentGrowthRate;
   }

    public double getPercentGrowthRate() {
        return percentGrowthRate;
    }
    public void grow(){
       this.weight += .01 * this.percentGrowthRate * this.weight;
       this.age++;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
    public void display(){
       System.out.println(this.getWeight());
       System.out.println(this.getAge());
    }
}
//end main
 //end class MethodSyntax
