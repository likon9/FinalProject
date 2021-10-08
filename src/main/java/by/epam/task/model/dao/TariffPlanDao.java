package by.epam.task.model.dao;

import by.epam.task.exception.DaoException;
import by.epam.task.model.builder.TariffPlanBuilder;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.model.dao.ColumnName.*;
import static by.epam.task.model.dao.ColumnName.INTERNET_CONNECTION_SPEED;

public interface TariffPlanDao {

    boolean updateNameTariffPlan(Map<String, String> parameters, Long tariffPlanId) throws DaoException;

    boolean updatePrice(Map<String, String> parameters, Long tariffPlanId) throws DaoException;

    boolean updateInternetConnectionSpeed(Map<String, String> parameters, Long tariffPlanId) throws DaoException;

    boolean addTariffPlan(Map<String, String> parameters) throws DaoException;

    Optional<TariffPlan> findByIdTariffPlan(Long id) throws DaoException;

    Optional<TariffPlan> findByNameTariffPlan(String nameTariffPlan) throws DaoException;

    List<TariffPlan> findByPrice(BigDecimal price) throws DaoException;

    List<TariffPlan> findByInternetConnectionSpeed(int speed) throws DaoException;

    List<TariffPlan> findAllTariffPlan() throws DaoException;
}
