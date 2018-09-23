//package lv.javaguru.java2.database;
//
//import lv.javaguru.java2.domain.Trip;
//import lv.javaguru.java2.domain.User;
//import org.springframework.stereotype.Component;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
////@Component
//public class JDBCDatabaseImpl extends JDBCRepository implements Database {
//
////    @Override
////    public boolean remove(Product product) {
////        Connection connection = null;
////        try {
////            connection = createConnection();
////            String sql = "delete from PRODUCTS where id = ?";
////            PreparedStatement preparedStatement = connection.prepareStatement(sql);
////            preparedStatement.setInt(1, product.getId());
////            preparedStatement.executeUpdate();
////
////
////            return true;
////        } catch (Throwable e) {
////            System.out.println("Exception while execute ProductDAOImpl.delete()");
////            e.printStackTrace();
////            throw new RuntimeException(e);
////        } finally {
////            closeConnection(connection);
////        }
////    }
//    @Override
//    public List<Trip> getAllTrips() {
//        List<Trip> trips = new ArrayList<>();
//        Connection connection = null;
//        try {
//            connection = createConnection();
//            String sql = "select * from Trip";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Trip trip = new Trip();
//                trip.setId(resultSet.getLong("id"));
//                trip.setDriverId(resultSet.getLong("driverid"));
//                trip.setOrigin(resultSet.getString("origin"));
//                trip.setDestination(resultSet.getString("destination"));
//                trip.setDate(resultSet.getDate("date"));
//                trip.setTime(resultSet.getTime("time"));
//                trip.setComment(resultSet.getString("comment"));
//                trip.setPrice(resultSet.getDouble("price"));
//                trip.setStatus(resultSet.getString("status"));
//                trips.add(trip);
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while getting trip list");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            closeConnection(connection);
//        }
//        return trips;
//    }
//    @Override
//    public void addTrip(Trip trip){
//        Connection connection = null;
//
//        try {
//            connection = createConnection();
//            String sql = "insert into TRIP(id, driverId, origin, destination, date, time, comment, price, status) values(default, ?, ?, ?, ?, ?, ?, ?, ?::status)";
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setLong(1, trip.getDriverId());
//            preparedStatement.setString(2, trip.getOrigin());
//            preparedStatement.setString(3, trip.getDestination());
//            preparedStatement.setDate(4, trip.getDate());
//            preparedStatement.setTime(5, trip.getTime() );
//            preparedStatement.setString(6, trip.getComment());
//            preparedStatement.setDouble(7, trip.getPrice());
//            preparedStatement.setString(8, trip.getStatus());
//
//            preparedStatement.executeUpdate();
//            ResultSet rs = preparedStatement.getGeneratedKeys();
//            if (rs.next()){
//                trip.setId(rs.getLong(1));
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while execute addTrip in DB");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            closeConnection(connection);
//        }
//    }
//    @Override
//    public void registerUser(User user){
//        Connection connection = null;
//
//        try {
//            connection = createConnection();
//            String sql = "insert into users(id, firstName, lastName, email, phone, login, password, isDriver) values(default, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.setString(4, user.getPhone());
//            preparedStatement.setString(5, user.getLogin());
//            preparedStatement.setString(6, user.getPassword());
//            preparedStatement.setBoolean(7, user.isDriver());
//
//            preparedStatement.executeUpdate();
//            ResultSet rs = preparedStatement.getGeneratedKeys();
//            if (rs.next()){
//                user.setId(rs.getLong(1));
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while execute add user in DB");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            closeConnection(connection);
//        }
//    }
//
//    @Override
//    public Optional<User> getUserByLogin(String login){
//        Connection connection = null;
//        User user = new User();
//        try {
//            connection = createConnection();
//            String sql = "select * from users where login = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, login);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                user.setId(resultSet.getLong("id"));
//                user.setLogin(resultSet.getString("login"));
//                user.setPassword(resultSet.getString("password"));
//                user.setPhone(resultSet.getString("phone"));
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while execute .getUserByLogin()");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            closeConnection(connection);
//        }
//        return Optional.ofNullable(user);
//    }
//
//
//    @Override
//    public boolean checkUserExist(Long id){
//        Connection connection = null;
//        boolean exist = false;
//        try {
//            connection = createConnection();
//            String sql = "select * from users where id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setLong(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (!resultSet.wasNull()) exist = true;
//
//        } catch (Throwable e) {
//            System.out.println("Exception while execute .checkUserExist()");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            closeConnection(connection);
//        }
//        return exist;
//    }
//
//
//}
