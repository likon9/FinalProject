package by.epam.finalTask.model.service;

import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.entity.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {

    boolean addContract(Map<String, String> parameters) throws ServiceException;

    public List<Contract> findContractByUserId(Long userId) throws ServiceException;

}
