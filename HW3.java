import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] Args)
    {
         /* Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
            сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
            apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы

          */

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

            game(words);

    }

    private static void game(String[] words) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        char[] hash= new char[15];
        String responce = "";
        String chozen;
        Arrays.fill(hash, '#');
        //При запуске программы компьютер загадывает слово
        //boolean check = true;
        int word_select = rand.nextInt(words.length);
        while (true) {

            //запрашивает ответ у пользователя,
            chozen=words[word_select];
            char[] show_chars = chozen.toCharArray();
            boolean resp_check = false;
            while (!resp_check){
                System.out.println("Введите свою догадку");
                System.out.println(hash);
                if (in.hasNextLine())
                {
                  responce=in.nextLine();
                  responce=responce.toLowerCase();
                  resp_check = true;
                }
                else
                in.next();
                }
            //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
                if (responce.equals(chozen))
                {
                    System.out.println("Вы выиграли!");
                    //check=false;
                    return;
                }
                //Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
                else {
                char[] comparing = responce.toCharArray();
                for (int i=0; i<show_chars.length && i<comparing.length;i++) {
                    if (show_chars[i]==comparing[i]) {
                        hash[i] = show_chars[i];
                    }
                }
                }
                in.reset();
        }
    }
}
