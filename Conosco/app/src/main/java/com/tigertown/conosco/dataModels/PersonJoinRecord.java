package com.tigertown.conosco.dataModels;
import com.tigertown.conosco.global.modelInterfaces.*;

public class PersonJoinRecord implements IPersonJoinRecord {
    public int personid;
    public int recordId;

    public PersonJoinRecord(int p, int r) {
        this.personid = p;
        this.recordId = r;
    }
}
