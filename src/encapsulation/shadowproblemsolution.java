package encapsulation;

import java.util.Scanner;

class Dog1 {
    private String name;
    private String color;
    private String breed;
    private int age;
    private int cost;

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public String getBreed() {
        return breed;
    }
    public int getAge() {
        return age;
    }
    public int getCost() {
        return cost;
    }
}

public class shadowproblemsolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dog1 d1 = new Dog1();

        System.out.print("Enter the name of the dog: ");
        String name = sc.nextLine();

        System.out.print("Enter the color of the dog: ");
        String color = sc.nextLine();

        System.out.print("Enter the breed of the dog: ");
        String breed = sc.nextLine();

        System.out.print("Enter the age of the dog: ");
        int age = sc.nextInt();

        System.out.print("Enter the cost of the dog: ");
        int cost = sc.nextInt();

        d1.setName(name);
        d1.setColor(color);
        d1.setBreed(breed);
        d1.setAge(age);
        d1.setCost(cost);

        // Printing the values using getters
        System.out.println("\nDog Details:");
        System.out.println("Name  : " + d1.getName());
        System.out.println("Color : " + d1.getColor());
        System.out.println("Breed : " + d1.getBreed());
        System.out.println("Age   : " + d1.getAge());
        System.out.println("Cost  : " + d1.getCost());

        sc.close();
    }
}
