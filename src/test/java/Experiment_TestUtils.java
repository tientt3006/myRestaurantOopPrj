
import com.nolaneg.myrestaurantprj.util.*;
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author $_{user}
 */
public class Experiment_TestUtils {
    public static void main(String[] args) {
        Connection c = Experiment_Utils.getConnection();
        System.out.println(c);
    }
}
