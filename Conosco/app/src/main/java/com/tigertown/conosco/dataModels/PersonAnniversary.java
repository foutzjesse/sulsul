package com.tigertown.conosco.dataModels;
import com.tigertown.conosco.global.modelInterfaces.*;

public class PersonAnniversary implements IPersonJoinRecord {
    public int personid;
    public int anniversaryid;

    public PersonAnniversary(int p, int a) {
        this.personid = p;
        this.anniversaryid = a;
    }
}
