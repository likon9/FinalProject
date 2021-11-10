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

        StringBuilder builder = new StringBuilder();
        builder.append(tariffPlanId);
        builder.append(" ");
        builder.append(nameTariffPlan);
        builder.append(" ");
        builder.append(price);
        builder.append(" ");
        builder.append(internetConnectionSpeed);

        return builder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TariffPlan)) return false;

        TariffPlan that = (TariffPlan) o;

        if (getInternetConnectionSpeed() != that.getInternetConnectionSpeed()) return false;
        if (getTariffPlanId() != null ? !getTariffPlanId().equals(that.getTariffPlanId()) : that.getTariffPlanId() != null)
            return false;
        if (getNameTariffPlan() != null ? !getNameTariffPlan().equals(that.getNameTariffPlan()) : that.getNameTariffPlan() != null)
            return false;
        return getPrice() != null ? getPrice().equals(that.getPrice()) : that.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getTariffPlanId() != null ? getTariffPlanId().hashCode() : 0;
        result = 31 * result + (getNameTariffPlan() != null ? getNameTariffPlan().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + getInternetConnectionSpeed();
        return result;
    }
}
