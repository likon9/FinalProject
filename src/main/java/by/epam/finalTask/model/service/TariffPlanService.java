package by.epam.finalTask.model.service;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.model.builder.TariffPlanBuilder;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.pool.ConnectionPool;
import com.google.protobuf.ServiceException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.finalTask.model.dao.ColumnName.*;
import static by.epam.finalTask.model.dao.ColumnName.INTERNET_CONNECTION_SPEED;

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
