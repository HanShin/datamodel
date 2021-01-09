package io.hanshin.datamodel.service.impl;

import io.hanshin.datamodel.model.dto.CustomerResponse;
import io.hanshin.datamodel.model.dto.HomeMovingRequestResponse;
import io.hanshin.datamodel.model.dto.MovingCompanyResponse;
import io.hanshin.datamodel.model.entity.Customer;
import io.hanshin.datamodel.model.entity.CustomerFeedback;
import io.hanshin.datamodel.model.entity.HomeMovingRequest;
import io.hanshin.datamodel.model.entity.MovingCompany;
import io.hanshin.datamodel.model.enums.MovingType;
import io.hanshin.datamodel.model.enums.SatisfactionType;
import io.hanshin.datamodel.repository.CustomerFeedbackRepository;
import io.hanshin.datamodel.repository.CustomerRepository;
import io.hanshin.datamodel.repository.HomeMovingRequestRepository;
import io.hanshin.datamodel.repository.MovingCompanyRepository;
import io.hanshin.datamodel.service.DataModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataModelServiceImpl implements DataModelService {

    private final CustomerFeedbackRepository customerFeedbackRepository;
    private final CustomerRepository customerRepository;
    private final MovingCompanyRepository movingCompanyRepository;
    private final HomeMovingRequestRepository homeMovingRequestRepository;


    public List<CustomerResponse> getCustomerList() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = customers.stream()
                .map(CustomerResponse::valueOf).collect(Collectors.toList());
        return customerResponses;
    }

    @Override
    public List<MovingCompanyResponse> getMovingCompanyList() {
        List<MovingCompany> movingCompanies = movingCompanyRepository.findAll();
        List<MovingCompanyResponse> movingCompanyResponses = movingCompanies.stream()
                .map(MovingCompanyResponse::valueOf).collect(Collectors.toList());
        return movingCompanyResponses;
    }

    @Override
    public List<HomeMovingRequestResponse> getHomeMovingRequestList() {
        List<HomeMovingRequest> homeMovingRequestList = homeMovingRequestRepository.findAll();
        List<HomeMovingRequestResponse> homeMovingRequestResponses = homeMovingRequestList.stream()
                .map(HomeMovingRequestResponse::valueOf).collect(Collectors.toList());
        return homeMovingRequestResponses;
    }

    @Override
    public void testSave() {
        Customer customer = Customer.builder()
                .marketingAgreement(true)
                .name("한신")
                .phone("010-1234-5678")
                .registrationDate(LocalDate.now())
                .termsAgreement(true)
                .thirdPartyAgreement(true)
                .build();

        MovingCompany movingCompany = MovingCompany.builder()
                .address("서울시 강남구 111")
                .detailAddress("강남의빌딩 502호")
                .bizNumber("123-45-67890")
                .bizRegistrationDate(LocalDate.now())
                .ceoName("박대표")
                .companyName("박이사회사")
                .employeeCount(100)
                .etcTruckCount(30)
                .fiveTonTruckCount(10)
                .matchingAvailable(true)
                .oneTonTruckCount(50)
                .phone("02-1234-5678")
                .twoHalfTonTruckCount(35)
                .build();

        CustomerFeedback customerFeedback = CustomerFeedback.builder()
                .contractPrice(BigInteger.valueOf(10000000))
                .disclosure(true)
                .expertSatisfaction(SatisfactionType.VERY_SATISFACTION)
                .feedbackContents("정말 좋은업체에요 감사합니다.")
                .feedbackDate(LocalDate.now())
                .kindSatisfaction(SatisfactionType.SATISFACTION)
                .movingDate(LocalDate.now())
                .movingType(MovingType.HOME)
                .priceSatisfaction(SatisfactionType.NORMAL)
                .revisit(true)
                .customer(customer)
                .movingCompany(movingCompany)
                .build();

        customerFeedbackRepository.save(customerFeedback);

        HomeMovingRequest homeMovingRequest = HomeMovingRequest.builder()
                .addrivedFloor(2)
                .arrivedAddress("경기도 시흥시 정왕동 1234")
                .departAddress("경기도 부천시 원미동 4321")
                .departFloor(25)
                .marketingAgreement(false)
                .movingDate(LocalDate.now())
                .name("이사신")
                .phone("010-1111-2222")
                .storageMoving(false)
                .termsAgreement(true)
                .thirdPartyAgreement(true)
                .build();

        homeMovingRequestRepository.save(homeMovingRequest);
    }
}
