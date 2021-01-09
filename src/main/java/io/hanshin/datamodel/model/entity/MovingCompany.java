package io.hanshin.datamodel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Table(name="moving_company")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovingCompany implements Serializable {

    private static final long serialVersionUID = -5096597210276652650L;
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "moving_company_id")
    private Integer movingCompanyId;

    @OneToMany(mappedBy = "movingCompany")
    private List<CustomerFeedback> customerFeedbackList;

    // 업체명
    @Column(name = "company_name")
    private String companyName;

    // 대표이사
    @Column(name = "ceo_name")
    private String ceoName;

    // 연락처
    @Column(name = "phone")
    private String phone;

    // 주소정보
    @Column(name = "address")
    private String address;

    @Column(name = "detail_address")
    private String detailAddress;

    // 사업자번호
    @Column(name = "biz_number")
    private String bizNumber;

    // 사업자등록일자
    @Column(name = "biz_registration_date")
    private LocalDate bizRegistrationDate;

    // 직원
    @Column(name = "employee_count")
    private Integer employeeCount;

    // 차량수(1톤, 2.5톤, 5톤, 기타)
    @Column(name = "one_ton_truck_count")
    private Integer oneTonTruckCount;

    @Column(name = "two_half_ton_truck_count")
    private Integer twoHalfTonTruckCount;

    @Column(name = "five_ton_truck_count")
    private Integer fiveTonTruckCount;

    @Column(name = "etc_truck_count")
    private Integer etcTruckCount;
    // 매칭가능여부
    @Column(name = "matching_available")
    private boolean matchingAvailable;
}
