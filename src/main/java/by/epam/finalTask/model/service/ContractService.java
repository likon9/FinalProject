package by.epam.finalTask.model.service;

import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.entity.Contract;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ContractService {

    boolean addContract(Map<String, String> parameters) throws ServiceException;

    public Optional<Contract> findByContractId(Long userId) throws ServiceException;

    public List<Contract> findEffectiveContractByUserId(Long userId) throws ServiceException;

}
