package emirim.hs.kr.dormitory.models;

import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class UserLogin {

    public String username;
    public String email;

    public UserLogin() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public UserLogin(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
// [END blog_user_class]
