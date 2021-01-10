package io.hanshin.datamodel.model.entity;

import io.hanshin.datamodel.model.enums.MovingType;
import io.hanshin.datamodel.model.enums.SatisfactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

@Table(name="customer_feedback")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerFeedback implements Serializable {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_feedback_id")
    private Integer customerFeedbackId;

    // 고객정보

    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // 업체정보
    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "moving_company_id")
    private MovingCompany movingCompany;

    // 이사종류(가정이사, 원룸이사)
    @Column(name = "moving_type")
    private MovingType movingType;

    // 정보공개동의여부
    @Column(name = "disclosure")
    private boolean disclosure;

    // 전문성 만족도(매우만족, 만족, 보통, 불만족, 매우불만족)
    @Column(name = "expert_satisfaction")
    private SatisfactionType expertSatisfaction;

    // 가격 만족도(매우만족, 만족, 보통, 불만족, 매우불만족)
    @Column(name = "price_satisfaction")
    private SatisfactionType priceSatisfaction;

    // 친절 만족도(매우만족, 만족, 보통, 불만족, 매우불만족)
    @Column(name = "kind_satisfaction")
    private SatisfactionType kindSatisfaction;

    // 재방문의사
    @Column(name = "revisit")
    private boolean revisit;

    // 계약가격
    @Column(name = "contract_price")
    private BigInteger contractPrice;

    // 이사일
    @Column(name = "moving_date")
    private LocalDate movingDate;

    // 피드백 작성일
    @Column(name = "feedback_date")
    private LocalDate feedbackDate;

    // 피드백 내용
    @Column(name = "feedback_contents")
    private String feedbackContents;

    public void updateFeedback(String feedbackContents, SatisfactionType expertSatisfaction, SatisfactionType priceSatisfaction, SatisfactionType kindSatisfaction){
        this.feedbackContents = feedbackContents;
        this.expertSatisfaction = expertSatisfaction;
        this.priceSatisfaction = priceSatisfaction;
        this.kindSatisfaction = kindSatisfaction;
    }
}
