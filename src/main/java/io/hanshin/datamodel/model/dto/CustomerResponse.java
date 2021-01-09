package io.hanshin.datamodel.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.hanshin.datamodel.model.entity.Customer;
import io.hanshin.datamodel.utils.MaskingUtil;
import lombok.Getter;

@Getter
public class CustomerResponse {

    @JsonProperty("이름")
    private String name;

    private String phone;

    @JsonProperty("연락처")
    public String getPhone(){
        return MaskingUtil.phoneMasking(phone);
    }

    public static CustomerResponse valueOf(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.name = customer.getName();
        customerResponse.phone = customer.getPhone();
        return customerResponse;
    }


}
