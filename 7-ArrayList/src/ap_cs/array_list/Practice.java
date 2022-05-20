package ap_cs.array_list;

import java.util.ArrayList;

public class Practice {

    public static void main(String[] args) {
//        ArrayList<Integer> myArrayList = new ArrayList<>();
//
//        myArrayList.add(15);
//
//        myArrayList.add(0, 10);
//
//        myArrayList.set(1, 20);
//
//
//        Integer removed = myArrayList.remove(1);
//
//        for (Integer i : myArrayList) {
//            System.out.println(i);
//        }
//
//        ArrayList<Double> arr = new ArrayList<>(Integer.MAX_VALUE);
//
//        arr.add(9.0);

        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(9);
        myList.add(10);
        myList.add(5);
        myList.add(4);
        myList.add(8);

        ArrayList<Integer> result = removeEvens(myList);
        System.out.println(result);
    }

    public static String getShortestName(ArrayList<String> names) {
        int shortest = Integer.MAX_VALUE;
        int shortestIdx = -1;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.length() < shortest) {
                shortest = name.length();
                shortestIdx = i;
            }
        }
        return names.get(shortestIdx);
    }

    public static void removeLongNames(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() >= 10) {
                names.remove(i);
                i--;
            }
        }
    }

    public static void scrambleNames(ArrayList<String> names) {
        for (int i = 0; i < names.size()/2; i++) {
            int j = names.size()-1-i;
            String first = names.get(i);
            String second = names.get(j);
            names.set(i, second);
            names.set(j, first);
            if (first.length() == 5) {
                names.remove(j);
            }
        }
    }

    public static ArrayList<String> getNamesWithLetter(ArrayList<String> names, char letter) {
        ArrayList<String> matches = new ArrayList<>();
        String stringed = String.valueOf(letter);
        for (String name : names) {
            if (name.startsWith(stringed)) {
                matches.add(name);
            }
        }
        return matches;
    }

    public static void sortNames(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < names.size() - i -1; j++) {
                if (names.get(j).compareTo(names.get(j+1)) < 0) {
                    String temp = names.get(j);
                    names.set(j, names.get(j+1));
                    names.set(j+1, temp);
                }
            }
        }
    }

    public static ArrayList<Integer> removeEvens(ArrayList<Integer> myList)

    {

        for (int i = 0; i < myList.size(); i++)

        {

            if (myList.get(i) % 2 == 0)

            {

                myList.remove(i);

            }

        }

        return myList;

    }
}
