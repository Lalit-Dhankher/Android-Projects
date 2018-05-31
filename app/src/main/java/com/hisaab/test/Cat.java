package com.hisaab.test;

/**
 * Created by Lalit dhankher on 5/17/2018.
 */

public class Cat {

    private String color;

    public Cat(String color){
        /*
            no return type
            same name as Class name
            cannot be private
        * */

        this.color=color;

    }

    protected String getColor(){

    /*
    structure:
    scope returnType methodName(Args ..){
        return x;
    }

    scope
    public: accessible everywhere
    private: within class
    default: same package
    protected:  only to the child class

    methodName:
    anything but not keyword

    * */

        return color;
    }

}

/*

modifier:
public : accesible everwhere
private : accesible to outer classes only
default : accesible to same package only


* */