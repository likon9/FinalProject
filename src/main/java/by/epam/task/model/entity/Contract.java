package by.epam.task.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class Contract {
    private Long contractId;
    private LocalDate connectionDate;
    private Long userId;
    private Long tariffPlanId;
    private String tariffPlanName;
    private BigDecimal tariffPlanPrice;
    private int tariffPlanSpeed;
    private ContractStatus contractStatus;
    public Contract() {
    }

    public Contract(Long contractId,
                    LocalDate connectionDate,
                    Long userId,
                    Long tariffPlanId,
                    String tariffPlanName,
                    BigDecimal tariffPlanPrice,
                    int tariffPlanSpeed,
                    ContractStatus contractStatus) {
        this.contractId = contractId;
        this.connectionDate = connectionDate;
        this.userId = userId;
        this.tariffPlanId = tariffPlanId;
        this.tariffPlanName = tariffPlanName;
        this.tariffPlanPrice = tariffPlanPrice;
        this.tariffPlanSpeed = tariffPlanSpeed;
        this.contractStatus = contractStatus;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public LocalDate getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(LocalDate connectionDate) {
        this.connectionDate = connectionDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTariffPlanId() {
        return tariffPlanId;
    }

    public void setTariffPlanId(Long tariffPlanId) {
        this.tariffPlanId = tariffPlanId;
    }

    public String getTariffPlanName() {
        return tariffPlanName;
    }

    public void setTariffPlanName(String tariffPlanName) {
        this.tariffPlanName = tariffPlanName;
    }

    public BigDecimal getTariffPlanPrice() {
        return tariffPlanPrice;
    }

    public void setTariffPlanPrice(BigDecimal tariffPlanPrice) {
        this.tariffPlanPrice = tariffPlanPrice;
    }

    public int getTariffPlanSpeed() {
        return tariffPlanSpeed;
    }

    public void setTariffPlanSpeed(int tariffPlanSpeed) {
        this.tariffPlanSpeed = tariffPlanSpeed;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", connectionDate=" + connectionDate +
                ", userId=" + userId +
                ", tariffPlanId=" + tariffPlanId +
                ", tariffPlanName='" + tariffPlanName + '\'' +
                ", tariffPlanPrice=" + tariffPlanPrice +
                ", tariffPlanSpeed=" + tariffPlanSpeed +
                ", contractStatus=" + contractStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        return getTariffPlanSpeed() == contract.getTariffPlanSpeed()
                && Objects.equals(getContractId(), contract.getContractId())
                && Objects.equals(getConnectionDate(), contract.getConnectionDate())
                && Objects.equals(getUserId(), contract.getUserId())
                && Objects.equals(getTariffPlanId(), contract.getTariffPlanId())
                && Objects.equals(getTariffPlanName(), contract.getTariffPlanName())
                && Objects.equals(getTariffPlanPrice(), contract.getTariffPlanPrice())
                && Objects.equals(getTariffPlanSpeed(), contract.getTariffPlanSpeed())
                && getContractStatus() == contract.getContractStatus();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + Long.hashCode(getContractId());
        result += 37 * result + getConnectionDate().hashCode();
        result += 37 * result + Long.hashCode(getUserId());
        result += 37 * result + Long.hashCode(getTariffPlanId());
        result += 37 * result + getTariffPlanName().hashCode();
        result += 37 * result + getTariffPlanPrice().hashCode();
        result += 37 * result + Integer.hashCode(getTariffPlanSpeed());
        return result;
    }
}
