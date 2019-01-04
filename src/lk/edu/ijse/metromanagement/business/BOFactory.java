package lk.edu.ijse.metromanagement.business;

public class BOFactory {

    private static BOFactory boFactory;

    public BOFactory() {

    }

    public static BOFactory getInstance(){
        if(boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
}
