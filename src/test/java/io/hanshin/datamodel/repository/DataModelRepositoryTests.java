package io.hanshin.datamodel.repository;

import io.hanshin.datamodel.model.entity.Customer;
import io.hanshin.datamodel.model.entity.CustomerFeedback;
import io.hanshin.datamodel.model.entity.MovingCompany;
import io.hanshin.datamodel.model.enums.MovingType;
import io.hanshin.datamodel.model.enums.SatisfactionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DataModelRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MovingCompanyRepository movingCompanyRepository;


    @Test
    public void 고객피드백정상등록_test(){

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

    }

    @Test
    public void 고객및회사정보등록후피드백등록_test(){
        Customer customer = Customer.builder()
                .marketingAgreement(true)
                .name("무한신")
                .phone("010-1234-5678")
                .registrationDate(LocalDate.now())
                .termsAgreement(true)
                .thirdPartyAgreement(true)
                .build();

        customerRepository.save(customer);

        MovingCompany movingCompany = MovingCompany.builder()
                .address("서울시 강남구 111")
                .detailAddress("강남의빌딩 502호")
                .bizNumber("123-45-67890")
                .bizRegistrationDate(LocalDate.now())
                .ceoName("박대표")
                .companyName("박씨집안의이사회사")
                .employeeCount(100)
                .etcTruckCount(30)
                .fiveTonTruckCount(10)
                .matchingAvailable(true)
                .oneTonTruckCount(50)
                .phone("02-1234-5678")
                .twoHalfTonTruckCount(35)
                .build();

        movingCompanyRepository.save(movingCompany);

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

    }

    @Test
    public void 고객과이사회사를여러번저장_test(){
        Customer customer = Customer.builder()
                .marketingAgreement(true)
                .name("복붙신신")
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
                .ceoName("백대표대표")
                .companyName("백씨집안의이사회사")
                .employeeCount(100)
                .etcTruckCount(30)
                .fiveTonTruckCount(10)
                .matchingAvailable(true)
                .oneTonTruckCount(50)
                .phone("02-1234-5678")
                .twoHalfTonTruckCount(35)
                .build();

        CustomerFeedback customerFeedback1 = CustomerFeedback.builder()
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

        customerFeedbackRepository.save(customerFeedback1);

        CustomerFeedback customerFeedback2 = CustomerFeedback.builder()
                .contractPrice(BigInteger.valueOf(50000))
                .disclosure(true)
                .expertSatisfaction(SatisfactionType.SATISFACTION)
                .feedbackContents("그렇게 좋지는 않아요~ 감사합니다.")
                .feedbackDate(LocalDate.now())
                .kindSatisfaction(SatisfactionType.SATISFACTION)
                .movingDate(LocalDate.now())
                .movingType(MovingType.HOME)
                .priceSatisfaction(SatisfactionType.NORMAL)
                .revisit(true)
                .customer(customer)
                .movingCompany(movingCompany)
                .build();

        customerFeedbackRepository.save(customerFeedback2);

    }

    @Test
    public void 고객피드백등록후_고객정보수정_test(){
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

        customer.updateUser("김신박신", "010-9999-0000");
        customerRepository.save(customer);

        Customer feedbackCustomer = customerFeedback.getCustomer();

        then(customer).isEqualTo(feedbackCustomer);


    }

    @Test
    public void 고객피드백등록후_업체정보수정_test(){
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

        movingCompany.updateMovingCompany("좋은이사", "조은대표","02-333-4444","경기도 분당구 수서동 9999", "303");
        movingCompanyRepository.save(movingCompany);

        MovingCompany feedbackMovingCompany = customerFeedback.getMovingCompany();

        then(movingCompany).isEqualTo(feedbackMovingCompany);
    }

}
