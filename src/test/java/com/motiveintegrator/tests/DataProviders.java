package com.motiveintegrator.tests;

import com.motiveintegrator.models.User;
import com.motiveintegrator.models.UserRoles;
import com.motiveintegrator.utilities.FilesUtils;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviders {

    @DataProvider
    public static Object[][] getAdminUser() {
        Object[][] admin=new User[1][0];
        List<User> users=FilesUtils.getPoJoFromJSON("./src/test/resources/data/users.json", User.class);
        for(int i=0;i<users.size();i++){
            if(users.get(i).getRole().equals(UserRoles.ADMIN)){
                admin[0][0]=users.get(i);
                break;
            }
        }
        return admin;
    }
}
