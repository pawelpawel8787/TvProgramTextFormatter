package com.mycompany;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TV4 {

    public static void main(String[] args) throws Exception {

        String path = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\input\\TV4.txt";
        String pathOut = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\tempFiles\\outputTV4_1.txt";
        String pathOut2 = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\tempFiles\\outputTV4_2.txt";
        String pathOut3 = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\tempFiles\\outputTV4_3.txt";
        String pathOut4 = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\tempFiles\\outputTV4_3.txt";
        String finalOut = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\output\\finalTV4.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;

        Scanner reader2 = null;
        PrintWriter writer2 = null;

        try {
            reader = new BufferedReader(new FileReader(path));
            writer = new BufferedWriter(new FileWriter(pathOut));

            String line1;

            while ((line1 = reader.readLine()) != null) {


                Pattern pattern = Pattern.compile("([0-9]{1,2}):([0-9]{1,2})");
                Matcher matcher = pattern.matcher(line1);


                if (line1.contains("Detektywi w Akcji")) {
                    writer.write(line1
                            .replace(line1, line1.substring(0, 5) + "\t" + "Detektywi w akcji - serial kryminalny prod. Polska")


                    );
//                } else if (line1.contains("MiłośćKropka.pl")) {
//                    writer.write(line1
//                            .replace(line1, line1.substring(0, 5) + "\t" + "MiłośćKropka.pl - rozrywkowa")
//                    );
//                }
                } else {
                    writer.write(line1
                            .replace("", ""));
                }
                writer.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        try {
            reader2 = new Scanner(new File(pathOut));
            writer2 = new PrintWriter(pathOut2);


            while ((reader2.hasNext())) {
                String line2 = reader2.nextLine();

                if (!line2.isEmpty()) {
                    writer2.write(line2);
                    writer2.write("\n");
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(pathOut2));
            writer = new BufferedWriter(new FileWriter(pathOut3));

            String line2;

            while ((line2 = reader.readLine()) != null) {
                writer.write(line2.trim().replace("\n", ""));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(pathOut3));
            writer = new BufferedWriter(new FileWriter(finalOut));

            String line3;

            while ((line3 = reader.readLine()) != null) {


                Pattern pattern = Pattern.compile("([0-9]{1,2}):([0-9]{1,2})");
                Matcher matcher = pattern.matcher(line3);
 if (line3.length() > 100) {

     String sentence = line3;

                    String[] array = sentence.split("([0-9]{1,2}):([0-9]{1,2})");
                    String word = array[1];

                    writer.write(line3
                            .replace(sentence, word)
                    );

                } else {
                    writer.write(line3
                            .replace("", ""));
                }

//                if (matcher.find()) {
//                    writer.write(line3
//                            .replace(matcher.group(), matcher.group() + "\n")
//                            .replace(" fabularny, dramat, thriller", " - thriller")
//                            .replace("fabularny, thriller", "- fabularny")
//                            .replace("fabularny, przygodowo-fantastyczny", "- przygodowo-fantastyczny")
//                            .replace(" fabularny, komedia obyczajowa", " - komedia obyczajowa")
//                            .replace("dokumentalny, film dokumentalny", "- film dokumentalny")
//                            .replace("fabularny, przygodowy, sensacyjny", "- przygodowy")
//                            .replace("fabularny, dramat historyczny", "- dramat historyczny")
//                            .replace("fabularny, kryminalny", "- kryminalny")
//                            .replace("fabularny, sensacyjny", "- sensacyjny")
//                            .replace("fabularny, komedia, przygodowy", "- komedia")
//                            .replace("fabularny, komedia romantyczna", "- komedia romantyczna")
//                            .replace("fabularny, komedia", "- komedia")
//                            .replace("fabularny, dramat", "- dramat")
//                            .replace("etiuda fabularna, krótkometrażowy", "- krótkometrażowy")
//                            .replace("fabularny, horror", "- horror")
//                            .replace("komedia, komedia sensacyjna", "komedia sensacyjna")
//                            .replace("  ", " ")
//                            .replace(", -", " -")
//                            .replace("  -", " -")
//                    );
//                } else {
//                    writer.write(line3
//                            .replace("", "")
//                            .replace(" fabularny, dramat, thriller", " - thriller")
//                            .replace("fabularny, thriller", "- fabularny")
//                            .replace("fabularny, horror", "- horror")
//                            .replace("fabularny, komedia", "- komedia")
//                            .replace("fabularny, przygodowo-fantastyczny", "- przygodowo-fantastyczny")
//                            .replace(" fabularny, komedia obyczajowa", " - komedia obyczajowa")
//                            .replace("dokumentalny, film dokumentalny", "- film dokumentalny")
//                            .replace("etiuda fabularna, krótkometrażowy", "- krótkometrażowy")
//                            .replace("fabularny, dramat", "- dramat")
//                            .replace("fabularny, przygodowy, sensacyjny", "- przygodowy")
//                            .replace("fabularny, komedia romantyczna", "- komedia romantyczna")
//                            .replace("fabularny, dramat historyczny", "- dramat historyczny")
//                            .replace("fabularny, kryminalny", "- kryminalny")
//                            .replace("fabularny, sensacyjny", "- sensacyjny")
//                            .replace("fabularny, komedia, przygodowy", "- komedia")
//                            .replace("fabularny, przygodowy", "- przygodowy")
//                            .replace("komedia, komedia sensacyjna", "komedia sensacyjna")
//                            .replace("  ", " ")
//                            .replace(", -", " -")
//                            .replace("  -", " -")
//                    );
//                }
                writer.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }


    }

}
