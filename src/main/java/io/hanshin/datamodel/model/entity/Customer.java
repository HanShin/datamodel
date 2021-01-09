package io.hanshin.datamodel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Table(name="customer")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer implements Serializable {

    private static final long serialVersionUID = 7671430120843043914L;

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerId;

    @OneToMany(mappedBy = "customer")
    private List<CustomerFeedback> customerFeedbackList;

    //이름
    @Column(name = "name")
    private String name;

    // 연락처
    @Column(name = "phone")
    private String phone;

    // 등록일
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // 이용약관동의여부
    @Column(name = "terms_agreement")
    private boolean termsAgreement;

    // 견적요청을 위한 개인정보 제3자 제공동의여부
    @Column(name = "third_party_agreement")
    private boolean thirdPartyAgreement;

    // 마케팅 정보수신 동의여부
    @Column(name = "marketing_agreement")
    private boolean marketingAgreement;
}
