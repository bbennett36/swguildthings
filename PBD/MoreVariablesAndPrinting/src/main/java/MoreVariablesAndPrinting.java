/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class MoreVariablesAndPrinting {
    public static void main( String[] args )
    {
        String name, eyes, teeth, hair;
        int age, height;
        double cm, kg, weight;

        name = "Zed A. Shaw";
        age = 35;     // not a lie
        height = 74;  // inches
        cm = (height * 2.54); // centimeters
        weight = 180; // lbs
        kg = (weight * 0.45359237); // kg
        eyes = "Blue";
        teeth = "White";
        hair = "Brown";

        System.out.println( "Let's talk about " + name + "." );
        System.out.println( "He's " + height + " inches (or " + cm + "cm ) tall." );
        System.out.println( "He's " + weight + " pounds (or " + kg + "kg) heavy." );
        System.out.println( "Actually, that's not too heavy." );
        System.out.println( "He's got " + eyes + " eyes and " + hair + " hair." );
        System.out.println( "His teeth are usually " + teeth + " depending on the coffee." );

        // This line is tricky; try to get it exactly right.
        System.out.println( "If I add " + age + ", " + height + ", and " + weight
            + " I get " + (age + height + weight) + "." );
    }
}
