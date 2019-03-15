package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.database.DatabaseConnectionManager;
import com.chernikin.webapp.domain.Gpu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GpuDao implements GenericDao<Gpu> {

    @Override
    public int create(Connection connection, Gpu gpu) {
        String sql = "INSERT INTO gpu(gpu_name) VALUES (?)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gpu.getGpuName());
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Gpu getById(Connection connection, int id) {
        String sql = "SELECT * FROM gpu WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                final Gpu gpu = new Gpu();
                gpu.setId(resultSet.getInt("id"));
                gpu.setGpuName(resultSet.getString("gpu_name"));
                return gpu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Gpu> getAll(Connection connection) {
        String sql = "select * from gpu";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            final List<Gpu> gpu = new ArrayList<>();
            while (resultSet.next()) {
                gpu.add(extractGpuFromResultSet(resultSet));
            }
            return gpu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Gpu update(Connection connection, Gpu object) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    @Override
    public void deleteById(Connection connection, int id) {
        throw new UnsupportedOperationException("This operations is not implemented yet");
    }

    private Gpu extractGpuFromResultSet(ResultSet resultSet) throws SQLException {
        final Gpu gpu = new Gpu();
        gpu.setId(resultSet.getInt("id"));
        gpu.setGpuName(resultSet.getString("gpu_name"));
        return gpu;
    }
}
