package ru.nosov.javaschool.userinfo.model;

import java.io.Serializable;

public class UserInformationResponse  implements Serializable {

    private UserInformation userInformation;

   /* private int returnCode;*/

    private String command;

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }


}
