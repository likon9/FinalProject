package by.epam.finalTask.model.service.impl;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.dao.ContractDao;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.service.ContractService;

import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements ContractService {

    @Override
    public boolean addContract(Map<String, String> parameters) throws ServiceException {
        return false;
    }

    @Override
    public List<Contract> findContractByUserId(Long userId) throws ServiceException {
        ContractDao contractDao = ContractDao.getInstance();
        try {
            List<Contract> contract = contractDao.findContractByUserId(userId);
            return contract;
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
