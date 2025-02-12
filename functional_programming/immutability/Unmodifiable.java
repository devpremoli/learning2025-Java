package functional_programming.immutability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Unmodifiable {

    private final List<String> listOfStringsField;
    private final List<int[]> listOfArraysField;
    private final List<List<Integer>> listOfListsField;

    public Unmodifiable( List<String> listOfStrings,List<int[]> listOfArrays, List<List<Integer>> listOfLists) {

        // listOfStrings references a mutable object containing references to immutable object
        listOfStringsField = new ArrayList<>(listOfStrings);

        // listOfArrays references mutable object containing references to mutable object
        listOfArraysField = new ArrayList<>();
        for (int[] array : listOfArrays) {
            listOfArraysField.add(Arrays.copyOf(array, array.length));
        }

        // listOfLists references mutable object containing references to mutable object
        listOfListsField = new ArrayList<>();
        for (List<Integer> list : listOfLists) {
            listOfListsField.add(List.copyOf(list));
        }
    }

    public List<String> getListOfStringsField() {
        // listOfStringsField references a mutable object containing references to immutable object
        return Collections.unmodifiableList(listOfStringsField);
    }

    public List<int[]> getListOfArraysField() {
        // listOfArraysField references mutable object containing references to mutable object
        List<int[]> deepCopiedList = new ArrayList<>();
        for (int[] array : listOfArraysField) {
            deepCopiedList.add(Arrays.copyOf(array, array.length));
        }
        return Collections.unmodifiableList(deepCopiedList);
    }

    public List<List<Integer>> getListOfListsField() {
        // listOfListsField references mutable object containing references to immutable object
        return Collections.unmodifiableList(listOfListsField);
    }

    public static void main(String[] args) {

        List<String> listOfString = new ArrayList<>();
        listOfString.add("Prem");
        listOfString.add("Raj");
        listOfString.add("Oli");

        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1, 2, 3});
        listOfArrays.add(new int[]{4, 5, 6});
        listOfArrays.add(new int[]{7, 8, 9});

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>(List.of(11, 12, 13)));
        listOfLists.add(new ArrayList<>(List.of(14, 15)));
        listOfLists.add(new ArrayList<>(List.of(16, 17, 18, 19)));

        Unmodifiable unmodifiable = new Unmodifiable(listOfString, listOfArrays, listOfLists);


        // listOfStringsField = listOfStrings;
        listOfString.add("Changed");
        System.out.println(unmodifiable.getListOfStringsField());

        // return listOfStringsField;
        //List<String> listOfStringField = unmodifiable.getListOfStringsField();
        //listOfStringField.add("changed");
        //System.out.println(unmodifiable.getListOfStringsField());


        // listOfArraysField = listOfArrays;
        List<int[]> listOfArraysField = unmodifiable.getListOfArraysField();
        listOfArrays.add(new int[]{10, 20, 30});
        System.out.println(Arrays.toString(unmodifiable.getListOfArraysField().get(listOfArraysField.size() - 1)));

        // return Collections.unmodifiableList(listOfArraysField);
        listOfArraysField = unmodifiable.getListOfArraysField();
        int[] listOfArraysFieldA = unmodifiable.getListOfArraysField().get(listOfArraysField.size() - 1);
        listOfArraysFieldA[0] = 70;
        System.out.println(Arrays.toString(unmodifiable.getListOfArraysField().get(listOfArraysField.size() - 1)));

        // return listOfListsField;
        //List<List<Integer>> listOfListsField = unmodifiable.getListOfListsField();
        //listOfListsField.add(Arrays.asList(1, 2));
        //System.out.println(unmodifiable.getListOfListsField().getLast());
    }
}