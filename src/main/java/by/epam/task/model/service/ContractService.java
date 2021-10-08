package by.epam.task.model.service;

import by.epam.task.exception.ServiceException;
import by.epam.task.model.entity.Contract;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ContractService {

    boolean addContract(Map<String, String> parameters) throws ServiceException;

    boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws ServiceException;

    Optional<Contract> findByContractId(Long userId) throws ServiceException;

    List<Contract> findEffectiveContractByUserId(Long userId) throws ServiceException;

    List<Contract> findAllContractByUserId(Long userId) throws ServiceException;

    List<Contract> findByStatus(String status) throws ServiceException;

    List<Contract> findByTariffPlanId(Long tariffPlanId) throws ServiceException;

    List<Contract> findByTariffPlanName(String tariffPlanName) throws ServiceException;

    List<Contract> findAll() throws ServiceException;
}
