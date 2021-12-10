package by.epam.task.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class Contract extends AbstractEntity {
    private Long contractId;
    private LocalDate connectionDate;
    private Long userId;
    private Long tariffPlanId;
    private String tariffPlanName;
    private BigDecimal tariffPlanPrice;
    private int tariffPlanSpeed;
    private ContractStatus contractStatus;

    public Contract() { }

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

        StringBuilder builder = new StringBuilder();
        builder.append(contractId);
        builder.append(" ");
        builder.append(connectionDate);
        builder.append(" ");
        builder.append(userId);
        builder.append(" ");
        builder.append(tariffPlanId);
        builder.append(" ");
        builder.append(tariffPlanName);
        builder.append(" ");
        builder.append(tariffPlanPrice);
        builder.append(" ");
        builder.append(tariffPlanSpeed);
        builder.append(" ");
        builder.append(contractStatus);

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        if (getTariffPlanSpeed() != contract.getTariffPlanSpeed()) return false;
        if (getContractId() != null ? !getContractId().equals(contract.getContractId()) : contract.getContractId() != null)
            return false;
        if (getConnectionDate() != null ? !getConnectionDate().equals(contract.getConnectionDate()) : contract.getConnectionDate() != null)
            return false;
        if (getUserId() != null ? !getUserId().equals(contract.getUserId()) : contract.getUserId() != null)
            return false;
        if (getTariffPlanId() != null ? !getTariffPlanId().equals(contract.getTariffPlanId()) : contract.getTariffPlanId() != null)
            return false;
        if (getTariffPlanName() != null ? !getTariffPlanName().equals(contract.getTariffPlanName()) : contract.getTariffPlanName() != null)
            return false;
        if (getTariffPlanPrice() != null ? !getTariffPlanPrice().equals(contract.getTariffPlanPrice()) : contract.getTariffPlanPrice() != null)
            return false;
        return getContractStatus() == contract.getContractStatus();
    }

    @Override
    public int hashCode() {
        int result = getContractId() != null ? getContractId().hashCode() : 0;
        result = 31 * result + (getConnectionDate() != null ? getConnectionDate().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getTariffPlanId() != null ? getTariffPlanId().hashCode() : 0);
        result = 31 * result + (getTariffPlanName() != null ? getTariffPlanName().hashCode() : 0);
        result = 31 * result + (getTariffPlanPrice() != null ? getTariffPlanPrice().hashCode() : 0);
        result = 31 * result + getTariffPlanSpeed();
        result = 31 * result + (getContractStatus() != null ? getContractStatus().hashCode() : 0);
        return result;
    }
}
