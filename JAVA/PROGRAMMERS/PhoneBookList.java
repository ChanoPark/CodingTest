package Programmers;

import java.util.Arrays;

public class PhoneBookList {

    public static void main(String[] args) {
        PhoneBookList phoneBookList = new PhoneBookList();
        phoneBookList.solution(new String[]{"\"119\", \"97674223\", \"1195524421\""});
    }

    public boolean solution(String[] phone_book) {
        int size = phone_book.length;
        Arrays.sort(phone_book);

        for (int i = 0; i < size - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }

        return true;
    }
}
