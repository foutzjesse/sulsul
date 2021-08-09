import java.time;

public class Person {
    public Guid id;
    public Name name;
    public String circle;
    //image
    //contact link
    public String howMet;
    public List<Anniversary> anniversaries;
    public List<Trait> traits;

    public String hometown;
    public List<Education> education;
    public String residence;
	
	public List<Relationship> relationships;

    public String job;
    public String socialGroup;
    public List<Favorite> faves;
    public List<String> interests;

    public String notes;
}

public class Name {
    public String fn;
    public String ln;
    public String phonetic;
    public String nickname;
    public String display;
}

public class Relationship {
	public String type;
	public Name name;
}

public class Trait {
    public String icon;
    public String name;
    public String grouping;
    public String description;
    public String notes;
}

public class Education {
    public String school;
    public int year;
    public String degree;
    public String major;
    public String notes;
}

public class Anniversary {
    public String type;
    public LocalDate date;
    public Boolean getsNotifications;

    public Anniversary() {
        this.getsNotifications = true;
    }
}

public class Favorite {
    public String type; //color, food, movies, TV, music, team
    public String value;
}
