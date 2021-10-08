package by.epam.task.model.service.impl;

import by.epam.task.exception.DaoException;
import by.epam.task.exception.ServiceException;
import by.epam.task.model.dao.impl.ContractDaoImpl;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.service.ContractService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContractServiceImpl implements ContractService {

    @Override
    public boolean addContract(Map<String, String> parameters) throws ServiceException {
        boolean result = true;
        if(result) {
            ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
            try {
                result = contractDaoImpl.addContract(parameters);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws ServiceException {
        boolean result = true;
        if(result) {
            ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();

            try {
                result = contractDaoImpl.updateStatusContract(parameters, contractId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    @Override
    public Optional<Contract> findByContractId(Long contractId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            Optional<Contract> contract = contractDaoImpl.findByContractId(contractId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findEffectiveContractByUserId(Long userId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findEffectiveContractByUserId(userId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findAllContractByUserId(Long userId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findAllContractByUserId(userId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findByStatus(String status) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        System.out.println(12);
        try {
            List<Contract> contract = contractDaoImpl.findByStatus(status);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findByTariffPlanId(Long tariffPlanId) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findByTariffPlanId(tariffPlanId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findByTariffPlanName(String tariffPlanName) throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findByTariffPlanName(tariffPlanName);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Contract> findAll() throws ServiceException {
        ContractDaoImpl contractDaoImpl = ContractDaoImpl.getInstance();
        try {
            List<Contract> contract = contractDaoImpl.findAll();
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
