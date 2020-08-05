package com.javarush.task.task19;

/**
 * Created by Alex on 03.12.2019.
 */
class Actor{
    public void act(){
        System.out.println("Actor");
    }
}

class HappyActor extends Actor{
//    Actor actor = new HappyActor();
    public void act(){
        System.out.println("HappyActor");
    }
}
class SadActor extends Actor{
//    Actor actor = new SadActor();
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage{
    private Actor actor = new HappyActor();
    public void change(){
        actor = new SadActor();
    }
    public void performPlay(){
        actor.act();
    }
}

public class Transmogrify {

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
