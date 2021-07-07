package com.digitalinnovation.StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class ExercicioStreamAPI {

    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        System.out.println("Imprima todos os elementos dessa lista de String: ");
       /* numerosAleatorios.stream().forEach(new Consumer<String>() { //Interface funcional
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

//        numerosAleatorios.stream().forEach(s -> System.out.println(s)); //Lambda

//        numerosAleatorios.forEach(s -> System.out.println(s)); //Lambda

//        numerosAleatorios.forEach(System.out::println); // Reference Method (Todos acima imprimem a lista)

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set");
        numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet()) //Como o set não aceita números repetidos imprimiu o 1 apenas uma vez
            .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
        /*numerosAleatorios.stream()
                .map(new Function<String, Integer>() { //Interface Function
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                });*/

       /* numerosAleatorios.stream()
                .map(s -> Integer.parseInt(s)); //Lambda*/

        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt) // Reference Method
                .collect(Collectors.toList());
//                .forEach(System.out::println); // se tirar da variável pode imprimir assim
        System.out.println(collectList);

        System.out.println("Pegue os múmeros pares e maiores que 2 e coloque em uma lista: ");
      /*  List<Integer> listaParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println(listaParesMaioresQue2);*/

        List<Integer> listaParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listaParesMaioresQue2);

        System.out.println("Mostre a média dos números: ");
//        numerosAleatorios.stream()
//                .mapToInt(new ToIntFunction<String>() {
//                    @Override
//                    public int applyAsInt(String s) {
//                        return Integer.parseInt(s);
//                    }
//                });
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);


        System.out.println("Remova os valores impares: ");
//        collectList.removeIf(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                if (integer % 2 != 0) return true;
//                return false;
//            }
//        });
//        System.out.println(collectList);
        collectList.removeIf(integer -> (integer % 2 != 0));
        System.out.println(collectList);

        //        Para você
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        collectList.stream()
                .skip(3)
                .forEach(System.out::println);

        long countNumerosUnicos = collectList.stream()
                .distinct()
                .count();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.print("Mostre o menor valor da lista: ");
        collectList.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.print("Mostre o maior valor da lista: ");
        collectList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);;

        int somaDosNumerosPares = collectList.stream()
                .filter(i -> (i % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Pegue apenas os números ímpares e some: " + somaDosNumerosPares);

        System.out.println("Mostre a lista na ordem númerica: ");
        List<Integer> numerosOrdemNatural = collectList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = collectList.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);
    }
}
