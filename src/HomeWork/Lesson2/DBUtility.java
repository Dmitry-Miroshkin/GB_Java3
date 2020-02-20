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
    public ArrayList<String> selectMaker(Statement stmt) {
        ArrayList<String> ans = new ArrayList<>();

        // TODO: 18.02.2020
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

    public int makerWithMaxProceeds(Statement stmt) {
        int result = 0;
        //todo
        return result;

    }

}
