/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.obj1;

/**
 *
 * @author apprentice
 */
public class Obj1 {

}

class house {

    String color;
    int numOfRooms;
    int numOfDoors;
    int numOfWindows;
    String materials;

    holdsPpl();

    protection();

    storage();
}

class student {

    int age;
    String collegeName;
    String typeOfDegree;
    String gender;
    double gpa;

    sleep();

    study();

    eat();
}

class employee {

    String name;
    int age;
    String title;
    int workId;
    double salary;

    works();

    signsPapers();

    bathroomBreak();

}

class manager {

    int id;
    String name;
    String dept;
    String mgrType;
    double salary;

    makeSchedule();

    supervise();

    holdMeeting();

}

class airplane {

    String brand;
    int capacity;
    String engineType;
    boolean millitary;
    int topSpeed;

    flys();

    lands();

    crash();

}

class school {

    String name;
    String location;
    String type;
    int studentPop;
    int teacherPop;

    open();

    closed();

    busService();

}

class city {

    String name;
    String state;
    int population;
    String stateBird;
    boolean nbaTeam;

    medicalService();

    publicTrans();

    fair();

}

class triangle {

    float height, width, area, angleSum;
    boolean rightTriangle;

    fitInternalTriangle();

    fitInternalCircle();

    fitInternalSquare();
}

class chair {

    String brand, color;
    float weightCap, seats;
    boolean wheels;

    recline();

    moveOnWheels();

    moveUpDown();

}

class couch {

    String color, brand, material;
    float weightCap, seats;

    foldOut();

    recline();

    holdCup();

}

class table {

    String color, brand, material;
    float height, weight;

    fold();

    changeWidth();

    revolve();

}

class Car {

    String carModel;
    String carMake;
    int carYear;
    String carColor;
    int carCapacity;

    isCarMoves();

    hasBreaks();

    hasHeatedSeat();
}

class Truck {

    String truckModel;
    String truckMake;
    int truckYear;
    String truckColor;
    boolean truckTow;

    isTruckStartsUp();

    isTruckStowThings();

    isTruckAddAHitch();

}

class Square {

    int height;
    int width;
    int area;
    int perim;
    int lines;

    hasDiagonals();

    canFitTriangels();

    canFitAnotherSquare();

}
