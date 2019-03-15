package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.domain.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyDao implements GenericDao<Company> {

    @Override
    public int create(Connection connection, Company company) {
        String sql = "INSERT INTO companies(company_name) VALUES (?)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, company.getCompanyName());
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return -1;
    }

    @Override
    public Company getById(Connection connection, int id) {
        String sql = "SELECT * FROM companies WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                final Company company = new Company();
                company.setId(resultSet.getInt("id"));
                company.setCompanyName(resultSet.getString("company_name"));
                return company;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Company> getAll(Connection connection){
        String sql = "select * from companies";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            final List<Company> companies = new ArrayList<>();
            while (resultSet.next()) {
                companies.add(extractCompanyFromResultSet(resultSet));
            }
            return companies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    @Override
    public Company update(Connection connection, Company object) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    @Override
    public void deleteById(Connection connection, int id) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }


    private Company extractCompanyFromResultSet(ResultSet resultSet) throws SQLException {
        final Company company = new Company();
        company.setId(resultSet.getInt("id"));
        company.setCompanyName(resultSet.getString("company_name"));
        return company;
    }
}
