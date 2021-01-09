package io.hanshin.datamodel.controller;

import io.hanshin.datamodel.model.dto.ApiResponse;
import io.hanshin.datamodel.model.dto.CustomerResponse;
import io.hanshin.datamodel.model.dto.HomeMovingRequestResponse;
import io.hanshin.datamodel.model.dto.MovingCompanyResponse;
import io.hanshin.datamodel.service.DataModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataModelController {

    private final DataModelService dataModelService;

    @GetMapping("/customers")
    @ResponseBody
    public ApiResponse<CustomerResponse> getCustomerList(){
        ApiResponse apiResponse = new ApiResponse(dataModelService.getCustomerList());
        return apiResponse;
    }

    @GetMapping("/moving-companies")
    @ResponseBody
    public ApiResponse<MovingCompanyResponse> getMovingCompanyList(){
        ApiResponse apiResponse = new ApiResponse(dataModelService.getMovingCompanyList());
        return apiResponse;
    }

    @GetMapping("/home-moving-requests")
    @ResponseBody
    public ApiResponse<HomeMovingRequestResponse> getHomeMovingRequestList(){
        ApiResponse apiResponse = new ApiResponse(dataModelService.getHomeMovingRequestList());
        return apiResponse;
    }


    @GetMapping("/test")
    public void test(){
        dataModelService.testSave();
    }

}
