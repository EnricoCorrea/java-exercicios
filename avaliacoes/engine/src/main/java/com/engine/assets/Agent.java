package com.engine.assets;

import javafx.scene.image.Image;
import java.util.List;

public class Agent{
    private int posX;
    private int posY;
    private int height;
    private int width;
    private int speed;
    private Image image;
    private Environment environment;
     
    public Agent(int posX, int posY, int height, int width, int speed, Image image, Environment environment) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.image = image;
        this.environment = environment;
    }
    public void move(List<String> movements){

    }
    public void chase(int targetX, int targetY){

    }
    
    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public Environment getEnvironment() {
        return environment;
    }
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}