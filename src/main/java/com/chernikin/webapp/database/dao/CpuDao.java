package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.domain.Cpu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CpuDao implements GenericDao<Cpu> {

    @Override
    public int create(Connection connection, Cpu cpu) {
        String sql = "INSERT INTO cpu(cpu_name) VALUES (?)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cpu.getCpuName());
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
    public Cpu getById(Connection connection, int id) {
        String sql = "SELECT * FROM cpu WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                final Cpu cpu = new Cpu();
                cpu.setId(resultSet.getInt("id"));
                cpu.setCpuName(resultSet.getString("cpu_name"));
                return cpu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cpu> getAll(Connection connection){
        String sql = "select * from cpu";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            final List<Cpu> cpu = new ArrayList<>();
            while (resultSet.next()) {
                cpu.add(extractCpuFromResultSet(resultSet));
            }
            return cpu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Cpu update(Connection connection, Cpu object) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    @Override
    public void deleteById(Connection connection, int id) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    private Cpu extractCpuFromResultSet(ResultSet resultSet) throws SQLException {
        final Cpu cpu = new Cpu();
        cpu.setId(resultSet.getInt("id"));
        cpu.setCpuName(resultSet.getString("cpu_name"));
        return cpu;
    }
}
