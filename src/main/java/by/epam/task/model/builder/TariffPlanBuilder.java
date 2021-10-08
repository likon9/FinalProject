package by.epam.task.model.builder;

import by.epam.task.model.entity.TariffPlan;

import java.math.BigDecimal;

public class TariffPlanBuilder {

    private Long tariffPlanId;
    private String nameTariffPlan;
    private BigDecimal price;
    private int internetConnectionSpeed;

    public static TariffPlanBuilder builder(){return new TariffPlanBuilder();}

    public TariffPlan build() {
       TariffPlan tariffPlan = new TariffPlan(tariffPlanId,
               nameTariffPlan,
               price,
               internetConnectionSpeed);

        this.tariffPlanId = null;
        this.nameTariffPlan = null;
        this.price = null;
        this.internetConnectionSpeed = 0;
        return tariffPlan;
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
}
