package io.hanshin.datamodel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name="home_moving_request")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomeMovingRequest implements Serializable {

    private static final long serialVersionUID = -2664989957774241006L;
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Home_moving_request_id")
    private Integer homeMovingRequestId;

    // 이름
    @Column(name = "name")
    private String name;
    // 연락처
    @Column(name = "phone")
    private String phone;
    // 출발지 주소정보
    @Column(name = "depart_address")
    private String departAddress;
    // 출발지 층수
    @Column(name = "depart_floor")
    private Integer departFloor;
    // 도착지 주소정보
    @Column(name = "arrived_address")
    private String arrivedAddress;
    // 도착지 층수
    @Column(name = "addrived_floor")
    private Integer addrivedFloor;
    // 이사일자
    @Column(name = "moving_date")
    private LocalDate movingDate;
    // 보관이사여부
    @Column(name = "storage_moving")
    private boolean storageMoving;
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

