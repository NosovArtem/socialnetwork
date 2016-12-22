package com.sbertech.javaschool.model;

import java.io.Serializable;

public class UserInformationResponse  implements Serializable {

    private UserInformation userInformation;

    private String command;

   /* private int returnCode;*/

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
