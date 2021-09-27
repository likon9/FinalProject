package by.epam.finalTask.model.entity;

import java.math.BigDecimal;

public class Promotion {

    private Long promotionId;
    private String namePromotion;
    private int quantityDiscountMonth;
    private BigDecimal discount;

    public Promotion() {
    }

    public Promotion(Long promotionId, String namePromotion, int quantityDiscountMonth, BigDecimal discount) {
        this.promotionId = promotionId;
        this.namePromotion = namePromotion;
        this.quantityDiscountMonth = quantityDiscountMonth;
        this.discount = discount;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    public int getQuantityDiscountMonth() {
        return quantityDiscountMonth;
    }

    public void setQuantityDiscountMonth(int quantityDiscountMonth) {
        this.quantityDiscountMonth = quantityDiscountMonth;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotionId=" + promotionId +
                ", namePromotion='" + namePromotion + '\'' +
                ", quantityDiscountMonth=" + quantityDiscountMonth +
                ", discount=" + discount +
                '}';
    }
}
