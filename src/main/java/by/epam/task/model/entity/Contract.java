package by.epam.task.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

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
}
