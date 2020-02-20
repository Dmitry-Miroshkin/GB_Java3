package HomeWork.Lesson2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {

    /*
     * Каждый из тасков решается одним SQL запросом
     */
    /*
     * Метод должен вернуть список производителей которые
     *  делают и пк и ноутбуки
     */
    public static ArrayList<String> selectMaker(Statement stmt) {
        ArrayList<String> ans = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("select maker, count(maker) as counter from \n" +
                    "(select DISTINCT * from product) group by maker having counter >= 2;");
            while (rs.next()) {
                ans.add(rs.getString("maker"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return ans;
    }

    /*
     * Метод должен вернуть максимальную среди всех произодителей
     * суммарную стоимость всех изделий типов ноутбук или компьютер,
     * произведенных одним производителем
     * Необходимо объединить таблицы продуктов ноутбуков и компьютеров
     * и отгрупировать по сумме прайсов после чего выбрать максимум
     * или сделать любым другим способом
     */

    public static int makerWithMaxProceeds(Statement stmt) throws SQLException {
        int result = 0;
        try{
        ResultSet rs = stmt.executeQuery("SELECT MAX(SUM) as ANS from\n" +
                " (SELECT DISTINCT maker, sum(price) as SUM from\n"+
                " (select distinct id, maker, price from PC join Product on\n"+
                " pc.model = product.model) group by maker);");
        rs.next();
        result = rs.getInt("ANS");}
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }

}
