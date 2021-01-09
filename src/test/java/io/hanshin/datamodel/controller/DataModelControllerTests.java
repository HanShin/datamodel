package io.hanshin.datamodel.controller;

import io.hanshin.datamodel.model.entity.Customer;
import io.hanshin.datamodel.model.entity.HomeMovingRequest;
import io.hanshin.datamodel.model.entity.MovingCompany;
import io.hanshin.datamodel.repository.CustomerRepository;
import io.hanshin.datamodel.repository.HomeMovingRequestRepository;
import io.hanshin.datamodel.repository.MovingCompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
public class DataModelControllerTests {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MovingCompanyRepository movingCompanyRepository;

    @Autowired
    private HomeMovingRequestRepository homeMovingRequestRepository;

    @Test
    public void 고객리스트_test() throws Exception {
        //given
        Customer customer1 = Customer.builder()
                .marketingAgreement(true)
                .name("한신")
                .phone("010-1234-5678")
                .registrationDate(LocalDate.now())
                .termsAgreement(true)
                .thirdPartyAgreement(true)
                .build();

        customerRepository.save(customer1);

        Customer customer2 = Customer.builder()
                .marketingAgreement(false)
                .name("박신")
                .phone("010-4444-5555")
                .registrationDate(LocalDate.now())
                .termsAgreement(true)
                .thirdPartyAgreement(true)
                .build();

        customerRepository.save(customer2);

        //when
        final ResultActions resultActions = mvc.perform(get("/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("total_data_count").isNotEmpty())
                .andExpect(jsonPath("result[0].이름").isNotEmpty())
                .andExpect(jsonPath("result[0].연락처").isNotEmpty());
    }

    @Test
    public void 이사회사정보_test() throws Exception {
        MovingCompany movingCompany1 = MovingCompany.builder()
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

        movingCompanyRepository.save(movingCompany1);

        MovingCompany movingCompany2 = MovingCompany.builder()
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

        movingCompanyRepository.save(movingCompany2);

        //when
        final ResultActions resultActions = mvc.perform(get("/moving-companies")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("total_data_count").isNotEmpty())
                .andExpect(jsonPath("result[0].업체명").isNotEmpty())
                .andExpect(jsonPath("result[0].연락처").isNotEmpty())
                .andExpect(jsonPath("result[0].주소정보").isNotEmpty())
                .andExpect(jsonPath("result[0].매칭가능여부").isNotEmpty());
    }

    @Test
    public void 가정이사신청정보_test() throws Exception {

        HomeMovingRequest homeMovingRequest1 = HomeMovingRequest.builder()
                .addrivedFloor(2)
                .arrivedAddress("경기도 부천시 옥길동 1234")
                .departAddress("경기도 부천시 원미동 4321")
                .departFloor(35)
                .marketingAgreement(false)
                .movingDate(LocalDate.now())
                .name("이사신")
                .phone("010-1111-2222")
                .storageMoving(false)
                .termsAgreement(true)
                .thirdPartyAgreement(true)
                .build();
        homeMovingRequestRepository.save(homeMovingRequest1);


        HomeMovingRequest homeMovingRequest2 = HomeMovingRequest.builder()
                .addrivedFloor(12)
                .arrivedAddress("경기도 시흥시 정왕동 1234")
                .departAddress("경기도 부천시 원미동 4321")
                .departFloor(5)
                .marketingAgreement(false)
                .movingDate(LocalDate.now())
                .name("이사박")
                .phone("010-1111-2222")
                .storageMoving(false)
                .termsAgreement(true)
                .thirdPartyAgreement(true)
                .build();

        homeMovingRequestRepository.save(homeMovingRequest2);

        //when
        final ResultActions resultActions = mvc.perform(get("/home-moving-requests")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("total_data_count").isNotEmpty())
                .andExpect(jsonPath("result[0].이름").isNotEmpty())
                .andExpect(jsonPath("result[0].연락처").isNotEmpty())
                .andExpect(jsonPath("result[0].출발지").isNotEmpty())
                .andExpect(jsonPath("result[0].도착지").isNotEmpty())
                .andExpect(jsonPath("result[0].이사일자").isNotEmpty())
                .andExpect(jsonPath("result[0].보관이사여부").isNotEmpty());
    }


}
