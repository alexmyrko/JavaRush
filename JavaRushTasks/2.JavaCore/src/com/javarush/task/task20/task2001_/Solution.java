package com.javarush.task.task20.task2001_;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = new File("D:/file19.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

//            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
//            ivanov.assets.get(0).setPrice(5.99);
            Human myrko = new Human("Myrko", new Asset("bike"), new Asset("PC"));
            myrko.assets.get(1).setPrice(13500);
            myrko.assets.add(new Asset("TV"));
            myrko.save(outputStream);

//            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name);
            for (Asset asset : somePerson.assets){
                System.out.println(asset.getName() + " " + asset.getPrice());
            }
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            if ((this.name != null) && (this.assets != null)){
                System.out.println(this.name);
                printWriter.println(this.name);
                for (Asset asset : this.assets){
                    System.out.println(asset.getName() + " " + asset.getPrice());
                    printWriter.println(asset.getName() + " " + asset.getPrice());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            String s = null;
            while ((s = reader.readLine()) != null){
                String l[] = s.split(" ");
                Asset asset = new Asset(l[0]);
                this.assets.add(asset);
                asset.setPrice(Double.parseDouble(l[1]));
            }
        }
    }
}
