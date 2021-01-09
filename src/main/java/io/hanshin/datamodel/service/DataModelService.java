package io.hanshin.datamodel.service;

import io.hanshin.datamodel.model.dto.CustomerResponse;
import io.hanshin.datamodel.model.dto.HomeMovingRequestResponse;
import io.hanshin.datamodel.model.dto.MovingCompanyResponse;

import java.util.List;

public interface DataModelService {
    List<CustomerResponse> getCustomerList();
    List<MovingCompanyResponse> getMovingCompanyList();
    List<HomeMovingRequestResponse> getHomeMovingRequestList();

    void testSave();

}
