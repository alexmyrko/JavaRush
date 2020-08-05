package com.javarush.task.task20.task2002_;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("D:/file20.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User myrko = new User();
            User jordan = new User();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date date = sdf.parse("08.01.1981");
            myrko.setBirthDate(date);
            myrko.setCountry(User.Country.UKRAINE);
            myrko.setFirstName("Oleksandr");
            myrko.setLastName("Myrko");
            myrko.setMale(true);
            date = sdf.parse("25.05.1975");
            jordan.setFirstName("Ostap");
            jordan.setLastName("Jordan");
            jordan.setMale(true);
            jordan.setCountry(User.Country.UKRAINE);
            jordan.setBirthDate(date);
            javaRush.users.add(myrko);
            javaRush.users.add(jordan);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
           // System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            Date date;
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            if (this.users != null) {
                for (User user : users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(sdf.format(user.getBirthDate()));
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date date;
            String s;
            boolean isNull = false;
            String[] el = new String[5];

            while (true){
                for (int i = 0; i < 5; i++){
                    if ((s = reader.readLine()) == null){
                        isNull = true;
                        break;
                    }
                    else
                        el[i] = s;
                }
                if (isNull)
                    break;
                User user = new User();
                user.setFirstName(el[0]);
                user.setLastName(el[1]);
                date = sdf.parse(el[2]);
                System.out.println(el[2]);
                user.setBirthDate(date);
                if (el[3].equals("true"))
                    user.setMale(true);
                else
                    user.setMale(false);
                if (el[4].equals("RUSSIA"))
                    user.setCountry(User.Country.RUSSIA);
                else if (el[4].equals("UKRAINE"))
                    user.setCountry(User.Country.UKRAINE);
                else
                    user.setCountry(User.Country.OTHER);
                this.users.add(user);
            }
        }
 /*       @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;

            JavaRush jr = (JavaRush) obj;
            if (users != null)
                return (users.equals(jr.users));
            else
                return jr.users == null;
        }*/

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

    }
}
