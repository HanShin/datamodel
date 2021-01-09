package io.hanshin.datamodel.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.hanshin.datamodel.model.entity.MovingCompany;
import io.hanshin.datamodel.utils.MaskingUtil;
import lombok.Getter;

@Getter
public class MovingCompanyResponse {

    @JsonProperty("업체명")
    private String companyName;;

    private String phone;

    @JsonProperty("주소정보")
    private String address;

    @JsonProperty("매칭가능여부")
    private boolean matchingAvailable;

    @JsonProperty("연락처")
    public String getPhone() {
        return MaskingUtil.phoneMasking(phone);
    }

    public static MovingCompanyResponse valueOf(MovingCompany movingCompany){
        MovingCompanyResponse movingCompanyResponse = new MovingCompanyResponse();
        movingCompanyResponse.companyName = movingCompany.getCompanyName();
        movingCompanyResponse.address = movingCompany.getAddress();
        movingCompanyResponse.phone = movingCompany.getPhone();
        return movingCompanyResponse;
    }

}
