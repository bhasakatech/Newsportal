package com.adobe.aem.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.*;


// import javax.annotation.PostConstruct;
import java.util.List;

@Model(adaptables = {Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserInfoModel {

    @ValueMapValue
    private String userName;

    @ValueMapValue
    private String userId;

    @ValueMapValue
    private String gender;

    @ValueMapValue
    private String marks;

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getGender() {
        return gender;
    }

    public String getMarks() {
        return marks;
    }

    @ChildResource
    private List<UserExtraInfoModel> userExtraInfo;

    public List<UserExtraInfoModel> getUserExtraInfo() {
        return userExtraInfo;
    }





    @Model(adaptables = {Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public  static class UserExtraInfoModel {

        @ValueMapValue
        private String mobileNo;

        @ValueMapValue
        private String address;

        public String getMobileNo() {
            return mobileNo;
        }

        public String getAddress() {
            return address;
        }
    }


}
