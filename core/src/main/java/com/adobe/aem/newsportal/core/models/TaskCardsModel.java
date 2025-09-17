package com.adobe.aem.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TaskCardsModel {
    @ValueMapValue
    private String cardTitle;
    @ValueMapValue
    private String description;
    @ValueMapValue
    private String  genderSelect;

    @ChildResource
private List<productDetailsModel>productDetails;

    public List<productDetailsModel> getProductDetails() {
        return productDetails;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getGenderSelect() {
        return genderSelect;
    }


    @Model(adaptables = {Resource.class},
            defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
    public class productDetailsModel{
        @ValueMapValue
        private String productcardTitle;
        @ValueMapValue
        private String productcardPrice;
        @ValueMapValue
        private String productcardImage;
        @ValueMapValue
        private String productcardExpiry;
        @ValueMapValue
        private String productcardColor;

        public String getProductcardExpiry() {
            return productcardExpiry;
        }

        public String getProductcardImage() {
            return productcardImage;
        }

        public String getProductcardPrice() {
            return productcardPrice;
        }

        public String getProductcardTitle() {
            return productcardTitle;
        }

        public String getProductcardColor() {
            return productcardColor;
        }
    }



}
