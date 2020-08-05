package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File("D://file16.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            User alex = new User();
            alex.setFirstName("Oleksandr");
            alex.setLastName("Myrko");
            alex.setMale(true);
            alex.setCountry(User.Country.UKRAINE);
            alex.setBirthDate(sdf.parse("Thursday January 08 01:12:35 EET 1981"));
            javaRush.users.add(alex);

            User lisa = new User();
            lisa.setFirstName("Lisa");
            lisa.setLastName("Myrko");
            lisa.setMale(false);
            lisa.setCountry(User.Country.UKRAINE);
            lisa.setBirthDate(sdf.parse("Thursday January 08 01:12:35 EET 1981"));
            javaRush.users.add(lisa);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter pw = new PrintWriter(outputStream, true);
            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            for (User user : this.users){
                if (user != null) {
                    pw.println(user.getFirstName());
                    pw.println(user.getLastName());
                    pw.println(user.isMale());
                    pw.println(user.getCountry());
                    pw.println(sdf.format(user.getBirthDate()));
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s = null;
            boolean notEnd = true;
            String[] el = new String[5];
            while (notEnd){
                User user = new User();
                for (int i = 0; i < 5; i++){
                    if ((s = reader.readLine()) == null) {
                        notEnd = false;
                        break;
                    }
                    el[i] = s;
                    if (i == 4) {
                        user.setFirstName(el[0]);
                        user.setLastName(el[1]);
                        user.setMale(Boolean.parseBoolean(el[2]));
                        if (el[3].equals("UKRAINE"))
                            user.setCountry(User.Country.UKRAINE);
                        else if (el[3].equals("RUSSIA"))
                            user.setCountry(User.Country.RUSSIA);
                        else user.setCountry(User.Country.OTHER);
                        user.setBirthDate(sdf.parse(el[4]));
                        this.users.add(user);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
