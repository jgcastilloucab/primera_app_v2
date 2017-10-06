package edu.ucab.uilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utilities {

    private static final EntityManagerFactory EMF = Persistence
            .createEntityManagerFactory("LoginSampleDBPU");
    
    public static EntityManagerFactory getEMF(){
        return EMF;
    }
}
