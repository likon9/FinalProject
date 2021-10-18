package by.epam.task.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class TariffPlan {
    private Long tariffPlanId;
    private String nameTariffPlan;
    private BigDecimal price;
    private int internetConnectionSpeed;

    public TariffPlan() {}

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

    public void setInternetConnectionSpeed(int internetConnectionSpeed) { this.internetConnectionSpeed = internetConnectionSpeed; }

    @Override
    public String toString() {
        return "TariffPlan{" +
                "tariffPlanId=" + tariffPlanId +
                ", nameTariffPlan='" + nameTariffPlan + '\'' +
                ", price=" + price +
                ", internetConnectionSpeed=" + internetConnectionSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TariffPlan)) return false;
        TariffPlan that = (TariffPlan) o;
        return getInternetConnectionSpeed() == that.getInternetConnectionSpeed()
                && Objects.equals(getTariffPlanId(), that.getTariffPlanId())
                && Objects.equals(getNameTariffPlan(), that.getNameTariffPlan())
                && Objects.equals(getPrice(), that.getPrice())
                && Objects.equals(getInternetConnectionSpeed(), that.getInternetConnectionSpeed());

    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + Long.hashCode(getTariffPlanId());
        result += 37 * result + getNameTariffPlan().hashCode();
        result += 37 * result + getPrice().hashCode();
        result += 37 * result + Integer.hashCode(getInternetConnectionSpeed());

        return result;
    }
}
