package com.adobe.aem.newsportal.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(AemContextExtension.class)
class UserInfoModelTest {
AemContext context = new AemContext();
UserInfoModel userInfoModel;

 @BeforeEach
    void init(){
     context.addModelsForClasses(UserInfoModel.class, UserInfoModel.UserExtraInfoModel.class);
     context.load().json("/userInfo.json","/content");
     Resource resource = context.currentResource("/content/test");
     userInfoModel= resource.adaptTo(UserInfoModel.class);
 }
    @Test
    void userInfoModel(){
assertEquals("Sushma",userInfoModel.getUserName());
assertEquals("123",userInfoModel.getUserId());
assertEquals("Female",userInfoModel.getGender());
assertEquals("95",userInfoModel.getMarks());
    }
@Test
void userExtraInfoModel(){

    List<UserInfoModel.UserExtraInfoModel> extra = userInfoModel.getUserExtraInfo();

    assertNotNull(extra);
    assertEquals(1, extra.size());

    assertEquals("9876543210", extra.get(0).getMobileNo());
    assertEquals("Hyderabad", extra.get(0).getAddress());



}
}