import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.io.*;
import java.io.IOException;
import java.util.Random;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    @org.junit.jupiter.api.Test
    void testOtherDir() throws Exception {
        try {
            File my_fil5 = new File("333\\555\\444.txt"); // несуществующий путь
            BufferedWriter bw5 = new BufferedWriter(new FileWriter(my_fil5));
        } catch (java.io.FileNotFoundException e) {
            System.out.println(e);
        }
    }

    @org.junit.jupiter.api.Test
    void testNull() throws Exception {
        String[] a1 = {null, null, null}; // пустые значения в массиве
    }
}