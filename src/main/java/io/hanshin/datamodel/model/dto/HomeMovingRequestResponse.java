package io.hanshin.datamodel.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.hanshin.datamodel.model.entity.HomeMovingRequest;
import io.hanshin.datamodel.utils.MaskingUtil;

import java.time.format.DateTimeFormatter;

public class HomeMovingRequestResponse {
    @JsonProperty("이름")
    private String name;

    private String phone;

    @JsonProperty("출발지")
    private String departAddress;

    @JsonProperty("도착지")
    private String arrivedAddress;

    @JsonProperty("이사일자")
    private String movingDate;

    @JsonProperty("보관이사여부")
    private boolean storageMoving;

    @JsonProperty("연락처")
    public String getPhone(){
        return MaskingUtil.phoneMasking(phone);
    }

    public static HomeMovingRequestResponse valueOf(HomeMovingRequest homeMovingRequest){
        HomeMovingRequestResponse homeMovingRequestResponse = new HomeMovingRequestResponse();
        homeMovingRequestResponse.name = homeMovingRequest.getName();
        homeMovingRequestResponse.phone = homeMovingRequest.getPhone();
        homeMovingRequestResponse.departAddress = homeMovingRequest.getDepartAddress();
        homeMovingRequestResponse.arrivedAddress = homeMovingRequest.getArrivedAddress();

        homeMovingRequestResponse.movingDate = homeMovingRequest.getMovingDate()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        homeMovingRequestResponse.storageMoving = homeMovingRequest.isStorageMoving();

        return homeMovingRequestResponse;
    }

}
