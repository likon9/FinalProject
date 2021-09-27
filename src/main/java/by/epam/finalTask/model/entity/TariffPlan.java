package by.epam.finalTask.model.entity;

import java.math.BigDecimal;

public class TariffPlan {
    private Long tariffPlanId;
    private String nameTariffPlan;
    private BigDecimal price;
    private int internetConnectionSpeed;

    public TariffPlan() {
    }

    public TariffPlan(Long tariffPlanId,
                      String nameTariffPlan,
                      BigDecimal price,
                      int internetConnectionSpeed) {
        this.tariffPlanId = tariffPlanId;
        this.nameTariffPlan = nameTariffPlan;
        this.price = price;
        this.internetConnectionSpeed = internetConnectionSpeed;
    }

    public Long getTariffPlanId() {
        return tariffPlanId;
    }

    public void setTariffPlanId(Long tariffPlanId) {
        this.tariffPlanId = tariffPlanId;
    }

    public String getNameTariffPlan() {
        return nameTariffPlan;
    }

    public void setNameTariffPlan(String nameTariffPlan) {
        this.nameTariffPlan = nameTariffPlan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInternetConnectionSpeed() {
        return internetConnectionSpeed;
    }

    public void setInternetConnectionSpeed(int internetConnectionSpeed) {
        this.internetConnectionSpeed = internetConnectionSpeed;
    }

    @Override
    public String toString() {
        return "TariffPlan{" +
                "tariffPlanId=" + tariffPlanId +
                ", nameTariffPlan='" + nameTariffPlan + '\'' +
                ", price=" + price +
                ", internetConnectionSpeed=" + internetConnectionSpeed +
                '}';
    }
}
