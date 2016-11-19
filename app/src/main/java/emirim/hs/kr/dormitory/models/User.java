package emirim.hs.kr.dormitory.models;

/**
 * Created by Student on 2016-11-15.
 */


// [START blog_user_class]
public class User {

    public String work;
    private int year;
    private int month;
    private int date;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String work, int year,int month, int date) {
        this.work = work;
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public String getWork(){
        return work;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){return month;}
    public int getDate(){
        return date;
    }

}
// [END blog_user_class]