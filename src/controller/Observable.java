package controller;

public class Observable{
    private Observer[] observerArray = new Observer[0];
    private static Observable instance;
    private int nextIndex;

    public void SetOb(Observer observer) {
        extendsArray();
        observerArray[nextIndex++]=observer;
    }
    public void extendsArray(){
        Observer[] tempArray=new Observer[observerArray.length+1];
        for(int i=0;i< observerArray.length;i++){
            tempArray[i]=observerArray[i];
        }
        observerArray=tempArray;
    }
    public void setMessage(String message,String title) {
        for (Observer ob : observerArray) {
            ob.update(message+"",title+"");
        }
    }
    public static Observable getInstance() {
        if (instance == null) {
            instance = new Observable();
        }
        return instance;
    }
}