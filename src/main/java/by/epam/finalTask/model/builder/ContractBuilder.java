package by.epam.finalTask.model.builder;

import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.ContractStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ContractBuilder {

    private Long contractId;
    private Timestamp connectionDate;
    private Timestamp disconnectionDate;
    private Long userId;
    private Long tariffPlanId;
    private String tariffPlanName;
    private BigDecimal tariffPlanPrice;
    private int tariffPlanSpeed;
    private ContractStatus contractStatus;

    public static ContractBuilder builder(){return new ContractBuilder();}

    public Contract build() {
        Contract contract = new Contract(contractId,
                connectionDate,
                userId,
                tariffPlanId,
                tariffPlanName,
                tariffPlanPrice,
                tariffPlanSpeed,
                contractStatus);

        this.contractId = null;
        this.connectionDate = null;
        this.disconnectionDate = null;
        this.userId = null;
        this.tariffPlanId = null;
        this.tariffPlanName = null;
        this.tariffPlanPrice = null;
        this.tariffPlanSpeed = 0;
        this.contractStatus = null;
        return contract;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Timestamp getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(Timestamp connectionDate) {
        this.connectionDate = connectionDate;
    }

    public Timestamp getDisconnectionDate() {
        return disconnectionDate;
    }

    public void setDisconnectionDate(Timestamp disconnectionDate) {
        this.disconnectionDate = disconnectionDate;
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
}
