package com.engine.assets;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.List;
import java.util.ArrayList;

public class Environment{
    private int posX;
    private int posY;
    private int height;
    private int width;
    private Image image;
    private GraphicsContext gc;
    private List<Agent> agents = new ArrayList<>();
    private Agent protagonist;

    
    public Environment(){}

    public Environment(int posX, int posY, int height, int width, Image image, GraphicsContext gc) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.image = image;
        this.gc = gc;
    }

    public void printStatusPanel(Agent agent){

    }

    public void drawBackground(){

    }
    public void D
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public Agent getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(Agent protagonist) {
        this.protagonist = protagonist;
    }

    


}