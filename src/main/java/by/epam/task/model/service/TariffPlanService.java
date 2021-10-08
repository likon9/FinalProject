package by.epam.task.model.service;

import by.epam.task.model.entity.TariffPlan;
import com.google.protobuf.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TariffPlanService {
    boolean updateNameTariffPlan(Map<String, String> parameters, Long tariffPlanId) throws ServiceException;

    boolean updatePrice(Map<String, String> parameters, Long tariffPlanId) throws ServiceException;

    boolean updateInternetConnectionSpeed(Map<String, String> parameters, Long tariffPlanId) throws ServiceException;

    boolean addTariffPlan(Map<String, String> parameters) throws ServiceException;

    Optional<TariffPlan> findByIdTariffPlan(Long id) throws ServiceException;

    Optional<TariffPlan> findByNameTariffPlan(String nameTariffPlan) throws ServiceException;

    List<TariffPlan> findByPrice(BigDecimal price) throws ServiceException;

    List<TariffPlan> findByInternetConnectionSpeed(int speed) throws ServiceException;

    List<TariffPlan> findAllTariffPlan() throws ServiceException;
}
