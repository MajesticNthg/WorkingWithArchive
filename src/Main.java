import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Main {

    public static void main(String[] args) throws Exception {
        File my_fil1 = new File("111.txt");
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(my_fil1));
        File my_fil2 = new File("222.txt");
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(my_fil2));
        File my_fil3 = new File("333.txt");
        BufferedWriter bw3 = new BufferedWriter(new FileWriter(my_fil3));
        File my_fil4 = new File("444.txt");
        BufferedWriter bw4 = new BufferedWriter(new FileWriter(my_fil4));
        File new_dir = new File("333");
        new_dir.mkdir();
        File my_fil5 = new File("333\\555.txt");
        BufferedWriter bw5 = new BufferedWriter(new FileWriter(my_fil5)); // создание файлов

        String[] a1 = {"111.txt", "222.txt", "555.txt"}; // массив с именами файлов, которые нужно добавить в архив

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("F:\\Программирование\\Обучение Java\\2 курс (с нуля)\\16 Работа с архивами\\test.zip")); // созданный архив с выбранной отдельной директорией

        createZipArchive(zos, a1); // функция, которая получает в качестве параметра архив и массив строк
        zos.close();
    }

    private static void createZipArchive(ZipOutputStream zos, String[] a1) throws Exception { // исходный метод
        File root = new File("."); // исходная директория
        ArrayList<File> expand = new ArrayList<File>(); // список expand типа ArrayList
        expand.addAll(Arrays.asList(root.listFiles())); // заполнение списка expand файлами и каталогами из директории root
        File[] expandCopy = expand.toArray(new File[expand.size()]); // список expandCopy, полученный из списка expand схожего размера
        expand.clear(); // удалены все элементы из списка

        for (int i = 0; i < a1.length; i++) { // цикл по массиву из искомых имен файлов
            String file = a1[i]; // переменная для перезаписи и дальнейшего сравнения имен
            for (File file1 : expandCopy) { // цикл по спику expandCopy
                if (file1.isDirectory()) { // условие, является ли проверяемый файл директорией, или же файлом
                    expand.addAll(Arrays.asList(file1.listFiles())); // если является директорией, то перемещаемся внутрь каталога
                } else {
                    file = a1[i]; // если является файлом, то переменная принимает значение одного из искомых имен
                    if (file.equals(file1.getName())) { // если проверяемый файл и искомое имя файла совпадают
                        ZipEntry zipEntry = new ZipEntry(file);
                        zos.putNextEntry(zipEntry); // добавляется новый заголовок в архив
                    }
                }
                FileInputStream fileInputStream = new FileInputStream(file); // считывается исходный файл в архив
                int length; // переменная размера
                byte[] buffer = new byte[1024]; // чтение байтов данных из файла
                while ((length = fileInputStream.read(buffer)) > 0) { // помещение в buffer данных, и чтение происходит до тех пор, пока размер больше нуля
                    zos.write(buffer, 0, length); // прочитанные байты записываются
                }

            }
        }

    }
}